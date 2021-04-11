package GeekBrains.Java.Lessons.HomeWorkLesson7;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Iterator;

public class CheckHomeWork {
    public static void main(String[] args) throws Exception {
        CheckHomeWork checkHomeWork = new CheckHomeWork();
        checkHomeWork.testSum();
    }

    public void testSum() throws Exception {
        File file = new File("C:/0123");
        String [] fileList = file.list();

        ArrayList<String> fileName = new ArrayList<>();

        for (String o: fileList) {
            String [] mass = o.split("\\.");
            if (mass[1].equalsIgnoreCase("class")) {
                fileName.add(mass[0]);
            }
        }

        Iterator iterator = fileName.iterator();
        while (iterator.hasNext()) {
            String name = String.valueOf(iterator.next());
            Class check = URLClassLoader.newInstance(new URL[]{new File("C:/0123").toURL()}).loadClass(name);
            Constructor constructor = check.getConstructor();
            Object calculation = constructor.newInstance();

            Method method = check.getDeclaredMethod("calculation", int.class, int.class);
            int result = (Integer) method.invoke(calculation, 2, 2);
            System.out.println(result);

            Method method3 = check.getDeclaredMethod("calculation3", int.class, int.class, int.class, int.class);
            int result3 = (Integer) method3.invoke(calculation, 1, 1, 1, 1);
            System.out.println(result3);

            Method method4 = check.getDeclaredMethod("calculation4", int.class, int.class);
            boolean result4 = (boolean) method4.invoke(calculation, 6, 6);
            System.out.println(result4);

            Method method5 = check.getDeclaredMethod("calculation5", int.class);
            String result5 = (String) method5.invoke(calculation, 2);
            System.out.println(result5);

            Method method6 = check.getDeclaredMethod("calculation5", int.class);
            boolean result6 = (boolean) method6.invoke(calculation, 2);
            System.out.println(result6);

            Method method7 = check.getDeclaredMethod("calculation5", String.class);
            String result7 = (String) method7.invoke(calculation, "Ivan");
            System.out.println(result7);

            Method method8 = check.getDeclaredMethod("calculation5", int.class);
            String result8 = (String) method8.invoke(calculation, 2020);
            System.out.println(result8);

            if (result == 4 && result3 == 2 && result4 && result5 == "positive" && result6 &&
                    result7.equalsIgnoreCase("Hello, Ivan") && result8 == "этот год високосный") {
                System.out.println(name + " Passed");
            } else {
                System.out.println(name + "Failed");
            }
        }
    }
}
