import java.util.Scanner;

public class Oppgave_1_3 {


    public static long C_rekursiv(int n, int m)
    {
        if (m == 0 || m == n)
            return 1;

        return C_rekursiv(n - 1, m) + C_rekursiv(n - 1, m - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("n? ");
        int n = scanner.nextInt();
        scanner.close();

        for (int m = 0; m <= n; m++)
            System.out.println("C(" + n + ", " + m + ") = " + C_rekursiv(n, m));
    }

}
