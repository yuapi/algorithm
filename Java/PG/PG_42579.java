import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, List> map = new HashMap<String, List>();
        Map<String, Integer> sum = new HashMap<String, Integer>();

        for (int i = 0; i < genres.length; i++) {
            if (map.containsKey(genres[i])) {
                map.get(genres[i]).add(Arrays.asList(i, plays[i]));
                sum.put(genres[i], sum.get(genres[i]) + plays[i]);
            } else {
                List<List<Integer>> list = new ArrayList<>(Arrays.asList(Arrays.asList(i, plays[i])));
                map.put(genres[i], list);
                sum.put(genres[i], plays[i]);
            }
        }

        List<String> keys = new ArrayList<>(sum.keySet());
        keys.sort((e1, e2) -> {
            return sum.get(e2) - sum.get(e1);
        });

        List<Integer> result = new ArrayList<>();
        int cnt = 0;
        for (String key: keys) {
            List<List<Integer>> list = map.get(key);

            list.sort((e1, e2) -> {
                return e2.get(1) - e1.get(1);
            });

            result.add(list.get(0).get(0));
            cnt += 1;
            if (list.size() > 1) {
                result.add(list.get(1).get(0));
                cnt += 1;
            }
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}