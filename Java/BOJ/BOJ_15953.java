import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15953 {
    public static void main(String[] args) throws Exception {
        int[][] prize1 = new int[][]{{1, 500}, {2, 300}, {3, 200}, {4, 50}, {5, 30}, {6, 10}};
        int[][] prize2 = new int[][]{{1, 512}, {2, 256}, {4, 128}, {8, 64}, {16, 32}};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int prize = 0;

            if (a > 0 && a < 22) {
                for (int[] pr1: prize1) {
                    a -= pr1[0];
                    if (a < 1) {
                        prize += pr1[1];
                        break;
                    }
                }
            }

            if (b > 0 && b < 32) {
                for (int[] pr2: prize2) {
                    b -= pr2[0];
                    if (b < 1) {
                        prize += pr2[1];
                        break;
                    }
                }
            }
            System.out.println(prize * 10000);
        }
    }
}

