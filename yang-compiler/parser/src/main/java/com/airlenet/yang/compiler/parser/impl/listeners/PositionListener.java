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

/*
 * Reference: RFC6020 and YANG ANTLR Grammar
 *
 * ABNF grammar as per RFC6020
 * position-stmt       = position-keyword sep
 *                       position-value-arg-str stmtend
 * position-value-arg-str = < a string that matches the rule
 *                            position-value-arg >
 * position-value-arg  = non-negative-integer-value
 * non-negative-integer-value = "0" / positive-integer-value
 * positive-integer-value = (non-zero-digit *DIGIT)
 * zero-integer-value  = 1*DIGIT
 *
 * ANTLR grammar rule
 * positionStatement : POSITION_KEYWORD position STMTEND;
 * position          : string;
 */

import com.airlenet.yang.compiler.datamodel.YangBit;
import com.airlenet.yang.compiler.datamodel.YangBits;
import com.airlenet.yang.compiler.datamodel.utils.Parsable;
import com.airlenet.yang.compiler.parser.exceptions.ParserException;
import com.airlenet.yang.compiler.parser.impl.TreeWalkListener;
import com.airlenet.yang.compiler.parser.impl.parserutils.*;

import static com.airlenet.yang.compiler.datamodel.utils.YangConstructType.POSITION_DATA;
import static com.airlenet.yang.compiler.parser.antlrgencode.GeneratedYangParser.PositionStatementContext;

/**
 * Represents listener based call back function corresponding to the "position"
 * rule defined in ANTLR grammar file for corresponding ABNF rule in RFC 6020.
 */
public final class PositionListener {

    /**
     * Creates a new position listener.
     */
    private PositionListener() {
    }

    /**
     * It is called when parser receives an input matching the grammar rule
     * (position), perform validations and update the data model tree.
     *
     * @param listener Listener's object
     * @param ctx      context object of the grammar rule
     */
    public static void processPositionEntry(TreeWalkListener listener,
                                            PositionStatementContext ctx) {

        // Check for stack to be non empty.
        ListenerValidation.checkStackIsNotEmpty(listener, ListenerErrorType.MISSING_HOLDER, POSITION_DATA, ctx.position().getText(), ListenerErrorLocation.ENTRY);

        // Obtain the node of the stack.
        Parsable tmpNode = listener.getParsedDataStack().peek();
        switch (tmpNode.getYangConstructType()) {
            case BIT_DATA: {
                YangBit bitNode = (YangBit) tmpNode;
                int positionValue = getValidBitPosition(listener, ctx);
                bitNode.setPosition(positionValue);
                break;
            }
            default:
                throw new ParserException(
                        ListenerErrorMessageConstruction.constructListenerErrorMessage(ListenerErrorType.INVALID_HOLDER, POSITION_DATA, ctx.position().getText(), ListenerErrorLocation.ENTRY));
        }
    }

    /**
     * Validates BITS position value correctness and uniqueness.
     *
     * @param listener Listener's object
     * @param ctx      context object of the grammar rule
     * @return position value
     */
    private static int getValidBitPosition(TreeWalkListener listener,
                                           PositionStatementContext ctx) {
        Parsable bitNode = listener.getParsedDataStack().pop();

        // Check for stack to be non empty.
        ListenerValidation.checkStackIsNotEmpty(listener, ListenerErrorType.MISSING_HOLDER, POSITION_DATA, ctx.position().getText(), ListenerErrorLocation.ENTRY);

        int positionValue = ListenerUtil.getValidNonNegativeIntegerValue(ctx.position().getText(), POSITION_DATA, ctx);

        Parsable tmpNode = listener.getParsedDataStack().peek();
        switch (tmpNode.getYangConstructType()) {
            case BITS_DATA: {
                YangBits yangBits = (YangBits) tmpNode;
                listener.getParsedDataStack().push(bitNode);
                if (yangBits.isBitPositionExists(positionValue)) {
                    ParserException parserException = new ParserException("YANG file error: Duplicate value of " +
                                                                                  "position is invalid.");
                    parserException.setLine(ctx.getStart().getLine());
                    parserException.setCharPosition(ctx.getStart().getCharPositionInLine());
                    throw parserException;
                }
                return positionValue;
            }
            default:
                listener.getParsedDataStack().push(bitNode);
                throw new ParserException(
                        ListenerErrorMessageConstruction.constructListenerErrorMessage(ListenerErrorType.INVALID_HOLDER, POSITION_DATA, ctx.position().getText(), ListenerErrorLocation.ENTRY));
        }
    }
}