import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>(Arrays.stream(scoville).boxed().collect(Collectors.toList()));

        while (true) {
            if (queue.peek() >= K) break;
            if (queue.size() == 1) {
                answer = -1;
                break;
            }
            answer++;
            queue.offer(queue.poll() + queue.poll() * 2);
        }

        return answer;
    }
}