package at.struct.was9bugs.bug5.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ENTITY")
public class MyEntity {

    @Id
    @Column(name = "ENTITY_PK", nullable = false, updatable = false, insertable = false)
    private Long id;

    @Basic
    @Column(name = "SOMEDATA", nullable = false, updatable = false, insertable = false)
    private String somedata;

    public Long getId() {
        return id;
    }

    public String getSomedata() {
        return somedata;
    }
}
