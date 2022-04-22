import java.util.*;
public class P1167_트리의지름 {
  static boolean visited[];
  static int [] distance;
  static ArrayList<Edge_1677>[] A;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt(); // 정점의 수
    A = new ArrayList[N + 1];
    for (int i = 1; i <= N; i++) {
      A[i] = new ArrayList<Edge_1677>();
    }
    for (int i = 0; i < N; i++) {
      int S = sc.nextInt();
      while(true)
      {
        int E = sc.nextInt();
        if(E==-1)break;
        int V = sc.nextInt();
        A[S].add(new Edge_1677(E, V));
      }
    }
    distance = new int[N+1];
    visited = new boolean[N+1];
    BFS(1);
    int Max = 1;
    for(int i=2; i<=N; i++) {
      if(distance[Max]<distance[i])
        Max = i;
    }
    distance = new int[N+1];
    visited = new boolean[N+1];
    BFS(Max);
    Arrays.sort(distance);
    System.out.println(distance[N]);
  }

  private static void BFS(int index) {  // BFS구현
    Queue<Integer> queue = new LinkedList<Integer>();
    queue.add(index);
    visited[index] = true;
    while (!queue.isEmpty()) {
      int now_node = queue.poll();
      for (Edge_1677 i : A[now_node]) {
        int e = i.e;
        int v = i.value;
        if (!visited[e]) {
          visited[e] = true;
          queue.add(e);
          distance[e]=distance[now_node]+v;
        }
      }
    }
  }
}
class Edge_1677 {
  int e;
  int value;

  public Edge_1677(int e, int value) {
      this.e = e ;
      this.value = value;
  }
}

