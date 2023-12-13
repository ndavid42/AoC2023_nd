import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class day09part1 {
    public static void code() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("./input09/test1.txt"));
        String line;

        ArrayList<ArrayList<Integer>> dataset = new ArrayList<>();

        // dateset feltöltés
        while ((line = br.readLine()) != null) {
            System.out.println("input line: " + line);
            String[] h = line.split(" ");
            ArrayList<Integer> history = new ArrayList<>();
            for (String string : h) {
                history.add(Integer.parseInt(string));
            }

            dataset.add(history);
        }
        System.out.println(dataset);

        // dataset feldolgozás
        for (ArrayList<Integer> adatsor: dataset) {

            boolean kiszamolva = false;
            while (!kiszamolva) {
                ArrayList<ArrayList<Integer>> listOfLists = new ArrayList<>();
                //végig az adott adatsoron
                ArrayList<Integer> temp = new ArrayList<>();
                for (int x = 0; x < adatsor.size() - 1; x++) {
                    temp.add(adatsor.get(x + 1) - adatsor.get(x));
                }
                listOfLists.add(temp);
                System.out.println(temp);

                int ures = 0;
                for (int a : temp) {
                    ures += a;
                }
                if (ures == 0) {
                    kiszamolva = true;
                }
                System.out.println("--");
            }

            System.out.println(kiszamolva);

//            ArrayList<Integer> x2 = new ArrayList<>();
//            for (int x = 0; x < adatsor.size()-1; x++) {
//                x2.add(adatsor.get(x+1)-adatsor.get(x));
//            }
//            System.out.println("x2: " + x2);
//
//            ArrayList<Integer> x3 = new ArrayList<>();
//            for (int x = 0; x < x2.size()-1; x++) {
//                x3.add(x2.get(x+1)-x2.get(x));
//            }
//            System.out.println("x3: " + x3);
//
//            ArrayList<Integer> x4 = new ArrayList<>();
//            for (int x = 0; x < x3.size()-1; x++) {
//                x4.add(x3.get(x+1)-x3.get(x));
//            }
//            System.out.println("x4: " + x4);


            System.out.println();



        } // dataset vége







        // Existing ArrayList of ArrayLists
        ArrayList<ArrayList<Integer>> listOfLists = new ArrayList<>();

        // Add a new ArrayList directly within the add method
        listOfLists.add(new ArrayList<>(List.of(1, 2, 3))); // Java 9 and later

        // Print the elements of the existing ArrayList
        for (ArrayList<Integer> list : listOfLists) {
            for (Integer element : list) {
                System.out.print(element + " ");
            }
            System.out.println(); // Move to the next line for the next ArrayList
        }


    }
}
