import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class day03 {
    public static void day03_part1() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("./input03/test1.txt"));
        String line;

        while ((line = br.readLine()) != null) {
            System.out.println("input line: " + line);


        }
//            System.out.println("D2P1");

    }
}
