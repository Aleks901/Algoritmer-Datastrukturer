import java.util.Scanner;

public class Oppgave_5_6 {

    public static long C_iterativ(int n, int m) {
        long[][] pascal = new long[n + 1][];

        for (int i = 0; i <= n; i++) {
            pascal[i] = new long[i + 1];
            pascal[i][0] = 1;
            pascal[i][i] = 1;

            for (int j = 1; j < i; j++)
                pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];

        }

        return pascal[n][m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("n? ");
        int n = scanner.nextInt();
        scanner.close();

        for (int m = 0; m <= n; m++) {
            System.out.println("C(" + n + ", " + m + ") = " + C_iterativ(n, m));
        }
    }
}
