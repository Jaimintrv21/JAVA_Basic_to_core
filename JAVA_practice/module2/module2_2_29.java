// Auto-generated file
public class module2_2_29 {
    public static void main(String[] args) {
        // Create first thread
        Thread thread1 = new Thread() {
            public void run() {
                System.out.println("Thread 1 is running");
                System.out.println("Thread 1 Name: " + Thread.currentThread().getName());
                System.out.println("Thread 1 Priority: " + Thread.currentThread().getPriority());
            }
        };

        // Create second thread
        Thread thread2 = new Thread() {
            public void run() {
                System.out.println("Thread 2 is running");
                System.out.println("Thread 2 Name: " + Thread.currentThread().getName());
                System.out.println("Thread 2 Priority: " + Thread.currentThread().getPriority());
            }
        };

        // Set names for threads
        thread1.setName("First Thread");
        thread2.setName("Second Thread");

        // Set priorities for threads
        thread1.setPriority(Thread.MAX_PRIORITY); // Priority 10
        thread2.setPriority(Thread.MIN_PRIORITY); // Priority 1

        // Start both threads
        thread1.start();
        thread2.start();
    }
}
