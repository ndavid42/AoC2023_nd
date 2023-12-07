import java.io.IOException;

public class day06part1 {
    public static void code() throws IOException {
//        int[] time = {7, 15, 30};
//        int[] dist = {9, 40, 200};
        int[] time = {46, 85, 75, 82};
        int[] dist = {208, 1412, 1257, 1410};
        int[] record = {0, 0, 0, 0};

        int races = time.length;
        int answer1 = 1;
        for (int b = 0; b < races; b++) {
            for (int a = 0; a <= time[b]; a++) {
                int hold = a;
                int charge = time[b] - a;
                int distance = hold * charge;
                if (distance > dist[b]) {
                    record[b]++;
                }
            }
            answer1 *= record[b];
        }

        System.out.println("answ1: " + answer1);
    }
}
