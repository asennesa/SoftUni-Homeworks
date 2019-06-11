package Google;

public class Children {
    private String childName;
    private String childBirthday;

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public String getChildBirthday() {
        return childBirthday;
    }

    public void setChildBirthday(String childBirthday) {
        this.childBirthday = childBirthday;
    }

    @Override
    public String toString() {
        return String.format("%s %s", getChildName(), getChildBirthday());
    }
}
