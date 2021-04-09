package banking;


import java.util.Scanner;

/**
 * Class for the menu displayed to the user.
 */
public class Menu {

    /**
     * Scans user input.
     */
    Scanner scanner = new Scanner(System.in);

    /**
     * Bank entity for which the menu corresponds and will create customers to.
     */
    private Bank bank;

    /**
     * Int that will define which action is requested by the user.
     */
    private static int option;

    /**
     * The customer which is using the program at that moment.
     */
    private Customer currentCustomer;

    /**
     * Identifier for the home menu.
     */
    private final static int HOME_MENU_ID = 10;

    /**
     * Identifier for the account menu.
     */
    private final static int ACCOUNT_MENU_ID = 20;

    /**
     * Constructor for a Menu.
     *
     * @param bank which the menu represents and will create customers to.
     */
    public Menu(Bank bank) {
        this.bank = bank;
    }

    /**
     * Method that presents the home menu, and requests an option in the form of a digit. This menu might be
     * called back at certain stages, for example, after the creation of a new account, or after logging out.
     */
    private void homeMenu() {
        do {
            System.out.println("1. Create an account");
            System.out.println("2. Log into account");
            System.out.println("0. Exit");
            try {
                Menu.option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please type a number corresponding to the pretended option");
                Menu.option = -1;
            }
        } while (Menu.option < 0 || Menu.option > 2);
        setOption(Menu.HOME_MENU_ID + Menu.option);
        menuOptions();
    }

    /**
     * Method that presents the account menu, and request an option in the form of a digit to the user. This menu is
     * called upon a valid user login.
     */
    private void accountMenu() {
        do {
            System.out.println("1. Balance");
            System.out.println("2. Log out");
            System.out.println("0. Exit");
            try {
                Menu.option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please type a number corresponding to the pretended option");
                Menu.option = -1;
            }
        } while (Menu.option < 0 || Menu.option > 2);
        setOption(Menu.ACCOUNT_MENU_ID + Menu.option);
        menuOptions();
    }

    /**
     * Method that will dictate the flow of the program, according to the options chosen by the user. Options with
     * "1" as the first digit correspond to the home menu, and options with "2" as the first digit correspond to the
     * account menu. The user may always choose to exit the program at any time, by entering "0".
     */
    public void menuOptions() {
        switch(Menu.option) {
            case 0:
                setOption(0);
                homeMenu();
            case 10:
            case 20:
                System.out.println("Bye!");
                System.exit(0);
            case 11:
                createNewCustomer();
                setOption(0);
                menuOptions();
            case 12:
                login();
                setOption(0);
                menuOptions();

            case 21:
                System.out.printf("\nBalance: %d\n", currentCustomer.getBalance());
                setOption(0);
                accountMenu();
            case 22:
                currentCustomer.setLoggedIn(false);
                System.out.println("You have successfully logged out!\n");
                setOption(0);
                menuOptions();
            default:
                System.out.println("error occurred, invalid option");
                System.exit(0);

        }
    }

    /**
     * Creates a new customer and displays its card number and PIN. Adds the customer to the bank's customer list.
     */
    private void createNewCustomer() {
        Customer customer = new Customer();
        System.out.println("Your card has been created.");
        System.out.println("Your card number: ");
        System.out.println(customer.getCustomerCardNumber());
        System.out.println("Your card PIN: ");
        System.out.println(customer.getPinString());
        bank.customerList.add(customer);
        currentCustomer = customer;
    }

    /**
     * Asks for the user's card number and PIN to validate if they can log in and access the account menu. If validated,
     * allows the user to log in and proceed.
     */
    private void login() {
        System.out.println("Enter your card number: ");
        String inputCardNumber = scanner.nextLine();
        System.out.println("Enter your PIN: ");
        String inputPIN = scanner.nextLine();
        boolean login = false;
        for (Customer client : bank.customerList) {
            login = LogIn.isLoginValid(client, inputCardNumber, inputPIN);

            if (login) {
                currentCustomer = client;
                currentCustomer.setLoggedIn(true);
                System.out.println("\nYou have successfully logged in!");
                accountMenu();
            }

        } if (!login) {
            System.out.println("\nWrong card number or PIN.");
        }
    }

    /**
     * Getter for the current option value.
     *
     * @return value that represents the current option selected by the user.
     */
    public int getOption() {
        return Menu.option;
    }

    /**
     * Setter for the option displayed for the menu.
     *
     * @param option int value that will be within certain rules, and will dictate the flow of the program.
     */
    public void setOption(int option) {
        Menu.option = option;
    }
}





