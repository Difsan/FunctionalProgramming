package functionalInterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {
    public static void main(String[] args) {

        Customer maria = new
                Customer("Maria", "9999");
        // No fuctional approach
        greetCustomer(maria);
        greetCustomerV2(maria, true);

        //Functional approach: Consumer
        greetCustomerFunctional.accept(maria);
        greetCustomerFunctionalV2.accept(maria, false);

    }

    static class Customer{
        private final String customerName;
        private final String customerPhoneNumber;

        public Customer(String customerName, String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }
    }

    // Functional
    static Consumer<Customer> greetCustomerFunctional =
            customer -> System.out.println("Hello " + customer.customerName
                    + ", thanks for registering phone number: " +
                    customer.customerPhoneNumber);

    static BiConsumer<Customer, Boolean> greetCustomerFunctionalV2 =
            (customer, showPhoneNumber) ->
            System.out.println("Hello " + customer.customerName
                    + ", thanks for registering phone number: " +
                    (showPhoneNumber ?
                            customer.customerPhoneNumber : "******"));

    // No functional
    static void greetCustomer(Customer customer){
        System.out.println("Hello " + customer.customerName
        + ", thanks for registering phone number: " +
                customer.customerPhoneNumber);
    }

    static void greetCustomerV2(Customer customer, Boolean showPhoneNumber){
        System.out.println("Hello " + customer.customerName
                + ", thanks for registering phone number: " +
                (showPhoneNumber ?
                        customer.customerPhoneNumber : "******"));
    }
}
