
import java.util.Scanner;

// WordBST: Binært søketre med ord og ordfrekvenser
public class WordBST
{
    // WordNode: Indre klasse for en node i søketreet
    class WordNode
    {
        String word;
        int data;
        WordNode left, right;

        public WordNode(String ord)
        {
            // Tenker det er greit om data starter på 1 ettersom hvis den ikke eksisterer i treet så vil den gjøre det
            // og dermed eksistere minst en gang.. (Hvorfor skriver jeg dette.. tenker jeg høyt i kommentarene mine?
            // eller kanskje kommentarene lever sitt eget liv..er jeg kommentarene..?..Hjelp slipp meg ut! *Bank Bank*)
            this.word = ord;
            this.data = 1;
            this.left = right = null;
        }

        public void print()
        {
            System.out.println(this.word + " " + this.data);
        }
    }

    private WordNode rot; // Roten i hele søketreet
    private int n;        // Antall noder i hele treet

    // WordBST(): Konstruktør som lager et tomt søketre
    public void WordBST()
    {
        rot = null;
        n = 0;
    }

    public boolean isEmpty()
    {
        return (n == 0);
    }

    // size(): Antall ord som er lagret i treet
    public int size()
    {
        return n;
    }

    // insert(): Setter inn ny forekomst av et ord
    public void insert(String ord)
    {
        WordNode newWordNode = new WordNode(ord);

        // Hvis det ikke eksisterer en rot så bare mekker vi en her.
        if(isEmpty())
        {
            rot = newWordNode;
            n++;
            return;
        }

        WordNode current = rot;
        while (true)
        {
            // Hvis ordet eksisterer så blir det lagt til i data.
            if (current.word.equals(ord))
            {
                current.data++;
                return;
            }
            if (current.word != ord)
            {
                // Her blir treet halvert basert på alfabetisk rekkefølge i hvert steg.
                if(ord.compareTo(current.word) < 0)
                {
                    if (current.left == null)
                    {
                        current.left = newWordNode;
                        n++;
                        return;
                    }
                    else current = current.left;
                }
                else
                {
                    if(current.right == null)
                    {
                        current.right = newWordNode;
                        n++;
                        return;
                    }
                    else current = current.right;
                }
            }
        }
    }

    // search(): Søk etter et ord. Skriv ut ordet og ordfrekvensen
    // hvis det finnes i søketreet.
    public void search(String ord)
    {
        WordNode current = rot;
        while (current != null)
        {
            if (current.word.equals(ord))
            {
                current.print();
                return;
            }
            if (ord.compareTo(current.word) < 0)
            {
                current = current.left;
            }
            else
            {
                current = current.right;
            }
        }
    }

    // print(): Alfabetisk utskrift av hele søketreet. Kaller en
    // rekursiv metode som gjør selve utskriften.
    public void print()
    {
        print(rot);
    }

    // print(): Rekursiv utskrift av hele søketreet med rot i "rot"
    private void print(WordNode rot)
    {
        // Her bare turer vi ned hver side rekursivt.
        if (rot != null)
        {
            rot.print();
            print(rot.left);
            print(rot.right);
        }
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