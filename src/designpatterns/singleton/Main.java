package designpatterns.singleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws Exception {

        Jalebi j1 = Jalebi.getJalebi();
        System.out.println(j1.hashCode());

        Jalebi j2 = Jalebi.getJalebi();
        System.out.println(j2.hashCode());

        Samosa s1 = Samosa.getSamosa();
        System.out.println(s1.hashCode());

        Samosa s2 = Samosa.getSamosa();
        System.out.println(s2.hashCode());

        // Break Singleton Pattern
        //
        // 1. Reflection API
            /*Constructor<Samosa> constructor = Samosa.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            Samosa s2 = constructor.newInstance();
            System.out.println(s2.hashCode());*/

        // solutions-----
        // 1. Throw RunTimeException in constructor, if object is already created once
        // 2. Enums
            /*SamosaEnum se1 = SamosaEnum.INSTANCE;
            System.out.println(se1.hashCode());
            SamosaEnum se2 = SamosaEnum.INSTANCE;
            System.out.println(se2.hashCode());*/


        // 2. Deserialisation

        /*ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("abc.ob"));
        oos.writeObject(s1);
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("abc.ob"));
        Samosa s2 = (Samosa) ois.readObject();
        System.out.println(s2.hashCode());*/

        // solution:- implement readResolve method in Singleton Class

        // 3. Cloning
        /*Samosa s2 = (Samosa) s1.clone();
        System.out.println(s2.hashCode());*/
        // solution:- override clone method, retun same object

    }
}
