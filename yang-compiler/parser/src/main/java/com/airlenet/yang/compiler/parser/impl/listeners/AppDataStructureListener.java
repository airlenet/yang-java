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

import com.airlenet.yang.compiler.datamodel.YangAppDataStructure;
import com.airlenet.yang.compiler.datamodel.YangCompilerAnnotation;
import com.airlenet.yang.compiler.datamodel.YangDataStructure;
import com.airlenet.yang.compiler.datamodel.utils.Parsable;
import com.airlenet.yang.compiler.parser.exceptions.ParserException;
import com.airlenet.yang.compiler.parser.impl.TreeWalkListener;
import com.airlenet.yang.compiler.parser.impl.parserutils.*;

import static com.airlenet.yang.compiler.datamodel.YangDataStructure.getDataStructureType;
import static com.airlenet.yang.compiler.datamodel.utils.YangConstructType.APP_DATA_STRUCTURE;
import static com.airlenet.yang.compiler.parser.antlrgencode.GeneratedYangParser.AppDataStructureStatementContext;

/*
 * Reference: RFC6020 and YANG ANTLR Grammar
 *
 * ABNF grammar as per RFC6020
 *   app-data-structure-stmt = prefix:app-data-structure-keyword string
 *                         (";" /
 *                          "{"
 *                              [data-structure-key-stmt stmtsep]
 *                          "}")
 *
 * ANTLR grammar rule
 *   appDataStructureStatement : APP_DATA_STRUCTURE appDataStructure (STMTEND | (LEFT_CURLY_BRACE
 *       dataStructureKeyStatement? RIGHT_CURLY_BRACE));
 */

/**
 * Represents listener based call back function corresponding to the "app-data-structure"
 * rule defined in ANTLR grammar file for corresponding ABNF rule in RFC 6020.
 */
public final class AppDataStructureListener {

    /**
     * Creates a new app-data-structure listener.
     */
    private AppDataStructureListener() {
    }

    /**
     * Performs validation and updates the data model tree. It is called when parser receives an
     * input matching the grammar rule(app-data-structure).
     *
     * @param listener listener's object
     * @param ctx      context object of the grammar rule
     */
    public static void processAppDataStructureEntry(TreeWalkListener listener,
                                                    AppDataStructureStatementContext ctx) {

        ListenerValidation.checkStackIsNotEmpty(listener, ListenerErrorType.MISSING_HOLDER, APP_DATA_STRUCTURE, "", ListenerErrorLocation.ENTRY);

        String prefix = ListenerUtil.getValidPrefix(ctx.APP_DATA_STRUCTURE().getText(), APP_DATA_STRUCTURE, ctx);
        YangDataStructure dataStructure = getDataStructureType(ctx.appDataStructure().getText());

        YangAppDataStructure appDataStructure = new YangAppDataStructure();
        appDataStructure.setPrefix(prefix);
        appDataStructure.setDataStructure(dataStructure);
        appDataStructure.setLineNumber(ctx.getStart().getLine());
        appDataStructure.setCharPosition(ctx.getStart().getCharPositionInLine());
        appDataStructure.setFileName(listener.getFileName());

        Parsable curData = listener.getParsedDataStack().peek();
        if (curData instanceof YangCompilerAnnotation) {
            YangCompilerAnnotation compilerAnnotation = ((YangCompilerAnnotation) curData);
            compilerAnnotation.setYangAppDataStructure(appDataStructure);
            listener.getParsedDataStack().push(appDataStructure);
        } else {
            throw new ParserException(ListenerErrorMessageConstruction.constructListenerErrorMessage(ListenerErrorType.INVALID_HOLDER, APP_DATA_STRUCTURE,
                    "", ListenerErrorLocation.ENTRY));
        }
    }

    /**
     * Performs validation and updates the data model tree. It is called when parser
     * exits from grammar rule (app-data-structure).
     *
     * @param listener listener's object
     * @param ctx      context object of the grammar rule
     */
    public static void processAppDataStructureExit(TreeWalkListener listener,
                                                   AppDataStructureStatementContext ctx) {

        ListenerValidation.checkStackIsNotEmpty(listener, ListenerErrorType.MISSING_HOLDER, APP_DATA_STRUCTURE, "", ListenerErrorLocation.EXIT);
        if (!(listener.getParsedDataStack().peek() instanceof YangAppDataStructure)) {
            throw new ParserException(ListenerErrorMessageConstruction.constructListenerErrorMessage(ListenerErrorType.MISSING_CURRENT_HOLDER, APP_DATA_STRUCTURE,
                    "", ListenerErrorLocation.EXIT));
        }
        listener.getParsedDataStack().pop();
    }
}
