import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class P2252_줄세우기 {
  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();
    ArrayList<ArrayList<Integer>> A = new ArrayList<>();
    for (int i = 0; i <= N; i++) {
      A.add(new ArrayList<>());
    }
    int[] indegree = new int[N + 1];  // 진입 차수 배열
    for (int i = 0; i < M; i++) {
      int S = sc.nextInt();
      int E = sc.nextInt();
      A.get(S).add(E);
      indegree[E]++; // 진입차수 배열 데이터 저장하기
    }
    Queue<Integer> queue = new LinkedList<>();  // 위상 정렬 수행
    for (int i = 1; i <= N; i++) {
      if (indegree[i] == 0) {
        queue.offer(i);
      }
    }
    while (!queue.isEmpty()) {
      int now = queue.poll();
      System.out.print(now + " ");
      for (int next : A.get(now)) {
        indegree[next]--;
        if (indegree[next] == 0) {
          queue.offer(next);
        }
      }
    }
  }
}
