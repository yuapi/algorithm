class Solution {
    private int answer = 0;

    public void calc(int[] numbers, int idx, int num, int target) {
        if (idx == numbers.length) {
            if (num == target) answer++;
            return;
        }
        calc(numbers, idx+1, num+numbers[idx], target);
        calc(numbers, idx+1, num-numbers[idx], target);
    }

    public int solution(int[] numbers, int target) {
        calc(numbers, 0, 0, target);

        return answer;
    }
}