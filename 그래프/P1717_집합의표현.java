import java.util.Scanner;
public class P1717_집합의표현 {
  public static int[] parent;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();
    parent = new int[N + 1];
    for (int i = 0; i <= N; i++) { // 대표 노드를 자기 자신으로 초기화 하기
      parent[i] = i;
    }
    for (int i = 0; i < M; i++) {
      int question = sc.nextInt();
      int a = sc.nextInt();
      int b = sc.nextInt();
      if (question == 0) { // 집합합치기
        union(a, b);
      } else { // 같은 집합의 원소인지 확인하기
        if (checkSame(a, b)) {
          System.out.println("YES");
        } else {
          System.out.println("NO");
        }
      }
    }
  }
  public static void union(int a, int b) { // union 연산 : 바로 연결이 아닌 대표 노드끼리 연결하여 줌
    a = find(a);
    b = find(b);
    if (a != b) {
      parent[b] = a;
    }
  }
  public static int find(int a) { // find 연산
    if (a == parent[a])
      return a;
    else
      return parent[a] = find(parent[a]); // 재귀함수의 형태로 구현
  }
  public static boolean checkSame(int a, int b) { // 두 원소가 같은 집합인지 확인
    a = find(a);
    b = find(b);
    if (a == b) {
      return true;
    }
    return false;
  }
}