package GeekBrains.Java.Lessons.HomeWorkLesson6;

public class CheckingArrayComposition {
    public boolean doCheckingArrayComposition(int[] array1) {
        boolean result = true;
        int count1 = 0;
        int count4 = 0;
        int i = 0;
        while (i < array1.length && result) {
            if (array1[i] == 1) {
                result = true;
                count1++;
            } else {
                if (array1[i] == 4) {
                    result = true;
                    count4++;
                } else {
                    result = false;
                }
            }
            i++;
        }
        return result && count1 > 0 && count4 > 0;
    }
}
