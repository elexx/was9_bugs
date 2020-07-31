/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package at.struct.was9bugs.bug22;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;

/**
 * PMR that @PostConstruct does not work on private methods on WAS-9.0.5.4.
 * This is a regression. It used to perfectly work on e.g. WAS-9.0.0.7
 * 
 * From the JSR-250 common-annotations specification:
 * Chapter 2.5 javax.annotation.PostConstruct
 * 
 * &quot;The method on which PostConstruct is applied MAY be public, protected, package private or private&quot;
 * 
 * @author <a href="mailto:struberg@apache.org">Mark Struberg</a>
 */
@ApplicationScoped
public class AppStartupBeanWithPrivateInit {

    @PostConstruct
    private void init() {
        System.out.println("init done, all fine!");
    }
    
    public void startMeUp(@Observes @Initialized(ApplicationScoped.class) Object initObject) {
        System.out.println("Application Context did fire it's started.");
    }
}
