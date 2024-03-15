package designpatterns.singleton;

import java.io.Serializable;

public class Samosa implements Serializable, Cloneable{

    private static Samosa samosa;

    private Samosa() {
        // if(samosa != null)
        //    throw new RuntimeException("You are trying to break Singleton Pattern");
    }

    public static Samosa getSamosa() {

        if (samosa == null)


            samosa = new Samosa();
        return samosa;
    }

    public Object readResolve() {
        return samosa;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        // return super.clone();
        return samosa;
    }

}
