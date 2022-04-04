import java.util.*;
public class P2775_부녀회장이될테야 {
  static int T, N, K;
  static int[][] D;
  public static void main(String[] args) throws Exception {
    D = new int[15][15];
    for (int i = 0; i < 15; i++) { //초기화
      D[i][1] = 1;
      D[0][i] = i;
    }
    for (int i = 1; i < 15; i++) {
      for (int j = 2; j < 15; j++) {
        D[i][j] = D[i][j-1] + D[i-1][j];  // 점화식
      }
    }
    Scanner sc = new Scanner(System.in);
    T = sc.nextInt();
    for(int i=0; i<T; i++) // D배열을 모두 구해놓은 후 질의 출력
    {
      K = sc.nextInt();
      N = sc.nextInt();
      System.out.println(D[K][N]);
    }
  }
}
