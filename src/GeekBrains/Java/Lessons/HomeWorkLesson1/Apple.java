package GeekBrains.Java.Lessons.HomeWorkLesson1;

public class Apple extends Fruit {
    public Apple() {
        super(1.0F);
    }

    public Fruit newInstance() {
        return new Apple();
    }
}