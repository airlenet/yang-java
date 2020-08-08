/*
 * Copyright 2016-present Open Networking Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.airlenet.yang.compiler.translator.tojava.javamodel;

import com.airlenet.yang.compiler.datamodel.YangNode;
import com.airlenet.yang.compiler.datamodel.YangNotification;
import com.airlenet.yang.compiler.datamodel.javadatamodel.YangJavaModule;
import com.airlenet.yang.compiler.translator.exception.TranslatorException;
import com.airlenet.yang.compiler.translator.tojava.JavaCodeGenerator;
import com.airlenet.yang.compiler.translator.tojava.JavaCodeGeneratorInfo;
import com.airlenet.yang.compiler.translator.tojava.JavaFileInfoTranslator;
import com.airlenet.yang.compiler.translator.tojava.TempJavaCodeFragmentFiles;
import com.airlenet.yang.compiler.translator.tojava.jnc.JavaClass;
import com.airlenet.yang.compiler.translator.tojava.jnc.JavaField;
import com.airlenet.yang.compiler.translator.tojava.jnc.JavaMethod;
import com.airlenet.yang.compiler.utils.io.YangPluginConfig;
import com.tailf.jnc.YangElement;

import java.io.IOException;
import java.util.ArrayList;

import static com.airlenet.yang.compiler.datamodel.utils.DataModelUtils.isRpcChildNodePresent;
import static com.airlenet.yang.compiler.translator.tojava.GeneratedJavaFileType.GENERATE_ALL_EVENT_CLASS_MASK;
import static com.airlenet.yang.compiler.translator.tojava.GeneratedJavaFileType.GENERATE_INTERFACE_WITH_BUILDER;
import static com.airlenet.yang.compiler.translator.tojava.GeneratedJavaFileType.GENERATE_SERVICE_AND_MANAGER;
import static com.airlenet.yang.compiler.translator.tojava.YangJavaModelUtils.*;
import static com.airlenet.yang.compiler.translator.tojava.utils.JavaIdentifierSyntax.getRootPackage;
import static com.airlenet.yang.compiler.translator.tojava.utils.TranslatorErrorType.FAIL_AT_ENTRY;
import static com.airlenet.yang.compiler.translator.tojava.utils.TranslatorErrorType.FAIL_AT_EXIT;
import static com.airlenet.yang.compiler.translator.tojava.utils.TranslatorUtils.getErrorMsg;
import static com.airlenet.yang.compiler.utils.UtilConstants.SBI;
import static com.airlenet.yang.compiler.utils.io.impl.YangIoUtils.*;

/**
 * Represents module information extended to support java code generation.
 */
public class YangJavaModuleTranslator
        extends YangJavaModule
        implements JavaCodeGeneratorInfo, JavaCodeGenerator {

    private static final long serialVersionUID = 806201625L;

    /**
     * File handle to maintain temporary java code fragments as per the code
     * snippet types.
     */
    private transient TempJavaCodeFragmentFiles tempFileHandle;

    /**
     * Creates a YANG node of module type.
     */
    public YangJavaModuleTranslator() {
        setJavaFileInfo(new JavaFileInfoTranslator());
        notificationNodes = new ArrayList<>();
        getJavaFileInfo().setGeneratedFileTypes(
                GENERATE_SERVICE_AND_MANAGER | GENERATE_INTERFACE_WITH_BUILDER);
    }

    /**
     * Returns the generated java file information.
     *
     * @return generated java file information
     */
    @Override
    public JavaFileInfoTranslator getJavaFileInfo() {
        if (javaFileInfo == null) {
            throw new TranslatorException(
                    "Missing java info in java datamodel node " + getName());
        }
        return (JavaFileInfoTranslator) javaFileInfo;
    }

    /**
     * Sets the java file info object.
     *
     * @param javaInfo java file info object
     */
    @Override
    public void setJavaFileInfo(JavaFileInfoTranslator javaInfo) {
        javaFileInfo = javaInfo;
    }

    /**
     * Returns the temporary file handle.
     *
     * @return temporary file handle
     */
    @Override
    public TempJavaCodeFragmentFiles getTempJavaCodeFragmentFiles() {
        return tempFileHandle;
    }

    /**
     * Sets temporary file handle.
     *
     * @param fileHandle temporary file handle
     */
    @Override
    public void setTempJavaCodeFragmentFiles(
            TempJavaCodeFragmentFiles fileHandle) {
        tempFileHandle = fileHandle;
    }

    /**
     * Generates java code for module.
     *
     * @param yangPlugin YANG plugin config
     * @throws TranslatorException when fails to generate the source files
     */
    @Override
    public void generateCodeEntry(YangPluginConfig yangPlugin)
            throws TranslatorException {
        String modulePkg = getRootPackage(getVersion(), getModuleName(),
                                          getRevision(),
                                          yangPlugin.getConflictResolver());
        updateJNCPackageInfo(this, yangPlugin, modulePkg);

        JavaFileInfoTranslator fileInfo = this.getJavaFileInfo();

        String classname=  this.getPrefixClassName();
        String absoluteDirPath = getAbsolutePackagePath(fileInfo.getBaseCodeGenPath(),
                fileInfo.getPackageFilePath());

        JavaClass javaClass = new JavaClass(classname, modulePkg, "The root class for namespace"+this.getModuleNamespace());

        javaClass.addField(new JavaField("NAMESPACE",this.getModuleNamespace(), "public" ,"static" ,"final", "String"),
                new JavaField("PREFIX",this.getPrefix(), "public" ,"static" ,"final", "String"));
        JavaMethod enabler = new JavaMethod("enable","void")
                .setExceptions(new String[]{"JNCException"}).addDependency("com.tailf.jnc.JNCException")
                .addJavadoc("Enable the elements in this namespace to be aware")
                .addJavadoc("of the data model and use the generated classes.");
        enabler.setModifiers (new String[]{ "public", "static"});
        enabler.addLine("YangElement.setPackage(NAMESPACE, \""+modulePkg+"\");");
        enabler.addDependency("com.tailf.jnc.YangElement");
        enabler.addLine("//"+classname + ".registerSchema();");
        javaClass.addMethod(enabler);


        JavaMethod  reg = new JavaMethod("registerSchema","void");
        reg.setExceptions (new String []{"JNCException"});
        reg.addDependency("com.tailf.jnc.JNCException");
        reg.setModifiers (new String[]{ "public", "static"});
        reg.addJavadoc("Register the schema for this namespace in the global");
        reg.addJavadoc("schema table (CsTree) making it possible to lookup");
        reg.addJavadoc("CsNode entries for all tagpaths");
        reg.addLine("SchemaParser parser = new SchemaParser();");
        reg.addDependency("com.tailf.jnc.SchemaParser");
        reg.addLine("HashMap<Tagpath, SchemaNode> h = SchemaTree.create(NAMESPACE);");
        reg.addDependency("java.util.HashMap");
        reg.addDependency("com.tailf.jnc.Tagpath");
        reg.addDependency("com.tailf.jnc.SchemaNode");
        reg.addDependency("com.tailf.jnc.SchemaTree");
        reg.addLine("parser.findAndReadFile(\"" + classname + ".schema\", h, " + classname + ".class);");
        javaClass.addMethod(reg);

        try {
            javaClass.write(absoluteDirPath);
        } catch (IOException e) {
            throw new TranslatorException(e);
        }

    }

    /**
     * Creates a java file using the YANG module info.
     */
    @Override
    public void generateCodeExit()
            throws TranslatorException {
        /*
         * As part of the notification support the following files needs to be generated.
         * 1) Subject of the notification(event), this is simple interface with builder class.
         * 2) Event class extending "AbstractEvent" and defining event type enum.
         * 3) Event listener interface extending "EventListener".
         * 4) Event subject class.
         *
         * The manager class needs to extend the "ListenerRegistry".
         */
//        try {
//            if ((getJavaFileInfo().getGeneratedFileTypes() &
//                    GENERATE_ALL_EVENT_CLASS_MASK) != 0) {
//                getTempJavaCodeFragmentFiles().generateJavaFile(
//                        GENERATE_ALL_EVENT_CLASS_MASK, this);
//            }
//
//            if (!isRootNodesCodeGenRequired(this)) {
//                if (getChild() != null) {
//                    generateInterfaceFileForNonDataNodes(this);
//                }
//            } else {
//                getTempJavaCodeFragmentFiles()
//                        .generateJavaFile(GENERATE_INTERFACE_WITH_BUILDER, this);
//                if (getJavaFileInfo().getPluginConfig()
//                        .getCodeGenerateForSbi() == null ||
//                        !getJavaFileInfo().getPluginConfig()
//                                .getCodeGenerateForSbi().equals(SBI)) {
//                    if (isRpcChildNodePresent(this)) {
//                        getTempJavaCodeFragmentFiles()
//                                .generateJavaFile(GENERATE_SERVICE_AND_MANAGER, this);
//                        // TODO : code generation for rpc at module level
//                        /*getTempJavaCodeFragmentFiles()
//                                .generateJavaFile(GENERATE_ALL_RPC_CLASS_MASK, this);
//                         */
//                    }
//                }
//            }
//
//            searchAndDeleteTempDir(getJavaFileInfo().getBaseCodeGenPath() +
//                                           getJavaFileInfo().getPackageFilePath());
//            removeEmptyDirectory(getJavaFileInfo().getBaseCodeGenPath() +
//                                         getJavaFileInfo().getPackageFilePath());
//        } catch (IOException e) {
//            throw new TranslatorException(getErrorMsg(FAIL_AT_EXIT, this,
//                                                      e.getLocalizedMessage()));
//        }
    }

    /**
     * Adds to notification node list.
     *
     * @param curNode notification node
     */
    private void addToNotificationList(YangNode curNode) {
        notificationNodes.add(curNode);
    }

    /**
     * Checks if there is any notification node present.
     *
     * @param rootNode root node of the data model
     * @return status of notification"s existence
     */
    private boolean isNotificationChildNodePresent(YangNode rootNode) {
        YangNode childNode = rootNode.getChild();

        while (childNode != null) {
            if (childNode instanceof YangNotification) {
                addToNotificationList(childNode);
            }
            childNode = childNode.getNextSibling();
        }

        return !notificationNodes.isEmpty();
    }
}