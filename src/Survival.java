import java.util.Scanner;
public class Survival extends Player {

    Scanner input = new Scanner(System.in);

    public Survival() {

        Player player = new Player();
        System.out.println("Press [P] to start playing, " + player.getName() + "!");

        play(input.nextLine());

    }

    public static void play(String p){

        if (p.equalsIgnoreCase("p")){

            new PlaySurvival();

        }
    }
}
