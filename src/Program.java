import java.util.Scanner;
public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s, r;
        System.out.println("Please enter number of sides:");
        s = sc.nextInt();
        System.out.println("Please enter number of rolls in the experiment:");
        r = sc.nextInt();
        
        int i;
        for(i = 1; i <= r; i++) {
            System.out.println("Starting iteration #"+i);
            Die my = new Die(s);
            for(int j = 0; j < r; j++) {
                my.rollDie(false);
            }
            my.showStatistics();
            if(my.getAllMostFrequents().length == 2) {
                break;
            }
        }
        System.out.println("Found multiple max frequency. Experiment ended after "+i+" iterations");
    }
}
