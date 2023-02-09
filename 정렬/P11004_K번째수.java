import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11004_K번째수 {
  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(in.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(in.readLine());
    int[] A = new int[N];
    for (int i = 0; i < N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
    }
    quickSort(A, 0, N - 1,  K - 1);
    System.out.println(A[K - 1]);
  }
  public static void quickSort(int[] A, int S, int E, int K) {
      if(S<E){
      int pivot = partition(A, S, E);
      if (pivot == K) { //K번째 수가 pivot이면 더이상 구할 필요 없음
        return;
      }
      else if(K < pivot) {  //K가 pivot보다 작으면 왼쪽만 정렬
        quickSort(A, S, pivot - 1, K);
      }
      else if(K > pivot){  //K가 pivot보다 크면 왼쪽만 정렬
        quickSort(A, pivot+1, E, K);
      }
          }
  }

  private static int partition(int[] A, int S, int E){
    if(S+1==E) {
      if(A[S]>A[E])swap(A,S,E);
      return E;
    }
    int M = (S + E) / 2;
    swap(A, S, M); // 중앙값을 1번째 요소로 이동하기
    int pivot = A[S];
    int i = S+1, j = E;
    
    while (i <= j) {
        while (pivot < A[j]){   //피벗보다 작은 수가 나올때까지 j--
            j--;    
        }
        while (pivot > A[i]){  //피벗보다 큰 수가 나올 떄까지 i++
               i ++;  
        }
        if (i =< j) {
            swap (A, i++, j--);  // 찾은 i와 j를 교환하기
        }
        else{
            break;
        }
    }
    // i == j 피벗의 값을 양쪽으로 분리한 가운데에 오도록 설정하기
    A[S] = A[j];
    A[j] = pivot;
    return j;
}
  
  public static void swap(int[] A, int i, int j) {
    int temp = A[i];
    A[i] = A[j];
    A[j] = temp;
  }
}
