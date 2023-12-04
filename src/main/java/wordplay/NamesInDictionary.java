package wordplay;

import wordplay.io.DictionaryReader;
import wordplay.io.NamesReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class NamesInDictionary {

    private static List<String> finnishNames = NamesReader.readFirstNames();
    private static List<String> finnishWords = DictionaryReader.readFinnishWords();

    public static void main(String[] args) {
        /*
         * Implement a program that prints all Finnish names that are also
         * found in the Finnish dictionary.
         *
         * You can use the finnishNames and finnishWords variables defined above
         * as the data set you need to process. Notice that the words are in lower case
         * but the names are not. The names can contain duplicates, as there are several
         * unisex names in the data set.
         *
         * Try to make your program as efficient as possible. A good goal is to have
         * the program run in tenths of a second.
         *
         * Good luck!
         */
        List<String> miehetNimetStringina = new ArrayList<>();
        List<String> naisetNimetStringina = new ArrayList<>();
        List<String> sanakirjaSanat = new ArrayList<>();
        Scanner miehetLukija = null;
        Scanner naisetLukija = null;
        Scanner sanakirjaLukija = null;

        try {
            miehetLukija = new Scanner(new File("data/etunimitilasto-miehet-ensimmainen.csv"));
            System.out.println("Luetaan tiedostoa");
            while (miehetLukija.hasNext()) {
                // System.out.println(miehetLukija.nextLine());
                miehetNimetStringina.add(miehetLukija.nextLine());
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            miehetLukija.close();
        }

        try {
            naisetLukija = new Scanner(new File("data/etunimitilasto-naiset-ensimmainen.csv"));
            System.out.println("Luetaan tiedostoa");
            while (naisetLukija.hasNext()) {
                // System.out.println(miehetLukija.nextLine());
                naisetNimetStringina.add(naisetLukija.nextLine());
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            naisetLukija.close();
        }

        try {
            sanakirjaLukija = new Scanner(new File("data/kaikkisanat.txt"));
            System.out.println("Luetaan tiedostoa");
            while (sanakirjaLukija.hasNext()) {
                // System.out.println(miehetLukija.nextLine());
                sanakirjaSanat.add(sanakirjaLukija.nextLine());
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            sanakirjaLukija.close();
        }

        for (int i = 0; i < 10; i++) {
            //System.out.println(miehetNimetStringina[i]);
        }

    }
}
