package banking;

import java.util.Random;

/**
 * Class Customer of bank, which extends class Bank.
 */
public class Customer extends CardNumber {

    /**
     * array of 4 ints that are generated with the CardNumber, which will be requested upon login.
     */
    private int[] pin;

    /**
     * int that represents current account balance (total money).
     */
    private int balance;

    /**
     * states if the user is logged in or not.
     */
    private boolean loggedIn = false;

    /**
     * Default constructor for a new customer, which will generate a new unique customerCode, and a random 4 digit pin.
     * All new customers will have an account balance of 0 at the moment of account creation.
     */
    public Customer() {
        super();
        this.pin = pinMaker();
        this.balance = 0;
    }

    /**
     * Constructor for Customer class, associated with the respective bank, and includes all existing parameters of
     * customer class.
     *
     * @param pin       array of 4 digits that is associated to an account, and is required to login.
     * @param balance   int that represents the money that the account has.
     */
    public Customer(int[] pin, int balance) {
        super();
        this.pin = pin;
        this.balance = balance;
    }
    
    /**
     * Method that returns the pin of a customer as a string, which facilitates other methods.
     *
     * @return a string consisting of 4 digits and no other chars, that is required as a key to login to an account.
     */
    public String getPinString() {
        StringBuilder str = new StringBuilder();

        for (int value : this.pin) {
            str.append(value);
        }
        return str.toString();
    }
   
    /**
     * Method that makes a random sequence of 4 digits.
     *
     * @return an int array of length 4, representing the pin to login to the respective customer account.
     */
    private int[] pinMaker() {
        int[] newPin = new int[4];
        for (int digit = 0; digit < newPin.length; digit++) {
            Random random = new Random();
            newPin[digit] = random.nextInt(10);
        }
        return newPin;
    }


    /**
     * Method that returns the customer's card number as a string.
     *
     * @return the customer's card number as a string.
     */
    public String getCustomerCardNumber() {
        return super.toString();
    }

    /**
     * Setter for login status of user.
     * 
     * @param loggedIn true to set the user as logged in, false if logged out.
     */
    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    /**
     * Checks if user is logged in.
     * 
     * @return true if logged in, false is not.
     */
    public boolean isCustomerLoggedIn() {
        return this.loggedIn;
    }

    /**
     * Setter for the pin of a customer account.
     *
     * @return a 4 digit array that will be requested upon login.
     */
    public int[] getPin() {
        return pin;
    }

    /**
     * Getter for the pin of a customer account.
     *
     * @param pin a int array with a length of 4, that will be requested upon login.
     */
    public void setPin(int[] pin) {
        this.pin = pin;
    }

    /**
     * Getter for the current account balance.
     *
     * @return int value of the money that the account contains.
     */
    public int getBalance() {
        return balance;
    }

    /**
     * Setter for the account balance.
     *
     * @param balance int value that represents the money the account contains.
     */
    public void setBalance(int balance) {
        this.balance = balance;
    }
}
