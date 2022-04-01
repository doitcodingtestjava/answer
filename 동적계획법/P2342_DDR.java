import java.util.Scanner;
public class P2342_DDR {
  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    //dp[N][L][R] = N개 수열을 수행하였고 왼쪽이 L 오른쪽이 R자리에 있을때 최소 누적 힘
    int dp[][][] = new int[100001][5][5];  
    //한발을 이동할 때 드는 힘을 미리 저장해 두기 mp[1][2] -> 1에서 2로 이동할때 드는 힘
int mp[][] = {  { 0, 2, 2, 2, 2 }, 
                    { 2, 1, 3, 4, 3 }, 
                    { 2, 3, 1, 3, 4 }, 
                    { 2, 4, 3, 1, 3 }, 
                    { 2, 3, 4, 3, 1 } }; 
    int n = 0, s = 1;
    for (int i = 0; i < 5; i++)
      for (int j = 0; j < 5; j++)
        for (int k = 0; k < 100001; k++)
          dp[k][i][j] = 100001 * 4; //충분히 큰수로 초기화
    dp[0][0][0] = 0;
    while (true) {
      n = sc.nextInt();
      if (n == 0)  // 입력의 마지막이면 종료
        break;
      for (int i = 0; i < 5; i++) {
        if (n == i) //두발이 같은 자리에 있을 수 없음
          continue;
        for (int j = 0; j < 5; j++) {
          // 오른발을 옮겨서 현재 모습이 되었을 때 최소의 힘 저장
          dp[s][i][n] = Math.min(dp[s - 1][i][j] + mp[j][n], dp[s][i][n]); 
        }
      }
      for (int j = 0; j < 5; j++) {
        if (n == j)  //두발이 같은 자리에 있을 수 없음
          continue;
        for (int i = 0; i < 5; i++) {
          //왼발을 옮겨서 현재 모습이 되었을 때 최소의 힘 저장
          dp[s][n][j] = Math.min(dp[s - 1][i][j] + mp[i][n], dp[s][n][j]); 
        }
      }
      s++;
    }
    s--;
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < 5; i++)
      for (int j = 0; j < 5; j++)
        min = Math.min(min, dp[s][i][j]);  //모두 수행하였을 때 최소 값 찾기
    System.out.println(min); //최소값 출력
  }
}
