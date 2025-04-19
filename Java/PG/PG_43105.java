class Solution {
    public int solution(int[][] triangle) {
        int lastIndex = triangle.length - 1;

        int[][] dp = new int[triangle.length][];
        for (int i = 0; i < triangle.length; i++) {
            dp[i] = triangle[i].clone();
        }

        for (int i = dp.length-2; i >= 0; i--) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] += Math.max(dp[i+1][j], dp[i+1][j+1]);
            }
        }

        return dp[0][0];
    }
}