import java.util.Scanner;
public class P1929_소수구하기 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int M = in.nextInt();
    int N = in.nextInt();
    int[] A = new int[N + 1];
    for (int i = 2; i <= N; i++) {
      A[i] = i;
    }
    for (int i = 2; i <= Math.sqrt(N); i++) { // 제곱근 까지만 수행
      if (A[i] == 0) {
        continue;
      }
      for (int j = i + i; j <= N; j = j + i) { // 배수 지우기
        A[j] = 0;
      }
    }
    for (int i = M; i <= N; i++) {
      if (A[i] != 0) {
        System.out.println(A[(int) i]);
      }
    }
  }
}
