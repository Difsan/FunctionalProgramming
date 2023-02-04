package functionalInterface;

import java.util.function.Supplier;

public class _Supplier {
    public static void main(String[] args) {
        System.out.println(getDBConnectionUrl());
        System.out.println(getDBConnectionUrlSupplier.get());
    }

    // Not functional
    static String getDBConnectionUrl(){
        return "jdbc://localhost:5432/users";
    }

    //functional
    static Supplier<String> getDBConnectionUrlSupplier =
            () -> "jdbc://localhost:5432/users";
}
