package gaokao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "major")
public class Major implements Serializable, BaseEntity {
    @Id
    @Column(name = "majorID")
    private String majorID;

    @Column(name = "majorScore")
    private int score;

    @Column(name = "majorNo")
    private int num;

    @Column(name = "majorName")
    private String name;

    @Column(name = "collegeID")
    private String collegeID;

    public String getMajorID() {
        return majorID;
    }

    public void setMajorID(String majorID) {
        this.majorID = majorID;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
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

    public String getCollegeID() {
        return collegeID;
    }

    public void setCollegeID(String collegeID) {
        this.collegeID = collegeID;
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
