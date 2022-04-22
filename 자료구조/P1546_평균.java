import java.util.Scanner;
public class P1546_평균 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int A[] = new int[N];
    for (int i = 0; i < N; i++) {
      A[i] = sc.nextInt();
    }
    long sum = 0;
    long max = 0;
    for (int i = 0; i < N; i++) {
      if (A[i] > max)
        max = A[i];
      sum = sum + A[i];
    }
    // 각각 계산이 아닌 수식 변환을 통해 총합에 대해 한번만 계산해주면 로직이 간단해 집니다.
    System.out.println(sum * 100.0 / max / N);
  }

}
