import java.util.*;
import java.io.*;
public class P1753_최단경로 {
  public static int V,E,K;
  public static int distance[];
  public static boolean visited[];
  public static ArrayList<Edge_1753> list[];
  public static PriorityQueue<Edge_1753> q = new PriorityQueue<Edge_1753>();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    st = new StringTokenizer(br.readLine());
    V = Integer.parseInt(st.nextToken());
    E = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(br.readLine());
    distance = new int[V + 1];
    visited = new boolean[V + 1];
    list = new ArrayList[V + 1];
    for (int i = 1; i <= V; i++)
      list[i] = new ArrayList<Edge_1753>();
    for (int i = 0; i <= V; i++) {
      distance[i] = Integer.MAX_VALUE;
    }
    for (int i = 0; i < E; i++) { // 가중치가 있는 인접 리스트 초기화
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());
      list[u].add(new Edge_1753(v, w));
    }
    q.add(new Edge_1753(K, 0)); // K를 시작점으로 설정
    distance[K] = 0;
    while (!q.isEmpty()) {
      Edge_1753 current = q.poll();
      int c_v = current.vertex;
      if (visited[c_v]) continue; // 기 방문 노드는 다시 큐에 넣지 않습니다.
  visited[c_v] = true;
      for (int i = 0; i < list[c_v].size(); i++) {
        Edge_1753 tmp = list[c_v].get(i);
        int next = tmp.vertex;
        int value = tmp.value;
        if (distance[next] > distance[c_v] + value) { // 최소 거리로 업데이트
          distance[next] = value + distance[c_v];
          q.add(new Edge_1753(next, distance[next]));
        }
      }}
    for (int i = 1; i <= V; i++) { // 거리 배열 출력
      if (visited[i])
        System.out.println(distance[i]);
      else
        System.out.println("INF");
    }}}
class Edge_1753 implements Comparable<Edge_1753> {
  int vertex, value;
  Edge_1753(int vertex, int value) {
    this.vertex = vertex;
    this.value = value;
  }
  public int compareTo(Edge_1753 e) {
    if (this.value > e.value) return 1;
    else return -1;
  }}