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


import com.airlenet.yang.compiler.datamodel.YangDeviateAdd;
import com.airlenet.yang.compiler.datamodel.YangDeviation;
import com.airlenet.yang.compiler.datamodel.utils.Parsable;
import com.airlenet.yang.compiler.parser.exceptions.ParserException;
import com.airlenet.yang.compiler.parser.impl.TreeWalkListener;
import com.airlenet.yang.compiler.parser.impl.parserutils.ListenerErrorLocation;
import com.airlenet.yang.compiler.parser.impl.parserutils.ListenerErrorMessageConstruction;
import com.airlenet.yang.compiler.parser.impl.parserutils.ListenerErrorType;
import com.airlenet.yang.compiler.parser.impl.parserutils.ListenerValidation;
import com.airlenet.yang.compiler.parser.antlrgencode.GeneratedYangParser;

import static com.airlenet.yang.compiler.datamodel.utils.YangConstructType.DEVIATE_ADD;


/*
 * Reference: RFC6020 and YANG ANTLR Grammar
 *
 * ABNF grammar as per RFC6020
 *
 *  deviate-add-stmt    = deviate-keyword sep add-keyword optsep
 *                        (";" /
 *                         "{" stmtsep
 *                             [units-stmt stmtsep]
 *                             *(must-stmt stmtsep)
 *                             *(unique-stmt stmtsep)
 *                             [default-stmt stmtsep]
 *                             [config-stmt stmtsep]
 *                             [mandatory-stmt stmtsep]
 *                             [min-elements-stmt stmtsep]
 *                             [max-elements-stmt stmtsep]
 *                         "}")
 *
 * ANTLR grammar rule
 *   deviateAddStatement: DEVIATE_KEYWORD ADD_KEYWORD (STMTEND
 *           | LEFT_CURLY_BRACE (unitsStatement | mustStatement
 *           | uniqueStatement| defaultStatement| configStatement
 *           | mandatoryStatement | minElementsStatement
 *           | maxElementsStatement)*
 *           RIGHT_CURLY_BRACE);
 */

/**
 * Represents listener based call back function corresponding to the "deviate
 * add" rule defined in ANTLR grammar file for corresponding ABNF rule in RFC
 * 6020.
 */
public final class DeviateAddListener {

    //No instantiation
    private DeviateAddListener() {
    }

    /**
     * Performs validation and updates the data model tree. It is called when
     * parser receives an input matching the grammar rule(deviate add).
     *
     * @param listener listener's object
     * @param ctx      context object of the grammar rule
     */
    public static void processDeviateAddEntry(TreeWalkListener listener,
                                              GeneratedYangParser.DeviateAddStatementContext ctx) {

        // Check for stack to be non empty.
        ListenerValidation.checkStackIsNotEmpty(listener, ListenerErrorType.MISSING_HOLDER, DEVIATE_ADD, null, ListenerErrorLocation.ENTRY);

        // TODO : Validate sub-statements cardinality

        Parsable curData = listener.getParsedDataStack().peek();
        if (curData instanceof YangDeviation) {
            YangDeviation curNode = (YangDeviation) curData;
            YangDeviateAdd deviationAdd = new YangDeviateAdd();
            curNode.addDeviateAdd(deviationAdd);
            listener.getParsedDataStack().push(deviationAdd);
        } else {
            throw new ParserException(ListenerErrorMessageConstruction.constructListenerErrorMessage(ListenerErrorType.INVALID_HOLDER,
                                                                    DEVIATE_ADD,
                                                                    null,
                                                                    ListenerErrorLocation.ENTRY));
        }
    }

    /**
     * Performs validation and updates the data model tree. It is called when
     * parser exits from grammar rule (deviate add).
     *
     * @param listener listener's object
     * @param ctx      context object of the grammar rule
     */
    public static void processDeviateAddExit(TreeWalkListener listener,
                                             GeneratedYangParser.DeviateAddStatementContext ctx) {

        // Check for stack to be non empty.
        ListenerValidation.checkStackIsNotEmpty(listener, ListenerErrorType.MISSING_HOLDER, DEVIATE_ADD, null,
                             ListenerErrorLocation.EXIT);

        if (listener.getParsedDataStack().peek() instanceof YangDeviateAdd) {
            listener.getParsedDataStack().pop();
        } else {
            throw new ParserException(ListenerErrorMessageConstruction.constructListenerErrorMessage(ListenerErrorType.MISSING_CURRENT_HOLDER, DEVIATE_ADD,
                                                                    null, ListenerErrorLocation.EXIT));
        }
    }
}
