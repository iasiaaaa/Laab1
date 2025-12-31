public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Java проєкт");

        Runnable sumTask = () -> {
            long sum = 0L;
            for (int i = 1; i <= 5_000_000; i++) {
                sum += i;
            }
            System.out.println(Thread.currentThread().getName() + " result: sum= " + sum);
        };

        Runnable factorialTask = () -> {
            java.math.BigInteger f = java.math.BigInteger.ONE;
            int n = 2000; // compute factorial(2000)
            for (int i = 1; i <= n; i++) {
                f = f.multiply(java.math.BigInteger.valueOf(i));
            }
            System.out.println(Thread.currentThread().getName() + " result: factorial(" + n + ") digits=" + f.toString().length());
        };

        Thread t1 = new Thread(sumTask, "SumThread");
        Thread t2 = new Thread(factorialTask, "FactThread");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Both threads finished.");
    }
}
