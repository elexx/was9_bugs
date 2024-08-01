### demonstrated bug:

TS016861944
CDI.current() doesn't always work

### how to reproduce

1. Build $>mvn clean install
2. run $>mvn -Pliberty liberty:run
3. examine logs $>less target/liberty/wlp/usr/servers/defaultServer/logs/messages.log


### actual behavior

### expected behavior
