package gaokao.utils;

import java.util.Map;

public class StudentInfo {
    private String ID;
    private String name;
    private String pwd;
    private int score;
    private Map<String, String[]> aspirations;

    public StudentInfo(String ID, String pwd, String name, int score, Map<String, String[]> aspirations) {
        this.ID = ID;
        this.pwd = pwd;
        this.name = name;
        this.score = score;
        this.aspirations = aspirations;
    }

    public StudentInfo() { }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
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

    public Map<String, String[]> getAspirations() {
        return aspirations;
    }

    public void setAspirations(Map<String, String[]> aspirations) {
        this.aspirations = aspirations;
    }
}
