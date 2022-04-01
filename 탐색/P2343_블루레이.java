import java.util.Scanner;
public class P2343_블루레이 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();
    int[] A = new int[N];
    int start = 0;
    int end = 0;
    for (int i = 0; i < N; i++) {
      A[i] = sc.nextInt();
      if (start < A[i])
        start = A[i]; // 레슨 최대값을 시작인덱스로 저장
      end = end + A[i]; // 모든 레슨의 총 합을 종료 인덱스로 저장
    }
    while (start <= end) {
      int middle = (start + end) / 2;
      int sum = 0;
      int count = 0;
      for (int i = 0; i < N; i++) { // middle값으로 모든 레슨을 저장 할 수 있는지 확인
        if (sum + A[i] > middle) {
          count++;
          sum = 0;
        }
        sum = sum + A[i];
      }
      if (sum != 0)
        count++;
      if (count > M)
        start = middle + 1;
      else
        end = middle - 1;
    }
      System.out.println(start);
  }
}
