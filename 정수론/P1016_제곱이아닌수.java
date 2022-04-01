import java.util.*;
public class P1016_제곱이아닌수 {
  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    long Min = sc.nextLong();
    long Max = sc.nextLong();
    boolean[] Check = new boolean[(int) (Max - Min + 1)]; // 최대 최소 차이만큼 배열 선언
    // 2의 제곱수인 4부터 max보다 작거나 같은 까지 반복
    for (long i = 2; i * i <= Max; i++) {
      long pow = i * i; // 제곱수
      long start_index = Min / pow;
      ;
      if (Min % pow != 0)
        start_index++; // 나머지가 있으면 1을 더해주어야 Min보다 큰 제곱수 부터 시작됨
      for (long j = start_index; pow * j <= Max; j++) { // 제곱수를 true로 변경
        Check[(int) ((j * pow) - Min)] = true;
      }
    }
    int count = 0;
    for (int i = 0; i <= Max - Min; i++) {
      if (!Check[i]) {
        count++;
      }
    }
    System.out.println(count);
  }
}