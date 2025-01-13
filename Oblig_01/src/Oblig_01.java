import java.util.*;

public class Oblig_01 {

    public static void main(String[] args) {
        // Ettersom et av krypterings stegene er å dele ordet i 2
        // så vil det kun være mulig å produsere strenger med oddetall
        // bokstaver..
        Scanner krypter_noe = new Scanner(System.in);
        System.out.println("Hva vil du kryptere?: ");
        String input = krypter_noe.nextLine();
        String kryptert_input = Krypter(input);
        System.out.println("Din krypterte string: " + kryptert_input);
        Scanner dekrypter_noe = new Scanner(System.in);
        System.out.println("Vil du dekryptere stringen? Y/N: ");
        String input_2 = dekrypter_noe.nextLine().toUpperCase();
        if (input_2.equals("Y")){
            System.out.println("Din dekrypterte string: " + Dekrypter(kryptert_input));
        }
        else{
            System.out.println("Synd, du får den likevell: " + Dekrypter(kryptert_input));
        }
    }

    public static String ROT13(String S)
    {
        char[] C = S.toCharArray();
        for (int i = 0; i < S.length(); i++)
        {
            char c = C[i];
            if       (c >= 'a' && c <= 'm') c += 13;
            else if  (c >= 'A' && c <= 'M') c += 13;
            else if  (c >= 'n' && c <= 'z') c -= 13;
            else if  (c >= 'N' && c <= 'Z') c -= 13;
            C[i] = c;
        }
        return String.valueOf(C);
    }

    public static String Krypter(String S) {
        // Steg 1 av krypteringen
        S = ROT13(S);

        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();
        String T = "";

        // Lagrer bokstav av strengen i et character array
        char[] characters_in_S = S.toCharArray();
        // Steg 2 av krypteringen
        for (int i = 0; i < S.length() / 2; i++) {
            queue.add(characters_in_S[i]);
        }
        // Steg 3 av krypteringen
        for (int i = S.length() / 2; i < S.length(); i++) {
            stack.push(characters_in_S[i]);
        }
        // Steg 4 av krypteringen
        while (!queue.isEmpty() || !stack.isEmpty()) {
            T += stack.pop();
            T += queue.remove();
        }
        return T;
    }

    public static String Dekrypter(String S){
        char[] characters_in_S = S.toCharArray();
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();
        int i = 0;
        String T = "";

        // Dekonstruerer strengen med tanke på at hvert oddetall element
        // er et stack element og hvert partall element er et queue element
        while(i < characters_in_S.length){
            stack.push(characters_in_S[i]);
            i++;
            queue.add(characters_in_S[i]);
            i++;
        }

        // Rekonstruerer strengen med tanke på at halvparten av de
        // første elementene er fra køen
        while (!queue.isEmpty()){
            T += queue.remove();
        }

        // reverserer stacken for at vi skal få tilbake elementene i
        // riktig rekkefølge relativt til strengen.
        // (Kunne helt sikkert vært gjort på en tøffere måte)
        List<Character> reversed_stack = stack.reversed();
        for (char c : reversed_stack){
            T += c;
        }

        T = ROT13(T);
        return T;
    }

}

