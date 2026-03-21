package functions;

public class passing {
    public static void main(String[] args) {
        String name = "ADITYA";
        changename(name);
        System.out.println(name);
//  in case of primitives only pass by value is there
    }
    static void changename(String name) {
        name = name.toLowerCase();
        //  a new object is created rather
        //  than modifying the already existing object;
        // the string is a reference type
        //as the memory location is passed to the method unlilke in primitive types.
    }
}
