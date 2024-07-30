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
package at.struct.was9bugs.wlp1;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.BeforeBeanDiscovery;
import javax.enterprise.inject.spi.BeforeShutdown;
import javax.enterprise.inject.spi.Extension;

/**
 * @author <a href="mailto:struberg@apache.org">Mark Struberg</a>
 */
public class TestExtension implements Extension {

    private static final Logger log = Logger.getLogger(TestExtension.class.getName());

    public void theStartup(@Observes BeforeBeanDiscovery event) {
        performTest(event.getClass().getSimpleName());
    }


    public void theShutdown(@Observes BeforeShutdown event) {
        performTest(event.getClass().getSimpleName());
    }

    void performTest(String eventType) {
        log.log(Level.INFO, "TCCL in {0} is: {1}, class.getClassLoader is: {2}", new Object[]{
                eventType,
                Thread.currentThread().getContextClassLoader(),
                getClass().getClassLoader()
        });
    }
}
