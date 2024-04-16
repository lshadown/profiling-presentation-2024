package com.gruzewskidev.profiling.demo0;

//Source: https://github.com/apangin/java-profiling-presentation/blob/master/src/demo1/StringBuilderTest.java

/**
 * This demo shows that most sampling profilers are misleading.
 * The given program appends 5 symbols to the end of StringBuilder
 * and deletes 5 symbols from the beginning of StringBuilder.
 *
 * The real bottleneck here is delete(), since it involves moving
 * of 1 million characters. However, safepoint-based profilers
 * will display Thread.isAlive() as the hottest method.
 * JFR will not report anything useful at all, since it cannot
 * traverse stack traces when JVM is running System.arraycopy().
 */
public class StringBuilderTest {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append(new char[1_000_000]);

        do {
            sb.append(12345);
            sb.delete(0, 5);
        } while (Thread.currentThread().isAlive());

        System.out.println(sb);  // never happens
    }
}
