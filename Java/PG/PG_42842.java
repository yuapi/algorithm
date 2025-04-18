class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        for (int h = 3; h <= brown / 4 + 1; h++) {
            int w = brown / 2 + 2 - h;

            if ((w - 2) * (h - 2) == yellow) {
                answer[0] = w;
                answer[1] = h;
                break;
            }
        }

        return answer;
    }
}