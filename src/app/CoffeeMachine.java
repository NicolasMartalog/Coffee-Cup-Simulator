package app;
/* A fancy coffee maker.  Makes coffee of varying strengths. */

public class CoffeeMachine {


    // global variable declaration
    private String strength = "Killer Intense"; // the current strength of the coffee
    // int stage is what is making sure that you can't skip steps in the process of making coffee
    private int stage = 0;
    // booleans are used for the status of the machine in the main
    boolean grindBeans = false;
    boolean brewing = false;
    boolean addWater = false;
    boolean addBeans = false;
    // starting waterSupply starts as 0
    int waterSupply = 0;




    // methods
    // setters for setting the strength and stage to the parameters
    public void setStrength(String s) {
        strength = s;
    }

    // this allows to change the stage in the main when called
    public void setStage(int v) { stage = v; }

    // grinding the beans if called and if the stage is on the correct number
    public void grindBeans() {
        if (stage == 2) {

            // sets the value of grindBeans to true and will show in the main
            // changes the status in the main for grindBeans
            grindBeans = true;
            System.out.println("\nGrinding beans for " + strength + " coffee.\n");
            System.out.println("        /~~~~~~~~~~~~~~~~~~~/|");
            System.out.println("       /              /######/ / |");
            System.out.println("      /              /______/ /  |");
            System.out.println("     ========================= /||");
            System.out.println("     |_______________________|/ ||");
            System.out.println("      |  \\****/     \\__,,__/    ||");
            System.out.println("      |===\\**/       __,,__     ||");
            System.out.println("      |______________\\====/%____||");
            System.out.println("      |   ___        /~~~~\\ %  / |");
            System.out.println("     _|  |===|===   /      \\%_/  |");
            System.out.println("    | |  |###|     |########| | /");
            System.out.println("    |____\\###/______\\######/__|/");
            System.out.println("    ~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
            // sets stage to the next stage (brewBeans)
            stage = 3;

        }
    }


    // brewing the coffee if the stage is the correct number and into the given cup c
    public void brew(CoffeeCup c) {
        if (stage == 3) {
            // sets the stage brewing to true
            brewing = true;
            // outputs the strength and name of the user
            System.out.print("\nBrewing " + strength + " coffee into coffee cup " + c.getName() + "\n");
            // sets isFull to true
            c.fill2();
            System.out.println("        /~~~~~~~~/|");
            System.out.println("       / /######/ / |");
            System.out.println("      / /______/ /  |");
            System.out.println("     ============ /||");
            System.out.println("     |__________|/ ||");
            System.out.println("      |\\__,,__/    ||");
            System.out.println("      | __,,__     ||");
            System.out.println("      |_\\====/%____||");
            System.out.println("      | /~~~~\\ %  / |");
            System.out.println("     _|/      \\%_/  |");
            System.out.println("    | |        | | /");
            System.out.println("    |__\\______/__|/");
            System.out.println("    ~~~~~~~~~~~~~~\n");
            // makes sure that the stages don't reset itself
            stage = 4;

        }
    }

    // adding water if the stage is the correct number
    public void addWater() {
        if (stage == 0) {
            addWater = true;
            // sets the waterSupply to full when called
            waterSupply = 10;
            System.out.println("\n Adding Water ");
            System.out.println("               __");
            System.out.println("         )) /\\<_");
            System.out.println("         ((/ /  \\");
            System.out.println("          __/~~~/");
            System.out.println("        ,(  \\__/");
            System.out.println("        \"`");
            System.out.println("      _|  |");
            System.out.println("     (_|~~|");
            System.out.println("       `--'\n");
            // sets stage to (addBeans) stage
            stage = 1;
        }
    }



    // adding beans if the stage is the proper number and if the method is called
    public void addBeans() {
        if (stage == 1) {
            addBeans = true; // shows new status in the main
            System.out.println("\n Adding Beans ");
            System.out.println("                        ______________________");
            System.out.println("                       (___________           |");
            System.out.println("                        [XXXXX]    |          |");
            System.out.println("                   __  /~~~~~~~\\   |          |");
            System.out.println("                  /  \\|@@@@@@@@@\\  |          |");
            System.out.println("                  \\   |@@@@@@@@@@| |          |");
            System.out.println("                      \\@@@@@@@@@@| |   ______ |");
            System.out.println("                       \\@@@@@@@@/  | |on|off| |");
            System.out.println("                      __\\@@@@@@/__ |  ~~~~~~  |");
            System.out.println("                      (____________|__________|");
            System.out.println("                      |_______________________|\n");
            // sets stage to (grindBeans)
            stage = 2;
        }

    }
// returns getter getGrind() boolean value for the main
    public boolean getGrind()
    {
        return grindBeans;
    }
    // sets the variables to zero or false when the method is called (used for the new customer)
    public void newCust()
    {
        grindBeans = false;
        addWater = false;
        brewing = false;
        addBeans = false;
        stage = 0;
    }
    // returns each boolean value for each stage of the coffee machine (all are set to false at the beginning of the machine)
    // the getters are used to see the status of the machine in the main
    public boolean getWater()
    {
        return addWater;
    }
    public boolean getBrew()
    {
        return brewing;
    }
    public boolean beans()
    {
        return addBeans;
    }
    // used to see what stage the machine is in the main
    public int stages()
    {
        return stage;
    }


}