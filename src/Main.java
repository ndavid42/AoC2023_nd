import java.io.*;
import java.util.Scanner;
public class Main
{
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("day01_test2.txt"));
        int calValues = 0;

        //végig a sorokon
        String line;
        String[] numbersText = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] numbersNum = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};

        while ((line = br.readLine()) != null) {
//            System.out.println("input line: " + line);
            String currentLine = "";
            for (int c = 0; c < line.length(); c++) {
                currentLine = currentLine + line.charAt(c);
//                System.out.println(currentLine);
                for (int i = 0; i < numbersText.length; i++) {
                    if (currentLine.contains(numbersText[i])) {
                        System.out.println("csere1! " + currentLine);
                        currentLine = currentLine.replace(numbersText[i], numbersNum[i]);
                        break;
                    }
                }
//                System.out.println(val);
            }
            line = currentLine;

            currentLine = "";
            for (int c = line.length()-1; c >= 0; c--) {
                currentLine = line.charAt(c) + currentLine;
//                System.out.println(currentLine);
                for (int i = 0; i < numbersText.length; i++) {
                    if (currentLine.contains(numbersText[i])) {
                        System.out.println("csere2! " + currentLine);
                        currentLine = currentLine.replace(numbersText[i], numbersNum[i]);
                        break;
                    }
                }
//                System.out.println(val);
            }
            line = currentLine;



            //végig egy-egy sor karakterein
            int currentNum = 0; //az adott sorban található szám lesz
            System.out.println("output line: " + line);
            //elejéről indulva
            for (int c = 0; c < line.length(); c++) {
                int num = ((int) line.charAt(c)) -48;

                if (num < 10) {;
//                    System.out.print(num);
                    currentNum += num*10;
                    break;
                }
            }

            //végéről indulva
            for (int c = line.length()-1; c >= 0; c--) {
                int num = ((int) line.charAt(c)) -48;

                if (num < 10) {;
//                    System.out.print(num);
                    currentNum += num;
                    break;
                }
            }

            calValues += currentNum;

            System.out. println(currentNum);
            System.out. println();
        }

        System.out.println("Calibration Value = " + calValues);




// rossz:
// 55929







    }
}  