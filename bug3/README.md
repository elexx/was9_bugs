### demonstrated bug:

Broken L2 Eclipselink Cache. It is possible to get a parent entity even afer it got removed from the db, by keeping a child and navigating back to the parent.

Not sure this is really a bug or just some caching problem.

### how to reproduce

1. Build $ mvn clean install
2. Deploy WAR from /target to WAS9
3. open bug/index.xhtml

### actual behavior

.

### expected behavior

.
