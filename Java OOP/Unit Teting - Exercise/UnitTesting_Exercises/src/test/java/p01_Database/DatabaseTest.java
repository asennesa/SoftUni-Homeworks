package p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class DatabaseTest {

    private Database database;
    private static final Integer[] TEST_ARRAY = {1, 2, 3, 4};
    private static final Integer[] TEST_ARRAY_EMPTY = new Integer[10];

    @Before
    public void createDb() throws OperationNotSupportedException {
        this.database = new Database(TEST_ARRAY);
    }

    @Test
    public void constructorTest() throws OperationNotSupportedException {
        Database database = new Database(TEST_ARRAY);
        Assert.assertArrayEquals(database.getElements(), TEST_ARRAY);

    }

    @Test(expected = OperationNotSupportedException.class)
    public void constructorExceptionTestWithZeroElements() throws OperationNotSupportedException {
        Database database = new Database();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void constructorExceptionTestWithMoreThenSixteenElements() throws OperationNotSupportedException {
        Database database = new Database(new Integer[17]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addMethodExceptionTest() throws OperationNotSupportedException {
        Database database = new Database(new Integer[5]);
        database.add(null);
    }

    @Test
    public void addMethodSuccessTest() throws OperationNotSupportedException {
        Database database = new Database(TEST_ARRAY);

        database.add(5);

        Assert.assertEquals(database.getElements().length, TEST_ARRAY.length + 1);


    }

    @Test(expected = OperationNotSupportedException.class)
    public void removeMethodExceptionTest() throws OperationNotSupportedException {
        Database database = new Database(TEST_ARRAY);
        for (int i = 0; i < TEST_ARRAY.length; i++) {
            database.remove();
        }
        database.remove();
    }

    @Test
    public void removeMethodSuccessTest() throws OperationNotSupportedException {
        database.remove();
        Assert.assertEquals(database.getElements().length, TEST_ARRAY.length - 1);


    }


}