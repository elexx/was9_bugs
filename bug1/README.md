### demonstrated bug: PMR 26523,010,618

When voting against an Alternative, the WAR doesn't even start on WAS9.

### how to reproduce

1. Build $ mvn clean install
2. Deploy WAR from /target to WAS9
3. open bug/index.xhtml

### actual behavior

Application starts

### expected behavior

Application start aborts with an exception
