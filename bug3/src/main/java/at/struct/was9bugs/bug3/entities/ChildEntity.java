package at.struct.was9bugs.bug3.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CHILDENTITY")
public class ChildEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CHILDENTITY_SQ")
    @SequenceGenerator(name = "CHILDENTITY_SQ", sequenceName = "CHILDENTITY_SQ")
    @Column(name = "CHILDENTITY_PK", nullable = false, updatable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "PARENT")
    private ParentEntity parent;

    public Long getId() {
        return id;
    }

    public ParentEntity getParent() {
        return parent;
    }

    public void setParent(ParentEntity parent) {
        this.parent = parent;
    }
}
