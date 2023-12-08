public class PlayStory {

    // TODO: Write the story scripts
    public PlayStory() {

        Player player = new Player();

        System.out.println("You are trekking along the forest and you got lost."
                + "\n" + "You need to find your way" + "\n"
                + "because it is late afternoon!" + "\n"
                + "1 - Okay");
    }

    public PlayStory(String c) {

        if (c.equalsIgnoreCase("c")){

            new PlayStory();

        }

    }
}
