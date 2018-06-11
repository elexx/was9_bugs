### demonstrated bug: PMR TS000805220

@OneToMany unidirectional not nullable association generates SQLIntegrityConstraintViolationException: Column 'POST_FK' cannot accept a NULL value. 

### how to reproduce

1. Build $ mvn clean install
2. Deploy WAR from /target to WAS9
3. open bug/index.xhtml

### actual behavior

See the Stacktrace

### expected behavior

Successful insert and display of the parent PK in the browser.

### DDL (Oracle)

```sql
CREATE TABLE POST (POST_PK BIGINT NOT NULL, PRIMARY KEY(POST_PK));
CREATE TABLE COMMENT (COMMENT_PK BIGINT NOT NULL, POST_FK BIGINT NOT NULL, PRIMARY KEY(COMMENT_PK)); 
ALTER TABLE COMMENT ADD CONSTRAINT FK_COMMENT_POST_FK FOREIGN KEY(POST_FK) REFERENCES POST (POST_PK); 
CREATE SEQUENCE COMMENT_SQ START WITH 1;
CREATE SEQUENCE POST_SQ START WITH 1;
```
