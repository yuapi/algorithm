import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int unq = (int) Arrays.stream(nums).distinct().count();

        return Math.min(unq, nums.length/2);
    }
}