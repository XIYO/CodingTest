import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 똑같은원소 {
    public static void main(String[] args) {
        int n, m;
        int[] arrayN, arrayM;
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arrayN = new int[n];
        for(int i = 0; i<n; i++) arrayN[i] = sc.nextInt();

        m = sc.nextInt();
        arrayM = new int[m];
        for(int i = 0; i<m; i++) arrayM[i] = sc.nextInt();

        ArrayList<Integer> answer = solution(n, arrayN, m, arrayM);
        for(int i : answer) System.out.print(i + " ");
    }

    private static ArrayList<Integer> solution(int n, int[] arrayN, int m, int[] arrayM) {
        int pN = 0, pM = 0;
        ArrayList<Integer> result = new ArrayList<>();

        Arrays.sort(arrayN);
        Arrays.sort(arrayM);

        while(pN < n && pM < m) {
            if (arrayN[pN] == arrayM[pM]) {
                result.add(arrayN[pN++]);
                pM++;
            } else if (arrayN[pN] < arrayM[pM])
                pN++;
            else pM++;
        }

        return result;
    }
}
