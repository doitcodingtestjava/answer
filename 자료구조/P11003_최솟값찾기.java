import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class P11003_최솟값찾기 {
  public static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // 출력을 그때 그때 하는 것보다 버퍼에 넣고 한번에 출력하기 위해 BufferedWriter를 사용
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int L = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    Deque<Node> mydeque = new LinkedList<>();
    for (int i = 0; i < N; i++) {
      int now = Integer.parseInt(st.nextToken());
      // 새로운 값이 들어 올 때마다 정렬하지 않고 현재 수보다 큰 값을 덱에서 제거함으로써 시간복잡도를 줄일 수 있음
      while (!mydeque.isEmpty() && mydeque.getLast().value > now) {
        mydeque.removeLast();
      }
      mydeque.addLast(new Node(now, i));
      // 범위에서 벗어난 값은 덱에서 제거
      if (mydeque.getFirst().index <= i - L) {
        mydeque.removeFirst();
      }
      bw.write(mydeque.getFirst().value + " ");
    }
    bw.flush();
    bw.close();
  }

  static class Node {
    public int value;
    public int index;

    Node(int value, int index) {
      this.value = value;
      this.index = index;
    }
  }
}
