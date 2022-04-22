import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class P10989_수정렬하기3 {
  public static int[] A;
  public static long result;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int N = Integer.parseInt(br.readLine());
    A = new int[N];
    for (int i = 0; i < N; i++) {
      A[i] = Integer.parseInt(br.readLine());
    }
    br.close();
    Radix_Sort(A, 5);
    for (int i = 0; i < N; i++) {
      bw.write(A[i] + "\n");
    }
    bw.flush();
    bw.close();
  }

  public static void Radix_Sort(int[] A, int max_size) {
    int[] output = new int[A.length];
    int jarisu = 1;
    int count = 0;
    while (count != max_size) // 최대 자리수 만큼 반복
    {
      int[] bucket = new int[10];
      for (int i = 0; i < A.length; i++) {
        bucket[(A[i] / jarisu) % 10]++; // 일의 자리 부터 시작
      }
      for (int i = 1; i < 10; i++) { // 합배열을 이용하여 index 계산
        bucket[i] += bucket[i - 1];
      }
      for (int i = A.length - 1; i >= 0; i--) { // 현재 자리수 기준으로 정렬하기
        output[bucket[(A[i] / jarisu % 10)] - 1] = A[i];
        bucket[(A[i] / jarisu) % 10]--;
      }
      for (int i = 0; i < A.length; i++) {
        A[i] = output[i]; // 다음 자리 수 이동을 위해 현재 자리수 기준 정렬 데이터 저장
      }
      jarisu = jarisu * 10; // 자리수 증가
      count++;
    }
  };
}


