### demonstrated bug: PMR 26956,010,618

Switchting alternative from outside not possible!

When using a library that provides multiple alternatives for an interface it is not
possible to change the one in use from outside the library.

### how to reproduce

1. Build $ mvn clean install
2. Deploy WAR from /target to WAS9
3. open bug/index.xhtml

### actual behavior

Browser shows "Service: at.struct.was9bugs.bug8.MyServiceImpl"

### expected behavior

Browser shows "Service: at.struct.was9bugs.bug8.MockMyServiceImpl" because in beans.xml the Mock is configured to be used.
