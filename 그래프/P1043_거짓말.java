import java.util.ArrayList;
import java.util.Scanner;
public class P1043_거짓말 {
  public static int[] parent;
  public static int[] trueP;
  public static ArrayList<Integer>[] party;
  public static int result;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();
    int T = sc.nextInt();
    result = 0;
    trueP = new int[T];
    for (int i = 0; i < T; i++) { // 진실을 아는 사람 저장
      trueP[i] = sc.nextInt();
    }
    party = new ArrayList[M];
    for (int i = 0; i < M; i++) { // 파티 데이터 저장
      party[i] = new ArrayList<Integer>();
      int party_size = sc.nextInt();
      for (int j = 0; j < party_size; j++) {
        party[i].add(sc.nextInt());
      }
    }
    parent = new int[N + 1];
    for (int i = 0; i <= N; i++) { // 대표 노드를 자기 자신으로 초기화 하기
      parent[i] = i;
    }
    for (int i = 0; i < M; i++) { // 각 파티에 참여한 사람들을 하나의 그룹으로 만들기 -> union 연산
      int firstPeople = party[i].get(0);
      for (int j = 1; j < party[i].size(); j++) {
        union(firstPeople, party[i].get(j));
      }
    }
    for (int i = 0; i < M; i++) { // 각 파티에서 진실을 아는 사람과 같은 그룹에 있다면 과장 할 수 없음
      boolean isPossible = true;
      int cur = party[i].get(0);
      for (int j = 0; j < trueP.length; j++) {
        if (find(cur) == find(trueP[j])) {
          isPossible = false;
          break;
        }
      }
      if (isPossible)
        result++;
    }
    System.out.println(result);
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