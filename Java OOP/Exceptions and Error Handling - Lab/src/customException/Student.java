package customException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {
    private String name;
    private String email;

    public Student(String name, String email) throws InvalidPersonNameException {
        this.setName(name);
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws InvalidPersonNameException {
        Pattern pattern = Pattern.compile("[^A-Za-z]+");
        Matcher matcher = pattern.matcher(name);
        if (matcher.find()) {
            throw new InvalidPersonNameException("Special characters or numeric values are not allowed");
        }
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
