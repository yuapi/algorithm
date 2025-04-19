import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = n;

        for (int i = 0; i < n-1; i++) {
            HashMap<Integer, List<Integer>> graph = new HashMap<>();
            for (int j = 1; j < n+1; j++) {
                graph.put(j, new ArrayList<>());
            }

            for (int j = 0; j < n-1; j++) {
                if (i == j) continue;
                graph.get(wires[j][0]).add(wires[j][1]);
                graph.get(wires[j][1]).add(wires[j][0]);
            }

            Queue<Integer> queue = new LinkedList<>();
            queue.offer(1);

            boolean[] visited = new boolean[n];
            int num = 0;

            while (!queue.isEmpty()) {
                int now = queue.poll();
                visited[now-1] = true;
                num++;

                List<Integer> nodes = graph.get(now);
                for (int node: nodes) {
                    if (visited[node-1]) continue;
                    queue.offer(node);
                }
            }
            int diff = 2*num > n ? 2*num - n : n - 2*num;
            if (diff < answer) answer = diff;
        }
        return answer;
    }
}