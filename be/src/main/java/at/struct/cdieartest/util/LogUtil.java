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
import java.util.logging.Logger;

/**
 * Log out a CDI Invocation
 * @author <a href="mailto:struberg@yahoo.de">Mark Struberg</a>
 */
public class LogUtil {

    public static void logInvocation(Extension extension, ClassLoader cl, String... params) {
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
        sb.append("------------------------------------------------------------------------------------------------------------------------------\n");

        logger.info(sb.toString());
    }
}
