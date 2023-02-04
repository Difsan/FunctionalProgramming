package functionalInterface;

import java.util.function.Predicate;

public class _Predicate {
    public static void main(String[] args) {

        // No functional
        System.out.println(isPhoneNumberValid("07000000000"));
        System.out.println(isPhoneNumberValid("0956300000"));
        System.out.println("070000000");
        System.out.println("0956300000");

        //functional
        System.out.println(isPhoneNumberValidPredicate.test("07000000000"));
        System.out.println(isPhoneNumberValidPredicate.test("0956300000"));

        //use .and()
        System.out.println(isPhoneNumberValidPredicate
                .and(containsNumber3)
                .test("07000000000"));

        System.out.println(isPhoneNumberValidPredicate
                .and(containsNumber3)
                .test("07000000003"));

        // using .or()
        System.out.println(isPhoneNumberValidPredicate
                .or(containsNumber3)
                .test("07000000000"));
    }

    // No functional
    static boolean isPhoneNumberValid (String phoneNumber){
        return phoneNumber.startsWith("07") &&
                phoneNumber.length() ==11;
    }

    // Functional
    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber ->
            phoneNumber.startsWith("07") &&
                    phoneNumber.length() ==11;

    static Predicate<String> containsNumber3 =
            phoneNumber -> phoneNumber.contains("3");
}
