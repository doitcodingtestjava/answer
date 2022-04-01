import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
public class P21568_AxByC {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        BufferedWriter bw  = new BufferedWriter( new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        long gcd = gcd(a,b);
        if(c%gcd != 0) {
            System.out.println(-1);
        }else {
            int mok = (int) (c/gcd);
            long[] ret = Excute(a, b);
            System.out.println(ret[0]*mok + " " + ret[1]*mok);
        }
    }
    private static long[] Excute(long a, long b) {
        long[] ret = new long[2];
        if(b==0) {
            ret[0] = 1;
            ret[1] = 0;
            return ret;
        }
        long q = a/b;
        long[] v = Excute(b, a%b); //재귀 형태로 호제 법 수행
        ret[0] = v[1];  //역으로 올라오면서 X Y값을 계산해주는 로직
        ret[1] = v[0] - v[1]*q;
        return ret;
    }
    private static long gcd(long a, long b) {
        while(b!= 0) {
            long temp = a%b;
            a=b;
            b=temp;
        }
        return Math.abs(a);
    }
}
