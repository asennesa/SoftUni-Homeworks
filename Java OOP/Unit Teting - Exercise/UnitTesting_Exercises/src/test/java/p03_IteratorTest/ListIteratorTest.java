package p03_IteratorTest;

import org.junit.Assert;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


public class ListIteratorTest {


    @Test(expected = OperationNotSupportedException.class)
    public void constructorParameterNullTestShouldThrowException() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator(null);
    }

    @Test
    public void constructorShouldWorkCorrectly() throws OperationNotSupportedException {

        ListIterator listIterator = new ListIterator("a");
        String result = listIterator.print();
        Assert.assertEquals("a", result);
    }

    @Test(expected = IllegalStateException.class)
    public void printMethodShouldThrowExceptionIfListIsEmpty() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator();
        listIterator.print();
    }

    @Test
    public void moveMethodShouldReturnTrueIfListSizeBiggerThenOne() throws OperationNotSupportedException, NoSuchFieldException, IllegalAccessException {
        ListIterator listIterator = new ListIterator("A", "B", "C");
        Assert.assertTrue(listIterator.move());


    }

    @Test
    public void moveMethodShouldReturnFalseIfListSizeEqualsOne() throws OperationNotSupportedException {
        String[] arrayOfStrings = {"a", "b", "c"};
        ListIterator listIterator = new ListIterator(arrayOfStrings);
        for (int i = 0; i < arrayOfStrings.length; i++) {
            listIterator.move();
        }
        Assert.assertFalse(listIterator.move());

    }


}