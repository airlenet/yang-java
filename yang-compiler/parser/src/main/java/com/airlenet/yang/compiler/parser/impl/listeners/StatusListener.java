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

import com.airlenet.yang.compiler.datamodel.YangStatus;
import com.airlenet.yang.compiler.datamodel.YangStatusType;
import com.airlenet.yang.compiler.datamodel.utils.Parsable;
import com.airlenet.yang.compiler.parser.exceptions.ParserException;
import com.airlenet.yang.compiler.parser.impl.TreeWalkListener;
import com.airlenet.yang.compiler.parser.impl.parserutils.*;
import com.airlenet.yang.compiler.parser.antlrgencode.GeneratedYangParser;

import static com.airlenet.yang.compiler.datamodel.utils.YangConstructType.STATUS_DATA;
import static com.airlenet.yang.compiler.datamodel.utils.YangConstructType.getYangConstructType;

/*
 * Reference: RFC6020 and YANG ANTLR Grammar
 *
 * ABNF grammar as per RFC6020
 *  status-stmt         = status-keyword sep status-arg-str stmtend
 *  status-arg-str      = < a string that matches the rule
 *                         status-arg >
 *  status-arg          = current-keyword /
 *                        obsolete-keyword /
 *                        deprecated-keyword
 *
 * ANTLR grammar rule
 * statusStatement : STATUS_KEYWORD status STMTEND;
 */

/**
 * Represents listener based call back function corresponding to the "status"
 * rule defined in ANTLR grammar file for corresponding ABNF rule in RFC 6020.
 */
public final class StatusListener {

    private static final String CURRENT_KEYWORD = "current";
    private static final String DEPRECATED_KEYWORD = "deprecated";
    private static final String OBSOLETE_KEYWORD = "obsolete";

    /**
     * Creates a new status listener.
     */
    private StatusListener() {
    }

    /**
     * It is called when parser receives an input matching the grammar
     * rule (status), performs validation and updates the data model
     * tree.
     *
     * @param listener listener's object
     * @param ctx      context object of the grammar rule
     */
    public static void processStatusEntry(TreeWalkListener listener,
                                          GeneratedYangParser.StatusStatementContext ctx) {

        // Check for stack to be non empty.
        ListenerValidation.checkStackIsNotEmpty(listener, ListenerErrorType.MISSING_HOLDER, STATUS_DATA, "", ListenerErrorLocation.ENTRY);

        YangStatusType status = getValidStatus(ctx);

        Parsable tmpData = listener.getParsedDataStack().peek();
        if (tmpData instanceof YangStatus) {
            YangStatus yangStatus = (YangStatus) tmpData;
            yangStatus.setStatus(status);
        } else {
            throw new ParserException(ListenerErrorMessageConstruction.constructListenerErrorMessage(ListenerErrorType.INVALID_HOLDER, STATUS_DATA, "", ListenerErrorLocation.ENTRY));
        }
    }

    /**
     * Validates status value and returns the value from context.
     *
     * @param ctx context object of the grammar rule
     * @return status current/deprecated/obsolete
     */
    private static YangStatusType getValidStatus(GeneratedYangParser.StatusStatementContext ctx) {

        YangStatusType status;

        String value = ListenerUtil.removeQuotesAndHandleConcat(ctx.status().getText());
        switch (value) {
            case CURRENT_KEYWORD: {
                status = YangStatusType.CURRENT;
                break;
            }
            case DEPRECATED_KEYWORD: {
                status = YangStatusType.DEPRECATED;
                break;
            }
            case OBSOLETE_KEYWORD: {
                status = YangStatusType.OBSOLETE;
                break;
            }
            default: {
                ParserException parserException = new ParserException("YANG file error : " +
                        getYangConstructType(STATUS_DATA) + " " + ctx.status().getText() +
                        " is not valid.");
                parserException.setLine(ctx.getStart().getLine());
                parserException.setCharPosition(ctx.getStart().getCharPositionInLine());
                throw parserException;
            }
        }

        return status;
    }
}