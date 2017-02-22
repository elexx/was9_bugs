### demonstrated bug: PMR 27212,010,618

Eventobserver for `@Initialized(ApplicationScoped.class)` do not get called when located in war/lib 

### how to reproduce

1. Build $ mvn clean install
2. Deploy WAR from /target to WAS9
3. open bug/index.xhtml

### actual behavior

Application does not start.

### expected behavior

Application does start.
