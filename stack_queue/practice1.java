import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        double[] rest = new double[progresses.length+1];
        for(int i = 0; i< progresses.length; i++){
            rest[i] = 100 - progresses[i];
            rest[i] = Math.ceil(rest[i]/speeds[i]);
        }
        rest[progresses.length] =-1;

        List<Integer> testlist = new ArrayList<Integer>();
        int front = 0;
        int rear = 1;
        int index = 0;
        while(true){
            if(rest[front]>=rest[rear]&&rear<progresses.length){
                rear++;
            }
            else if(rest[front]<rest[rear]&&rear<progresses.length) {
                testlist.add(rear - front);
                index++;
                front = rear;
                rear++;
            }
            else if(rear==progresses.length) {
                testlist.add(rear - front);
                index++;
                break;
            }
        }
        answer = new int[index];
        for(int i = 0; i<index;i++){
            answer[i] = testlist.get(i);
        }
        
        return answer;
    }
}
