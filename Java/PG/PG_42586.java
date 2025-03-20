import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();

        int complete = 0;
        while (complete < progresses.length) {
            int changed = 0;

            for (int i = 0; i < progresses.length; i++) {
                if (progresses[i] > 99) continue;

                progresses[i] += speeds[i];
            }

            if (progresses[complete] > 99) {
                changed += 1;
                for (int i = complete+1; i < progresses.length; i++) {
                    if (progresses[i] < 100) break;
                    changed += 1;
                }
            }

            if (changed > 0) {
                list.add(changed);
                complete += changed;
            }
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}