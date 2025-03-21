import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;

        PriorityQueue<int[]> jobQueue = new PriorityQueue<>((e1, e2) -> {
            return e1[1] - e2[1];
        });

        for (int i = 0; i < jobs.length; i++) {
            jobQueue.offer(new int[]{i, jobs[i][0], jobs[i][1]});
        }

        PriorityQueue<int[]> waitQueue = new PriorityQueue<>((e1, e2) -> {
            if (e1[2] == e2[2]) {
                if (e1[1] == e2[1]) {
                    return e1[3] - e2[3];
                }
                return e1[1] - e2[1];
            }
            return e1[2] - e2[2];
        });

        int time = 0;
        while (jobQueue.size() > 0 || waitQueue.size() > 0) {
            int num = jobQueue.size();
            for (int i = 0; i < num; i++) {
                if (jobQueue.peek()[1] > time) break;
                waitQueue.offer(jobQueue.poll());
            }

            if (waitQueue.size() == 0) {
                time++;
                continue;
            }

            int[] now = waitQueue.poll();
            time += now[2];
            answer += time - now[1];
        }

        return answer / jobs.length;
    }
}