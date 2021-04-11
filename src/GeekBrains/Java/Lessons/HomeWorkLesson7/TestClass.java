package GeekBrains.Java.Lessons.HomeWorkLesson7;

public class TestClass {
    public static void method1() {
        System.out.println("method1");
    }
    @BeforeSuite
    public static void start() {
        System.out.println("start");
    }
    @Test (priority = 7)
    public static void method2() {
        System.out.println("method2");
    }
    @Test (priority = 6)
    public static void method3() {
        System.out.println("method3");
    }
    @Test (priority = 5)
    public static void method4() {
        System.out.println("method4");
    }
    @AfterSuite
    public static void shutdown() {
        System.out.println("shutdown");
    }
}
