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

package com.airlenet.yang.compiler.parser.impl.listeners;

import org.junit.Test;
import com.airlenet.yang.compiler.datamodel.YangContainer;
import com.airlenet.yang.compiler.datamodel.YangGrouping;
import com.airlenet.yang.compiler.datamodel.YangList;
import com.airlenet.yang.compiler.datamodel.YangModule;
import com.airlenet.yang.compiler.datamodel.YangNode;
import com.airlenet.yang.compiler.datamodel.YangNodeType;
import com.airlenet.yang.compiler.datamodel.YangStatusType;
import com.airlenet.yang.compiler.datamodel.YangUses;
import com.airlenet.yang.compiler.parser.exceptions.ParserException;
import com.airlenet.yang.compiler.parser.impl.YangUtilsParserManager;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Test cases for testing uses listener.
 */
public class UsesListenerTest {

    private final YangUtilsParserManager manager = new YangUtilsParserManager();

    /**
     * Checks uses statement inside module.
     */
    @Test
    public void processUsesInModule() throws IOException, ParserException {

        YangNode node = manager.getDataModel("src/test/resources/UsesInModule.yang");

        // Check whether the data model tree returned is of type module.
        assertThat((node instanceof YangModule), is(true));

        // Check whether the node type is set properly to module.
        assertThat(node.getNodeType(), is(YangNodeType.MODULE_NODE));

        // Check whether the module name is set correctly.
        YangModule yangNode = (YangModule) node;
        assertThat(yangNode.getName(), is("Test"));

        YangGrouping yangGrouping = (YangGrouping) yangNode.getChild();
        assertThat(yangGrouping.getName(), is("endpoint"));

        YangUses yangUses = (YangUses) yangGrouping.getNextSibling();
        assertThat(yangUses.getName(), is("endpoint"));
    }

    /**
     * Checks uses statement inside container.
     */
    @Test
    public void processUsesInContainer() throws IOException, ParserException {

        YangNode node = manager.getDataModel("src/test/resources/UsesInContainer.yang");

        // Check whether the data model tree returned is of type module.
        assertThat((node instanceof YangModule), is(true));

        // Check whether the node type is set properly to module.
        assertThat(node.getNodeType(), is(YangNodeType.MODULE_NODE));

        // Check whether the module name is set correctly.
        YangModule yangNode = (YangModule) node;
        assertThat(yangNode.getName(), is("Test"));

        YangGrouping yangGrouping = (YangGrouping) yangNode.getChild();
        assertThat(yangGrouping.getName(), is("endpoint"));

        YangContainer yangContainer = (YangContainer) yangGrouping.getNextSibling();
        assertThat(yangContainer.getName(), is("valid"));

        YangUses yangUses = (YangUses) yangContainer.getChild();
        assertThat(yangUses.getName(), is("endpoint"));

        // Check attributes associated with uses.
        assertThat(yangUses.getStatus(), is(YangStatusType.CURRENT));
        assertThat(yangUses.getReference(), is("\"RFC 6020\""));
        assertThat(yangUses.getDescription(), is("\"grouping under test\""));
    }

    /**
     * Checks uses statement inside list.
     */
    @Test
    public void processUsesInList() throws IOException, ParserException {

        YangNode node = manager.getDataModel("src/test/resources/UsesInList.yang");

        // Check whether the data model tree returned is of type module.
        assertThat((node instanceof YangModule), is(true));

        // Check whether the node type is set properly to module.
        assertThat(node.getNodeType(), is(YangNodeType.MODULE_NODE));

        // Check whether the module name is set correctly.
        YangModule yangNode = (YangModule) node;
        assertThat(yangNode.getName(), is("Test"));

        YangGrouping yangGrouping = (YangGrouping) yangNode.getChild();
        assertThat(yangGrouping.getName(), is("endpoint"));

        YangList yangList = (YangList) yangGrouping.getNextSibling();
        assertThat(yangList.getName(), is("valid"));

        YangUses yangUses = (YangUses) yangList.getChild();
        assertThat(yangUses.getName(), is("endpoint"));

        // Check attributes associated with uses.
        assertThat(yangUses.getStatus(), is(YangStatusType.CURRENT));
        assertThat(yangUses.getReference(), is("\"RFC 6020\""));
        assertThat(yangUses.getDescription(), is("\"grouping under test\""));
    }
}
