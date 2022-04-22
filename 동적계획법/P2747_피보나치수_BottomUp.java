import java.util.Scanner;
public class P2747_피보나치수_BottomUp {
  static int[] D;
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    D = new int[n + 1];
    for (int i = 0; i <= n; i++) {
      D[i] = -1;
    }
    D[0] = 0;
    D[1] = 1;
    for (int i = 2; i <= n; i++) {
      D[i] = D[i - 1] + D[i - 2];
    }
    System.out.println(D[n]);
  }
}