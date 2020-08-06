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

import com.airlenet.yang.compiler.parser.exceptions.ParserException;
import com.airlenet.yang.compiler.parser.impl.TreeWalkListener;
import org.antlr.v4.runtime.ParserRuleContext;
import com.airlenet.yang.compiler.datamodel.YangCase;
import com.airlenet.yang.compiler.datamodel.YangChoice;
import com.airlenet.yang.compiler.datamodel.YangConfig;
import com.airlenet.yang.compiler.datamodel.YangInput;
import com.airlenet.yang.compiler.datamodel.YangNode;
import com.airlenet.yang.compiler.datamodel.YangNotification;
import com.airlenet.yang.compiler.datamodel.YangOutput;
import com.airlenet.yang.compiler.datamodel.YangRpc;
import com.airlenet.yang.compiler.datamodel.utils.Parsable;
import com.airlenet.yang.compiler.datamodel.utils.YangConstructType;

import java.util.Iterator;
import java.util.List;

import static com.airlenet.yang.compiler.datamodel.utils.YangConstructType.getYangConstructType;
import static com.airlenet.yang.compiler.parser.impl.parserutils.ListenerErrorMessageConstruction.constructListenerErrorMessage;

/**
 * Represents a utility to carry out listener validation.
 */
public final class ListenerValidation {

    /**
     * Creates a new listener validation.
     */
    private ListenerValidation() {
    }

    /**
     * Checks parsed data stack is not empty.
     *
     * @param listener Listener's object
     * @param errorType error type needs to be set in error message
     * @param yangConstructType type of parsable data in which error occurred
     * @param parsableDataTypeName name of parsable data type in which error
     *            occurred
     * @param errorLocation location where error occurred
     */
    public static void checkStackIsNotEmpty(TreeWalkListener listener, ListenerErrorType errorType,
                                            YangConstructType yangConstructType, String parsableDataTypeName,
                                            ListenerErrorLocation errorLocation) {

        if (listener.getParsedDataStack().empty()) {
            /*
             * If stack is empty it indicates error condition, value of
             * parsableDataTypeName will be null in case there is no name
             * attached to parsable data type.
             */
            String message = constructListenerErrorMessage(errorType, yangConstructType, parsableDataTypeName,
                    errorLocation);
            throw new ParserException(message);
        }
    }

    /**
     * Checks parsed data stack is empty.
     *
     * @param listener Listener's object
     * @param errorType error type needs to be set in error message
     * @param yangConstructType type of parsable data in which error occurred
     * @param parsableDataTypeName name of parsable data type in which error
     *            occurred
     * @param errorLocation location where error occurred
     */
    public static void checkStackIsEmpty(TreeWalkListener listener, ListenerErrorType errorType,
            YangConstructType yangConstructType, String parsableDataTypeName,
            ListenerErrorLocation errorLocation) {

        if (!listener.getParsedDataStack().empty()) {
            /*
             * If stack is empty it indicates error condition, value of
             * parsableDataTypeName will be null in case there is no name
             * attached to parsable data type.
             */
            String message = constructListenerErrorMessage(errorType, yangConstructType, parsableDataTypeName,
                    errorLocation);
            throw new ParserException(message);
        }
    }

    /**
     * Returns parent node config value, if top node does not specify a config
     * statement then default value true is returned.
     *
     * @param listener listener's object
     * @return true/false parent's config value
     */
    public static boolean getParentNodeConfig(TreeWalkListener listener) {
        Parsable curData = listener.getParsedDataStack().peek();
        YangNode parentNode = ((YangNode) curData).getParent();
        if (curData instanceof YangConfig) {
            return ((YangConfig) curData).isConfig();
        } else if (curData instanceof YangRpc || curData instanceof YangOutput
                || curData instanceof YangInput || curData instanceof YangNotification) {
            return false;
        } else if (curData instanceof YangCase && parentNode instanceof YangChoice) {
            return ((YangChoice) parentNode).isConfig();
        } else {
            return true;
        }
    }

    /**
     * Checks if a rule occurrences is as per the expected YANG grammar's
     * cardinality.
     *
     * @param childContext child's context
     * @param yangChildConstruct child construct for whom cardinality is to be
     *            validated
     * @param yangParentConstruct parent construct
     * @param parentName parent name
     * @throws ParserException exception if cardinality check fails
     */
    public static void validateCardinalityMaxOne(List<?> childContext, YangConstructType yangChildConstruct,
            YangConstructType yangParentConstruct, String parentName)
            throws ParserException {

        if (!childContext.isEmpty() && childContext.size() != 1) {
            ParserException parserException = new ParserException("YANG file error: \""
                    + getYangConstructType(yangChildConstruct) + "\" is defined more than once in \""
                    + getYangConstructType(yangParentConstruct) + " " + parentName + "\".");

            Iterator<?> context = childContext.iterator();
            parserException.setLine(((ParserRuleContext) context.next()).getStart().getLine());
            parserException.setCharPosition(((ParserRuleContext) context.next()).getStart().getCharPositionInLine());
            throw parserException;
        }
    }

    /**
     * Checks if a rule occurrences is exactly 1.
     *
     * @param childContext child's context
     * @param yangChildConstruct child construct for whom cardinality is to be
     *                           validated
     * @param yangParentConstruct parent construct
     * @param parentName parent name
     * @param parentContext parents's context
     * @throws ParserException exception if cardinality check fails
     */
    public static void validateCardinalityEqualsOne(List<?> childContext, YangConstructType yangChildConstruct,
            YangConstructType yangParentConstruct, String parentName,
            ParserRuleContext parentContext)
            throws ParserException {

        if (childContext.isEmpty()) {
            ParserException parserException = new ParserException("YANG file error: Missing \""
                    + getYangConstructType(yangChildConstruct) + "\" in \"" + getYangConstructType(yangParentConstruct)
                    + " " + parentName + "\".");
            parserException.setLine(parentContext.getStart().getLine());
            parserException.setCharPosition(parentContext.getStart().getCharPositionInLine());
            throw parserException;
        } else if (!childContext.isEmpty() && childContext.size() != 1) {
            Iterator<?> childcontext = childContext.iterator();
            ParserException parserException = new ParserException("YANG file error: \""
                    + getYangConstructType(yangChildConstruct) + "\" is present more than once in \""
                    + getYangConstructType(yangParentConstruct) + " " + parentName + "\".");
            parserException.setLine(((ParserRuleContext) childcontext.next()).getStart().getLine());
            parserException.setCharPosition(((ParserRuleContext) childcontext.next()).getStart()
                    .getCharPositionInLine());
            throw parserException;
        }
    }

    /**
     * Checks if a rule occurrences is minimum 1.
     *
     * @param childContext child's context
     * @param yangChildConstruct child construct for whom cardinality is to be
     *                           validated
     * @param yangParentConstruct parent construct
     * @param parentName parent name
     * @param parentContext parents's context
     * @throws ParserException exception if cardinality check fails
     */
    public static void validateCardinalityNonZero(List<?> childContext, YangConstructType yangChildConstruct,
            YangConstructType yangParentConstruct, String parentName,
            ParserRuleContext parentContext)
            throws ParserException {

        if (childContext.isEmpty()) {
            ParserException parserException = new ParserException("YANG file error: Missing \""
                    + getYangConstructType(yangChildConstruct) + "\" in \"" + getYangConstructType(yangParentConstruct)
                    + " " + parentName + "\".");

            parserException.setLine(parentContext.getStart().getLine());
            parserException.setCharPosition(parentContext.getStart().getCharPositionInLine());
            throw parserException;
        }
    }

    /**
     * Checks if a either of one construct occurrence.
     *
     * @param child1Context       first optional child's context
     * @param yangChild1Construct first child construct for whom cardinality is
     *                            to be validated
     * @param child2Context       second optional child's context
     * @param yangChild2Construct second child construct for whom cardinality is
     *                            to be validated
     * @param yangParentConstruct parent construct
     * @param parentName          parent name
     * @param parentContext       parents's context
     * @throws ParserException exception if cardinality check fails
     */
    public static void validateCardinalityEitherOne(List<?> child1Context, YangConstructType yangChild1Construct,
                                                    List<?> child2Context, YangConstructType yangChild2Construct,
                                                    YangConstructType yangParentConstruct, String parentName,
                                                    ParserRuleContext parentContext)
            throws ParserException {

        if (child1Context.isEmpty() && child2Context.isEmpty()) {
            ParserException parserException = new ParserException("YANG file error: Either \""
                    + getYangConstructType(yangChild1Construct) + "\" or \"" + getYangConstructType(yangChild2Construct)
                    + "\" should be present in \"" + getYangConstructType(yangParentConstruct) + " "
                    + parentName + "\".");
            parserException.setLine(parentContext.getStart().getLine());
            parserException.setCharPosition(parentContext.getStart().getCharPositionInLine());
            throw parserException;
        }
    }

    /**
     * Checks if a either of one construct occurrence.
     *
     * @param ctx1       first optional child's context
     * @param type1      first child construct for whom cardinality is
     *                   to be validated
     * @param ctx2       second optional child's context
     * @param type2      second child construct for whom cardinality is
     *                   to be validated
     * @param type       parent construct
     * @param parentName parent name
     * @param ctx        parents's context
     * @throws ParserException exception if cardinality check fails
     */
    public static void validateCardinalityMutuallyExclusive(List<?> ctx1,
                                                            YangConstructType type1,
                                                            List<?> ctx2,
                                                            YangConstructType type2,
                                                            YangConstructType type,
                                                            String parentName,
                                                            ParserRuleContext ctx)
            throws ParserException {

        if (!ctx1.isEmpty() && !ctx2.isEmpty()) {
            String error = "YANG file error: Either " + getYangConstructType(type1)
                    + " or " + getYangConstructType(type2) + " should be present in "
                    + getYangConstructType(type) + " " + parentName + ".";
            ParserException parserException = new ParserException(error);
            parserException.setLine(ctx.getStart().getLine());
            parserException.setCharPosition(ctx.getStart().getCharPositionInLine());
            throw parserException;
        }
    }
}
