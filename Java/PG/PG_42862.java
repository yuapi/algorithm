import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        List<Integer> list = Arrays.stream(reserve).boxed().collect(Collectors.toList());

        for (int i = 0; i < lost.length; i++) {
            int idx = list.indexOf(lost[i]);

            if (idx != -1) {
                list.remove(idx);
                lost[i] = -1;
                answer++;
            }
        }

        Arrays.sort(lost);

        for (int l: lost) {
            int prv = list.indexOf(l-1);
            int nxt = list.indexOf(l+1);

            if (prv != -1) {
                answer++;
                list.remove(prv);
            } else if (nxt != -1) {
                answer++;
                list.remove(nxt);
            }
        }
        return answer;
    }
}