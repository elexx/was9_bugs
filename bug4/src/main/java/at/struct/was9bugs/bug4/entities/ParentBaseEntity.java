package at.struct.was9bugs.bug4.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "TYPE")
@Table(name = "PARENTBASEENTITY")
public abstract class ParentBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PARENTBASEENTITY_SQ")
    @SequenceGenerator(name = "PARENTBASEENTITY_SQ", sequenceName = "PARENTBASEENTITY_SQ", allocationSize = 1)
    @Column(name = "PARENTBASEENTITY_PK", nullable = false, updatable = false)
    private Long id;

    public Long getId() {
        return id;
    }
}
