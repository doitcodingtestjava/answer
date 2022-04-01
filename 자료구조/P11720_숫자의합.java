import java.util.Scanner;
public class P11720_숫자의합 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    // String 변수로 받아 배열 변수로 변환하기
    String sNum = sc.next();
    char[] cNum = sNum.toCharArray();
    int sum = 0;
    for (int i = 0; i < cNum.length; i++) {
      sum += cNum[i] - '0'; // 문자 값을 정수 형으로 변환하여 더해주기
    }
    System.out.print(sum);
  }
}
