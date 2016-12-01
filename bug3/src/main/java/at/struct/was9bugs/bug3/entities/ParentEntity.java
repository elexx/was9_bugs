package at.struct.was9bugs.bug3.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "PARENTENTITY")
public class ParentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PARENTENTITY_SQ")
    @SequenceGenerator(name = "PARENTENTITY_SQ", sequenceName = "PARENTENTITY_SQ")
    @Column(name = "PARENTENTITY_PK", nullable = false, updatable = false)
    private Long id;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<ChildEntity> children;

    public Long getId() {
        return id;
    }

    public List<ChildEntity> getChildren() {
        return children;
    }

    public void setChildren(List<ChildEntity> children) {
        this.children = children;
    }
}
