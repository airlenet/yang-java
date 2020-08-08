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

package com.airlenet.yang.compiler.plugin.maven;

import org.apache.maven.plugin.MojoExecutionException;
import org.junit.Test;
import com.airlenet.yang.compiler.parser.exceptions.ParserException;
import com.airlenet.yang.compiler.tool.YangCompilerManager;
import com.airlenet.yang.compiler.utils.io.YangPluginConfig;
import com.airlenet.yang.compiler.utils.io.impl.YangIoUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

import static com.airlenet.yang.compiler.utils.io.impl.YangFileScanner.getYangFiles;

/**
 * Unit test case for typedef translator.
 */
public class TypeDefTranslatorTest {

    private final YangCompilerManager utilManager =
            new YangCompilerManager();
    private static final String DIR = "target/typedefTranslator/";
    private static final String DIR1 = System.getProperty("user.dir") + File
            .separator + DIR;

    /**
     * Checks typedef translation should not result in any exception.
     *
     * @throws MojoExecutionException
     */
    @Test
    public void processTypeDefTranslator() throws IOException,
            ParserException, MojoExecutionException {

        YangIoUtils.deleteDirectory(DIR);
        String searchDir = "src/test/resources/typedefTranslator/without";
        Set<Path> paths = new HashSet<>();
        for (String file : getYangFiles(searchDir)) {
            paths.add(Paths.get(file));
        }

        utilManager.createYangFileInfoSet(paths);
        utilManager.parseYangFileInfoSet();
        utilManager.createYangNodeSet();
        utilManager.resolveDependenciesUsingLinker();

        YangPluginConfig yangPluginConfig = new YangPluginConfig();
        yangPluginConfig.setCodeGenDir(DIR);
        utilManager.translateToJava(yangPluginConfig);
        YangPluginConfig.compileCode(DIR1);
        YangIoUtils.deleteDirectory(DIR);
    }

    /**
     * Checks typedef translation should not result in any exception.
     *
     * @throws MojoExecutionException
     */
    @Test
    public void processTypeDefWithRestrictionsTranslator() throws IOException,
            ParserException, MojoExecutionException {

        YangIoUtils.deleteDirectory(DIR);
        String searchDir = "src/test/resources/typedefTranslator/with";
        Set<Path> paths = new HashSet<>();
        for (String file : getYangFiles(searchDir)) {
            paths.add(Paths.get(file));
        }

        utilManager.createYangFileInfoSet(paths);
        utilManager.parseYangFileInfoSet();
        utilManager.createYangNodeSet();
        utilManager.resolveDependenciesUsingLinker();

        YangPluginConfig yangPluginConfig = new YangPluginConfig();
        yangPluginConfig.setCodeGenDir(DIR);
        utilManager.translateToJava(yangPluginConfig);
        YangPluginConfig.compileCode(DIR1);
        YangIoUtils.deleteDirectory(DIR);
    }

    /**
     * Checks typedef translation should not result in any exception.
     *
     * @throws MojoExecutionException
     */
    @Test
    public void processTypeDefWithUnionAndBitsTranslator() throws IOException,
            ParserException, MojoExecutionException {

        YangIoUtils.deleteDirectory(DIR);
        String searchDir = "src/test/resources/typedefTranslator/union";
        Set<Path> paths = new HashSet<>();
        for (String file : getYangFiles(searchDir)) {
            paths.add(Paths.get(file));
        }

        utilManager.createYangFileInfoSet(paths);
        utilManager.parseYangFileInfoSet();
        utilManager.createYangNodeSet();
        utilManager.resolveDependenciesUsingLinker();

        YangPluginConfig yangPluginConfig = new YangPluginConfig();
        yangPluginConfig.setCodeGenDir(DIR);
        utilManager.translateToJava(yangPluginConfig);
        YangPluginConfig.compileCode(DIR1);
        YangIoUtils.deleteDirectory(DIR);
    }
}