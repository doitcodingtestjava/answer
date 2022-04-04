import java.io.*;
import java.util.StringTokenizer;
public class P14003_가장길게증가하는부분수열 {
  static int N, maxLength;
  static int B[] = new int[1000001];
  static int A[] = new int[1000001];
  static int D[] = new int[1000001];
  static int ans[] = new int[1000001];
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
    }
    int index;
    B[++maxLength] = A[1];
    D[1] = 1;
    for (int i = 2; i <= N; i++) {
      if (B[maxLength] < A[i]) { //가장 마지막 수열보다 현재 수열이 큰 경우
        B[++maxLength] = A[i];
        D[i] = maxLength;
      } else { 
        index = binarysearch(1, maxLength, A[i]);    // B배열에서 data[i]보다 처음으로 크거나 같아지는 원소의 index 찾기
        B[index] = A[i];
        D[i] = index;
      }
    }
    System.out.println(maxLength); //가장 긴 증가하는 부분 수열 길이 출력
    index = maxLength;
    int x = B[maxLength] + 1;
    for (int i = N; i >= 1; i--) { //뒤에서 부터 탐색하면서 정답 수열 저장하기
      if (D[i] == index && A[i] < x) {
        ans[index] = A[i];
        x = A[i];
        index--;
      }
    }
    for (int i = 1; i <= maxLength; i++)
      System.out.print(ans[i] + " ");
  }
  // 현재 수열이 들어 갈 수 있는 위치를 빠르게 찾아주기 위한 바이너리 서치 구현
  static int binarysearch(int l, int r, int now) {
    int mid;
    while (l < r) {
      mid = (l + r) / 2;
      if (B[mid] < now)
        l = mid + 1;
      else
        r = mid;
    }
    return l;
  }
}
