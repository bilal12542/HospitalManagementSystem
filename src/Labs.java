import java.util.Scanner;

class labs{
    String test_name;
    int lab_cost;
    public labs(){
        Scanner input = new Scanner(System.in);
        System.out.print("Test Name:");
        test_name = input.nextLine();
        System.out.print("Cost:");
        lab_cost = input.nextInt();
    }
    public String toString(){
        return this.test_name + "\t\t" + this.lab_cost;
    }
}