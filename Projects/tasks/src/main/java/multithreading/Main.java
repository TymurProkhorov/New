package multithreading;

public class Main {
    public static void main(String[] args) {
                ProducerThread producerThread = new ProducerThread();
        ConsumerThread consumerThread = new ConsumerThread();
        ConsumerThread consumerThread1 = new ConsumerThread();
        Thread thread3 = new Thread(consumerThread1);
        Thread thread1 = new Thread(producerThread);
        Thread thread2 = new Thread(consumerThread);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
