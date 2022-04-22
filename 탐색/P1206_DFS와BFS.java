import java.util.*;
public class P1206_DFS와BFS {
  static boolean visited[];
  static ArrayList<Integer>[] A;
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int N = scan.nextInt(); // 정점의 수
    int M = scan.nextInt(); // 간선의 수
    int Start = scan.nextInt(); // 시작점
    A = new ArrayList[N + 1];
    for (int i = 1; i <= N; i++) {
      A[i] = new ArrayList<Integer>();
    }
    for (int i = 0; i < M; i++) {
      int S = scan.nextInt();
      int E = scan.nextInt();
      A[S].add(E);
      A[E].add(S);
    }
    // 방문할 수 있는 정점이 여러 개인 경우에는 번호가 작은 것을 먼저 방문 하기 위해 정렬
    for (int i = 1; i <= N; i++) {
      Collections.sort(A[i]);
    }
    visited = new boolean[N + 1];  //방문 배열 초기화
    DFS(Start);
    System.out.println();
    visited = new boolean[N + 1];  //방문 배열 초기화
    BFS(Start);
    System.out.println();

  }

  public static void DFS(int node) {  // DFS구현
    System.out.print(node + " ");
    visited[node] = true;
    for (int i : A[node]) {
      if (!visited[i]) {
        DFS(i);
      }
    }
  }

  private static void BFS(int node) {  // BFS구현
    Queue<Integer> queue = new LinkedList<Integer>();
    queue.add(node);
    visited[node] = true;

    while (!queue.isEmpty()) {
      int now_node = queue.poll();
      System.out.print(now_node + " ");
      for (int i : A[now_node]) {
        if (!visited[i]) {
          visited[i] = true;
          queue.add(i);
        }
      }
    }
  }
}
