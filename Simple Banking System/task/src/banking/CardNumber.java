package banking;


import java.util.Random;

/**
 * Class CardNumber that extends Bank, which defines and creates an unique card number for customer identification.
 * This code will both be pseudo random, and will have a set of constant digits, which are defined by the bank
 * identification code.
 */
public class CardNumber extends Bank {

    /**
     * Array of integers representing the customer account identifier. This code will always be unique, and always have
     * a length of 9 digits.
     */
    private int[] accountIdentifier;


    /**
     * Array of 16 digits, that corresponds to the bank identification number joined with the account identifier and
     * finally joined by the digit checkSum. This is the complete card number of an account, and will be unique.
     */
    private int[] completeCardNumber;

    /**
     * integer that validates the credit card number using the Luhn algorithm. It will be, at this stage, always 0.
     */
    private int checkSum;

    /**
     * Default constructor for the card number, which will assume a checksum of 0, and an accountIdentifier will be
     * randomly generated.
     */
    public CardNumber() {
        super();
        this.accountIdentifier = accountIdentifierMaker();
        this.checkSum = 0;
        this.completeCardNumber = new int[16];
        int counter = 0;
        for (int index = 0; index < completeCardNumber.length; index++) {
            if (index < 6) {
                completeCardNumber[index] = super.getBin()[index];
            } else if (index == 15) {
                completeCardNumber[15] = checkSum;
            } else {
                completeCardNumber[index] = accountIdentifier[counter];
                counter++;
            }
        }
        setCompleteCardNumber(completeCardNumber);
    }

    /**
     * Constructor for a cardNumber, which is unique to each account.
     *
     * @param accountIdentifier array of ints that are unique to each account.
     * @param checkSum          int that validates the customer code.
     */
    public CardNumber(int[] accountIdentifier, int checkSum) {
        super();
        this.accountIdentifier = accountIdentifier;
        this.checkSum = checkSum;
        this.completeCardNumber = new int[16];
        int counter = 0;
        for (int index = 0; index < completeCardNumber.length; index++) {
            if (index < 6) {
                completeCardNumber[index] = super.getBin()[index];
            } else if (index == 15) {
                completeCardNumber[15] = checkSum;
            } else {
                completeCardNumber[index] = accountIdentifier[counter];
                counter++;
            }
        }
        setCompleteCardNumber(completeCardNumber);
    }

    /**
     * Method that creates a random sequence of 9 digits, that will identify the customer.
     *
     * @return int array of length of 9, with randomly chosen single digits for each index.
     */
    private int[] accountIdentifierMaker() {
        int[] newAccountIdentifier = new int[9];
        for (int digit = 0; digit < newAccountIdentifier.length; digit++) {
            Random random = new Random();
            newAccountIdentifier[digit] = random.nextInt(10);
        }
        return newAccountIdentifier;
    }

    /**
     * Overrides method toString to be able to translate the object card Number in a string of digits.
     *
     * @return String of 16 digits, corresponding to the card number.
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        for (int value : this.completeCardNumber) {
            str.append(value);
        }

        return str.toString();
    }

    /**
     * Getter for the completeCardNumber, which in a unique array of 16 digits, that will identify a customer account.
     *
     * @return a integer array, of length 16, each index contains a single digit.
     */
    public int[] getCompleteCardNumber() {
        return completeCardNumber;
    }

    /**
     * Setter for completeCardNumber. This will become the identifier of a customer account, universally unique.
     *
     * @param completeCardNumber an integer array, of length 16, each index must contain a single digit.
     */
    public void setCompleteCardNumber(int[] completeCardNumber) {
        this.completeCardNumber = completeCardNumber;
    }

    /**
     * Getter for the accountIdentifier, which identifies the account.
     *
     * @return an array of digits that are unique to the account.
     */
    public int[] getAccountIdentifier() {
        return accountIdentifier;
    }

    /**
     * Setter for the accountIdentifier.
     *
     * @param accountIdentifier array of 9 digits that are unique to each account.
     */
    public void setAccountIdentifier(int[] accountIdentifier) {
        this.accountIdentifier = accountIdentifier;
    }

    /**
     * Getter for checkSum, which retrieves the last digit of a card number, which serves as a validator.
     *
     * @return a digit that validates the code.
     */
    public int getCheckSum() {
        return checkSum;
    }

    /**
     * Setter for checkSum.
     *
     * @param checkSum digit that validates the account number.
     */
    public void setCheckSum(int checkSum) {
        this.checkSum = checkSum;
    }


}
