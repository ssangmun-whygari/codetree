import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), K = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int[] sorted = new int[N];
        System.arraycopy(arr, 0, sorted, 0, N);
        Arrays.sort(sorted);
        // System.out.println("sorted : " + Arrays.toString(sorted));

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {

            int cnt = 0;
            int[] permit = new int[N];
            Arrays.fill(permit, -1);
            int max = sorted[i];

            for (int j = 0; j < N; j++) {
                if (arr[j] <= max) {
                    permit[cnt++] = j;
                }
            }

            // System.out.println("permit : " + Arrays.toString(permit));
            
            int curPos = 0;
            for (int j = 0; j < cnt; j++) {
                if (j == 0 && permit[0] != 0) break;
                int nextPos = permit[j];
                int dist = nextPos - curPos;
                if (dist > K) break;
                curPos = nextPos;
            }

            if (curPos == N - 1)
                ans = Math.min(ans, max);

        }

        System.out.println(ans);
    }
}