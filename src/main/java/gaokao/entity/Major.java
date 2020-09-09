package gaokao.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "major")
@NamedQueries({
        @NamedQuery(query = "SELECT m FROM Major m WHERE m.majorID = :mID", name = "find major by ID"),
        @NamedQuery(query = "SELECT m FROM Major m WHERE m.college.ID = :cID AND m.name = :name", name = "find major by name")
})
public class Major implements Serializable {
    @Id
    @Column(name = "majorID")
    private String majorID;

    @Column(name = "majorNo")
    private int num;

    @Column(name = "majorName")
    private String name;

    @ManyToOne
    private College college;

    public String getMajorID() {
        return majorID;
    }

    public void setMajorID(String majorID) {
        this.majorID = majorID;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Major major = (Major) o;
        return majorID.equals(major.majorID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(majorID);
    }
}
