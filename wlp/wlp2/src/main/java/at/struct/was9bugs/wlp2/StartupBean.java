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
package at.struct.was9bugs.wlp2;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Destroyed;
import javax.enterprise.context.Initialized;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.CDI;

/**
 * @author <a href="mailto:struberg@apache.org">Mark Struberg</a>
 */
@ApplicationScoped
public class StartupBean {
    private static final Logger log = Logger.getLogger(StartupBean.class.getName());

    public void startup(@Observes @Initialized(ApplicationScoped.class) Object startup) {
        logCDI("@Initialized(ApplicationScoped.class)");
    }

    @PostConstruct
    public void init() {
        logCDI("PostConstruct");

        startBackgroundThread();
    }

    private void startBackgroundThread() {
        log.info("Starting new Background Thread");


        final ExecutorService bg = Executors.newFixedThreadPool(1, new OwnThradFactory());

        bg.execute(()-> {
            try {
                Thread.sleep(500L);
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            logCDI("Background_Thread");
        });
    }

    @PreDestroy
    public void shutdown() {
        logCDI("PreDestroy");
    }

    public void destroyedReqScope(@Observes @Destroyed(RequestScoped.class) Object startup) {
        logCDI("@Destroyed(RequestScoped.class)");
    }

    public void destroyedAppScope(@Observes @Destroyed(ApplicationScoped.class) Object startup) {
        logCDI("@Destroyed(ApplicationScoped.class)");
    }


    public static void logCDI(String occasion) {
        try {
            BeanManager bm = CDI.current().getBeanManager();
            log.log(Level.INFO, "BeanManager at {0} is {1}, TCCL: {2}", new Object[]{occasion, bm.toString(), Thread.currentThread().getContextClassLoader().toString()});
        } catch (Exception e) {
            log.log(Level.WARNING, "Exception during getBeanManager at " + occasion + ", TCCL: " + Thread.currentThread().getContextClassLoader().toString(), e);
        }
    }

    private static class OwnThradFactory implements ThreadFactory {
        @Override
        public Thread newThread(Runnable runnable) {
            Thread bg = new Thread(null, runnable, "test thread");
            AccessController.doPrivileged(new PrivilegedAction<Void>() {
                @Override
                public Void run() {
                    bg.setContextClassLoader(OwnThradFactory.class.getClassLoader());
                    return null;
                }
            });
            bg.setUncaughtExceptionHandler((t,e) -> {
                log.log(Level.SEVERE, "Exception on Thread " + t, e);
            });
            return bg;
        }
    }
}
