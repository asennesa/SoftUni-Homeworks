package p02_ExtendedDatabase;


import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.List;

public class DatabaseTestExtended {
    private Database database;

    @Before
    public void createDb() throws OperationNotSupportedException {
        Person person = new Person(1, "A");
        Person person2 = new Person(2, "C");
        Person person3 = new Person(3, "D");
        this.database = new Database(person, person2, person3);

    }


    @Test(expected = OperationNotSupportedException.class)
    public void findByIdMethodDuplicateIdsTest() throws OperationNotSupportedException {
        Person person1 = new Person(1, "B");
        this.database.add(person1);
        this.database.findById(1);

    }

    @Test(expected = OperationNotSupportedException.class)
    public void addMethodNullException() throws OperationNotSupportedException {
        this.database.add(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findByUsernameNoUsernamePresentTest() throws OperationNotSupportedException {
        this.database.findByUsername("Z");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findByUsernameShouldThrowExceptionIfUsernameEqualsNull() throws OperationNotSupportedException {
        this.database.findByUsername(null);

    }

    @Test(expected = OperationNotSupportedException.class)
    public void findByUsernameShouldThrowExceptionIfUsernamesDuplicate() throws OperationNotSupportedException {
        Person person = new Person(1, "A");
        this.database.add(person);
        this.database.findByUsername("A");
    }


}