package at.struct.was9bugs.bug2.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ANOTHERENTITY")
public class AnotherEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ANOTHERENTITY_SQ")
    @SequenceGenerator(name = "ANOTHERENTITY_SQ", sequenceName = "ANOTHERENTITY_SQ")
    @Column(name = "ANOTHERENTITY_PK", nullable = false, updatable = false)
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
