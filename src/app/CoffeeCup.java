
package app;

import java.util.Scanner;


public class CoffeeCup extends CoffeeMachine{

    // global variable declaration
    private boolean isFull;  //  Default value of isFull is false.
    private String coffeeName;
    private String cupSize;
    private String coffeeName2;
    private String cupSize2;
    private int tries = 0; // variable used to make sure you cant keep pouring coffee
    private int newTries = 0; // used for the new customer making sure that the user cant keep pouring coffee
    boolean coffeeFill = false;
    boolean pourCup = false;

    // methods
    // returns the value of isFull (start value is false)
    public boolean isFull() {
        return isFull;
    }

    // method for pouring a cup of coffee and outputting the image of a coffee
    public void fill() {
        if (isFull == true && tries == 0 ) {
            tries = 1;
            // sets tries to 1 to make sure you cant pour teh coffee again
            coffeeFill = true;
            pourCup = true;
            // shown in the main as the action is true and complete
            System.out.println("\nPoured a cup of coffee");
            System.out.println("                        (");
            System.out.println("                          )     (");
            System.out.println("                   ___...(-------)-....___");
            System.out.println("               .-\"\"       )    (          \"\"-.");
            System.out.println("         .-'``'|-._             )         _.-|");
            System.out.println("        /  .--.|   `\"\"---...........---\"\"`   |");
            System.out.println("       /  /    |                             |");
            System.out.println("       |  |    |                             |");
            System.out.println("        \\  \\   |                             |");
            System.out.println("         `\\ `\\ |                             |");
            System.out.println("          ` \\ `|                             |");
            System.out.println("           _/ /\\                             /");
            System.out.println("          (__/  \\                           /");
            System.out.println("       _..---\"\"` \\                         /`\"\"---.._");
            System.out.println("    .-'           \\                       /          '-.");
            System.out.println("   :               `-.__             __.-'              :");
            System.out.println("   :                  ) \"\"---...---\"\" (                 :");
            System.out.println("    '._               `\"--...___...--\"`              _.'");
            System.out.println("      \\\"\"--..__                              __..--\"\"/");
            System.out.println("       '._     \"\"\"----.....______.....----\"\"\"     _.'");
            System.out.println("          `\"\"--..,,_____            _____,,..--\"\"`");
            System.out.println("                        `\"\"\"----\"\"\"`\n");


        }
    }
    public void fill2()
    {
        isFull = true;
    }
// used in the CoffeeMachine class to brew coffee

    // if called then will drink the coffee cup entirely
    public boolean drink() {
        // if isFull is full and the user poured the coffee first then they drink the coffee
        if (isFull && tries == 1) {

            System.out.println("\nYou glug " + coffeeName + "'s " + "coffee down.\n");
// makes sure you cant drink the coffee fully again
            isFull = false;
            return true;
            // if isFall is false then prints out user did not drink coffee
        } else {
            // sets coffeeFill to false to make sure you cant drink the coffee
            coffeeFill = false;
                System.out.println("\nYou sip " + coffeeName + "'s" + " coffee" + " furiously, but only suck air.\n");
                return false;
        }

    }
// setting a Constructor for the coffee cup that inputs the users name and coffee cup size
    public CoffeeCup()
    {
        // setting the coffee cup name and size for the startup of the machine
        if (newTries == 0) {
        Scanner input = new Scanner(System.in);
        System.out.println("what is your name? ");
             coffeeName = input.nextLine();
        System.out.println("what is the cup size: small, medium or large");
            cupSize = input.nextLine();
            // increasing the tries for each time this is called and makes sure to not repeat itself
            newTries++;

        }
// setting the coffee cup name and size for each use after the startup for the machine (used for new customers in main)
        if (newTries >= 2)
        {
            Scanner input = new Scanner(System.in);
            System.out.println("what is your name? ");
            coffeeName2 = input.nextLine();
            // sets new name inputted as the original coffee name
            coffeeName = coffeeName2;
            System.out.println("what is the cup size: small, medium or large");
            cupSize2 = input.nextLine();
            // sets the new cupsize as the original cupsize (used for new customers)
            cupSize = cupSize2;

        }


    }
// creating getters for the main to output
    public String getName()
    {
        return coffeeName;
    }
    public String name(){
        return cupSize;
    }
    public boolean getFull()
    {
        return coffeeFill;
    }
    public boolean pourFill() { return pourCup; }
// created a setter for the new customer ability in the main
    public void newCust()
    {
        // setting all the variables to zero and false every time it is called
        coffeeFill = false;
        tries = 0;
        isFull = false;
    }
    // creating setters for setting the name and size to a string variable
    public void setName(String s)
    {
        coffeeName = s;
    }
    // the parameter c is going to be the new cupsize (used in main to set new cupsize for new customer)
    public void setSize(String c)
    {
        cupSize = c;
        pourCup = false;
    }

}
