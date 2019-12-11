package io.zipcoder;

import java.util.Random;

/**
 * Make this extend the Copier like `UnsafeCopier`, except use locks to make sure that the actual intro gets printed
 * correctly every time.  Make the run method thread safe.
 */
public class SafeCopier extends Copier{

    public SafeCopier(String toCopy) {
        super(toCopy);
    }

    public void run() {
        Random random = new Random();
        int randomSleep = random.nextInt((100 - 50 ) + 1) + 50;


        while (stringIterator.hasNext()) {
//            System.out.println(Thread.currentThread().getName() + " " + stringIterator.next());
//            copied += stringIterator.next();

            try {
//                String holder = stringIterator.next() + " ";
//                Thread.sleep(randomSleep);
//                System.out.println(Thread.currentThread().getName());
//                copied += holder;
                {
                    synchronized (stringIterator) {
                        String holder = stringIterator.next() + " ";
                        // Thread.sleep(new Random().nextInt(50));
                        Thread.sleep(randomSleep);
                        System.out.println(Thread.currentThread().getName());
                        copied += holder;
                    }
                }

            } catch (Exception e) {
                System.out.println("MAIN INTERRUPTED");
            }
        }
        copied = copied.trim();
    }
}
