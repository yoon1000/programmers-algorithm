import java.util.ArrayList;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        ArrayList<Integer> list = new ArrayList<Integer>();
        int length = 0;
        answer = new int[commands.length];
        for(int j = 0;j< commands.length;j++) {
            for (int i = commands[j][0] - 1; i <= commands[j][1] - 1; i++) {
                list.add(array[i]);
            }
            list.sort(null);
            answer[j] = list.get(commands[j][2] - 1);
            length++;list.clear();
        }
        return answer;
    }
}
