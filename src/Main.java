import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static ArrayList<Integer> expenses = new ArrayList<>(Arrays.asList(1000, 2300, 45000, 32000, 110));

    public static void main(String[] args) {
        System.out.println("\n**************************************\n");
        System.out.println("\tWelcome to The Desk \n");
        System.out.println("**************************************");
        optionsSelection();

    }

    private static void optionsSelection() {
        String[] arr = { "1. I wish to review my expenditure", "2. I wish to add my expenditure",
                "3. I wish to delete my expenditure", "4. I wish to sort the expenditures",
                "5. I wish to search for a particular expenditure", "6. Close the application" };

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        System.out.println("\nEnter your choice:\t");
        Scanner sc = new Scanner(System.in);
        int options = sc.nextInt();
        switch (options) {
            case 1:
                System.out.println("Your saved expenses are listed below: \n");
                System.out.println(expenses + "\n");
                optionsSelection();
                break;
            case 2:
                System.out.println("Enter the value to add your Expense: \n");
                int value = sc.nextInt();
                expenses.add(value);
                System.out.println("Your value is updated\n");
                System.out.println(expenses + "\n");
                optionsSelection();
                break;
            case 3:
                System.out.println(
                        "You are about the delete all your expenses! \nConfirm again by selecting the same option...\n");
                int con_choice = sc.nextInt();
                if (con_choice == options) {
                    expenses.clear();
                    System.out.println(expenses + "\n");
                    System.out.println("All your expenses are erased!\n");
                } else {
                    System.out.println("Did not erase Expenses. Returning to Menu...\n");
                    optionsSelection();
                }
                optionsSelection();
                break;
            case 4:
                System.out.println("Sorting List...");
                sortExpenses(expenses);
                System.out.println("Your values have been sorted\n");
                System.out.println(expenses + "\n");
                optionsSelection();
                break;
            case 5:
                System.out.println("\nEnter the expense you want to search:\t");
                searchExpenses(expenses, sc.nextInt());
                optionsSelection();
                break;
            case 6:
                closeApp();
                break;
            default:
                System.out.println("You have made an invalid choice!");
                break;
        }
        sc.close();
    }

    private static void closeApp() {
        System.out.println("Closing your application... \nThank you!");
    }

    private static void searchExpenses(ArrayList<Integer> arrayList, int sVal) {
        // check if value is in the arraylist
        String result = (arrayList.contains(sVal)) ? "\nYour Expeditures contain " + sVal + "\n"
                : "\n" + sVal + " is not contained in your Expenditures\n";
        // print if it was found or not
        System.out.println(result);
    }

    private static void sortExpenses(ArrayList<Integer> arrayList) {
        // Insertion Sort
        for (int i = 1; i < arrayList.size(); i++) {
            int current = arrayList.get(i); // hold current for redistribution
            int j = i; // pointer

            // move until it is in its right position
            while (j > 0 && arrayList.get(j - 1).compareTo(current) > 0) {
                arrayList.set(j, arrayList.get(j - 1)); // shift right
                j--; // decrement
            }
            // place current at current pointer
            arrayList.set(j, current);
        }
    }
}
