import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class day06 {
    public static void day06_part1() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("./input04/test1.txt"));
        String line;

        while ((line = br.readLine()) != null) {
            System.out.println("input line: " + line);


        }
//            System.out.println("D2P1");

    }
}
