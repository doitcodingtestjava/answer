import java.io.*;
import java.util.*;
public class P11505_구간곱구하기 {
  static long[] tree;
  static int MOD;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken()); // 수의 개수
    int M = Integer.parseInt(st.nextToken()); // 변경이 일어나는 횟수
    int K = Integer.parseInt(st.nextToken()); // 구간 곱을 구하는 횟수
    int treeHeight = 0;
    int lenght = N;
    while (lenght != 0) {
      lenght /= 2;
      treeHeight++;
    }
    int treeSize = (int) Math.pow(2, treeHeight + 1);
    int leftNodeStartIndex = treeSize / 2 - 1;
    MOD = 1000000007;
    tree = new long[treeSize + 1];
    for (int i = 0; i < tree.length; i++) {   //초기 값을 곱셈이기 때문에 1로 설정
      tree[i] = 1;
    }
    for (int i = leftNodeStartIndex + 1; i <= leftNodeStartIndex + N; i++) {
      tree[i] = Long.parseLong(br.readLine()); // 데이터를 리프노드에 입력 받기
    }
    setTree(treeSize - 1); // tree 만들기
    for (int i = 0; i < M + K; i++) {
      st = new StringTokenizer(br.readLine());
      long a = Integer.parseInt(st.nextToken());
      int s = Integer.parseInt(st.nextToken());
      long e = Long.parseLong(st.nextToken());
      if (a == 1) { // 변경
        changeVal(leftNodeStartIndex + s, e);
      } else if (a == 2) { // 구간 곱
        s = s + leftNodeStartIndex;
        e = e + leftNodeStartIndex;
        System.out.println(getMul(s, (int) e));
      } else {
        return;
      }
    }
    br.close();
  }
  // 모든 함수에서 곱셈이 발생할때 마다 MOD연산 수행
  private static long getMul(int s, int e) {
    long partMul = 1;
    while (s <= e) {
      if (s % 2 == 1) {
        partMul = partMul * tree[s] % MOD;
        s++;
      }
      if (e % 2 == 0) {
        partMul = partMul * tree[e] % MOD;
        e--;
      }
      s = s / 2;
      e = e / 2;
    }
    return partMul;
  }
  private static void changeVal(int index, long val) {
    tree[index] = val;
    while (index > 1) { //현재 노드의 양쪽 자식 노드를 찾아 곱해주는 로직
      index = index / 2;
      tree[index] = tree[index * 2] % MOD * tree[index * 2 + 1] % MOD;
    }
  }
  private static void setTree(int i) {
    while (i != 1) {
      tree[i / 2] = tree[i / 2] * tree[i] % MOD;
      i--;
    }}}