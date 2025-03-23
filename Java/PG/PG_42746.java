import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] strings = new String[numbers.length];
        int zeros = 0;

        for (int i = 0; i < numbers.length; i++) {
            strings[i] = String.valueOf(numbers[i]);
            if (numbers[i] == 0) zeros++;
        }

        if (zeros == numbers.length) return "0";

        Arrays.sort(strings, (e1, e2) -> (e2+e1).compareTo(e1+e2));

        return String.join("", strings);
    }
}