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

package com.airlenet.yang.compiler.parser.impl.parserutils;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import com.airlenet.yang.compiler.parser.exceptions.ParserException;
import com.airlenet.yang.compiler.parser.impl.YangUtilsParserManager;

import java.io.IOException;

/**
 * Test case for testing listener util.
 */
public class ListenerUtilTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private final YangUtilsParserManager manager = new YangUtilsParserManager();

    /**
     * Checks whether exception is thrown when identifier starts with xml.
     */
    @Test
    public void validateIdentifierStartsWithXml() throws IOException {
        thrown.expect(ParserException.class);
        thrown.expectMessage("YANG file error : module identifier xMlTest must not start" +
                " with (('X'|'x') ('M'|'m') ('L'|'l'))");
        manager.getDataModel("src/test/resources/InValidIdentifierXML.yang");
    }
}
