import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class day02 {
    public static void day02_part1() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("./input02/test1.txt"));
        String line;

        while ((line = br.readLine()) != null) {
            System.out.println("input line: " + line);


        }
//            System.out.println("D2P1");

    }
}



// myArray = new int[]{0, 1, 2, 3};
// int myArray[] = {0, 1, 2, 3};