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
        List<String> yhteisetLista = new ArrayList<>();
        List<String> nimiMolemmilla = new ArrayList<>();
        List<String> maijuLista = new ArrayList<>();
        String nimi = "mai";
        String nimi1 = "iju";
        String nimi2 = "ju";
        Scanner miehetLukija = null;
        Scanner naisetLukija = null;
        Scanner sanakirjaLukija = null;

        try {
            miehetLukija = new Scanner(new File("data/etunimitilasto-miehet-ensimmainen.csv"));
            System.out.println("Luetaan tiedostoa");

            while (miehetLukija.hasNext()) {
                String rivi = miehetLukija.nextLine();
                String[] osat = rivi.split(";");
                // System.out.println(osat[0]);

                // System.out.println(miehetLukija.nextLine());
                miehetNimetStringina.add(osat[0].toLowerCase());
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
                String rivi = naisetLukija.nextLine();
                String[] osat = rivi.split(";");
                // System.out.println(miehetLukija.nextLine());
                naisetNimetStringina.add(osat[0].toLowerCase());
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
                String rivi = sanakirjaLukija.nextLine();
                // System.out.println(miehetLukija.nextLine());
                sanakirjaSanat.add(rivi.toLowerCase());
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            sanakirjaLukija.close();
        }

        for (String sana : sanakirjaSanat) {
            if (miehetNimetStringina.contains(sana)) {
                yhteisetLista.add(sana);
            }
        }

        for (int i = 0; i < sanakirjaSanat.size(); i++) {
            String sana = sanakirjaSanat.get(i);
            if (naisetNimetStringina.contains(sana)) {
                yhteisetLista.add(sana);
            }
        }

        for (String sana : naisetNimetStringina) {
            if (miehetNimetStringina.contains(sana)) {
                nimiMolemmilla.add(sana);
            }
        }
        //for (String sana : sanakirjaSanat) {
        //    if (sana.contains(nimi)) {
        //        maijuLista.add(sana);
        //    }
        //}
        for (String sana : sanakirjaSanat) {
            if (sana.length() >= 2 && sana.substring(0, 2).equals(nimi1)) {
                maijuLista.add(sana);
            }
        }
        for (String sana : sanakirjaSanat) {
            if (sana.length() >= 3 && sana.substring(0, 3).equals(nimi2)) {
                maijuLista.add(sana);
            }
        }
        for (String sana : sanakirjaSanat) {
            if (sana.startsWith(nimi2)) {
                maijuLista.add(sana);
            }
        }
        for (String sana : sanakirjaSanat) {
            if (sana.startsWith(nimi1)) {
                maijuLista.add(sana);
            }
        }

        for (String x : yhteisetLista) {
            //System.out.println(x);
        }
        for (String x : nimiMolemmilla) {
            //System.out.println(x);
        }
        for (String x : maijuLista) {
            System.out.println(x);
        }

        //System.out.println(yhteisetLista.size());
        //System.out.println(nimiMolemmilla.size());

    }
}
