import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class day04 {
    public static void part1() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("./input04/data.txt"));
        String line;

        int points = 0;

        while ((line = br.readLine()) != null) {
            int pointsOfCard = 0;
            ArrayList<Integer> playedNumbers = new ArrayList<Integer>();
            ArrayList<Integer> winningNumbers = new ArrayList<Integer>();

            System.out.println("input line: " + line.replace("  "," "));
//            System.out.println(line.split(": ")[1].charAt(0));

            String card = line.split(": ")[1].replace("  "," ");

//            System.out.println("card: " + card);
//            System.out.println(card.indexOf('|'));

            String num = "";

            //played numbers
//            System.out.println("------played: ");
            for (char c: card.split("\\| ")[0].toCharArray()) {
//                System.out.println("c1: " + c);
                if (isDigit(c)) {
                    num = num + c;
//                    System.out.println("digit! " + c + ", a num pedig jelenleg: " + num);
                } else if ( c == ' ' && !num.isEmpty()) {
                    playedNumbers.add(Integer.parseInt(num.trim()));
//                    System.out.println("played: " + Integer.parseInt(num));
                    num = "";
                }
            }
            num = "";

            //separator után, azaz winning numbers
//            System.out.println("------winning:");
            for (char c: card.split(" \\| ")[1].toCharArray()) {
//                System.out.println("c2: " + c);
                if (isDigit(c)) { // ha szám
                    num = num + c;
//                    System.out.println("digit! " + c + ", a num pedig jelenleg: " + num);
                } else if ( (c == ' ') && !num.isEmpty()) { // ha nem szám
//                       System.out.println("winning: " + Integer.parseInt(num));
                        winningNumbers.add(Integer.parseInt(num.trim()));
                        num = "";

                }
            }
            winningNumbers.add(Integer.parseInt(num.trim())); //az utolsó szám miatt


            for (Integer p : playedNumbers) {
//                System.out.println("p: " + p);
                for (Integer w: winningNumbers) {
                    if (p == w) {
                        if (pointsOfCard == 0) {
                            pointsOfCard = 1;
                            System.out.println("1 point!");
                        } else {
                            pointsOfCard *= 2;
                            System.out.println(pointsOfCard + " points!");
                        }
                    }
                }
            }

            points += pointsOfCard;

//
//            do {
//                System.out.println(card.charAt(i));
//
//
//                i++;
//            } while (card.charAt(i) != '|');


            System.out.println();
        }
            System.out.println("points: " + points);

    }





    public static boolean isDigit ( char c){
        boolean isnum = false;
//        System.out.println("isDigit " + ((int) c -48));
        if ((((int) c)-48) >= 0 && (((int) c)-48) < 10) {
            isnum = true;
        }
        return isnum;
    }

    public static boolean isSymbol ( char c){
        boolean isnum = false;
        if ((((int) c)-48) < -2) {
            isnum = true;
        }
        return isnum;
    }

}
