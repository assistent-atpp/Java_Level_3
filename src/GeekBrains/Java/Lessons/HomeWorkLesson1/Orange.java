package GeekBrains.Java.Lessons.HomeWorkLesson1;

public class Orange extends Fruit {
    public Orange() {
        super(1.5F);
    }

    public Fruit newInstance() {
        return new Orange();
    }
}