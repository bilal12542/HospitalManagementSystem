import java.util.Scanner;

class Medicine{
    String med_name, med_comp, exp_date;
    int med_cost, count;
    public Medicine(){
        Scanner input = new Scanner(System.in);
        System.out.print("Name:");
        med_name = input.nextLine();
        System.out.print("Company:");
        med_comp = input.nextLine();
        System.out.print("Exp_date:");
        exp_date = input.nextLine();
        System.out.print("Cost:");
        med_cost = input.nextInt();
        System.out.print("No of Unit:");
        count = input.nextInt();
    }
    public String toString(){
        return med_name + "\t" + med_comp + "\t" + exp_date + "\t" + med_cost;
    }
}