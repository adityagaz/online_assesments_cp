package functions;

public class passingtwo {

    public static void main(String[] args) {
        int num = 1;
        changenum(num);
        System.out.println(num);
    }

    static void changenum(int num) {
        num +=1;
        //another object is created rather than modifying the same object
        /*
        When you pass a primitive type (like int) to a method in Java,
        you are passing a copy of the value. Inside the changenum method,
        num is a local copy of the original value.
        Modifying num inside the method does not affect the original variable.
         So, when you print num after calling changenum(num), it prints the original value 1,
         because the modification was done on the copy, not on the original variable.
         */
    }
}
