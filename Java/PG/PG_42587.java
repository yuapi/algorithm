import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            queue.offer(i);
        }

        int count = 0;
        while (true) {
            int now = queue.poll();

            boolean skip = false;
            for (int priority: priorities) {
                if (priorities[now] < priority) {
                    skip = true;
                    break;
                }
            }

            if (skip) {
                queue.offer(now);
                continue;
            }

            count++;
            priorities[now] = 0;
            if (now == location) break;
        }
        return count;
    }
}