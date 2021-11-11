// level 1 - 최소 직사각형
// 2021.11.10


import java.util.*;

public class smallestRec {
  public static int solution(int[][] sizes) {
    int answer = 0;
    Integer[] width = new Integer[sizes.length];
    Integer[] hight = new Integer[sizes.length];
    for(int i = 0; i < sizes.length; i++){
      if(sizes[i][0] < sizes[i][1]){
        int temp = sizes[i][0];
        sizes[i][0] = sizes[i][1];
        sizes[i][1] = temp;
      }
    }
    for(int i = 0; i < sizes.length; i++){
      width[i] = sizes[i][0];
      hight[i] = sizes[i][1];
    }
    Arrays.sort(width, Collections.reverseOrder());Arrays.sort(hight, Collections.reverseOrder());
    answer = (width[0].intValue()) *(hight[0].intValue());
    return answer;
  }
}
