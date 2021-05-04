package Lesson1;

public class Main {
    public static void main(String[] args) {
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();
        Apple apple4 = new Apple();
        Orange orange1 = new Orange();
        Orange orange2 = new Orange();

        Box<Apple> boxOfApples = new Box<Apple>();
        Box<Orange> boxOfOranges = new Box<Orange>();

        boxOfApples.put(apple1);
        boxOfApples.put(apple2);
        boxOfApples.put(apple3);
        boxOfOranges.put(orange1);
        boxOfOranges.put(orange2);

        System.out.println(boxOfApples.compare(boxOfOranges));
        boxOfApples.put(apple4);
        System.out.println(boxOfApples.compare(boxOfOranges));

        System.out.println("boxOfApples весит " + boxOfApples.getWeight());
        System.out.println("boxOfOranges весит " + boxOfOranges.getWeight());

        Box<Apple> appleBox = new Box<Apple>();
        appleBox.pourBox(boxOfApples);
        System.out.println("boxOfApples весит " + boxOfApples.getWeight());
        System.out.println("appleBox весит " + appleBox.getWeight());
    }
}
