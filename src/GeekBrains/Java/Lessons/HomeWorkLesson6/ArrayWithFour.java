package GeekBrains.Java.Lessons.HomeWorkLesson6;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayWithFour {
    public static void main(String[] args) {
        int [] numbers = {5, 3, 6, 5, 3, 4, 8, 8, 4};

        ArrayWithFour arrayWithFour = new ArrayWithFour();
        Integer [] arrayList = arrayWithFour.getAfterLastFour(numbers);
        for (int i = 0; i < arrayList.length; i++) {
            System.out.println(arrayList[i] + " ");
        }
    }

    public Integer [] getAfterLastFour(int [] array1) {
        ArrayList<Integer> array_int = new ArrayList<Integer>();
        for (int i = array1.length - 1; i >= 0 && array1[i] != 4; i--) {
            array_int.add(array1[i]);
        }
        if (array_int.size() == array1.length) {
            throw new RuntimeException("Exception: в исходном массиве нет 4!");
        }
        Collections.reverse(array_int);
        Integer[] array2 = array_int.toArray(new Integer[array_int.size()]);

        return array2;
    }
}
