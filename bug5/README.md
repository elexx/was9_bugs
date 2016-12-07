### demonstrated bug: PMR 26918,010,618

Nativequeries with expected result type of Integer throw exceptions.

### how to reproduce

1. Build $ mvn clean install
2. Deploy WAR from /target to WAS9
3. open bug/index.xhtml

### actual behavior

See the Stacktrace

### expected behavior

Should display "Size: 0" in the browser.
