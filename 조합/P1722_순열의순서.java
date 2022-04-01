import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1722_순열의순서 {
  public static void main(String[] args) throws IOException {
    int N, Q;
    long F[] = new long[21];
    int S[] = new int[21];
    boolean visit[] = new boolean[21];
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());
    N = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(bf.readLine());
    Q = Integer.parseInt(st.nextToken());
    F[0] = 1;
    for (int i = 1; i <= N; i++) { // 팩토리얼 초기화 -> 각 자리수에서 만들수 있는 경우의 수
      F[i] = F[i - 1] * i;
    }
    if (Q == 1) {
      long K = Long.parseLong(st.nextToken());
      for (int i = 1; i <= N; i++) {
        for (int j = 1, cnt = 1; j <= N; j++) {
          if (visit[j])
            continue; // 이미 사용한 숫자는 사용할 수 없음
          if (K <= cnt * F[N - i]) { // 주어진 K에 따라 각 자리에 들어갈 수 있는 수 찾기
            K -= ((cnt - 1) * F[N - i]);
            S[i] = j;
            visit[j] = true;
            break;
          }
          cnt++;
        }
      }
      for (int i = 1; i <= N; i++) {
        System.out.print(S[i] + " ");
      }
    } else {
      long K = 1;
      for (int i = 1; i <= N; i++) {
        S[i] = Integer.parseInt(st.nextToken());
        long cnt = 0;
        for (int j = 1; j < S[i]; j++) {
          if (visit[j] == false) {
            cnt++; // 미사용 숫자 개수만큼 카운트
          }
        }
        K += cnt * F[N - i]; // 자리수 개수에 따라 순서 더해주기
        visit[S[i]] = true;
      }
      System.out.println(K);
    }
  }
}
