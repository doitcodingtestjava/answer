import java.util.*;
public class P11437_LCA {
  static ArrayList<Integer>[] tree;
  static int[] depth;
  static int[] parent;
  static boolean[] visited;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt(); // 정점의 수
    tree = new ArrayList[N + 1];
    for (int i = 1; i <= N; i++) {
      tree[i] = new ArrayList<Integer>();
    }
    for (int i = 0; i < N - 1; i++) { // A인접리스트에 그래프 데이터 저장
      int s = sc.nextInt();
      int e = sc.nextInt();
      tree[s].add(e);
      tree[e].add(s);
    }
    depth = new int[N + 1];
    parent = new int[N + 1];
    visited = new boolean[N + 1];
    BFS(1); // depth를 BFS를 통하여 구하기
    int M = sc.nextInt(); // 질의의 수
    for (int i = 0; i < M; i++) {
      // 공통 조상을 구할 두 노드
      int a = sc.nextInt();
      int b = sc.nextInt();
      int LCA = excuteLCA(a, b);
      System.out.println(LCA);
    }
  }
  static int excuteLCA(int a, int b) {
    if (depth[a] < depth[b]) {
      int temp = a;
      a = b;
      b = temp;
    }
    while (depth[a] != depth[b]) { // 두 노드의 Depth 맞춰주기
      a = parent[a];
    }
    while (a != b) { // 같은 조상이 나올 때까지 한칸씩 올려주기
      a = parent[a];
      b = parent[b];
    }
    return a;
  }
  // BFS구현
  private static void BFS(int node) { 
    Queue<Integer> queue = new LinkedList<Integer>();
    queue.add(node);
    visited[node] = true;
    int level = 1;
    int now_size = 1;
    int count = 0;
    while (!queue.isEmpty()) {
      int now_node = queue.poll();
      for (int next : tree[now_node]) {
        if (!visited[next]) {
          visited[next] = true;
          queue.add(next);
          parent[next] = now_node;  //부모 노드 저장
          depth[next] = level; //노드 depth 저장
        }
      }
      count++;
      if (count == now_size) {
        count = 0;
        now_size = queue.size();
        level++;
      }
    }
  }
}
