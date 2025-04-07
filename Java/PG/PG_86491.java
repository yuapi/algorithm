class Solution {
    public int solution(int[][] sizes) {
        int walletw = 1;
        int walleth = 1;

        for (int[] size: sizes) {
            int w;
            int h;
            if (size[0] > size[1]) {
                w = size[0];
                h = size[1];
            } else {
                w = size[1];
                h = size[0];
            }

            if (w > walletw) walletw = w;
            if (h > walleth) walleth = h;
        }
        return walletw * walleth;
    }
}