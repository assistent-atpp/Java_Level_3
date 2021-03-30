package GeekBrains.Java.Lessons.HomeWorkLesson1;

public abstract class Fruit {
    protected float weight;

    public abstract Fruit newInstance();

    public float getWeight() {
        return this.weight;
    }

    public Fruit(float weight) {
        this.weight = weight;
    }
}