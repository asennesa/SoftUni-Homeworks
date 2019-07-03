package RandomArrayList;

public class Main {
    public static void main(String[] args) {
        RandomArrayList arrayList = new RandomArrayList();
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("1");
        arrayList.add("2");
        System.out.println(arrayList.getRandomElement());
        System.out.println(arrayList.getRandomElement());
        System.out.println(arrayList.getRandomElement());

    }
}
