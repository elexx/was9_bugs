### demonstrated bug: PMR -----,010,618

Deploying a war-file containing a parameterized static method in an interface, which gets called in a servlet, results in `Error 500: javax.servlet.ServletException: SRVE0207E: Uncaught initialization exception created by servlet` after the second deployment.

The error also occures deploying the same war twice or using the same dependency containing the constelation above in multiple applications.


### how to reproduce

1. Build $ mvn clean install
2. Deploy the WAR from /target to WAS9 twice to different contexts
3. Call the servlet from both deployments http://localhost:8080/{context}/

### actual behavior

First servlet shows in browser `Success! Servlet-Initialization finished.`

The second servlet shows in browser `Error 500: javax.servlet.ServletException: SRVE0207E: Uncaught initialization exception created by servlet`

### expected behavior

Both applications should show the following output:
```
Success!
Servlet-Initialization finished.
```
