import java.util.*;

public class SortTest2 {
    public static void main(String[] args) {
        System.out.println(">>>>>>>>>>>>><<<<<<<<<<<<<<");
        System.out.println("   n    tA    tL   tL/tA");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        for (int n = 1000000; n <= 10000000; n += 1000000) {
            int[] A = new int[n];
            Random r = new Random();

            // 0,1,2,3,...,(n/3)−1
            for (int i = 0; i < n/3; i++)
                A[i] = i;

            // tilfeldige tall større eller lik 0 og mindre enn 2·n.
            for (int i = n/3; i < 2 * n/3; i++)
                A[i] = r.nextInt(2 * n);

            // (n/3),(n/3)+1,(n/3)+2,...,(2·n/3)−1, i stigende sortert rekkefølge.
            for (int i = 2 * n/3; i < n; i++)
                A[i] = i - n/3;

            LinkedList<Integer> L = new LinkedList<>();
            for (int i = n - 1; i >= 0; i--)
                L.addFirst(A[i]);


            long tA, tL, t;

            // Sortering av array
            t = System.currentTimeMillis();
            Arrays.sort(A);
            tA = System.currentTimeMillis() - t;

            // Sortering av liste
            t = System.currentTimeMillis();
            Collections.sort(L);
            tL = System.currentTimeMillis() - t;

            System.out.printf("%-5d %-5d %-5d %-5.1f\n", n, tA, tL, (float) tL / tA);
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
}
