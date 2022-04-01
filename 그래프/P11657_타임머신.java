import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
public class P11657_타임머신 {
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int N, M;
  static long distance[];
  static Edge edges[];
  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    edges = new Edge[M + 1];
    distance = new long[N + 1];
    Arrays.fill(distance, Integer.MAX_VALUE); // 최단거리 배열 초기화
    for (int i = 0; i < M; i++) { // 간선 리스트에 데이터 저장하기
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      int time = Integer.parseInt(st.nextToken());
      edges[i] = new Edge(start, end, time);
    }
    // 벨만포드 알고리즘 수행
    distance[1] = 0;
    for (int i = 1; i < N; i++) {  //N보다 하나 적은 수만큼 반복
      for (int j = 0; j < M; j++) {
        Edge edge = edges[j];
        // 더 작은 최단거리 가 있는 경우 갱신
        if (distance[edge.start] != Integer.MAX_VALUE && distance[edge.end] > distance[edge.start] + edge.time) {
          distance[edge.end] = distance[edge.start] + edge.time;
        }
      }
    }
    boolean mCycle = false;
    for (int i = 0; i < M; i++) { // 음수 cycle 확인
      Edge edge = edges[i];
      if (distance[edge.start] != Integer.MAX_VALUE && distance[edge.end] > distance[edge.start] + edge.time) {
        mCycle = true;
      }
    }
    if (!mCycle) { // 음의 cycle이 없는 경우
      for (int i = 2; i <= N; i++) {
        if (distance[i] == Integer.MAX_VALUE)
          System.out.println("-1");
        else
          System.out.println(distance[i]);
      }
    } else { // 음의 cycle이 있는 경우
      System.out.println("-1");
    }
  }
}
class Edge { // 간선리스트를 편하게 다루기 위해 클래스로 별도 구현
  int start, end, time;  // 시작점, 도착점, 걸리는 시간
  public Edge(int start, int end, int time) {
    this.start = start;
    this.end = end;
    this.time = time;
  }
}
