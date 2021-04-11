package GeekBrains.Java.Lessons.HomeWorkLesson4;

public class MFU {

    Object printLock = new Object();
    Object scanLock = new Object();

    public void printing(String doc, int n) {
        synchronized (printLock) {
            System.out.println("Начало печати");
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Конец печати");
        }

    }

    public void scanning(String doc, int n, int source) {
        synchronized (scanLock) {
            System.out.println("Начало сканирования");
            switch (source) {
                case 1 :
                    System.out.println("Сканирование в сеть");
                    for (int i = 0; i < 10; i++) {
                        System.out.println(i);
                    }
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2 :
                    synchronized(printLock) {
                        System.out.println("Начало копирования");
                        for (int i = 0; i < 10; i++) {
                            System.out.println(i);
                        }
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Конец копирования");
                        break;
                    }
            }
            System.out.println("Конец сканирования");
        }
    }

    public static void main(String[] args) {
        MFU mfu = new MFU();

        new Thread(new Runnable() {
            @Override
            public void run() {
                mfu.printing("Doc 1", 10);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                mfu.printing("Doc 2", 5);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                mfu.scanning("Doc 2", 5, 1);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                mfu.scanning("Doc 2", 5, 2);
            }
        }).start();
    }
}
