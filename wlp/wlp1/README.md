### demonstrated bug: 

TS016580368
TCCL during @BeforeShutdown is not the application TCCL.
That leads to weird behaviour during shutdown, where the 
application business code cannot store away data nor clean
up unfinished work.

### how to reproduce

1. Build $ mvn clean install
2. Deploy WAR from /target to WAS9
3. The output contains a log with the different classloaders
   printed out. In Liberty you have to look at
   target/liberty/wlp/usr/servers/defaultServer/logs/messages.log
   But note that due to the failure in the shutdown logic the BeforeShutdown
   log can only be experienced in the debugger. It is not printed out in WLP.

### actual behavior

### expected behavior
