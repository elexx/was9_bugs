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
package at.struct.cdieartest.war1;

import at.struct.cdieartest.util.BaseLoggingExtension;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.ProcessAnnotatedType;
import java.util.ArrayList;
import java.util.List;

/**
 * CDI Extension registered in war1
 * @author <a href="mailto:struberg@yahoo.de">Mark Struberg</a>
 */
public class War1Extension extends BaseLoggingExtension {
    private List<String> classNames = new ArrayList<>();

    public void collectMe(@Observes ProcessAnnotatedType pat) {
        classNames.add(pat.getAnnotatedType().getJavaClass().getName());
    }

    public List<String> getClassNames() {
        return classNames;
    }
}
