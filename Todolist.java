import java.util.ArrayList;
import java.util.Scanner;

public class Todolist {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> todolist = new ArrayList<String>();
        
        // While loop to keep displaying the main menu without having to callback to the main method
        while(true){
            System.out.println("1 to add to your To-do list");
            System.out.println("2 to view to your To-do list");
            System.out.println("3 to remove items from To-do list");
            System.out.println("4 to exit");
            int user_choice = scan.nextInt();
            scan.nextLine();
            
            // If user_choice is 4 then we close the program by breaking the while loop
            if(user_choice == 4){
                System.out.println("Exiting the program");
                break;
            }
            // Else we just go to the todofunction method
            todofunction(user_choice, todolist, scan);
        }
        // Closing the Scanner object to prevent any leaks
        scan.close();
    }
    public static void todofunction(int user_choice, ArrayList<String> todolist, Scanner scan){
        switch (user_choice) {
            case 1 -> {
                System.out.println("What would you like to add?");
                String j = scan.nextLine();
                todolist.add(j);
                System.out.printf("Added %s\n\n", j);
            }
            case 2 -> {
                Printlist(todolist);
            }
            case 3 -> {
                // Calls the Printlist() method
                Printlist(todolist);
                System.out.println("What would you like to delete? ");
                System.out.println("Please give the number next to the item");
                int delete_choice = scan.nextInt();
                // Decrementing the delete_choice method such to get the index number within the Array
                delete_choice--;
                // If delete_choice is higher than the size of the array or lower than 0 then it is an invalid size
                if(delete_choice > todolist.size() || delete_choice < 0){
                    System.out.println("Please enter a valid number");
                } else {
                    // Using the remove() function on the arraylist to remove the index number
                    todolist.remove(delete_choice);
                }
                System.out.println();
            }
            default -> System.out.println("Invalid choice!");
        }
    }
    public static void Printlist(ArrayList<String> todolist){
        System.out.println("\nYour To-do list");
        int y = 1;
        // For string object i in todolist
        for(String i : todolist){
            // print y, i
            System.out.printf("%d. %s\n", y, i);
            y++;
        }
        // Add a divider such as to increase readability of the program.
        System.out.println("=".repeat(33) + "\n");
    }
}
