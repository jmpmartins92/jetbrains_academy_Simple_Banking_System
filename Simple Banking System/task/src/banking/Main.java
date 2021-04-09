package banking;

public class Main {
    public static void main(String[] args) {

        // A bank is created and a menu for that bank will be displayed.
        Bank bank = new Bank();
        Menu menu = new Menu(bank);

        /* Will process the operations that are requested by the user, and continuously display the corresponding menu
        until the user chooses to exit the program.*/
        menu.menuOptions();
    }
}