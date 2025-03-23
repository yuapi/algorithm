import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        PriorityQueue<Integer> reverse = new PriorityQueue<>(Collections.reverseOrder());

        int tdx = 0;
        for (String operation: operations) {
            String[] op = operation.split(" ");

            if (op[0].equals("I")) {
                queue.add(Integer.parseInt(op[1]));
                reverse.add(Integer.parseInt(op[1]));
            } else {
                if (queue.isEmpty()) continue;

                if (op[1].equals("1")) queue.remove(reverse.poll());
                else reverse.remove(queue.poll());
            }
        }

        int[] answer;
        if (queue.isEmpty()) answer = new int[2];
        else answer = new int[]{reverse.peek(), queue.peek()};

        return answer;
    }
}