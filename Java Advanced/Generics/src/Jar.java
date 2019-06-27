public class Jar<T> {
    //Jar - Writing generic classes.
    private T element;

    public void add(T element) {
        this.element = element;
    }

    public T remove() {
        return this.element;
    }

}
