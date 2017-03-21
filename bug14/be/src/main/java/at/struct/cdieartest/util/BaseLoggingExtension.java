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

import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.AfterBeanDiscovery;
import javax.enterprise.inject.spi.AfterDeploymentValidation;
import javax.enterprise.inject.spi.BeforeBeanDiscovery;
import javax.enterprise.inject.spi.BeforeShutdown;
import javax.enterprise.inject.spi.Extension;
import javax.enterprise.inject.spi.ProcessAnnotatedType;

/**
 * @author <a href="mailto:struberg@yahoo.de">Mark Struberg</a>
 */
public abstract class BaseLoggingExtension implements Extension {

    public void beforeBeanDiscovery(@Observes BeforeBeanDiscovery bbd) {
        LogUtil.logExtensionInvocation(this, null);
    }

    public void processAnnotatedType(@Observes ProcessAnnotatedType pat) {
        String className = pat.getAnnotatedType().getJavaClass().getName();
        if (className.contains("at.struct.cdieartest")) {
            LogUtil.logExtensionInvocation(this, pat);
        }
    }

    public void afterBeanDicovery(@Observes AfterBeanDiscovery bbd) {
        LogUtil.logExtensionInvocation(this, null);
    }

    public void afterDeploymentValidation(@Observes AfterDeploymentValidation afterDeploymentValidation) {
        LogUtil.logExtensionInvocation(this, null);
    }

    public void beforeShutDown(@Observes BeforeShutdown beforeShutdown) {
        LogUtil.logExtensionInvocation(this, null);
    }


}
