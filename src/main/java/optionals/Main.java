package optionals;

import java.util.Optional;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Object value = Optional.ofNullable(null)
                .orElseGet(() -> "default value");

        /*Supplier<IllegalStateException> exception =
                    () -> new  IllegalStateException("exception");

        Object value2 = Optional.ofNullable(null)
                    .orElseThrow(exception);*/

        Optional.ofNullable("Hello")
                .ifPresent(System.out::println);

        Optional.ofNullable("john@gmail.com")
                .ifPresent(email-> System.out.println("Sending email to" +
                        email));

        Optional.ofNullable(null)
                        .ifPresentOrElse(
                                email -> System.out.println("Sending email to " + email),
                                () -> {
                                    System.out.println("Cannot send email");
                                }
                        );
        System.out.println(value);
        //System.out.println(value2);
    }
}
