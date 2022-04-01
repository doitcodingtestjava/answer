import java.io.*;
import java.util.*;
public class P1414_불우이웃돕기 {
  static int[] parent;
  static int N, sum;
  static PriorityQueue<lEdge> queue;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    queue = new PriorityQueue<>();
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      char[] tempc = st.nextToken().toCharArray();
      for (int j = 0; j < N; j++) {
        int temp = 0;
        if (tempc[j] >= 'a' && tempc[j] <= 'z')
          temp = tempc[j] - 'a' + 1;
        else if (tempc[j] >= 'A' && tempc[j] <= 'Z')
          temp = tempc[j] - 'A' + 27;
        sum = sum + temp; // 총 랜선의 길의 저장
        if (i != j && temp != 0)queue.add(new lEdge(i, j, temp));
      }
    }
    parent = new int[N];
    for (int i = 0; i < parent.length; i++)parent[i] = i;
    int useEdge = 0;
    int result = 0;
    while (!queue.isEmpty()) { // 최소 신장 트리 알고리즘을 수행하여 줍니다.
      lEdge now = queue.poll();
      if (find(now.s) != find(now.e)){ // 같은 부모가 아니라면 -> 연결 가능
        union(now.s, now.e);
        result = result + now.v;
        useEdge++;
      }
    }
    if (useEdge == N - 1) System.out.println(sum - result);
    else System.out.println(-1);
  }
  public static void union(int a, int b) { // union 연산 : 대표 노드끼리 연결하여 줌
    a = find(a); b = find(b);
    if (a != b) parent[b] = a;
  }
  public static int find(int a) { // find 연산
    if (a == parent[a]) return a;
    else return parent[a] = find(parent[a]); // 재귀함수의 형태로 구현 -> 경로 압축 부분
}
}
class lEdge implements Comparable<lEdge> {
  int s, e, v;
  lEdge(int s, int e, int v) {
    this.s = s;
    this.e = e;
    this.v = v;
  }
  @Override
  public int compareTo(lEdge o) {
    return this.v - o.v;
  }
}
