### demonstrated bug: PMR 27623,010,618

When packaging a JBatch implementation in a WAR, the Websphere implementation does not get excluded.

### how to reproduce

1. Build $ mvn clean install
2. Deploy WAR from /target to WAS9

### actual behavior

Starting the WAR failes with `org.jboss.weld.exceptions.DeploymentException`.
```
  - Producer Method [String] with qualifiers [@BatchProperty @Any] declared as [[UnbackedAnnotatedMethod] @Produces @BatchProperty public org.apache.batchee.container.cdi.BatchProducerBean.produceProperty(InjectionPoint)],
  - Producer Method [String] with qualifiers [@BatchProperty @Any] declared as [[UnbackedAnnotatedMethod] @Produces @BatchProperty @Dependent public com.ibm.ws.jbatch.cdi.BatchProducerBean.produceProperty(InjectionPoint)]
```


### expected behavior

Application starts. And batch can be executed.
