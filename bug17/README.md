### demonstrated bug: PMR 27608,010,618 and 27680,010,618

Calling an EJB from a `javax.servlet.ServletContextListener` during `contextDestroyed` throws an `javax.ejb.NoSuchEJBException`. One would expect the shutdown order to be the opposite of the startup order. So if EJBs are available during `contextInitialized` they should also be available during `contextDestroyed`.

### how to reproduce

1. Build $ mvn clean install
2. Deploy WAR from /target to WAS9
3. Start the application
4. Stop the application

### actual behavior

During startup the application logs

```
[5/23/17 14:47:13:421 CEST] 00000099 SystemOut     O STARTUP!
[5/23/17 14:47:13:447 CEST] 00000099 SystemOut     O EJB working!
[5/23/17 14:47:13:448 CEST] 00000099 SystemOut     O FINISHED STARTUP!
```

During shutdown the application throws an exception after it logs

```
[5/23/17 14:47:22:402 CEST] 00000099 SystemOut     O SHUTDOWN!
[5/23/17 15:01:57:715 CEST] 00000097 webapp        E com.ibm.ws.webcontainer.webapp.WebApp notifyServletContextDestroyed SRVE0285E: Exception caught while destroying context: {0}
                                 javax.ejb.NoSuchEJBException: nested exception is: com.ibm.websphere.ejbcontainer.EJBStoppedException: The referenced version of the MyEjb bean in the bug17_war application has been stopped and may no longer be used. If the bug17_war application has been started again, a new reference for the new image of the MyEjb bean must be obtained. Local references to a bean or home are no longer valid once the application has been stopped.
```

### expected behavior

Shutdown should log
```
SHUTDOWN!
EJB working!
FINISHED SHUTDOWN!
```

without throwing an exception.
