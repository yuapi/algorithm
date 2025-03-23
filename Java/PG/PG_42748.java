import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int n = commands.length;
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            int a = commands[i][0] - 1;
            int b = commands[i][1];
            int k = commands[i][2] - 1;
            int tl = b - a;
            int[] temp = new int[tl];

            for (int j = 0; j < tl; j++) {
                temp[j] = array[j+a];
            }

            Arrays.sort(temp);
            answer[i] = temp[k];
        }

        return answer;
    }
}