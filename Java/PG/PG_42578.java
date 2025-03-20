import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;

        Map<String, Integer> clothMap = new HashMap<String, Integer>();

        for (String[] cloth: clothes) {
            String key = cloth[1];
            if (clothMap.containsKey(key)) {
                clothMap.put(key, clothMap.get(key)+1);
            } else {
                clothMap.put(key, 1);
            }
        }

        for (int v: clothMap.values()) {
            answer *= (v + 1);
        }
        answer -= 1;

        return answer;
    }
}