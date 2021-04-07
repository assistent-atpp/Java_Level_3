package GeekBrains.Java.Lessons.HomeWorkLesson1;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public Main() {
    }
    public static void main(String[] args) {
        Box<Fruit> box1 = new Box(new Fruit[0]);
        Box<Apple> box2 = new Box(new Apple[0]);
        box2.addFruit(new Apple());
        box2.transfer(box1);
    }

    // метод для замены местами двух элементов массива
    public static void swapTwoElements(Object[] array, int x1, int x2) {
        Object buffer = array[x1];
        array[x1] = array[x2];
        array[x2] = buffer;
    }

    // метод для преобразования массива в коллекцию ArrayList
    public static <T> ArrayList<T> convert(T[] array) {
        return new ArrayList(Arrays.asList(array));
    }
}