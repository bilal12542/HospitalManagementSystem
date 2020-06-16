import java.util.Scanner;

class labs{
    String facility;
    int lab_cost;
    public labs(){
        Scanner input = new Scanner(System.in);
        System.out.print("Facility:-");
        facility = input.nextLine();
        System.out.print("Cost:");
        lab_cost = input.nextInt();
    }
    public String toString(){
        return facility + "\t\t" + lab_cost;
    }
}