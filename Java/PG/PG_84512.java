class Solution {
    public int solution(String word) {
        int answer = 0;
        String[] words = word.split("");
        String r = "AEIOU";
        int[] d = { 781, 156, 31, 6, 1 };

        for (int i = 0; i < words.length; i++) {
            answer += 1 + r.indexOf(words[i]) * d[i];
        }

        return answer;
    }
}
