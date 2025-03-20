class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int opened = 0;

        for (String c: s.split("")) {
            if (c.equals("(")) {
                opened += 1;
            } else if (c.equals(")")) {
                opened -= 1;
            }

            if (opened < 0) {
                return false;
            }
        }

        if (opened != 0) answer = false;
        return answer;
    }
}