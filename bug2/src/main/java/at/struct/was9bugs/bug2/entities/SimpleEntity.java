package at.struct.was9bugs.bug2.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SIMPLEENTITY")
public class SimpleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SIMPLEENTITY_SQ")
    @SequenceGenerator(name = "SIMPLEENTITY_SQ", sequenceName = "SIMPLEENTITY_SQ")
    @Column(name = "SIMPLEENTITY_PK", nullable = false, updatable = false)
    private Long id;

    @Column
    private String somevalue;

    public String getSomevalue() {
        return somevalue;
    }

    public void setSomevalue(String somevalue) {
        this.somevalue = somevalue;
    }
}
