### demonstrated bug: PMR 26882,010,618

Converter for primitive types do not work.

### how to reproduce

1. Build $ mvn clean install
2. Deploy WAR from /target to WAS9
3. open bug/index.xhtml

### actual behavior

Persisting fails

### expected behavior

Database should now contain a few rows with T and F for true and false
