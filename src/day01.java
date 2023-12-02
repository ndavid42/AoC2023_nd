import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class day01 {
    public static void day_01_part2() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("day01_data.txt"));
        String line;

        int calValues = 0;

        //végig a sorokon
        String[] numbersText = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] numbersNum = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};

        //végig az input sorain. egy sor adata = line
        while ((line = br.readLine()) != null) {
            System.out.println("input line: " + line);

            String currentLine = "";
            //végig egy-egy sor karakterein
            int currentNum = 0; //az adott sorban található szám lesz
            int charLen = 0; //aktuális betűsorozat (amit nem szakítanak meg számok)

            //végig az aktuális sor karakterein balról jobbra
            for (int c = 0; c < line.length(); c++) {
                if (isNumber(line.charAt(c))) {             // ha szám
                    System.out.println("szám-bal! " + line.charAt(c));
                    currentNum += ((int) line.charAt(c) - 48) * 10;
                    break;
                } else {                                    // ha betű
                    currentLine = currentLine + line.charAt(c);
//                  System.out.println(currentLine);
                    boolean foundNumText = false;
                    for (int i = 0; i < numbersText.length; i++) {
                        if (currentLine.contains(numbersText[i])) {
                            int a = Integer.parseInt(numbersNum[i]);
                            System.out.println("char-bal: " + a);
                            currentNum += a * 10;
                            foundNumText = true;
                            break;
                        }
                    }
                    if (foundNumText) break;
                }
            }

            currentLine = "";
            //végig az akt. sor karakterein jobbról balra
            for (int c = line.length() - 1; c >= 0; c--) {
                if (isNumber(line.charAt(c))) {             // ha szám
                    System.out.println("szám-jobb! " + line.charAt(c));
                    currentNum += ((int) line.charAt(c) - 48);
                    break;
                } else {                                    // ha betű
                    currentLine = line.charAt(c) + currentLine;
//                  System.out.println(currentLine);
                    boolean foundNumText = false;
                    for (int i = 0; i < numbersText.length; i++) {
                        if (currentLine.contains(numbersText[i])) {
                            int a = Integer.parseInt(numbersNum[i]);
                            System.out.println("char-jobb: " + a);
                            currentNum += a;
                            foundNumText = true;
                            break;
                        }
                    }
                    if (foundNumText) break;
                }
            }

            calValues += currentNum;

            System.out.println(currentNum);
            System.out.println();
        }


        System.out.println("Calibration Value = " + calValues);


// 55902 ??? na? IGEN!!

    }

    public static boolean isNumber ( char c){
        boolean isnum = false;
        if ((c - 48) < 10) {
            isnum = true;
        }
        return isnum;
    }

}