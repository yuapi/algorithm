import java.util.*;
import java.math.*;

class Solution {
    public int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public int solution(String numbers) {
        String[] numarr = numbers.split("");
        Set<Integer> nums = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        for (int i = 0; i < numarr.length; i++) queue.offer(Integer.toString(i));

        while (queue.size() > 0) {
            String now = queue.poll();
            String[] nowarr = now.split("");
            String input = "";
            for (int i = 0; i < nowarr.length; i++) {
                input += numarr[Integer.parseInt(nowarr[i])];
            }
            nums.add(Integer.valueOf(input));

            if (now.length() < numarr.length) {
                List<Integer> used = new ArrayList<>();
                for (String n: now.split("")) used.add(Integer.valueOf(n));

                for (int i = 0; i < numarr.length; i++) {
                    if (used.contains(i)) continue;

                    queue.offer(now + Integer.toString(i));
                }
            }
        }

        int answer = 0;
        Iterator iter = nums.iterator();
        while (iter.hasNext()) {
            int num = (int) iter.next();
            if (num < 2) continue;

            boolean isPrime = true;
            for (int j = 2; j <= Math.sqrt(num); j++) {
                if (num % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) answer++;
        }

        return answer;
    }
}