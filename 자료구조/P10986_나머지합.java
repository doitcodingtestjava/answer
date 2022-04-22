import java.io.IOException;
import java.util.Scanner;
public class P10986_나머지합 {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();
    long[] S = new long[N];
    long[] C = new long[M];
    long answer = 0;
    S[0] = sc.nextInt();
    for (int i = 1; i < N; i++) { // 수열 합배열 만들기
      S[i] = S[i - 1] + sc.nextInt();
    }
    for (int i = 0; i < N; i++) { // 합배열의 모든 값에 %연산 수행하기
      int remainder = (int) (S[i] % M);
      if (remainder == 0)
        answer++; // 0~i까지의 구간합 자체가 0인 경우 정답에 더해주기
      C[remainder]++; // 같은 나머지를 가진 인덱스의 개수 카운팅 해주기
    }
    for (int i = 0; i < M; i++) {
      if (C[i] > 1) {
        answer = answer + (C[i] * (C[i] - 1) / 2); // 같은 나머지를 가진 인덱스들중 2개를 뽑는 경우의 수를 더해주기
      }
    }
    System.out.println(answer);
  }
}