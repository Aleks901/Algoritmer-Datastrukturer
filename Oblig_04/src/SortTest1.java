import java.util.*;

public class SortTest1 {
    public static void main(String[] args) {
        System.out.println(">>>>>>>>>>>>><<<<<<<<<<<<<<");
        System.out.println("   n    tA    tL   tL/tA");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        for (int n = 1000000; n <= 10000000; n += 1000000) {
            int[] A = new int[n];
            Random r = new Random();
            for (int i = 0; i < n; i++)
                A[i] = r.nextInt(2 * n);

            LinkedList<Integer> L = new LinkedList<>();
            for (int i = n - 1; i >= 0; i--)
                L.addFirst(A[i]);

            long tA, tL, t;

            t = System.currentTimeMillis();
            Arrays.sort(A);
            tA = System.currentTimeMillis() - t;

            t = System.currentTimeMillis();
            Collections.sort(L);
            tL = System.currentTimeMillis() - t;

            System.out.printf("%-5d %-5d %-5d %-5.1f\n", n, tA, tL, (float) tL / tA);
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
}
