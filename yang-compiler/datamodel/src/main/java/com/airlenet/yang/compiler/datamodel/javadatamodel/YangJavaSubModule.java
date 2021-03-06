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

package com.airlenet.yang.compiler.datamodel.javadatamodel;

import com.airlenet.yang.compiler.datamodel.YangNode;
import com.airlenet.yang.compiler.datamodel.YangSubModule;

import java.util.List;

import static java.util.Collections.unmodifiableList;

/**
 * Represents YANG java submodule.
 */
public class YangJavaSubModule
        extends YangSubModule {

    private static final long serialVersionUID = 208201612L;

    protected JavaFileInfo javaFileInfo;
    protected List<YangNode> notificationNodes;

    /**
     * Returns java file info.
     *
     * @return java file info
     */
    public JavaFileInfo getJavaFileInfo() {
        return javaFileInfo;
    }

    @Override
    public String getJavaPackage() {
        return getJavaFileInfo().getPackage();
    }

    @Override
    public String getJavaClassNameOrBuiltInType() {
        return getJavaFileInfo().getJavaName();
    }

    @Override
    public String getJavaAttributeName() {
        throw new RuntimeException("Attribute name is not applicable ");
    }

    @Override
    public List<YangNode> getNotificationNodes() {
        return unmodifiableList(notificationNodes);
    }
}
