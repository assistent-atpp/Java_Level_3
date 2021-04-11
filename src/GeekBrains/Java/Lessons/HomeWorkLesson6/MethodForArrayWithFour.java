package GeekBrains.Java.Lessons.HomeWorkLesson6;

public class MethodForArrayWithFour {
    public int [] doMethodForArrayWithFour (int[] array1) throws RuntimeException {
        int [] result = null;
        int i = array1.length - 1;
        int j = 0;
        boolean found = false;
        while (i >= 0 && !found) {
            found = array1[i] == 4;
            j = 1;
            i--;
        }
        if (found) {
            result = new int[array1.length - j - 1];
            for (i = j + 1; i < array1.length; i++) {
                result[i - j - 1] = array1[i];
            }
        } else {
            throw new RuntimeException("В массиве нет 4");
        }
        return result;
    }
}
