import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class P1325_효율적인해킹 {
  static int N, M;
  static boolean visited[];
  static int answer[];
  static ArrayList<Integer> A[];
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    A = new ArrayList[N + 1];
    answer = new int[N + 1];
    for (int i = 1; i <= N; i++)
      A[i] = new ArrayList<>();
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int S = Integer.parseInt(st.nextToken());
      int E = Integer.parseInt(st.nextToken());
      A[S].add(E);
    }
    for (int i = 1; i <= N; i++) { //모든 정점에 대하여 BFS 실행
      visited = new boolean[N + 1];
      BFS(i);
    }
    int maxVal = 0;
    for (int i = 1; i <= N; i++) {
      maxVal = Math.max(maxVal, answer[i]);
    }
    for (int i = 1; i <= N; i++) {
      if (answer[i] == maxVal) //answer배열에서 maxVal와 같은 값을 가진 index를 정답으로 출력
        System.out.print(i + " ");
    }
  }
  public static void BFS(int index) {
    Queue<Integer> queue = new LinkedList<Integer>();
    queue.add(index);
    visited[index] = true;
    while (!queue.isEmpty()) {
      int now_node = queue.poll();
      for (int i : A[now_node]) {
        if (visited[i] == false) {
          visited[i] = true;
          answer[i]++; //신규 정점인덱스의 정답 배열 값을 증가 시키기  
          queue.add(i);
        }
      }
    }
  }
}