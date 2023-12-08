import java.util.Scanner;

public class Story {

    public Story() {

        Scanner input = new Scanner(System.in);
        Player player = new Player();

        System.out.println("Story Mode." + "\n" + player.getName() + " 's" + "Adventure!" + "\n" + "Press [C] to continue.");

        new PlayStory(input.nextLine());

    }
}
