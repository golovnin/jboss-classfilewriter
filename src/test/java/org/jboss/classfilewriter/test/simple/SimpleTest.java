/*
 * JBoss, Home of Professional Open Source.
 *
 * Copyright 2012 Red Hat, Inc.
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
package org.jboss.classfilewriter.test.simple;

import java.io.Serializable;

import junit.framework.Assert;

import org.jboss.classfilewriter.ClassFile;
import org.junit.Test;

public class SimpleTest {

    @Test
    public void simpleTest() {
        ClassFile test = new ClassFile("com/test/AClass", "java/lang/Object");
        Class<?> clazz = test.define(getClass().getClassLoader());
        Assert.assertEquals("com.test.AClass", clazz.getName());
    }

    @Test
    public void testDefaultInterface() {
        ClassFile test = new ClassFile("DefaultPackageClass", "java/lang/Object");
        Class<?> clazz = test.define(getClass().getClassLoader());
        Assert.assertEquals("DefaultPackageClass", clazz.getName());
    }

    @Test
    public void testAddingInterfaces() {
        ClassFile test = new ClassFile("com/test/BClass", "java/lang/Object", "java/io/Serializable");
        Class<?> clazz = test.define(getClass().getClassLoader());
        Assert.assertEquals("com.test.BClass", clazz.getName());
        Assert.assertTrue(Serializable.class.isAssignableFrom(clazz));
        Assert.assertEquals(1, clazz.getInterfaces().length);
    }

}
