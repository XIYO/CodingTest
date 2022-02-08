import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HelloWorld {

    public static int solution(int n, int m, int[][] grade) {
        Set<Integer> lastPlaces = getLastPlaces(n, m, grade);
        int answer = 0;

        for(int i=1; i<n+1; i++) {
            if(lastPlaces.contains(i)) continue;
            for(int j=1; j<n+1; j++) {
                if(i==j) continue;
                int cnt = 0;
                int mentor=0, mentee=0;
                for(int a=0; a<m; a++) {
                    for(int b=0; b<n; b++) {
                        if(grade[a][b]==i) mentor=b;
                        if(grade[a][b]==j) mentee=b;
                    }
                    if(mentor<mentee) cnt++;
                }
                if(cnt==m) answer++;
            }
        }
        return answer;
    }

    private static Set<Integer> getLastPlaces(int n, int m, int[][] grade) {
        Set<Integer> lastPlaces = new HashSet<>();

        for(int i=0; i<m; i++) {
            lastPlaces.add(grade[i][n-1]);
        }

        return lastPlaces;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m, grade[][];

        n=sc.nextInt();
        m=sc.nextInt();
        grade=new int[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                grade[i][j] = sc.nextInt();
            }
        }
        System.out.println(solution(n, m, grade));
    }
}