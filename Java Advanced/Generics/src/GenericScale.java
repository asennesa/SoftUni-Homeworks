public class GenericScale<T extends Comparable<T>> {
    private T left;
    private T right;

    public GenericScale(T left, T right) {
        this.left = left;
        this.right = right;
    }

    public T getHeavier() {
        if (left == right) {
            return null;
        } else if (this.left.compareTo(this.right) < 0) {
            return right;
        }
        return left;

    }
}
