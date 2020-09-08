package gaokao.utils;

import java.util.List;

public class CollegeInfo {
    private String name;
    private String ID;
    private String addr;
    private List<MajorInfo> majorList;
    private int total;
    private int score;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public List<MajorInfo> getMajorList() {
        return majorList;
    }

    public void setMajorList(List<MajorInfo> majorList) {
        this.majorList = majorList;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
