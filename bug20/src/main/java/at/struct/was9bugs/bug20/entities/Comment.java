package at.struct.was9bugs.bug20.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "COMMENT_TABLE")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMMENT_SQ")
    @SequenceGenerator(name = "COMMENT_SQ", sequenceName = "COMMENT_SQ", allocationSize = 1)
    @Column(name = "COMMENT_PK", nullable = false, updatable = false)
    private Long id;

    public Long getId() {
        return id;
    }

}
