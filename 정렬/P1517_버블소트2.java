import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class P1517_버블소트2 {
  public static int[] A, tmp;
  public static long result;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    A = new int[N + 1];
    tmp = new int[N + 1];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
    }
    result = 0;
    merget_sort(1, N); //병합정렬 수행하기
    System.out.println(result);
  }

  private static void merget_sort(int s, int e) { 
    if (e - s < 1)
      return;
    int m = s + (e - s) / 2;
    //재귀함수 형태로 구현
    merget_sort(s, m); 
    merget_sort(m + 1, e);
    for (int i = s; i <= e; i++) {
      tmp[i] = A[i];
    }
    int k = s;
    int index1 = s;
    int index2 = m + 1;
    while (index1 <= m && index2 <= e) {  //두 그룹을 Merge 해주는 로직 
      if (tmp[index1] > tmp[index2]) {
        A[k] = tmp[index2];
        result = result + index2 - k; // 뒤쪽 데이터 값이 작아 선택되는 경우 결과 값 업데이트
        k++;
        index2++;
      } else {
        A[k] = tmp[index1];
        k++;
        index1++;
      }
    }
    while (index1 <= m) {
      A[k] = tmp[index1];
      k++;
      index1++;
    }
    while (index2 <= e) {
      A[k] = tmp[index2];
      k++;
      index2++;
    }

  }
}
