package AmazonOA;

public class TrottlingGateway {
    public int ThrottlingGateway(int n, int[] requestTime) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (i > 2 && requestTime[i] == requestTime[i - 3]) {
                cnt++;
            } else if (i > 19 && requestTime[i] - requestTime[i - 20] < 10) {
                cnt++;
            } else if (i > 59 && requestTime[i] - requestTime[i - 60] < 60) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int n = 27;
        int[] requestTime = {1, 1, 1, 1, 2, 2, 2, 3, 3, 3,
                4, 4, 4, 5, 5, 5, 6, 6, 6, 7,
                7, 7, 7, 11, 11, 11, 11};
        TrottlingGateway trottlingGateway = new TrottlingGateway();
        System.out.println(trottlingGateway.ThrottlingGateway(n,requestTime));
    }
}
