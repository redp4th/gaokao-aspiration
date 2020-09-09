package gaokao.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "aspiration")
@NamedQueries({
        @NamedQuery(query = "SELECT a FROM Aspiration a WHERE a.studentID = :ID", name = "find aspiration by student ID"),
        @NamedQuery(query = "SELECT a FROM Aspiration a WHERE a.studentID = :sID AND a.collegeID = :cID", name = "find aspiration by college and student")
        })
public class Aspiration implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "aspirationID")
    private int aspirationID;

    @Column(name = "studentID")
    private String studentID;

    @Column(name = "collegeId")
    private String collegeID;

    @Column(name = "majorList")
    private String majorList;

    public int getAspirationID() {
        return aspirationID;
    }

    public void setAspirationID(int aspirationID) {
        this.aspirationID = aspirationID;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentName(String studentID) {
        this.studentID = studentID;
    }

    public String getCollegeID() {
        return collegeID;
    }

    public void setCollegeID(String collegeID) {
        this.collegeID = collegeID;
    }

    public String[] getMajorList() {
        return majorList.split("||");
    }

    public void setMajorList(String[] majorLists) {
        this.majorList = cast(majorLists);
    }

    public static String cast(String[] st) {
        if(st.length == 0)
            return "";
        if(st.length == 1)
            return st[0];
        return st[0] + "||" + cast(Arrays.copyOfRange(st, 1, st.length));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aspiration that = (Aspiration) o;
        return aspirationID == that.aspirationID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(aspirationID);
    }
}
