package banking;

/**
 * Class that handles the Login procedure.
 */
public class LogIn {

    /**
     * Method that confirms if the login is valid, according to the given client,
     * and its card number and pin.
     *
     * @param client            the customer trying to log in.
     * @param inputCardNumber   the card number that has been given as user input.
     * @param inputPIN          the pin that's been written during log in.
     *
     * @return  returns whether the client can proceed and log in, or not.
     */
    public static boolean isLoginValid(Customer client, String inputCardNumber, String inputPIN) {
            return client.getCustomerCardNumber().equals(inputCardNumber) &&
                    client.getPinString().equals(inputPIN);
    }

}
