package at.struct.was9bugs.bug4.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PARENTENTITY")
@DiscriminatorValue("entity_a")
public class ParentEntity extends ParentBaseEntity {

}
