import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] citations) {
        List<Integer> list = Arrays.stream(citations).boxed().collect(Collectors.toList());
        list.sort(Collections.reverseOrder());

        for (int i = citations.length-1; i >= 0; i--) {
            if (list.get(i) > i) {
                return i+1;
            }
        }

        return 0;
    }
}