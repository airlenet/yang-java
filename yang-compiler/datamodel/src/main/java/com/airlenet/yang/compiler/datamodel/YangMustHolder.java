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

package com.airlenet.yang.compiler.datamodel;

import java.util.List;

/**
 * Abstraction of must entity. It is used to abstract the data holders of must.
 */
public interface YangMustHolder {

    /**
     * Returns the list of must from data holder like container / list.
     *
     * @return the list of must
     */
    List<YangMust> getListOfMust();

    /**
     * Sets the list of must.
     *
     * @param mustConstraintList the list of must to set
     */
    void setListOfMust(List<YangMust> mustConstraintList);

    /**
     * Adds must in data holder like container / list.
     *
     * @param must the must to be added
     */
    void addMust(YangMust must);
}
