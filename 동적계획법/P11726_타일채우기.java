import java.util.Scanner;
public class P11726_타일채우기 {
  static long mod = 10007;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    long D[] = new long[1001];
    D[1] = 1;  //길이가 2*1일때 타일 경우의 수
    D[2] = 2;  //길이가 2*2일때 타일 경우의 수
    for(int i=3; i<=N; i++){
      D[i] = (D[i-1] + D[i-2])%mod; 
    }
    System.out.println(D[N]);
  }
}
