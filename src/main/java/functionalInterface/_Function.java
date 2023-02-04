package functionalInterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {
        // Function normal
        int increment = incrementByOne(1);
        System.out.println(increment);

        // Apply each Function but separately
        Integer increment2 = incrementByOneFunction.apply(1);
        System.out.println(increment2);
        int multiply = multiplyBy10.apply(increment2);
        System.out.println(multiply);

        // Apply each Function at the same time thanks to the .AndThen()
        Function<Integer, Integer> addBy1AndThenMultiplyBy10 =
                incrementByOneFunction.andThen(multiplyBy10);
        System.out.println(addBy1AndThenMultiplyBy10.apply(1));

        //BiFunction takes 2 argument and produces 1 result
        System.out.println(incrementByOneAndMultiply(4, 100));

        System.out.println(incrementByOneAndMultiplyByFunction.apply(4, 100));
    }

    // declarative approach (Function)
    static Function<Integer, Integer> incrementByOneFunction =
            number -> number + 1;

    static Function<Integer, Integer> multiplyBy10 = number -> number * 10;

    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyByFunction =
            (numberToIncrementByOne, numberToMultiplyBy) ->
                    (numberToIncrementByOne + 1) * numberToMultiplyBy;




    // Imperative approach
    static int incrementByOne(int number){
        return number + 1;
    }
    static int incrementByOneAndMultiply (int number, int numToMultiplyBy){
        return (number + 1) * numToMultiplyBy;
    }



}
