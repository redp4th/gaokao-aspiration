package gaokao.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "student")
@NamedQuery(query = "SELECT s FROM Student s where s.studentID = :ID", name = "find student by ID")
public class Student implements Serializable {
    @Id
    @Column(name = "studentID")
    private String studentID;

    @Column(name = "studentPwd")
    private String studentPwd;

    @Column(name = "studentScore")
    private int studentScore;

    @Column(name = "studentName")
    private String studentName;

//    @OneToMany(targetEntity = Aspiration.class)
//    private List aspList;

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentPwd() {
        return studentPwd;
    }

    public void setStudentPwd(String studentPwd) {
        this.studentPwd = studentPwd;
    }

    public int getStudentScore() {
        return studentScore;
    }

    public void setStudentScore(int studentScore) {
        this.studentScore = studentScore;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
//
//    public List getAspList() {
//        return aspList;
//    }
//
//    public void setAspList(List aspList) {
//        this.aspList = aspList;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentID.equals(student.studentID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentID);
    }
}
