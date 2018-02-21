### demonstrated bug: PMR -----,010,618

Injecting a produced typed bean which inherits from an abstract class with a parameterized constructor in a webservice leads in a NullPointerException.

### how to reproduce

1. Build $ mvn clean install
2. Deploy WAR from /target to WAS9
3. Start the application
4. Create a Webservice-Request in SOAP UI for URL localhost:8080/was-bug18/myWebservice
5. XML-Content of the request:
````
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:myw="http://was9bugs.struct.at/Webservice/MyWebservice/">
   <soapenv:Header/>
   <soapenv:Body>
      <myw:webserviceMethod>
         <request>
            <request>req</request>
         </request>
      </myw:webserviceMethod>
   </soapenv:Body>
</soapenv:Envelope>
````

### actual behavior

NullPointerException while injecting the bean.

```
...
Caused by: javax.ejb.EJBException: CWNEN0030E: The server was unable to obtain an object instance for the @Inject java.lang.reflect.Field.principal reference.  The exception message was: java.lang.NullPointerException; nested exception is: java.lang.NullPointerException
        ... 48 more
Caused by: java.lang.NullPointerException
        at org.jboss.weld.manager.BeanManagerImpl.getBean(BeanManagerImpl.java:883)
        at org.jboss.weld.manager.BeanManagerImpl.getInjectableReference(BeanManagerImpl.java:870)
        at com.ibm.ws.cdi.impl.inject.InjectInjectionObjectFactory$2.run(InjectInjectionObjectFactory.java:164)
        at java.security.AccessController.doPrivileged(AccessController.java:638)
        at com.ibm.ws.cdi.impl.inject.InjectInjectionObjectFactory.getObjectInstance(InjectInjectionObjectFactory.java:157)
        at com.ibm.ws.cdi.impl.inject.InjectInjectionBinding.getInjectionObjectInstance(InjectInjectionBinding.java:102)
        at com.ibm.wsspi.injectionengine.InjectionBinding.getInjectionObject(InjectionBinding.java:1433)
        at com.ibm.ws.cdi.impl.inject.InjectInjectionBinding.getInjectionObject(InjectInjectionBinding.java:135)
        at com.ibm.wsspi.injectionengine.InjectionBinding.getInjectableObject(InjectionBinding.java:1373)
        at com.ibm.wsspi.injectionengine.InjectionTarget.inject(InjectionTarget.java:108)
        at com.ibm.ws.injectionengine.AbstractInjectionEngine.inject(AbstractInjectionEngine.java:852)
        at com.ibm.ejs.container.ManagedBeanOBase.injectInstance(ManagedBeanOBase.java:148)
        ... 46 more

```

### expected behavior

Webservice should answer with a none fault response without throwing an exception.
