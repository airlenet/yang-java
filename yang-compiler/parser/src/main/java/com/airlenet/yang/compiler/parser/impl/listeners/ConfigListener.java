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
 * config-stmt         = config-keyword sep
 *                       config-arg-str stmtend
 * config-arg-str      = < a string that matches the rule
 *                         config-arg >
 * config-arg          = true-keyword / false-keyword
 *
 * ANTLR grammar rule
 * configStatement : CONFIG_KEYWORD config STMTEND;
 * config          : string;
 */

import com.airlenet.yang.compiler.datamodel.YangConfig;
import com.airlenet.yang.compiler.datamodel.utils.Parsable;
import com.airlenet.yang.compiler.parser.exceptions.ParserException;
import com.airlenet.yang.compiler.parser.impl.TreeWalkListener;
import com.airlenet.yang.compiler.parser.impl.parserutils.*;
import com.airlenet.yang.compiler.parser.antlrgencode.GeneratedYangParser;

import static com.airlenet.yang.compiler.datamodel.utils.YangConstructType.CONFIG_DATA;

/**
 * Represents listener based call back function corresponding to the "config"
 * rule defined in ANTLR grammar file for corresponding ABNF rule in RFC 6020.
 */
public final class ConfigListener {

    /**
     * Creates a new config listener.
     */
    private ConfigListener() {
    }

    /**
     * It is called when parser receives an input matching the grammar rule
     * (config), performs validation and updates the data model tree.
     *
     * @param listener listener's object
     * @param ctx      context object of the grammar rule
     */
    public static void processConfigEntry(TreeWalkListener listener,
                                          GeneratedYangParser.ConfigStatementContext ctx) {

        // Check for stack to be non empty.
        ListenerValidation.checkStackIsNotEmpty(listener, ListenerErrorType.MISSING_HOLDER, CONFIG_DATA, "", ListenerErrorLocation.ENTRY);

        boolean isConfig = ListenerUtil.getValidBooleanValue(ctx.config().getText(),
                                                CONFIG_DATA, ctx);

        Parsable tmpData = listener.getParsedDataStack().peek();
        if (tmpData instanceof YangConfig) {
            YangConfig config = ((YangConfig) tmpData);
            config.setConfig(isConfig);
        } else {
            throw new ParserException(
                    ListenerErrorMessageConstruction.constructListenerErrorMessage(ListenerErrorType.INVALID_HOLDER,
                                                  CONFIG_DATA, "", ListenerErrorLocation.ENTRY));
        }
    }
}
