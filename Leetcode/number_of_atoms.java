package Leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Phaser;

public class number_of_atoms {
    //leetcode hard

    public static void main(String[] args) {

        HashMap<String, Integer> map = new HashMap<>();
        map.put("Mg", 1);
        map.put("H", 2);
        map.put("O", 2);
        StringBuilder s = new StringBuilder();
        int index = 0;
        for (Map.Entry entry : map.entrySet()) {
            int value = (Integer) entry.getValue();
            s.append(entry.getKey());
            if(value != 1) {
                s.append(value);
            }
        }
        System.out.println(s);
    }
}
