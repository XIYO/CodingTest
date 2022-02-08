import java.util.Scanner;

public class arraySum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n=sc.nextInt();
        int arrayN[] = new int[n];
        for(int i=0; i<n; i++)
            arrayN[i] = sc.nextInt();

        int m=sc.nextInt();
        int arrayM[] = new int[m];
        for(int i=0; i<m; i++)
            arrayM[i] = sc.nextInt();

        int result[] = solution(n, arrayN, m, arrayM);
        for(int i : result) {
            System.out.print(i + " ");
        }
    }

    private static int[] solution(int n, int[] arrayN, int m, int[] arrayM) {
        int pN = 0, pM = 0, pR = 0;
        int result[] = new int[n+m];
        while (pN<n && pM<m) {
            result[pR++] = arrayN[pN] < arrayM[pM] ? arrayN[pN++] : arrayM[pM++];
        }
        while(pN < n) result[pR++]=arrayN[pN++];
        while(pM < m) result[pR++]=arrayM[pM++];
        return result;
    }
}
