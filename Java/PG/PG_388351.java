class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = schedules.length;

        for (int i = 0; i < schedules.length; i++) {
            if (schedules[i] % 100 < 49) schedules[i] += 10;
            else schedules[i] += 50;
        }

        int day = startday;
        boolean[] late = new boolean[schedules.length];
        for (int i = 0; i < 7; i++) {
            if (day < 6) {
                for (int j = 0; j < schedules.length; j++) {
                    if (late[j]) continue;

                    if (timelogs[j][i] > schedules[j]) {
                        late[j] = true;
                        answer--;
                    }
                }
            } else {
                if (day == 7) day = 0;
            }
            day += 1;
        }

        return answer;
    }
}