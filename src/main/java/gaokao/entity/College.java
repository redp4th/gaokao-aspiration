package gaokao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "college")
public class College implements Serializable, BaseEntity {
    @Id
    @Column(name = "collegeID")
    private String ID;

    @Column(name = "collegeName")
    private String name;

    @Column(name = "collegeScore")
    private int score;

    @Column(name = "collegeAddr")
    private String address;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        College college = (College) o;
        return ID.equals(college.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }
}
