package app;

/*
Author: Nicolas Martalog
Class: ICS4U

Program: CoffeeKlatch
Input: This program takes in the users name, cupsize, strength, and decision with the coffee machine
Processing: This program takes the input of user and processes how the coffee machine will react to each input (brewing coffee, adding water, etc...)
Output: This program outputs the results of the input from the user (ex. brewed coffee successfully, added water, etc...)

*/
import java.util.Scanner;
public class CoffeeKlatch {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Created a new app.CoffeeMachine and a app.CoffeeCup as well as variables to refer to it.
        app.CoffeeMachine machineOfJoe = new app.CoffeeMachine();
        app.CoffeeCup cupOfJoe = new app.CoffeeCup();

        // global variable declaration
        char decision; // used for the user's input
        int tries = 0; // used to output what to user should do next if their original input was not in order
        String strength2; // strength for the new user
        int pourTries = 0;
        char newDecision;
        int brewTries = 0;

        // asks the user for the strength of the coffee and sets it to the variable strength
            System.out.println("How strong do you want to make your coffee? ");
            System.out.println("Options: weak, regular or strong");
            String strength = input.nextLine();
            // sets input to the new strength
        machineOfJoe.setStrength(strength);

        // this is the main coffee machine game loop
            do {


                // prints the main interface of the coffee machine as well as the status of each part completed with the methods from the other classes
                System.out.println("\t\t\tCOFFEE MACHINE");
                System.out.println("Add Water\t\t" + "Add Beans\t\t" + "Grind The Beans\t\t" + "Brew The Coffee\t\t" + "Pour A Cup Of Coffee\t\t" + "Water Supply");
                System.out.println(machineOfJoe.getWater() + "\t\t\t" + machineOfJoe.beans() + "\t\t\t" + machineOfJoe.getGrind() + "\t\t\t\t" + machineOfJoe.getBrew() + "\t\t\t\t" + cupOfJoe.pourFill() + "\t\t\t\t\t\t" + machineOfJoe.waterSupply);


                // prints out the options for the coffee machine and inputs the first character of the input
                System.out.println(" ");
            System.out.println("(w). Add Water?");
            System.out.println("(b). Add Beans?");
            System.out.println("(g). Grind The Beans?");
            System.out.println("(c). Brew The Coffee?");
            System.out.println("(p). Pour A Cup Of Coffee?");
            System.out.println("(d). Drink A Cup Of Coffee?");
            System.out.println("(n). New Customer");
            System.out.println("(q). Quit");
            decision = input.next().charAt(0);

// runs the method addWater if certain conditions are met
            if ((decision == 'w' && machineOfJoe.waterSupply <= 9)) {
                machineOfJoe.addWater();
            }
// outputs machine is full if 'w' is pressed repeatedly and machine is already full
            // makes sure that the waterSupply doesn't overflow if the customer adds water if the supply is already full
            else if (decision == 'w' && machineOfJoe.waterSupply == 10){
                System.out.println("\nMACHINE IS AT ITS MAX WATER LEVEL CANNOT ADD WATER\n");

            }
// sets the stage to 0 (addWater stage) if the stage is currently 0 and the waterSupply is greater than one
            // used to make sure that if the new customer tries to input another command instead of (addWater) and the stage is currently (addWater) then it will automatically set the stage to (addWater)
            else if (machineOfJoe.stages() == 0 && machineOfJoe.waterSupply >= 1)
            {
                machineOfJoe.setStage(0);

            }
// runs the method addBeans if the input is 'b' and the status of the method is false
            if ((decision == 'b' && machineOfJoe.beans() == false)) {
                machineOfJoe.addBeans();

            }

            // Get ready to grind some strong coffee in the app.CoffeeMachine.


            // Grind the beans if input is 'g' and the status of the method is false.
                // used to make sure that grind beans is not true and can run
            if (decision == ('g') && machineOfJoe.getGrind() == false) {
                machineOfJoe.grindBeans();

            }


            if (decision == ('c')) {

                if (machineOfJoe.waterSupply <= 0) {
                    System.out.println(" \nREFILL THE WATER FOR THE COFFEE MACHINE\n ");
                }
                // sets the stage of the machine to 0 when it is on the brewing stage and doesn't have enough water to brew
                // used for when their is not enough water to brew
                if (machineOfJoe.waterSupply <= 1 && cupOfJoe.name().equals("small") && brewTries == 0 && machineOfJoe.stages() == 3)
                {
                    // outputs not enough water for brewing and sets the machine to stage 0
                    System.out.println("\nNOT ENOUGH WATER FOR BREWING. ADD WATER \n");
                    // sets the machine to the "add water" stage
                    machineOfJoe.setStage(0);

                    brewTries = 1;
                    // allows for the machine to know what to output
                    tries = 0;

                }
                // same purpose as the if statement above only for if the user chose medium instead of small
                if (machineOfJoe.waterSupply <= 2 && cupOfJoe.name().equals("medium") && brewTries == 0 && machineOfJoe.stages() == 3)
                {
                    System.out.println("\nNOT ENOUGH WATER FOR BREWING. ADD WATER \n");
                    machineOfJoe.setStage(0);
                    brewTries = 1;
                    tries = 0;

                }
                // same purpose as the if statement above only for if teh user chose large instead of medium
                if (machineOfJoe.waterSupply <= 3 && cupOfJoe.name().equals("large") && brewTries == 0 && machineOfJoe.stages() == 3)
                {
                    System.out.println("\nNOT ENOUGH WATER FOR BREWING. ADD WATER \n");
                    machineOfJoe.setStage(0);
                    brewTries = 1;
                    tries = 0;

                }
                // brews the coffee if there is enough water to brew the coffee
                else
                    machineOfJoe.brew(cupOfJoe);

            }
// checks if water is added after the failure of brewing and then sets the machine to the brewing stage
                if (decision == 'w' && brewTries == 1)
                {
                    machineOfJoe.setStage(3);
                    brewTries = 0;
                    tries = 3;
                }


            // pours from the cup
            if (decision == ('p')) {
                // checks to see if it can increase pourTries to 1
                if (machineOfJoe.getBrew() == true && cupOfJoe.pourFill() == false)
                {
                    pourTries = 1;
                }
                // increases pourTries by one each time it is run so it can output the message one cup of coffee per customer
                if (machineOfJoe.getBrew() == true && cupOfJoe.pourFill() == true)
                {
                    pourTries++;
                }
// checks to see how by how much the waterSupply should subtract by
                if (cupOfJoe.name().equals("small") && machineOfJoe.waterSupply != 0 && pourTries == 1)
                {
// sets the cup as full
                    cupOfJoe.fill();
                    // increases pourTries so the user cant pour again
                    pourTries++;
                    if (cupOfJoe.getFull() == true) {
                        // small cup reduces waterSupply by 2
                        machineOfJoe.waterSupply -= 2;

                    }
                }
                // this has the same purpose as the if statement as above only for medium cupesize
                if (cupOfJoe.name().equals("medium") && machineOfJoe.waterSupply != 0 && pourTries == 1)
                {

                    cupOfJoe.fill();
                    pourTries++;
                    if (cupOfJoe.getFull() == true) {
                        // medium cup reduces waterSupply by 3
                        machineOfJoe.waterSupply-=3;

                    }
                }
                // this has the same purpose as the if statement as above only for large cupsize
                if (cupOfJoe.name().equals("large") && machineOfJoe.waterSupply != 0 && pourTries == 1)
                {

                    cupOfJoe.fill();
                    pourTries++;
                    if (cupOfJoe.getFull() == true) {
                        // large cup reduces waterSupply by 4
                        machineOfJoe.waterSupply-=4;

                    }
                }
// if 'p' keeps being pressed repeatedly after the cup is already poured then this output will be shown
                // makes sure the customer cant keep pouring coffee
                if (pourTries >= 3 )
                {
                    System.out.println("\nONLY ONE CUP OF COFFEE PER CUSTOMER\n");
                }
            }
// drinks coffee if the input is 'd'
            if (decision == ('d')) {
                cupOfJoe.drink();
            }
            if (decision == ('n'))
            {

                app.CoffeeCup cupOfJoe2 = new app.CoffeeCup();

// sets every variable to zero once there is a new customer
                tries = 0;
                pourTries = 0;
                System.out.println("How strong do you want to make your coffee? ");
                System.out.println("Suggestions: weak, regular or strong" );
                // sets the new name and coffee cup inputted as the original name and coffee cup
                cupOfJoe.setName(cupOfJoe2.getName());
                cupOfJoe.setSize(cupOfJoe2.name());
                // inputs new strength and sets it to a new variable
                input.nextLine();
                strength2 = input.nextLine();
                // sets the new strength as the updated old strength
                machineOfJoe.setStrength(strength2);
                // checks whether the user wants to adds beans for the new coffee or fills the tank
                System.out.println("Add a full tank of water or use remaining water from last use and add beans? ( " + "'w'" + " for more water or " + "'b' for keeping water and adding beans)");
                newDecision = input.next().charAt(0);

                // these methods set the other variables from the other classes to 0 and basically resets the program for the new customer
                machineOfJoe.newCust();
                cupOfJoe.newCust();
                cupOfJoe2.getName();
                cupOfJoe2.name();

// if statements for changing stages while going through the coffee machine for the new customer

                if (newDecision == 'w')
                {
                    machineOfJoe.setStage(0);
                    machineOfJoe.addWater();
                    // the tries allow for the machine to tell the user what to do if a input is done incorrectly
                    tries = 1;
                }
                if (newDecision == 'b')
                {
                    machineOfJoe.setStage(1);
                    machineOfJoe.addBeans();
                    tries = 2;

                }


            }

// these if statements allow the machine to determine what to output if the user inputs something incorrectly
                else if (machineOfJoe.stages() == 0 && decision != 'w') {
                    tries += 1;
                    if (tries == 1){
                System.out.println("\nADD WATER\n");
                // resets tries back to 0 so the message can keep appearing if the stage is on addWater
                    tries = 0; }
            }
                else if (machineOfJoe.stages() == 1 && decision != 'b')
            {
                tries+= 1;
                if (tries == 2) {
                    System.out.println("\nADD BEANS\n");
                    //resets tries back to 1 so the message can appear if the stage is on addBeans
                    tries = 1;

                }

            }
                else if(machineOfJoe.stages() == 2 && decision != 'g')
            {

                tries++;
                if (tries == 3) {
                    System.out.println("\nGRIND BEANS\n");
                    //resets tries back to 2 so the message can appear if the stage is on grindBeans
                    tries = 2;

                }
            }
                else if (machineOfJoe.stages() == 3 && decision != 'c')
            {

                tries++;
                if (tries == 4) {
                    System.out.println("\nBREW COFFEE\n");
                    //resets tries back to 3 so the message can appear if the stage is on brewCoffee
                    tries = 3;

                }
            }
// tests to see if the user wants to quit the loop
        }while (decision != ('q')); }


}