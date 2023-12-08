import java.awt.*;
import java.util.*;

public class Player implements CharacterActions, Character{
    static HashSet<Item> localInventory = new HashSet<>();
    String itemName[] = {"Bottled Water", "Snack", ""};
    Random random = new Random();
    int itemQty = random.nextInt(1,2);
    Item itemDropped = new Item(itemName[random.nextInt(itemName.length)], itemQty);
    static Scanner input = new Scanner(System.in);
    private static String name;
    String runningStateMessages[] = {"Careful running! You might get slipped",
            "You're running too fast!",
            "You slipped! Get up."};
    public Item getItemDropped() {
        return itemDropped;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        Player.name = name;
    }
    public void chooseAction(int action){

        if (action == 1){

            // Walk
            // Drop Random items

            System.out.println("Walking..");

            if (itemDropped.getItemName().isEmpty()){

                // continue walk
                new PlaySurvival();

            } else {

                System.out.println("A " + itemDropped.getItemName() + " was found!" + "\n" + "Press [E] to pick up an item.");
                // pick up
                pickup(input.nextLine());

            }


        } else if (action == 2) {

            //Run
            //Might slip

            String randomMessage = runningStateMessages[random.nextInt(runningStateMessages.length)];
            System.out.println(randomMessage);

            if (randomMessage.contains("slipped!")){

                System.out.println("Press [G] to get up.");

                getUp(input.nextLine());


            }

            new PlaySurvival();


        } else if (action == 3) {

            new Main();

        } else if (action == 4) {

            inventory();

        }

    }
    public void inventory(){

        System.out.println("Bag: ");

        if (!localInventory.isEmpty()){

            System.out.println("Choose the number you want to consume.");

            int count = 1;

            for (Item i: localInventory) {

                System.out.println(count + ". " + i.getItemName() + " " + i.getQuantity());

                count++;

            }

        } else {

            System.out.println("Bag is empty.");

        }

        System.out.println("Press [C] to close your bag.");

        String chosenAction = input.nextLine();

        if (chosenAction.equalsIgnoreCase("c")){

            new PlaySurvival();

        } else {

            consume(Integer.parseInt(chosenAction) - 1);

        }
    }

    @Override
    public void consume(int index) {

        if (index >= 0 && index < localInventory.size()) {
            // Access the item at the specified index
            Item itemToUpdate = null;
            int currentIndex = 0;

            for (Item item : localInventory) {
                if (currentIndex == index) {
                    itemToUpdate = item;
                    break;
                }
                currentIndex++;
            }

            // Subtract 1 from the quantity of the item
            if (itemToUpdate != null) {
                int currentQty = itemToUpdate.getQuantity();
                itemToUpdate.setQuantity(currentQty - 1);

                if (itemToUpdate.getQuantity() == 0){

                    localInventory.remove(itemToUpdate);
                }

                inventory();
            }
        }
    }

    @Override
    public void hit() {

    }

    @Override
    public void pickup(String pickUpKey) {

        if (pickUpKey.equalsIgnoreCase("e")) {

            if (localInventory.isEmpty()){

                localInventory.add(getItemDropped());

            } else {

                Iterator<Item> i = localInventory.iterator();
                boolean found = false;

                while (i.hasNext()) {
                    Item item = i.next();

                    if (item.getItemName().equalsIgnoreCase(getItemDropped().getItemName())) {
                        // If the item is found, update it and set the flag to true
                        Item updatedItem = new Item(item.getItemName(), item.getQuantity() + getItemDropped().getQuantity());
                        i.remove(); // Use the iterator's remove method to safely remove the current item
                        localInventory.add(updatedItem);
                        found = true;
                        break; // Exit the loop since the item has been found and updated
                    }
                }

// If the item was not found, add it to the inventory
                if (!found) {

                    localInventory.add(getItemDropped());

                }

            }

        }

        System.out.println("Item added to your inventory!");

        new PlaySurvival();

    }

    @Override
    public void drop() {

    }

    @Override
    public void getUp(String g) {

        if (g.equalsIgnoreCase("g")){

            new PlaySurvival();

        }

    }
}
