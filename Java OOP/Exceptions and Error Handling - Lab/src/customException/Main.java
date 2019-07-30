package customException;

public class Main {
    public static void main(String[] args) {
        try {
            Student student = new Student("Christian123 Löffler", "anEmail@gmail.com");
        } catch (InvalidPersonNameException e) {
            System.out.println(e.getMessage());
        }
    }
}
