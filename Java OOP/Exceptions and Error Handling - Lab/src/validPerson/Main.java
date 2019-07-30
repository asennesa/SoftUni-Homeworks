package validPerson;

public class Main {
    public static void main(String[] args) {

        try {
            Person noName = new Person(" ", "Löffler", 34);
            Person noLastName = new Person("Christian", null, 34);
            Person negativeAge = new Person("Christian", "Löffler", -1);
            Person tooOldForThisProgram = new Person("Christian", "Löffler", 121);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}
