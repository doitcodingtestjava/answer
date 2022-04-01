import java.io.*;
import java.util.StringTokenizer;
public class P11758_CCW {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int x1 = Integer.parseInt(st.nextToken());
    int y1 = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    int x2 = Integer.parseInt(st.nextToken());
    int y2 = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    int x3 = Integer.parseInt(st.nextToken());
    int y3 = Integer.parseInt(st.nextToken());
    int result = (x1 * y2 + x2 * y3 + x3 * y1) - (x2 * y1 + x3 * y2 + x1 * y3);
    int ans = 0;
    if (result > 0) {
      ans = 1;
    } else if (result < 0) {
      ans = -1;
    } else {
      ans = 0;
    }
    System.out.println(ans);
  }
}