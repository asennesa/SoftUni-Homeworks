import java.lang.reflect.Array;

public class ArrayCreator {

    // ArrayCreator - writing generic Methods.

    public static <T> T[] create(Class<T> tClass, int length, T item) {
        T[] array = (T[]) Array.newInstance(tClass, length);
        for (int i = 0; i < array.length; i++) {
            array[i] = item;
        }
        return array;

    }
}
