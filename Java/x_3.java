import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> log = new HashSet<>();

        int player = 0;
        int turn = 0;
        String prev = "";

        for (int i = 0; i < words.length; i++) {
            if (words[i].length() == 1 || !words[i].startsWith(prev) || log.contains(words[i])) {
                if ((i+1) % n == 0) player = n;
                else player = (i+1) % n;
                turn = i / n + 1;
                break;
            }
            log.add(words[i]);
            prev = words[i].substring(words[i].length()-1);
        }

        int[] answer = {player, turn};

        return answer;
    }
}