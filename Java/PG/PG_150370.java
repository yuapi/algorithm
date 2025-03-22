import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> expired = new ArrayList<>();

        Map<String, Integer> termsMap = new HashMap<>();
        for (String term: terms) {
            String t[] = term.split(" ");
            termsMap.put(t[0], Integer.parseInt(t[1]));
        }

        for (int i = 0; i < privacies.length; i++) {
            String[] priv = privacies[i].split(" ");
            int months = termsMap.get(priv[1]);

            int ey = Integer.parseInt(priv[0].substring(0, 4));
            int em = Integer.parseInt(priv[0].substring(5, 7));
            int ed = Integer.parseInt(priv[0].substring(8));

            em += months;
            if (em > 12) {
                em--;
                ey += em / 12;
                em %= 12;
                em++;
            }

            int ty = Integer.parseInt(today.substring(0, 4));
            int tm = Integer.parseInt(today.substring(5, 7));
            int td = Integer.parseInt(today.substring(8));

            if (ey < ty) expired.add(i+1);
            else if (ey == ty && em < tm) expired.add(i+1);
            else if (ey == ty && em == tm && ed <= td) expired.add(i+1);
        }

        int[] answer = new int[expired.size()];
        for (int i = 0; i < expired.size(); i++) {
            answer[i] = expired.get(i);
        }

        return answer;
    }
}