### demonstrated bug: PMR 27185,010,618

Voting against an EJB results in exceptions.

### how to reproduce

1. Build $ mvn clean install
2. Deploy WAR from /target to WAS9
3. open bug/index.xhtml

### actual behavior

Application does not start.

### expected behavior

Application does start.
