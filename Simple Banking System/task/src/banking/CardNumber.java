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
     * integer that validates the credit card number using the Luhn algorithm.
     */
    private int checkSum;

    /**
     * number that results from applying the Luhn algorithm, necessary to calculate the checkSum (last digit) of a card
     * number.
     */
    private int controlNumber;

    /**
     * Default constructor for the card number, and an accountIdentifier will be
     * randomly generated.
     */
    public CardNumber() {
        super();
        this.accountIdentifier = accountIdentifierMaker();
        this.completeCardNumber = new int[16];
        int counter = 0;
        for (int index = 0; index < completeCardNumber.length - 1; index++) {
            if (index < 6) {
                completeCardNumber[index] = super.getBin()[index];
            } else {
                completeCardNumber[index] = accountIdentifier[counter];
                counter++;
            }
        }
        this.checkSum = checkSumMaker(completeCardNumber);
        completeCardNumber[15] = checkSum;
        setCompleteCardNumber(completeCardNumber);
    }

    /**
     * Constructor for a cardNumber, which is unique to each account.
     *
     * @param accountIdentifier array of ints that are unique to each account.
     */
    public CardNumber(int[] accountIdentifier) {
        super();
        this.accountIdentifier = accountIdentifier;
        this.completeCardNumber = new int[16];
        int counter = 0;
        for (int index = 0; index < completeCardNumber.length - 1; index++) {
            if (index < 6) {
                completeCardNumber[index] = super.getBin()[index];
            } else {
                completeCardNumber[index] = accountIdentifier[counter];
                counter++;
            }
        }
        this.checkSum = checkSumMaker(completeCardNumber);
        completeCardNumber[15] = checkSum;
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
     * Method that finds the checkSum value of the card. This value is the only single digit that, when added to the
     * control number, results in a number divisible by 10.
     *
     * @param completeCardNumber card number for which the checkSum will be found.
     * @return the checkSum, which is the last digit of a complete card number, and verifies its authenticity.
     */
    private int checkSumMaker(int[] completeCardNumber) {
        controlNumberCalc(completeCardNumber);
        for (int possibleCheckSum = 0; possibleCheckSum < 10; possibleCheckSum++) {
            if ((getControlNumber() + possibleCheckSum) % 10 == 0) {
                setCheckSum(possibleCheckSum);
                return checkSum;
            }
        }
        return -1;
    }

    /**
     * Method to calculate the control Number of a card according to the Luhn's algorithm. The calculation  of this
     * value is done as following: for each number of the card number (besides the last digit which is the checkSum
     * itself), if it is at an odd position (or even, in case of arrays), the value should be multiplied by 2. All
     * values that are over 9, should be subtracted by 9. The control number is the result of the sum of all resulting
     * digits.
     *
     * @param completeCardNumber the card number on which the algorithm will be applied
     */
    private void controlNumberCalc(int[] completeCardNumber) {
        controlNumber = 0;
        int[] controlArray = new int[15];
        for (int index = 0; index < controlArray.length; index++) {
            controlArray[index] = completeCardNumber[index];
            if (index % 2 == 0) {
                controlArray[index] *= 2;
            }
            if (controlArray[index] > 9) {
                controlArray[index] -= 9;
            }
            controlNumber += controlArray[index];
        }
        setControlNumber(controlNumber);
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

    /**
     * Getter for the controlNumber
     *
     * @return value which, when added to checkSum, should be divisible by 10.
     */
    public int getControlNumber() {
        return controlNumber;
    }

    /**
     * Setter for the controlNumber
     *
     * @param controlNumber value that results from applying the Luhn algorythm to the card number.
     */
    public void setControlNumber(int controlNumber) {
        this.controlNumber = controlNumber;
    }


}
