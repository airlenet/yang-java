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
import com.airlenet.yang.compiler.datamodel.YangModule;
import com.airlenet.yang.compiler.datamodel.YangNode;
import com.airlenet.yang.compiler.parser.exceptions.ParserException;
import com.airlenet.yang.compiler.parser.impl.YangUtilsParserManager;

import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test cases for testing organization listener functionality.
 */
public class OrganizationListenerTest {

    private final YangUtilsParserManager manager = new YangUtilsParserManager();

    /**
     * Checks if organization listener updates the data model tree.
     */
    @Test
    public void processOrganizationValidEntry() throws IOException, ParserException {

        YangNode node = manager.getDataModel("src/test/resources/OrganizationValidEntry.yang");

        // Checks for the version value in data model tree.
        assertThat(((YangModule) node).getOrganization(), is("\"IETF SPRING Working Group\""));
    }

    /**
     * Checks that organization must be present only once.
     */
    @Test(expected = ParserException.class)
    public void processOrganizationDualEntry() throws IOException, ParserException {

        YangNode node = manager.getDataModel("src/test/resources/OrganizationDualEntry.yang");
    }

    /**
     * Checks if organization entry syntax is correct.
     */
    @Test(expected = ParserException.class)
    public void processOrganizationMissingValue() throws IOException, ParserException {

        YangNode node = manager.getDataModel("src/test/resources/OrganizationMissingValue.yang");
    }

    /**
     * Checks if organization and namespace is present in correct order.
     */
    @Test(expected = ParserException.class)
    public void processOrganizationInvalidOrder() throws IOException, ParserException {

        YangNode node = manager.getDataModel("src/test/resources/OrganizationInvalidOrder.yang");
    }
}