package GeekBrains.Java.Lessons.HomeWorkLesson1;

import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Arrays;

public class Box <T extends Fruit> {
    private ArrayList<T> list;

    public Box(T...arr) {
        this.list = new ArrayList(Arrays.asList(arr));
    }

    public float getWeight() {
        return this.list.size() == 0 ? 0.0F : ((Fruit) this.list.get(0)).getWeight() * (float) this.list.size();
    }

    public void addFruit(T fruit) {
        this.list.add(fruit);
    }

    public boolean compare(Box another) {
        return (double) Math.abs(this.getWeight() - another.getWeight()) < 1.0E-50;
    }

    public void transfer(Box<? super T> another) {
        another.list.addAll(this.list);
        this.list.clear();
    }
}