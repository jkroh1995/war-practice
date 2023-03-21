package counter;

public class RaceConditionDemo {
    public static void main(String[] args) {
        Counter counter = new Counter(); // 싱글턴 객체를 상태를 유지하게 설계
        /*
         * race condition 문제가 발생.
         * 여러 프로세스 또는 쓰레드가 동시에 하나의 자원에 접근하기 위해 경쟁하는 상태.
         */
        Thread thread1 = new Thread(counter, "Thread 1");
        Thread thread2 = new Thread(counter, "Thread 2");
        Thread thread3 = new Thread(counter, "Thread 3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
