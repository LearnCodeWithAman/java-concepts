package designpatterns.singleton;

public class Jalebi {

    //Eager way of creating Singleton Object
    private static Jalebi jalebi = new Jalebi();

    public static Jalebi getJalebi() {
        return jalebi;
    }
}
