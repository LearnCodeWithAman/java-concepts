package collections;

import java.util.HashMap;

public class Hash_Map {
    public static void main(String[] args) {

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("vishal", 10);
        map.put("sachin", 30);
        map.put("vaibhav",20);

        System.out.println("Size of map is:- " + map.size());

        System.out.println(map);

        if(map.containsKey("vishal")) {

            Integer value = map.get("vishal");
            System.out.println("Value for key" + " \"vishal\" is :- " + value);
        }
    }
}
