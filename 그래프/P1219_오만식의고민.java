import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
public class P1219_오만식의고민 {
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int N, M, sCity, eCity;
  static long distance[],cityMoney[];
  static Edge_1219 Edge_1219s[];
  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    sCity = Integer.parseInt(st.nextToken());
    eCity = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    Edge_1219s = new Edge_1219[M];
    distance = new long[N];
    cityMoney = new long[N];
    Arrays.fill(distance, Long.MIN_VALUE); // 최단거리 배열 초기화
    for (int i = 0; i < M; i++) { // 간선 리스트에 데이터 저장하기
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      int price = Integer.parseInt(st.nextToken());
      Edge_1219s[i] = new Edge_1219(start, end, price);
    }
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      cityMoney[i] = Long.parseLong(st.nextToken());
    }
    distance[sCity] = cityMoney[sCity]; // 변형된 벨만포드 알고리즘 수행
    for (int i = 0; i <= N + 100; i++) { // 양수싸이클이 전파되도록 충분히 큰 수로 반복하기
      for (int j = 0; j < M; j++) {
        int start = Edge_1219s[j].start;
        int end = Edge_1219s[j].end;
        int price = Edge_1219s[j].price;
        if (distance[start] == Long.MIN_VALUE) continue; // 시작노드가 미방문 노드이면 skip
        // 시작 노드가 양수사이클에 연결된 노드라면 종료 노드도 연결 노드로 갱신
        else if (distance[start] == Long.MAX_VALUE)
          distance[end] = Long.MAX_VALUE;
        // 더 많은 돈을 벌수 있는 새로운 경로가 발견된 경우 새로운 경로 값으로 갱신
        else if (distance[end] < distance[start] + cityMoney[end] - price) {
          distance[end] = distance[start] + cityMoney[end] - price;
          // N-1 반복 이후 갱신되는 종료 노드는 양수사이클 연결 노드로 변경
          if (i >= N - 1)
            distance[end] = Long.MAX_VALUE;
        }
      }
    }
    if (distance[eCity] == Long.MIN_VALUE) System.out.println("gg"); // 도착 불가능
    else if (distance[eCity] == Long.MAX_VALUE) System.out.println("Gee"); // 양수사이클 연결
    else System.out.println(distance[eCity]); //그 이외의 경우
  }
}
class Edge_1219 { // 간선리스트를 편하게 다루기 위해 클래스로 별도 구현
  int start, end, price; // 시작점, 도착점, 걸리는 시간
  public Edge_1219(int start, int end, int price) {
    this.start = start;
    this.end = end;
    this.price = price;
  }
}
