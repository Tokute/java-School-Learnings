import java.util.Scanner;

class Pair<A, B> {
    public final A first;
    public final B second;


    public Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }

}



public class TuplesExample {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        

        System.out.print("Enter your kill count: ");
        int userKillCount = scanner.nextInt();
        scanner.nextLine();

        Pair<String, Integer> killCount = new Pair<>("Kill/s:", userKillCount);

        System.out.printf("%s %d", killCount.first, killCount.second);



        scanner.close();
    }

}