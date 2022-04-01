import java.io.*;
public class P11689_GCDNK1 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    long n = Long.parseLong(br.readLine());
    long result = n;
    for (long p = 2; p <= Math.sqrt(n); p++) { // 제곱근까지만 진행
      if (n % p == 0) { // p가 소인수인지 확인
        result = result - result / p; // 결과 값 업데이트
        while (n % p == 0) { // 해당 소인수를 지워줌 2^7*11이라면 2^7을 없애고 11만 남김
          n /= p;
        }
      }
    }
    if (n > 1) // 아직 소인수 구성이 남아있는 경우
//(반복문에서 제곱근까지만 탐색했기 때문에 1개의 소인수가 누락되는 케이스)
      result = result - result / n;
    System.out.println(result);
  }
}
