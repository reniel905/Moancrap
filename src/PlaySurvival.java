import java.util.ArrayList;
import java.util.Scanner;

public class PlaySurvival {
    static Scanner input = new Scanner(System.in);

    public PlaySurvival() {

        Player player = new Player();

        if (Player.localInventory.isEmpty()){

            System.out.println("1 - Walk" + "\n" + "2 - Run" + "\n" + "3 - Back to menu");

        } else {

            System.out.println("1 - Walk" + "\n" + "2 - Run" + "\n" + "3 - Back to menu" + "\n" + "4 - Inventory");

        }

        player.chooseAction(input.nextInt());

    }

    public PlaySurvival(String c){

        if (c.equalsIgnoreCase("c")){

            new PlaySurvival();

        }

    }


}
