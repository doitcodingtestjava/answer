import java.io.*;
import java.util.StringTokenizer;
public class P1389_케빈베이컨의6단계법칙 {
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int N, M;
  static int distance[][];
  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    distance = new int[N + 1][N + 1];
    for (int i = 1; i <= N; i++) { // 인접 행렬 초기화
      for (int j = 1; j <= N; j++) {
        if (i == j)
          distance[i][j] = 0;
        else
          distance[i][j] = 10000001; // 충분히 큰수로 저장
      }
    }
    for (int i = 0; i < M; i++) {  // 친구 관계이므로 양방향 저장을 하며 1로 가중치 통일
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      distance[s][e] = 1;
      distance[e][s] = 1;
    }
    for (int k = 1; k <= N; k++) { // 플로이드 워셜 알고리즘 수행
      for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= N; j++) {
          if (distance[i][j] > distance[i][k] + distance[k][j])
            distance[i][j] = distance[i][k] + distance[k][j];
        }
      }
    }
    int Min = Integer.MAX_VALUE;
    int Answer = -1;
    for (int i = 1; i <= N; i++) {
      int temp = 0;
      for (int j = 1; j <= N; j++) {
        temp = temp + distance[i][j];
      }
      if(Min>temp)  // 가장 작은 케빈 베이컨의 수를 지니고 있는 i를 찾기
      {
        Min = temp;
        Answer = i;
      }
    }
    System.out.println(Answer);
  }
}