import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;

// WordBST: Binært søketre med ord og ordfrekvenser
public class WordBST
{


    Map<String, Integer> T = new TreeMap<>();

    // WordBST(): Konstruktør som lager et tomt søketre
    public void WordBST()
    {
        // Jada, her var det jo tomt. Usikker på om dere ville ha noe mer.
        // Stemmer jo forsåvidt at konstruktøren lager et tomt søketre enda.
        // ..
        // Day 31 of being stuck inside the comments
        // I ran out of water a few days ago.. but I've learnt a thing or two from Bear Grylls.
        // .. Salty.
    }

    // size(): Antall ord som er lagret i treet
    public int size()
    {
        return T.size();
    }

    // insert(): Setter inn ny forekomst av et ord
    public void insert(String ord)
    {
        if (T.containsKey(ord))
        {
            int val = T.get(ord);
            T.replace(ord, val + 1);
        }
        else
        {
            T.put(ord, 1);
        }
    }

    // search(): Søk etter et ord. Skriv ut ordet og ordfrekvensen
    // hvis det finnes i søketreet.
    public void search(String ord)
    {
       if (T.containsKey(ord))
       {
           System.out.println(ord + ": " + T.get(ord));
       }
    }

    public void print()
    {
        System.out.println
                ("  ／l、   Meow     \n" +
                "（ﾟ､ ｡ ７         \n" +
                "  l  ~ヽ       \n" +
                "  じしf_,)ノ");
        for (String key : T.keySet())
            System.out.println(key + ": " + T.get(key));
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
        WordBST wBST = new WordBST();

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
}