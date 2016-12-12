### demonstrated bug: PMR 26935,010,618

`@Id @Column(updatable = false, insertable = false)` on PK throws an exception

### how to reproduce

1. Build $ mvn clean install
2. Deploy WAR from /target to WAS9
3. open bug/index.xhtml

### actual behavior

See the Stacktrace

### expected behavior

Should display "Result: 1" in the browser.
