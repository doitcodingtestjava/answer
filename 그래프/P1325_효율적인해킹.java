import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class P1325_효율적인해킹 {
    static boolean visited[]  = new boolean[10001];;
    static int answer[] = new int[10001];;
    static ArrayList<Integer> A[] = new ArrayList[10001];;

    static Queue<Integer> queue = new ArrayDeque<Integer>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++)
            A[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            A[S].add(E);
        }
        for (int i = 1; i <= N; i++) { //모든 정점에 대하여 BFS 실행
            for (int j = 1; j <= N; j++) {
                visited[j] = false;
            }

            BFS(i);
        }

        int maxVal = 0;
        for (int i = 1; i <= N; i++) {
            if (maxVal < answer[i]) {
                maxVal = answer[i];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (answer[i] == maxVal) //answer배열에서 maxVal와 같은 값을 가진 index를 정답으로 출력
                sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
    public static void BFS(int index) {
        queue.add(index);
        visited[index] = true;
        while (!queue.isEmpty()) {
            int now_node = queue.poll();
            for (int i : A[now_node]) {
                if (visited[i]) continue;
                visited[i] = true;
                answer[i]++; //신규 정점인덱스의 정답 배열 값을 증가 시키기
                queue.add(i);
            }
        }
    }
}
