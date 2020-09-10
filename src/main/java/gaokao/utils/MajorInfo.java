package gaokao.utils;

import java.util.Objects;

public class MajorInfo {
    private String ID;
    private String name;

    public MajorInfo(String ID, String name) {
        this.ID = ID;
        this.name = name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MajorInfo majorInfo = (MajorInfo) o;
        return Objects.equals(ID, majorInfo.ID) &&
                Objects.equals(name, majorInfo.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, name);
    }
}
