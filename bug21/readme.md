### demonstrated bug: PMR TS000805220

RequestScoped is not active in `@PreDestroy` hooks of SessionScoped Beans.

### how to reproduce

1. Build $ mvn clean install
2. Deploy WAR from /target to WAS9
3. open bug/index.xhtml
4. click on "Logout" to perform a `session.invalidate()`

### actual behavior

See the Stacktrace in SystemErr.log

### expected behavior

Should log: "Called remove for user: JaneDoeX" 
