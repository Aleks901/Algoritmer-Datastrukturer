import java.util.*;
import java.util.Scanner;

// WordBST: Binært søketre med ord og ordfrekvenser
public class WordHash
{
    public HashMap<String, Integer> tre;

    // WordBST(): Konstruktør som lager et tomt søketre
    public WordHash()
    {
        // Hello, how are you, I am under the code, please help me UUuuuUUu
        this.tre = new HashMap<>();
    }

    // public boolean isEmpty() {return (n == 0);}

    // size(): Antall ord som er lagret i treet
    public int size()
    {
        return this.tre.size();
    }

    // insert(): Setter inn ny forekomst av et ord
    public void insert(String ord)
    {
        if (this.tre.containsKey(ord)) {
            this.tre.put(ord, this.tre.get(ord) + 1);
        }else
        {
            this.tre.put(ord, 1);
        }
    }

    // search(): Søk etter et ord. Skriv ut ordet og ordfrekvensen
    // hvis det finnes i søketreet.
    public void search(String ord)
    {
        System.out.println(ord + ": " + this.tre.get(ord));
    }


    // print():
    private void print()
    {
        this.tre.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }

    // main(): Testprogram
    public static void main (String argv[])
    {
        // Leser filnavn fra bruker
        Scanner scan = new Scanner(System.in);
        System.out.print("File? ");
        String fileName = scan.next();

        // Oppretter ordleser og tomt sÃ¸ketre
        WordReader wR = new WordReader(fileName);
        WordHash wBST = new WordHash();

        // Leser alle ordene på filen og legger inn i treet
        String ord = wR.nextWord();
        while (ord != null)
        {
            wBST.insert(ord);
            ord = wR.nextWord();
        }
        // Skriver ut antall ulike ord som fantes i filen
        System.out.println(wBST.size() + " unique words " +
                "read from file " + fileName);

        // Menyvalg for å teste programmet
        int valg = 0;
        while(valg != 3)
        {
            System.out.print("\n1:Search, 2:Print, 3:Quit ? ");
            valg = scan.nextInt();
            if (valg == 1)
            {
                System.out.print("Search for? ");
                ord = scan.next();
                wBST.search(ord.toLowerCase());
            }
            else if (valg == 2)
                wBST.print();
        }
    }
    /* Hello there.
⬜⬜⬜⬜🟥🟥🟥🟨🟨🟨🟨🟥⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜
⬜⬜⬜⬜🟥🟥🟥🟨🟥🟨🟥⬜⬜⬛⬛⬛⬜⬜⬜⬜⬜⬜⬜🟧⬜⬜⬜⬜⬜
⬜⬜⬜⬜⬜🟥🟥🟧🟥🟨🟨⬜⬛🟧🟧🟧⬛⬜⬜⬜⬜⬜⬜🟧⬜⬜⬜⬜⬜
⬜⬜⬜⬜⬜⬜🟧🟧⬜🟥⬜⬜⬜🟥⬜🟧⬛⬜⬜⬜⬜⬜⬜🟧🟧🟧⬜⬜⬜
⬜⬜⬜⬜🟧🟧🟧🟧⬜⬜🟥⬜⬛🟥🟥🟥🟧⬛⬜⬜⬜⬜⬜🟧🟧🟧🟧⬜⬜
⬜⬜⬜🟧🟧🟧🟧⬜⬜⬜⬜⬜⬜⬛🟥🟥🟧⬛⬛⬜⬜⬜⬜🟧🟦🟧🟧🟧⬜
⬜⬜⬜🟧🟧🟦🟧⬜⬜⬜⬜🏻🏻🏻🟥🟫🟧⬜⬛⬜⬜⬜🟧🟧🟦🟦🟦🟧⬜
⬜⬜🟧🟧🟦🟦🟧🟧⬜⬜⬜⬛🟪🏻🏻🟫🟧🟧🟧⬛⬜⬜🟧🟦🟦🟦🟦🟧🟧
⬜⬜🟧🟦🟦🟦🟧🟧⬜⬜⬛🟧⬛⬛⬛🟧🟧⬛🟧⬛⬜🟧🟧🟦🟦🟦🟦🟦🟧
⬜🟧🟧🟦🟦🟦🟧🟧⬜⬜⬜⬛🟧🟧🟧🟧⬛⬛🟧🟧⬛🟧🟧🟦🟦🟦🟥🟦🟧
⬜🟧🟦🟦🟦🟦🟧🟧⬜⬜⬜⬜⬛⬛⬛🟧⬛⬜⬛⬛⬛🟧🟦🟦🟥🟥🟦🟦🟧
🟧🟧🟦🟦🟦🟦🟦🟧🟧⬜⬜⬜⬛🟧🟧🟧⬛⬜⬜⬜🟧🟧🟦🟦🟥🟨🟦🟦🟥
🟧🟦🟦🟦🟦🟦🟦🟧🟧🟧⬜⬜⬛🟧🟧🟧⬛⬜⬜🟧🟧🟦🟦🟥🟥🟦🟥🟥🟥
🟧🟦🟦🟦🟦🟦🟦🟦🟧🟧🟧⬜⬛🟧🟧🟧⬛⬜🟧🟧🟧🟦🟦🟥🟨🟥🟨🟥🟧
🟧🟦🟦⬛⬜⬛🟦🟦🟦🟧🟧⬛🟧🟧🟧🟧⬛🟧🟧🟧🟦🟦🟦🟥🟨🟨🟥🟧🟥
🟧🟦⬜⬜🟧⬜⬛🟦🟦🟧⬛🟧🟧🟧🟧🟧🟧⬛🟧🟧🟦🟦🟥🟨🟨🟨🟨🟥🟧
🟧⬜⬜⬛🟧🟧⬛🟦🟦⬛🟧🟧🟧🟧🟧🟧🟧⬛🟧🟦⬜⬜⬛🟥🟧🟨🟨🟧🟥
🟧⬜⬜⬜⬛🟧🟧⬛⬛🟧🟧🏻🏻🏻🏻🟧🟧🟧⬛🟦⬛🟧⬜🟥🟥🟧🟨🟨🟥
⬜⬜⬜⬜⬜⬛🟧🟧🟧⬛🏻🏻🏻🏻🏻🏻🟧🟧🟧⬛🟧🟧⬛🟦⬛🟧⬛🟥🟦
⬜⬜⬜⬜⬛⬛⬛⬛⬛🏻🏻🏻🏻🏻🏻🏻🟧⬛🟧🟧🟧⬛🟦⬜⬛🟧⬛⬜🟦
⬜⬜⬛⬛🟧🟧🟧🟧⬛🏻🏻🏻🏻🏻🏻🏻🏻🟧⬛⬛⬛🟦⬜⬛🟧🟧⬛⬜⬜
⬜⬛🟧🟧🟧🟧⬛⬛⬛🏻🏻🏻🏻🏻🏻🏻🏻🟧⬛🟧🟧⬛⬛🟧🟧⬛⬜⬜⬜
⬜⬛🟧🟧🟧⬛🟧🟧⬛🏻🏻🏻🏻🏻🏻🏻🏻🟧🟧⬛🟧🟧🟧🟧⬛⬜⬜⬜⬜
⬜⬛🟧🟧⬛🟧🟧🟧⬛🏻🏻🏻🏻🏻🏻🏻🏻🟧🟧🟧⬛🟧🟧⬛⬜⬜⬜⬜⬜
⬜⬛🏻🟧⬛🟧🟧🟧🟧⬛🏻🏻🏻🏻🏻🏻🏻🟧🟧🟧🟧⬛⬛⬜⬜⬜⬜⬜⬜
⬜⬛🏻🏻🏻⬛🟧🟧🟧🟧⬛🏻🏻🏻🏻🏻⬛🟧🟧🟧🟧⬛⬜⬜⬜⬜⬜⬜⬜
⬜⬜⬛⬛⬛⬛🟧🟧🟧⬛🏻⬛⬛⬛⬛⬛🟧🟧🟧🟧⬛⬜⬜⬜⬜⬜⬜⬜⬜
⬜⬜⬛⬜🟧🟧🟧🟧⬛🏻🏻🏻⬛⬜⬜⬜⬛🟧🟧🟧🟧⬜⬜⬜⬜⬜⬜⬜⬜
⬜⬜⬜⬛⬜⬛⬜⬛⬛⬛⬛⬛⬜⬜⬜⬜⬜⬛⬜⬛⬜⬛⬜⬜⬜⬜⬜⬜⬜⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
     */

}
