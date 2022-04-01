import java.util.*;
public class P2023_신기한소수 {
  static int N;
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    N = in.nextInt();
    // 일의 자리 소수는 2 3 5 7 이므로 4개 수에서만 시작
    DFS(2, 1);
    DFS(3, 1);
    DFS(5, 1);
    DFS(7, 1);
  }
  static void DFS(int number, int jarisu) {
    if (jarisu == N) {
      if (isPrime(number)) {
        System.out.println(number);
      }
      return;
    }
    for (int i = 1; i < 10; i++) {
      if (i % 2 == 0) { // 짝수이면 더 이상 탐색할 필요가 없음
        continue;
      }
      if (isPrime(number * 10 + i)) { // 소수이면 재귀로 자리수를 늘려갑니다.
        DFS(number * 10 + i, jarisu + 1);
      }
    }
  }
  static boolean isPrime(int num) {
    for (int i = 2; i <= num / 2; i++)
      if (num % i == 0)
        return false;
    return true;
  }
}