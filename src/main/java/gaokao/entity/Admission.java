package gaokao.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "admission")
@NamedQuery(query = "SELECT a FROM Admission a WHERE a.studentID = :ID", name = "find admission by ID")
public class Admission implements Serializable {
    @Id
    @Column(name = "studentID")
    private String studentID;

    @Column(name = "collegeID")
    private String collegeID;

    @Column(name = "majorID")
    private String majorID;

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getCollegeID() {
        return collegeID;
    }

    public void setCollegeID(String collegeID) {
        this.collegeID = collegeID;
    }

    public String getMajorID() {
        return majorID;
    }

    public void setMajorID(String majorID) {
        this.majorID = majorID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admission admission = (Admission) o;
        return studentID.equals(admission.studentID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentID);
    }
}
