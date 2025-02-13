// Auto-generated file
public class module2_2_32 {
    public static void main(String[] args) {
        // Create first thread
        Thread thread1 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Regular Thread: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Create second thread and set it as daemon
        Thread thread2 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Daemon Thread: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Set thread2 as daemon thread
        thread2.setDaemon(true);

        // Check if threads are daemon
        System.out.println("Thread1 is Daemon: " + thread1.isDaemon());
        System.out.println("Thread2 is Daemon: " + thread2.isDaemon());

        // Start both threads
        thread1.start();
        thread2.start();
    }
}
