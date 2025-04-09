import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        Queue<Integer> student1 = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
        Queue<Integer> student2 = new LinkedList<>(Arrays.asList(2, 1, 2, 3, 2, 4, 2, 5));
        Queue<Integer> student3 = new LinkedList<>(Arrays.asList(3, 3, 1, 1, 2, 2, 4, 4, 5, 5));
        List<Queue<Integer>> students = new ArrayList<>(Arrays.asList(student1, student2, student3));

        int[] score = new int[3];
        for (int answer: answers) {
            for (int i = 0; i < students.size(); i++) {
                int check = students.get(i).poll();
                if (check == answer) score[i] += 1;
                students.get(i).offer(check);
            }
        }

        int max = score[0];
        List<Integer> answer = new ArrayList<>(Arrays.asList(1));
        for (int i = 1; i < score.length; i++) {
            if (score[i] < max) continue;
            else if (score[i] == max) answer.add(i+1);
            else {
                max = score[i];
                answer.clear();
                answer.add(i+1);
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}