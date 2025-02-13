// Auto-generated file
class MyThread extends Thread {
    private String name;

    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(name + " is running: Count " + i);
            try {
                Thread.sleep(2000); // Sleep for 2 seconds
            } catch (InterruptedException e) {
                System.out.println(name + " interrupted");
            }
        }
    }
}

public class module2_2_28 {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread("Thread 1");
        MyThread thread2 = new MyThread("Thread 2");

        System.out.println("Starting threads...");
        thread1.start();
        thread2.start();
        System.out.println("Main thread continues...");
    }
}
