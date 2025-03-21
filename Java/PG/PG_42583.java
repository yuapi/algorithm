import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int[] bridge = new int[bridge_length];
        LinkedList<Integer> wait = new LinkedList<Integer>(Arrays.stream(truck_weights).boxed().collect(Collectors.toList()));

        while (true) {
            int now = 0;
            if (wait.size() > 0) {
                now = wait.pop();
            }

            answer += 1;
            for (int i = 0; i < bridge.length-1; i++) {
                bridge[i] = bridge[i+1];
            }

            int sum = 0;
            for (int i = 0; i < bridge.length-1; i++) {
                sum += bridge[i];
            }

            if (sum + now > weight) {
                wait.push(now);
                now = 0;
            }
            bridge[bridge.length-1] = now;

            if (wait.size() == 0 && sum+now == 0) break;

        }

        return answer;
    }
}