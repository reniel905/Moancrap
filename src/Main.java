import java.util.Scanner;

public class Main implements Mode{
    static Player player = new Player();
    static Scanner input = new Scanner(System.in);
    public Main() {

        System.out.println("Choose your game mode: " + "\n" + "1 - Survival " + "\n" + "2 - Story" + "\n" + "3 - Exit");

        chooseMode(input.nextInt());

    }

    public static void main(String[] args) {

        System.out.println("Welcome to Moancrap!");
        System.out.print("Please enter your name: ");

        player.setName(input.nextLine());

        new Main();

    }

    public void chooseMode(int mode){

        if (mode == 1){

            Survival();

        } else if (mode == 2){

            System.out.println("Story mode is coming soon!");
            //new Story();
            new Main();

        } else if (mode == 3) {

            //exit game
            System.out.println("Game exited!");
            System.exit(0);

        }
    }

    @Override
    public void Survival() {

        new Survival();
    }

    @Override
    public void Story() {

        new Story();

    }
}