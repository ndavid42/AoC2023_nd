import java.io.IOException;

public class day06part2 {
    public static void code() throws IOException {
//        int time = 71530;
//        int dist = 940200;
        long time = 46857582L;
        long dist = 208141212571410L;
        int record = 0;


        for (int a = 0; a <= time; a++) {
            long charge = time - a;
            long distance = a * charge;
            if (distance > dist) {
                record++;
            }
        }

        System.out.println("answ1: " + record);
    }
}
