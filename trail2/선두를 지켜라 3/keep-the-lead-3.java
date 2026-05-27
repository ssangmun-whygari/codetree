import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[n][2];
        int[][] b = new int[m][2];
        int t = 0;
        for (int i = 0; i < n; i++) {
            a[i][0] = sc.nextInt();
            a[i][1] = sc.nextInt();
            t += a[i][1];
        }
        for (int i = 0; i < m; i++) {
            b[i][0] = sc.nextInt();
            b[i][1] = sc.nextInt();
        }
        // A가 이동한 총 시간과 B가 이동한 총 시간은 동일함

        int[] as = new int[t + 1];
        int[] bs = new int[t + 1];
        // 시간당 A, B가 있는 위치를 구한다.

        int temp = 1;
        for (int i = 0; i < n; i++) {
            // a[i][0] : v, a[i][1] : dt
            for (int j = 1; j <= a[i][1]; j++) {
                as[temp] = as[temp - 1] + a[i][0]; // 1초에 이동한 거리는 v
                temp++;
            }
        }
        temp = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j <= b[i][1]; j++) {
                bs[temp] = bs[temp - 1] + b[i][0];
                temp++;
            }
        }

        char[] sundu = new char[t + 1]; // 1 ~ t
        Arrays.fill(sundu, 'X'); // 초기값은 X, A가 앞서면 A, B가 앞서면 B, 둘다 있으면 T

        for (int i = 1; i <= t; i++) {
            if (as[i] - bs[i] > 0) { // A가 앞서있다.
                sundu[i] = 'A';
            } else if (as[i] - bs[i] < 0) { // B가 앞서있다
                sundu[i] = 'B';
            } else { // 같은 위치에 있다.
                sundu[i] = 'T';
            }
        }
        // System.out.println(Arrays.toString(sundu));

        int changed = 0;
        for (int i = 1; i <= t; i++) {
            if (sundu[i] != sundu[i - 1]) 
                changed++;
        }
        System.out.println(changed);
    }
}