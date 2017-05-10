### demonstrated bug: PMR 27622,010,618

When starting a Java Batch (JSR352) WAR, that uses `@Inject @BatchProperty Boolean someBool;` a `javax.enterprise.inject.UnsatisfiedResolutionException` is raised.

### how to reproduce

1. Build $ mvn clean install
2. Deploy WAR from /target to WAS9

### actual behavior

Starting the WAR failes with Unsatisfied dependencies for type Boolean with qualifiers @BatchProperty.

### expected behavior

Application starts. And batch can be executed.
