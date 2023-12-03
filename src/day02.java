import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.module.ResolutionException;
import java.lang.ref.SoftReference;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentSkipListSet;

public class day02 {
    public static void day02_part1() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("./input02/data.txt"));
        String line;

        int red = 12;
        int grn = 13;
        int blu = 14;
        int game = 0;
        int sumOfIds = 0;
        boolean isPossible;

        while ((line = br.readLine()) != null) {
            int thisRED = 0;
            int thisGRN = 0;
            int thisBLU = 0;

            isPossible = false;
            game += 1;
            System.out.println("input line: " + line);

            ArrayList<String> currentSet = new ArrayList<String>();
            //szét kell darabolni a GAMEeket az egyes SETekre
            System.out.println(line.split(": ")[1]);

            //hány set van a game-ben
            int setNum = line.split(": ")[1].split("; ").length + 1;
            System.out.println(setNum);

            //végig a game setjein
            for (int i = 0; i < setNum - 1; i++) {
                currentSet.add(line.split(": ")[1].split("; ")[i]);
                System.out.println("game is: " + game + " | set is: " + currentSet.get(i));

                String[] setCubes = currentSet.get(i).split(", ");
                int setCubesNum = currentSet.get(i).split(", ").length;
                System.out.println("setCubes: " + setCubesNum);

                //végig az adott set elemein
                for (int j = 0; j < setCubesNum; j++) {
//                    int colorPcs = String.valueOf(setCubes[j].split(" ")[0]);
                    int colorPcs = Integer.parseInt(setCubes[j].split(" ")[0]);
                    String color = setCubes[j].split(" ")[1];
                    System.out.println(colorPcs + " of color " + color);

                    if (color.equals("red") && colorPcs > thisRED) {
                        thisRED = colorPcs;
                    } else if (color.equals("green") && colorPcs > thisGRN) {
                        thisGRN = colorPcs;
                    } else if (color.equals("blue") && colorPcs > thisBLU) {
                        thisBLU = colorPcs;
                    }


                }

            }

            if (
                    (thisRED <= red) &&
                            (thisGRN <= grn) &&
                            (thisBLU <= blu)
            ) {
                System.out.println("----yes!! and this is game " + game);
                sumOfIds += game;
            } else {
                System.out.println("---NOPE---");
            }


            // meg kéne nézni, h az egyes színekből
            // mennyi a legnagyobb kimarkolt darab


            System.out.println();
        }
//            System.out.println("D2P1");
        System.out.println("sum of game ids is: " + sumOfIds);

    }

//2551!!!

    public static void day02_part2() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("./input02/data.txt"));
        String line;

        int red = 12;
        int grn = 13;
        int blu = 14;
        int game = 0;
        int sumOfIds = 0;
        boolean isPossible;

        while ((line = br.readLine()) != null) {
            int thisRED = 0;
            int thisGRN = 0;
            int thisBLU = 0;

            isPossible = false;
            game += 1;
            System.out.println("input line: " + line);

            ArrayList<String> currentSet = new ArrayList<String>();
            //szét kell darabolni a GAMEeket az egyes SETekre
            System.out.println(line.split(": ")[1]);

            //hány set van a game-ben
            int setNum = line.split(": ")[1].split("; ").length + 1;
            System.out.println(setNum);

            //végig a game setjein
            for (int i = 0; i < setNum - 1; i++) {
                currentSet.add(line.split(": ")[1].split("; ")[i]);
                System.out.println("game is: " + game + " | set is: " + currentSet.get(i));

                String[] setCubes = currentSet.get(i).split(", ");
                int setCubesNum = currentSet.get(i).split(", ").length;
                System.out.println("setCubes: " + setCubesNum);

                //végig az adott set elemein
                for (int j = 0; j < setCubesNum; j++) {
    //                    int colorPcs = String.valueOf(setCubes[j].split(" ")[0]);
                    int colorPcs = Integer.parseInt(setCubes[j].split(" ")[0]);
                    String color = setCubes[j].split(" ")[1];
                    System.out.println(colorPcs + " of color " + color);

                    if         (color.equals("red") && colorPcs > thisRED) {
                        thisRED = colorPcs;
                    } else if (color.equals("green") && colorPcs > thisGRN) {
                        thisGRN = colorPcs;
                    } else if (color.equals("blue") && colorPcs > thisBLU) {
                        thisBLU = colorPcs;
                    }


                }

            }

            System.out.println("R: " + thisRED + ",G: " + thisGRN + ",B: " + thisBLU);
            sumOfIds += (thisRED * thisBLU * thisGRN);
//
//            if (
//                    (thisRED <= red) &&
//                    (thisGRN <= grn) &&
//                    (thisBLU <= blu)
//            ) {
//                System.out.println("----yes!! and this is game " + game);
//                sumOfIds += game;
//            } else {
//                System.out.println("---NOPE---");
//            }


            // meg kéne nézni, h az egyes színekből
            // mennyi a legnagyobb kimarkolt darab


            System.out.println();
        }
    //            System.out.println("D2P1");
        System.out.println("power of game ids is: " + sumOfIds);

    }

}