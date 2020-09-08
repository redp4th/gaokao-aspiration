package gaokao.utils;

import java.util.Objects;

public class MajorInfo {
    private String ID;
    private String name;
    private int score;
    private int num;

    public MajorInfo(String ID, String name, int score, int num) {
        this.ID = ID;
        this.name = name;
        this.score = score;
        this.num = num;
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

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MajorInfo majorInfo = (MajorInfo) o;
        return score == majorInfo.score &&
                num == majorInfo.num &&
                Objects.equals(ID, majorInfo.ID) &&
                Objects.equals(name, majorInfo.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, name, score, num);
    }
}
