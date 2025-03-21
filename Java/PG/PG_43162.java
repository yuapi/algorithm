class Solution {
    int[] visited;

    public void search(int idx, int[][] computers) {
        visited[idx] = 1;

        for (int i = 0; i < computers.length; i++) {
            if (computers[idx][i] == 1 && visited[i] == 0)
                search(i, computers);
        }
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new int[n];

        for (int i = 0; i < n; i++) {
            if (visited[i] == 1) continue;

            search(i, computers);
            answer++;
        }


        return answer;
    }
}