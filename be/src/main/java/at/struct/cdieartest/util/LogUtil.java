/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package at.struct.cdieartest.util;

import javax.enterprise.inject.spi.Extension;
import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.logging.Logger;

/**
 * Log out a CDI Invocation
 * @author <a href="mailto:struberg@yahoo.de">Mark Struberg</a>
 */
public class LogUtil {

    public static final String LOG_SEPARATOR = "------------------------------------------------------------------------------------------------------------------------------\n";
    private static Set<String> classesToCheck = new ConcurrentSkipListSet<String>();

    public static void logExtensionInvocation(Extension extension, ClassLoader cl, String... params) {
        Logger logger = Logger.getLogger(Thread.currentThread().getStackTrace()[2].getClassName());

        String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        StringBuilder sb = new StringBuilder(methodName).append('\n');
        sb.append("Extension Instance: ").append(extension).append('\n');
        sb.append("ThreadContextClassLoader = ").append(Thread.currentThread().getContextClassLoader().toString()).append('\n');
        if (cl != null) {
            sb.append("Object ClassLoader = ").append(cl.toString()).append('\n');
        }
        if (params != null) {
            sb.append("params = ").append(Arrays.toString(params)).append('\n');
        }
        sb.append(LOG_SEPARATOR);

        logger.info(sb.toString());
    }

    public static void logVisibility(Object caller, String callerMessage) {
        Logger logger = Logger.getLogger(caller.getClass().getName());

        ClassLoader callerClassLoader = caller.getClass().getClassLoader();

        StringBuilder sb = new StringBuilder(callerMessage);
        sb.append("\nClass ").append(caller.getClass().getName()).append(" can see \n\t");

        for (String classToCheckBeingVisible : classesToCheck) {
            try {
                callerClassLoader.loadClass(classToCheckBeingVisible);
                sb.append(classToCheckBeingVisible).append(" : YES\n\t");
            } catch (ClassNotFoundException e) {
                sb.append(classToCheckBeingVisible).append(" : NO\n\t");
            }
        }
        sb.append(LOG_SEPARATOR);
        logger.info(sb.toString());
    }

    public static void addClassToCheckForVisibility(Class<?> clazz) {
        classesToCheck.add(clazz.getName());
    }
}
