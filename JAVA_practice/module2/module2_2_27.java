// Auto-generated file
class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread is running: Count " + i);
            try {
                Thread.sleep(1000); // Sleep for 1 second
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
    }
}

public class module2_2_27 {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        System.out.println("Starting thread...");
        thread.start();
        System.out.println("Main thread continues...");
    }
}
