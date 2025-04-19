class Solution {
    private int maxDepth = 0;

    public void search(int[][] dungeons, String log, int k, int depth) {
        if (depth == dungeons.length) {
            maxDepth = depth;
            return;
        }

        for (int i = 0; i < dungeons.length; i++) {
            if (log.contains(Integer.toString(i))) continue;

            if (dungeons[i][0] > k) {
                if (maxDepth < depth) maxDepth = depth;
            } else {
                search(dungeons, log + Integer.toString(i), k - dungeons[i][1], depth+1);
            }
        }
    }

    public int solution(int k, int[][] dungeons) {
        search(dungeons, "", k, 0);
        return maxDepth;
    }
}