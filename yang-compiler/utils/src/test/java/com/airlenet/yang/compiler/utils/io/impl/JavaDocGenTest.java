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

package com.airlenet.yang.compiler.utils.io.impl;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import com.airlenet.yang.compiler.utils.io.YangPluginConfig;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;
import static com.airlenet.yang.compiler.utils.io.impl.JavaDocGen.JavaDocType.CONSTRUCTOR;
import static com.airlenet.yang.compiler.utils.io.impl.JavaDocGen.JavaDocType.DEFAULT_CLASS;
import static com.airlenet.yang.compiler.utils.io.impl.JavaDocGen.JavaDocType.DEFAULT_CONSTRUCTOR;
import static com.airlenet.yang.compiler.utils.io.impl.JavaDocGen.JavaDocType.GETTER_METHOD;
import static com.airlenet.yang.compiler.utils.io.impl.JavaDocGen.JavaDocType.INTERFACE;
import static com.airlenet.yang.compiler.utils.io.impl.JavaDocGen.JavaDocType.PACKAGE_INFO;
import static com.airlenet.yang.compiler.utils.io.impl.JavaDocGen.JavaDocType.SETTER_METHOD;
import static com.airlenet.yang.compiler.utils.io.impl.JavaDocGen.JavaDocType.TYPE_DEF_SETTER_METHOD;
import static com.airlenet.yang.compiler.utils.io.impl.JavaDocGen.getJavaDoc;

/**
 * Tests the java doc that is generated.
 */
public final class JavaDocGenTest {

    private static final String TEST_NAME = "testName";
    private static final String END_STRING = " */\n";

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    /**
     * A private constructor is tested.
     *
     * @throws SecurityException         if any security violation is observed
     * @throws NoSuchMethodException     if when the method is not found
     * @throws IllegalArgumentException  if there is illegal argument found
     * @throws InstantiationException    if instantiation is provoked for the private constructor
     * @throws IllegalAccessException    if instance is provoked or a method is provoked
     * @throws InvocationTargetException when an exception occurs by the method or constructor
     */
    @Test
    public void callPrivateConstructors()
            throws SecurityException, NoSuchMethodException, IllegalArgumentException,
            InstantiationException, IllegalAccessException, InvocationTargetException {

        Class<?>[] classesToConstruct = {JavaDocGen.class};
        for (Class<?> clazz : classesToConstruct) {
            Constructor<?> constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true);
            assertThat(null, not(constructor.newInstance()));
        }
    }

    /**
     * This test case checks the content received for the constructor java doc.
     */
    @Test
    public void constructorGenerationTest() {
        String constructorDoc = getJavaDoc(CONSTRUCTOR, TEST_NAME, false, null);
        assertThat(true,
                is(constructorDoc.contains("Creates an instance of ")
                        && constructorDoc.contains("object value of")
                        && constructorDoc.contains("@param") && constructorDoc.contains("*/\n")));
    }

    /**
     * This test case checks the content received for the default constructor java doc.
     */
    @Test
    public void defaultConstructorGenerationTest() {
        String defaultConstructorDoc = getJavaDoc(DEFAULT_CONSTRUCTOR, TEST_NAME, false, null);
        assertThat(true, is(defaultConstructorDoc.contains("Creates an instance of ")
                && defaultConstructorDoc.contains(END_STRING)));
    }

    /**
     * This test case checks the content received for the getter java doc.
     */
    @Test
    public void getterGenerationTest() {
        String getterJavaDoc = getJavaDoc(GETTER_METHOD, TEST_NAME, false, null);
        assertThat(true,
                is(getterJavaDoc.contains("Returns the attribute") && getterJavaDoc.contains(END_STRING)));
    }

    /**
     * This test case checks the content received for the impl class java doc.
     */
    @Test
    public void implClassGenerationTest() {
        String implClassJavaDoc = getJavaDoc(DEFAULT_CLASS, TEST_NAME, false, null);
        assertThat(true,
                is(implClassJavaDoc.contains("Represents the implementation of")
                        && implClassJavaDoc.contains(END_STRING)));
    }

    /**
     * This test case checks the content received for the interface java doc.
     */
    @Test
    public void interfaceGenerationTest() {
        String interfaceJavaDoc = getJavaDoc(INTERFACE, TEST_NAME, false, null);
        assertThat(true,
                is(interfaceJavaDoc.contains("Abstraction of an entity which represents the functionality of")
                        && interfaceJavaDoc.contains(END_STRING)));
    }

    /**
     * This test case checks the content received for the package info  java doc.
     */
    @Test
    public void packageInfoGenerationTest() {
        String packageInfo = getJavaDoc(PACKAGE_INFO, TEST_NAME, false, null);
        assertThat(true,
                is(packageInfo.contains("Implementation of YANG node") && packageInfo.contains(END_STRING)));
    }

    /**
     * This test case checks the content received for the package info  java doc.
     */
    @Test
    public void packageInfoGenerationForChildNodeTest() {
        String packageInfo = getJavaDoc(PACKAGE_INFO, TEST_NAME, true, null);
        assertThat(true, is(packageInfo.contains("Implementation of YANG node testName's children nodes")
                && packageInfo.contains(END_STRING)));
    }

    /**
     * This test case checks the content received for the setter java doc.
     */
    @Test
    public void setterGenerationTest() {
        String setterJavaDoc = getJavaDoc(SETTER_METHOD, TEST_NAME, false, null);
        assertThat(true,
                is(setterJavaDoc.contains("Sets the attribute") &&
                        setterJavaDoc.contains(END_STRING)));
    }

    /**
     * This test case checks the content received for the typedef setter java doc.
     */
    @Test
    public void typeDefSetterGenerationTest() {
        String typeDefSetter = getJavaDoc(TYPE_DEF_SETTER_METHOD, TEST_NAME, false, null);
        assertThat(true, is(typeDefSetter.contains("Sets the value of") && typeDefSetter.contains(END_STRING)));
    }

    /**
     * Returns stub pluginConfig.
     *
     * @return stub pluginConfig
     */
    private YangPluginConfig getStubPluginConfig() {
        YangPluginConfig pluginConfig = new YangPluginConfig();
        pluginConfig.setConflictResolver(null);
        return pluginConfig;
    }
}
