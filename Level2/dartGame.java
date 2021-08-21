// level 2 - [1차] 다트 게임

class Solution {
    public static int solution(String dartResult) {
        int answer = 0;
        int score = 0;
        int front = 0;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        dartResult = dartResult.replace("#", "# ");
        dartResult = dartResult.replace("*", "* ");
        String[] array =dartResult.split(" ");

        for(int i = 0; i < array.length; i++) {
            char[] temp = array[i].toCharArray();
            if (temp.length == 2) {
                score = calculate(temp[0], temp[1]);
                list.add(score);
                System.out.println("~"+score);
            } else {
                score = calculate(temp[0], temp[1]);
                list.add(score);
                score = option(temp[2], score, list.get(list.size()-2));
                System.out.println("@"+score);
            }
            answer += score;
        }
        return answer;
    }
  
  public static int calculate(char A, char B){
        double score = 0;
        if(Character.compare(B, 'S') == 0){
            score = Character.getNumericValue(A);
        }
        else if(Character.compare(B, 'D') == 0){
            score = Math.pow(Character.getNumericValue(A), 2);
        }
        else if(Character.compare(B, 'T') == 0){
            score = Math.pow(Character.getNumericValue(A), 3);
        }
        return (int)score;
    }
  
  public static int option(char C, int input, int front){
        double score = 0;
        if(Character.compare(C, '#') == 0){
            score = input * (-1);
        }
        else if(Character.compare(C, '*') == 0){
            score = (front + input) * 2;
        }

        return (int)score;
    }
}
