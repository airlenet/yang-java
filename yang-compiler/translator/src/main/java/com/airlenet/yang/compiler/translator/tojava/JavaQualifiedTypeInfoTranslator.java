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

package com.airlenet.yang.compiler.translator.tojava;

import com.airlenet.yang.compiler.translator.exception.TranslatorException;
import com.airlenet.yang.compiler.translator.tojava.javamodel.AttributesJavaDataType;
import com.airlenet.yang.compiler.translator.tojava.javamodel.JavaLeafInfoContainer;
import com.google.common.base.MoreObjects;
import com.airlenet.yang.compiler.datamodel.YangNode;
import com.airlenet.yang.compiler.datamodel.javadatamodel.JavaQualifiedTypeInfo;
import com.airlenet.yang.compiler.utils.io.YangToJavaNamingConflictUtil;

import java.io.Serializable;
import java.util.Objects;

import static com.airlenet.yang.compiler.datamodel.utils.builtindatatype.YangDataTypes.BINARY;
import static com.airlenet.yang.compiler.utils.UtilConstants.BASE64;
import static com.airlenet.yang.compiler.utils.UtilConstants.COLLECTION_IMPORTS;

/**
 * Represents the information about individual imports in the generated file.
 */
public class JavaQualifiedTypeInfoTranslator
        extends JavaQualifiedTypeInfo
        implements Comparable<JavaQualifiedTypeInfoTranslator>, Serializable {
    private static final long serialVersionUID = 806201634L;
    private boolean isQualified;
    private boolean isForInterface = true;

    /**
     * Creates a java qualified type info object.
     */
    public JavaQualifiedTypeInfoTranslator() {
        super();
    }

    /**
     * Returns the imported package info.
     *
     * @return the imported package info
     */
    public String getPkgInfo() {
        return pkgInfo;
    }

    /**
     * Sets the imported package info.
     *
     * @param pkgInfo the imported package info
     */
    public void setPkgInfo(String pkgInfo) {
        this.pkgInfo = pkgInfo;
    }

    /**
     * Returns the imported class/interface info.
     *
     * @return the imported class/interface info
     */
    public String getClassInfo() {
        return classInfo;
    }

    /**
     * Sets the imported class/interface info.
     *
     * @param classInfo the imported class/interface info
     */
    public void setClassInfo(String classInfo) {
        this.classInfo = classInfo;
    }

    /**
     * Updates the leaf's java information.
     *
     * @param leaf leaf whose java information is being updated
     */
    public static void updateLeavesJavaQualifiedInfo(
            JavaLeafInfoContainer leaf) {

        JavaQualifiedTypeInfoTranslator importInfo =
                (JavaQualifiedTypeInfoTranslator) leaf.getJavaQualifiedInfo();

        if (leaf.getDataType() == null) {
            throw new TranslatorException(
                    "missing data type of leaf " + leaf.getName()
                            + " in " + leaf.getLineNumber() + " at" +
                            leaf.getCharPosition() + " in " +
                            leaf.getFileName());
        }

        /*
         * Current leaves holder is adding a leaf info as a attribute to the
         * current class.
         */
        String className =
                AttributesJavaDataType.getJavaImportClass(leaf.getDataType(), leaf.isLeafList(),
                                   leaf.getConflictResolveConfig());
        if (className != null) {
            /*
             * Corresponding to the attribute type a class needs to be imported,
             * since it can be a derived type or a usage of wrapper classes.
             */
            importInfo.setClassInfo(className);
            String classPkg = AttributesJavaDataType.getJavaImportPackage(leaf.getDataType(),
                                                   leaf.isLeafList(),
                                                   leaf.getConflictResolveConfig());
            if (classPkg == null) {
                throw new TranslatorException(
                        "import package cannot be null when the class is used" +
                                " for "
                                + leaf.getName()
                                + " in " + leaf.getLineNumber() + " at" +
                                leaf.getCharPosition() + " in " +
                                leaf.getFileName());
            }
            importInfo.setPkgInfo(classPkg);
        } else {
            /*
             * The attribute does not need a class to be imported, for example
             * built in java types.
             */
            String dataTypeName =
                    AttributesJavaDataType.getJavaDataType(leaf.getDataType());
            if (dataTypeName == null) {
                throw new TranslatorException("not supported data type for "
                                                      + leaf.getName()
                                                      + " in " +
                                                      leaf.getLineNumber() +
                                                      " at" +
                                                      leaf.getCharPosition() +
                                                      " in " +
                                                      leaf.getFileName());
            }
            importInfo.setClassInfo(dataTypeName);
        }

        leaf.getJavaQualifiedInfo().setJavaAttributeName(leaf.getJavaName(
                leaf.getConflictResolveConfig()));
    }

    /**
     * Returns the import info for an attribute, which needs to be used for code
     * generation for import or for qualified access.
     *
     * @param curNode       current data model node for which the java file
     *                      is being
     *                      generated
     * @param attributeName name of the attribute being added, it will used in
     *                      import info for child class
     * @return return the import info for this attribute
     */
    public static JavaQualifiedTypeInfoTranslator getQualifiedTypeInfoOfCurNode(
            YangNode curNode,
            String attributeName) {

        JavaQualifiedTypeInfoTranslator importInfo =
                new JavaQualifiedTypeInfoTranslator();

        if (!(curNode instanceof JavaFileInfoContainer)) {
            throw new TranslatorException(
                    "missing java file information to get the package details "
                            + "of attribute corresponding to child node " +
                            curNode.getName() +
                            " in " + curNode.getLineNumber() + " at " +
                            curNode.getCharPosition() + " in " +
                            curNode.getFileName());
        }

        importInfo.setClassInfo(attributeName);
        importInfo.setPkgInfo(((JavaFileInfoContainer) curNode)
                                      .getJavaFileInfo().getPackage());

        return importInfo;
    }

    /**
     * Returns the java qualified type information for the wrapper classes.
     *
     * @param referredTypesAttrInfo attribute of referred type
     * @param conflictResolver      plugin configurations
     * @return return the import info for this attribute
     */
    static JavaQualifiedTypeInfoTranslator getQualifiedInfoOfFromString(
            JavaAttributeInfo referredTypesAttrInfo,
            YangToJavaNamingConflictUtil conflictResolver) {

        /*
         * Get the java qualified type information for the wrapper classes and
         * set it in new java attribute information.
         */
        JavaQualifiedTypeInfoTranslator qualifiedInfoOfFromString =
                new JavaQualifiedTypeInfoTranslator();

        if (referredTypesAttrInfo.getAttributeType().getDataType() == BINARY) {
            qualifiedInfoOfFromString.setClassInfo(BASE64);
            qualifiedInfoOfFromString.setPkgInfo(COLLECTION_IMPORTS);
        } else {
            qualifiedInfoOfFromString.setClassInfo(
                    AttributesJavaDataType.getJavaImportClass(referredTypesAttrInfo.getAttributeType(),
                                       true, conflictResolver));
            qualifiedInfoOfFromString.setPkgInfo(
                    AttributesJavaDataType.getJavaImportPackage(
                            referredTypesAttrInfo.getAttributeType(), true,
                            conflictResolver));
        }
        return qualifiedInfoOfFromString;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pkgInfo, classInfo);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }
        if (obj instanceof JavaQualifiedTypeInfoTranslator) {
            JavaQualifiedTypeInfoTranslator other =
                    (JavaQualifiedTypeInfoTranslator) obj;
            return Objects.equals(pkgInfo, other.pkgInfo) &&
                    Objects.equals(classInfo, other.classInfo);
        }
        return false;
    }

    /**
     * Checks if the import info matches.
     *
     * @param importInfo matched import
     * @return if equal or not
     */
    public boolean exactMatch(JavaQualifiedTypeInfoTranslator importInfo) {
        return equals(importInfo)
                && Objects.equals(pkgInfo, importInfo.getPkgInfo())
                && Objects.equals(classInfo, importInfo.getClassInfo());
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(getClass())
                .add("pkgInfo", pkgInfo)
                .add("classInfo", classInfo).toString();
    }

    /**
     * Checks that there is no 2 objects with the same class name.
     *
     * @param other compared import info.
     */
    @Override
    public int compareTo(JavaQualifiedTypeInfoTranslator other) {
        return getClassInfo().compareTo(other.getClassInfo());
    }

    /**
     * Returns true if import is qualified.
     *
     * @return true if import is qualified
     */
    public boolean isQualified() {
        return isQualified;
    }

    /**
     * Sets true if import is qualified.
     *
     * @param qualified true if import is qualified
     */
    public void setQualified(boolean qualified) {
        isQualified = qualified;
    }

    /**
     * Returns true if import should be added to interface.
     *
     * @return true if import should be added to interface
     */
    boolean isForInterface() {
        return isForInterface;
    }

    /**
     * Sets true if import should be added to interface.
     *
     * @param forInterface true if import should be added to interface
     */
    void setForInterface(boolean forInterface) {
        isForInterface = forInterface;
    }
}
