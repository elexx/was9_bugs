package at.struct.was9bugs.bug7.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "MYENTITY")
public class MyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MYENTITY_SQ")
    @SequenceGenerator(name = "MYENTITY_SQ", sequenceName = "MYENTITY_SQ")
    @Column(name = "MYENTITY_PK")
    private Long id;

    @Basic
    @Column(name = "SOMEDATA")
    private boolean somedata;

    @Basic
    @Column(name = "MOREDATA")
    private Boolean moredata;

    public Long getId() {
        return id;
    }

    public boolean isSomedata() {
        return somedata;
    }

    public void setSomedata(boolean somedata) {
        this.somedata = somedata;
    }

    public Boolean getMoredata() {
        return moredata;
    }

    public void setMoredata(Boolean moredata) {
        this.moredata = moredata;
    }

    @Override
    public String toString() {
        return "MyEntity{" +
               "id=" + id +
               ", somedata=" + somedata +
               ", moredata=" + moredata +
               '}';
    }
}
