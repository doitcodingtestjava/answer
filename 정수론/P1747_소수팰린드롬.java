import java.util.Scanner;
public class P1747_소수팰린드롬 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[] A = new int[10000001]; // N의 범위까지 소수 구해주기
    for (int i = 2; i < A.length; i++) {
      A[i] = i;
    }
    for (int i = 2; i < Math.sqrt(A.length); i++) { // 제곱근 까지만 수행
      if (A[i] == 0) {
        continue;
      }
      for (int j = i + i; j < A.length; j = j + i) { // 배수 지우기
        A[j] = 0;
      }
    }
    int i = N;
    while (true) { // N부터 1씩 증가시켜가면서 소수와 펠린드롬 수가 맞는지 확인
      if (A[i] != 0) {
        int result = A[i];
        if (isPalindrome(result)) {
          System.out.println(result);
          break;
        }
      }
      i++;
    }
  }
  private static boolean isPalindrome(int target) // 펠린드롬수 판별 함수
  {
    char temp[] = String.valueOf(target).toCharArray();
    int s = 0;
    int e = temp.length - 1;
    while (s < e) {
      if (temp[s] != temp[e])
        return false;
      s++;
      e--;
    }
    return true;
  }
}
