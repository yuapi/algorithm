import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        List<Stack<Integer>> gboard = new ArrayList<>();
        Stack<Integer> budget = new Stack<>();
        int answer = 0;

        for (int i = 0; i < board.length; i++) {
            Stack<Integer> line = new Stack<>();

            for (int j = board.length-1; j >= 0; j--) {
                int now = board[j][i];
                if (now > 0) line.push(now);
            }
            gboard.add(line);
        }

        for (int m: moves) {
            if (gboard.get(m-1).size() == 0) continue;

            int picked = gboard.get(m-1).pop();

            if (budget.size() > 0 && picked == budget.peek()) {
                budget.pop();
                answer += 2;
            } else {
                budget.push(picked);
            }

        }

        return answer;
    }
}
