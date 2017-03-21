### demonstrated bug: PMR xxxxx,010,618

Having an EAR with multiple WARs/EJBs inside requires the application server to isolate them. A module (in this case a WAR or EJB) must not see another modules classes, even during CDI bootstrap. This sample inspects the bootstrapping of the application and logs the detected visibilities. 

### how to reproduce

1. Build $ mvn clean install
2. Deploy EAR from /ear/target to WAS9

### actual behavior (in SystemOut.log)

During the phase ProcessAnnotatedType CDI extensions get all beans. For example `War1Extension` gets an event for `War2Extension` ...

```
00000130 LogUtil       I   logExtensionInvocation
Extension Instance: at.struct.cdieartest.war1.War1Extension@dc3a24ce
ThreadContextClassLoader =
com.ibm.ws.classloader.CompoundClassLoader@d4146451[app:bug14-ear]
   Local ClassPath: /app/IBM/WebSphere/AppServer/profiles/server1/installedApps/Cell_WAS01/bug14-ear.ear/ejb1.jar:/app/IBM/WebSphere/AppServer/profiles/server1/installedApps/Cell_WAS01/bug14-ear.ear/ejb2.jar:/app/IBM/WebSphere/AppServer/profiles/server1/installedApps/Cell_WAS01/bug14-ear.ear/lib/be-1.0-SNAPSHOT.jar
   Parent: com.ibm.ws.classloader.ProtectionClassLoader@c68e74d5
   Delegation Mode: PARENT_FIRST
Object ClassLoader =
com.ibm.ws.classloader.CompoundClassLoader@beca1421[war:bug14-ear/war2.war]
   Local ClassPath: /app/IBM/WebSphere/AppServer/profiles/server1/installedApps/Cell_WAS01/bug14-ear.ear/war2.war/WEB-INF/classes:/app/IBM/WebSphere/AppServer/profiles/server1/installedApps/Cell_WAS01/bug14-ear.ear/war2.war
   Parent: com.ibm.ws.classloader.CompoundClassLoader@d4146451[PF][app:bug14-ear]
   Delegation Mode: PARENT_FIRST
AnnotatedType = at.struct.cdieartest.war2.War2Extension
```

... and for `War2SampleBean` ...

```
00000130 LogUtil       I   logExtensionInvocation
Extension Instance: at.struct.cdieartest.war1.War1Extension@dc3a24ce
ThreadContextClassLoader =
com.ibm.ws.classloader.CompoundClassLoader@d4146451[app:bug14-ear]
   Local ClassPath: /app/IBM/WebSphere/AppServer/profiles/server1/installedApps/Cell_WAS01/bug14-ear.ear/ejb1.jar:/app/IBM/WebSphere/AppServer/profiles/server1/installedApps/Cell_WAS01/bug14-ear.ear/ejb2.jar:/app/IBM/WebSphere/AppServer/profiles/server1/installedApps/Cell_WAS01/bug14-ear.ear/lib/be-1.0-SNAPSHOT.jar
   Parent: com.ibm.ws.classloader.ProtectionClassLoader@c68e74d5
   Delegation Mode: PARENT_FIRST
Object ClassLoader =
com.ibm.ws.classloader.CompoundClassLoader@beca1421[war:bug14-ear/war2.war]
   Local ClassPath: /app/IBM/WebSphere/AppServer/profiles/server1/installedApps/Cell_WAS01/bug14-ear.ear/war2.war/WEB-INF/classes:/app/IBM/WebSphere/AppServer/profiles/server1/installedApps/Cell_WAS01/bug14-ear.ear/war2.war
   Parent: com.ibm.ws.classloader.CompoundClassLoader@d4146451[PF][app:bug14-ear]
   Delegation Mode: PARENT_FIRST
AnnotatedType = at.struct.cdieartest.war2.War2SampleBean
```

... and the `EarLoggingExtension` gets an event for `War1SampleBean` ...

```
00000130 LogUtil       I   logExtensionInvocation
Extension Instance: at.struct.cdieartest.EarLoggingExtension@2631ef79
ThreadContextClassLoader =
com.ibm.ws.classloader.CompoundClassLoader@d4146451[app:bug14-ear]
   Local ClassPath: /app/IBM/WebSphere/AppServer/profiles/server1/installedApps/Cell_WAS01/bug14-ear.ear/ejb1.jar:/app/IBM/WebSphere/AppServer/profiles/server1/installedApps/Cell_WAS01/bug14-ear.ear/ejb2.jar:/app/IBM/WebSphere/AppServer/profiles/server1/installedApps/Cell_WAS01/bug14-ear.ear/lib/be-1.0-SNAPSHOT.jar
   Parent: com.ibm.ws.classloader.ProtectionClassLoader@c68e74d5
   Delegation Mode: PARENT_FIRST
Object ClassLoader =
com.ibm.ws.classloader.CompoundClassLoader@eff69ff6[war:bug14-ear/war1.war]
   Local ClassPath: /app/IBM/WebSphere/AppServer/profiles/server1/installedApps/Cell_WAS01/bug14-ear.ear/war1.war/WEB-INF/classes:/app/IBM/WebSphere/AppServer/profiles/server1/installedApps/Cell_WAS01/bug14-ear.ear/war1.war
   Parent: com.ibm.ws.classloader.CompoundClassLoader@d4146451[PF][app:bug14-ear]
   Delegation Mode: PARENT_FIRST
AnnotatedType = at.struct.cdieartest.war1.War1SampleBean
```

... and so on.

### expected behavior

* `War1Extension` should only get events for classes packaged in the war1 or ear/lib (shared-libs)
* `War2Extension` should only get events for classes packaged in the war2 or ear/lib (shared-libs)
* `EarLoggingExtension`  should only get events for classes packaged in the ear/lib (shared-libs)
