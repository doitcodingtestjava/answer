import java.util.*;
public class P13023_친구관계파악하기 {
  static boolean visited[];
  static ArrayList<Integer>[] A;
  static boolean arrive;
  public static void main(String[] args) {
    int N; // 정점의 수
    int M; // 간선의 수
    arrive = false;
    Scanner scan = new Scanner(System.in);
    N = scan.nextInt();
    M = scan.nextInt();
    A = new ArrayList[N];
    visited = new boolean[N];
    for (int i = 0; i < N; i++) {
      A[i] = new ArrayList<Integer>();
    }
    for (int i = 0; i < M; i++) {
      int S = scan.nextInt();
      int E = scan.nextInt();
      A[S].add(E);
      A[E].add(S);
    }
    for (int i = 0; i < N; i++) {
      DFS(i, 1);
      if (arrive)
        break;
    }
    if (arrive)
      System.out.println("1");
    else
      System.out.println("0"); // 5의 깊이가 없다면 0 출력
  }
  public static void DFS(int now, int depth) { // DFS구현
    if (depth == 5 || arrive) { // 깊이가 5가되면 프로그램 종료
      arrive = true;
      return;
    }
    visited[now] = true;
    for (int i : A[now]) {
      if (!visited[i]) {
        DFS(i, depth + 1);
      }
    }
    visited[now] = false;
  }
}
