

/**
 * Flooring Factory
 * This program allows user to pick flooring for their room
 * and calculates and displays the cost
 *
 * @author 45101MUR
 * @date 22 March 2023
 */

        import java.io.*;
        import java.util.Scanner;
public class MainFlooringFactory {
    /**
     * Gets y or n from the user
     *@return a char, either y or n
     *
     */
    public static char getYorN() {
//Create scanner class and scanner object
        Scanner s = new Scanner(System.in);
        char ans;
//Ask user for y or n
        System.out.print("Enter y or n: ");
//Error trap user's response
        while(true) {
            ans = s.nextLine().toLowerCase().charAt(0);
            if(ans == ('y')|| ans == ('n')) {
                break;
            }// end if
            System.out.println("Please enter y or n");
        }// end while
        return ans;
    }//char getYorN()
    /**
     * Displays all the floorings and their prices
     *
     *
     *
     *
     */
    public static void displayFloors(String [] floors ,double [] prices) {
//Format heading
        System.out.printf("%-3s %-30s %10s", "#", "Type", "Cost per Sq.m. \n");
//Print all the floors and their prices properly formatted
        for(int i = 0; i<floors.length;i++) {
            System.out.printf("%-3d %-30s $%10s \n",i+1,floors[i],prices[i]);
        }// end for

    }//displayFloors(String[],String[])
    /**
     * Checks if the length and width are valid
     *

     *
     * @return float area, the area of the room
     *
     */
    public static float validVal(String prompt){
//Create scanner class and scanner object
        Scanner s = new Scanner(System.in);
//Create a variable for the value user enters
        float value;
//Error trap user's input
        while(true){
            System.out.print(prompt);
            value = s.nextFloat();
//If value is 1 or greater, break loop
            if(value>=1){
                break;
            }// end if
//Print error message
            System.out.println("Please enter a value that is 1 or greater.");
        }//end while
//return value
        return value;
    }// float validVal(String)
    /**
     * Calculates the area
     *
     * @return float area, the area of the room
     *
     */
    public static float calcArea(){
//Initialize variables
        float length;
        float width;
        float area;
//call validVal method and store user's input in variable
        length = validVal("Enter length of your room in metres: ");
        width = validVal("Enter width of your room in metres: ");
//Calculate area
        area = length * width;
//Return area
        return area;
    }// float calcArea()


    /**
     * Returns the cost of the flooring the user chooses and makes sure
     * user chooses a valid floor
     *
     * @param opt1, starting number to pick flooring from
     * @param opt2, ending number to pick till
     *
     *
     * @return float cost, the cost of the room user chooses
     *
     */
    public static double validFloor(int opt1, int opt2,FLOORTYPE[] floor){
//Create scanner class and scanner object
        Scanner s = new Scanner(System.in);
//variable to store user's option
        int opt;
        double cost =0;
//Ask user for floor choice and error trap
        while(true){
            System.out.println("Enter option for flooring: ");
            opt = s.nextInt();
//If option is between the starting and ending option number break loop
            if(opt>=opt1 && opt<=opt2){
                break;
            }//end if
//Display error message
            System.out.println("Please enter a valid option.");
        }// end while



//Return cost
        return floor [opt-1].getCost();

    }// double validFloor(int,int)
    /**
     * Calculates and displays all the charges
     *
     * @param area, the area of the room
     * @param cost, cost of flooring of one square meter
     *
     *
     */
    public static double displayCharges(double area, double cost){
//Declare variables
        double materialCost;
        double labourCharge;
        double subTotal;
        double HST;
        double total;
//Calculate charges
        materialCost = area*cost;
        labourCharge = 6.5*area;
        subTotal = materialCost + labourCharge;
        HST = subTotal*0.13;
        total = subTotal + HST;
//Display all charges formatted
        System.out.printf("%-25s $%15.2f \n","Material Cost: ", materialCost);
        System.out.printf("%-25s $%15.2f \n","Labour Charges: ", labourCharge);
        System.out.printf("%-25s $%15.2f \n","Sub Total: ", subTotal);
        System.out.printf("%-25s $%15.2f \n","HST: ", HST);
        System.out.printf("%-25s $%15.2f \n","Total: ", total);
//return total
        return total;
    }//displayCharges(double,double)
    public static void main(String[] args) throws IOException {
// TODO Auto-generated method stub
//Create scanner class and scanner object
        Scanner s = new Scanner(System.in);
//Declare/Initialize variables
        double grandTotal=0;
        int room = 0;
        double area;
        double cost;
        double total;
        char ans;
        int option;

//Create an array for floors and their prices
//String[] floors = {"Low pile carpet","Shag rug", "Parquet", "Linoleum", "Hardwood"};
//double [] prices = {18.75, 11.05, 14.35, 10.40, 28.15};




/*BufferedReader in = new BufferedReader(new FileReader("floors-2.csv"));
num = Integer.parseInt(in.readLine());
String[] floors = new String[num];
double[] prices = new double[num];

for(int i = 0; i<num; i++){
text = in.readLine();
String [] data = text.split(",");
floors[i] = data[0];
prices[i] =Double.parseDouble( data[1]);
}//end for*/


        String data;

        BufferedReader in = new BufferedReader(new FileReader("FloorTypes1.csv"));

        int size = Integer.parseInt(in.readLine());

//declare the array of FloorType objects
        FLOORTYPE[] floor = new FLOORTYPE[size];


        for(int i = 0; i <size; i++){
            data = in.readLine();
            floor[i]=new FLOORTYPE(data);

        }// end for

        in.close();


//Ask user if they are the admin
        System.out.println("Are you the administrator? ");
        ans = getYorN();
//If they are the admin ask if they would like to make any changes
        if(ans=='y') {
            System.out.println("Would you like to make any changes? ");
            ans = getYorN();
//If they want to make changes, ask them to choose what they would like to do
            if(ans=='y') {
//List options
                System.out.printf("1. Change price\n");
                System.out.printf("2. Add item\n");
                System.out.printf("3. Delete item\n");
//Ask user to enter option
                while(true) {
                    System.out.println("Enter option: ");
                    option = s.nextInt();
                    if(option >=1 && option <=3) {
                        break;
                    }// end if
//Print error message
                    System.out.println("Please enter a valid option.");
                    System.out.println();
                }// end while
//If option is 1, call method to change price
//If option is 2, call method to add item
//If option is 3, call method to delete item
            }//end if
        }//end if
//Display title and intro
        System.out.println("Olivia's Phenomenal Flooring Factory");
        System.out.println();
        System.out.println();
        System.out.println("Welcome to Olivia's Flooring Factory! Your satisfaction is our guarantee!");
        System.out.println("This program will help you determine the cost for your flooring.");
        System.out.println();
        System.out.println();
//Loop program
        while(true) {
//Add 1 to counter for rooms
            room++;
//Call method to calculate area and store in a variable
            area =calcArea();
            System.out.println();
            System.out.println();
//Call method to display floors
//displayFloors(floors,prices);
//display the objects using calls to the getters
            for(int i = 0; i< floor.length; i++){
                System.out.printf("%d. %-20s %6.2f%n", i+1,floor[i].getName(),floor[i].getCost());
            }// end for


            System.out.println();
            System.out.println();
//Call function for user to choose the flooring and store the cost in a variable
            cost = validFloor(1,size,floor);
            System.out.println();
            System.out.println();
//Call the function to calculate and display all the charges
            System.out.println("ROOM "+ room);
            System.out.println("----------------------------------------------------------");
            total = displayCharges(area,cost);
            System.out.println();
            System.out.println();
//Add total to grandTotal
            grandTotal+=total;
//Ask user if they want to add more rooms, if not get out of loop
//call function getYorN
            System.out.println("Would you like to add another room?");
            ans = getYorN();
//if user enters n, break loop
            if(ans=='n') {
                break;
            }// end if
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
        }//end while
//Display the grand total
        System.out.println();
        System.out.println();
        System.out.printf("%-25s $%15.2f \n","GRAND TOTAL: ", grandTotal);
    }//end main
}// end class