package banking;

import java.util.*;

/**
 * Class Bank, defining different bank entities by its BIN code.
 */
public class Bank {

    /**
     * array of digits that defines a bank. Typically, this code will have a length of 6, and the first digit will be 4.
     */
    private int[] bin;

    /**
     * List of customers that have an account of this bank.
     */
    List<Customer> customerList;

    /**
     * Default bank identification number, as per requested.
     */
    final static int[] DEFAULT_BIN = {4, 0, 0, 0, 0, 0};


    /**
     * Default constructor for a bank with the default bin.
     */
    public Bank() {
        this.bin = DEFAULT_BIN;
        this.customerList = new ArrayList<>();
    }

    /**
     * Constructor for a bank with a specific bin code.
     *
     * @param bin int array of length 6, that is unique to each bank
     */
    public Bank(int[] bin) {
        this.bin = bin;
        this.customerList = new ArrayList<>();
    }

    /**
     * Getter for the identification of the bank
     *
     * @return the bin of the bank.
     */
    public int[] getBin() {
        return bin;
    }

    /**
     * Setter for the identification of a bank
     *
     * @param bin array of ints corresponding to the bank identity code to be set.
     */
    public void setBin(int[] bin) {
        this.bin = bin;
    }


}
