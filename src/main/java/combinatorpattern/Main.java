package combinatorpattern;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer(
                "Sergio",
                "seki@gmail.com",
                "+0358896",
                LocalDate.of(2020, 1, 1 )
        );



        // we don't know what could fail or something
        //System.out.println(new CustomerValidatorService().isValid(customer));

        //Using combinator pattern
        CustomerRegistrationValidator.ValidationResult result = CustomerRegistrationValidator
                .isEmailValid()
                .and(CustomerRegistrationValidator.isPhoneNumberValid())
                .and(CustomerRegistrationValidator.isAdult())
                .apply(customer);

        System.out.println(result);

        if ((result!= CustomerRegistrationValidator.ValidationResult.SUCCESS)){
            throw new IllegalStateException(result.name());
        }
    }
}
