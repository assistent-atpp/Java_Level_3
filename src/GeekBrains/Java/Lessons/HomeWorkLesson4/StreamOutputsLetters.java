package GeekBrains.Java.Lessons.HomeWorkLesson4;

public class StreamOutputsLetters {
    static volatile char letter = 'A';
    public static void main(String[] args) {
        Object lock = new Object();
        class MyStreamOutputsLetters implements Runnable {
            private char b;
            private char nextB;
            public MyStreamOutputsLetters(char b, char nextB) {
                this.b = b;
                this.nextB = nextB;
            }
            @Override
            public void run() {
                synchronized (lock) {
                    for (int i = 0; i < 5; i++) {
                        try {
                            while (letter != b) {
                                lock.wait();
                            }
                            System.out.println(b);
                            letter = nextB;
                            lock.notifyAll();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        new Thread(new MyStreamOutputsLetters('A', 'B')).start();
        new Thread(new MyStreamOutputsLetters('B', 'C')).start();
        new Thread(new MyStreamOutputsLetters('C', 'A')).start();
    }

}
