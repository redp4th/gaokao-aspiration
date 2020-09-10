package gaokao.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "college")
@NamedQueries({
        @NamedQuery(query = "SELECT c FROM College c where c.ID = :ID", name = "find college by ID")
})
public class College implements Serializable {
    @Id
    @Column(name = "collegeID")
    private String ID;

    @Column(name = "collegeName")
    private String name;

    @Column(name = "collegeScore")
    private int score;

    @Column(name = "collegeAddr")
    private String address;

    @OneToMany(targetEntity = Major.class, fetch = FetchType.LAZY, mappedBy = "college")
    private List<Major> majors;

    public List<Major> getMajors() {
        return majors;
    }

    public void setMajors(List<Major> majors) {
        this.majors = majors;
    }

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
