import java.util.*;

public class Oblig_01 {

    public static void main(String[] args) {
        System.out.println(Krypter("Karmann-Ghia"));
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
        S = ROT13(S);

        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();
        String T = "";

        char[] characters_in_S = S.toCharArray();
        for (int i = 0; i < S.length() / 2; i++) {
            queue.add(characters_in_S[i]);
        }
        for (int i = S.length() / 2; i < S.length(); i++) {
            stack.push(characters_in_S[i]);
        }

        while (!queue.isEmpty() || !stack.isEmpty()) {
            T += stack.pop();
            T += queue.remove();
        }

        return T;
    }

}

