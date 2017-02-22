### demonstrated bug: PMR todo

TCCL is not set up correctly during CDI bootstrap. 

### how to reproduce

1. Build $ mvn clean install
2. Deploy WAR from /target to WAS9
3. open bug/index.xhtml

### actual behavior

`ClassNotFoundException` thrown, when loading an applicationclass with TCCL in extension.

### expected behavior

Application does start.
