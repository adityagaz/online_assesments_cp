package functions;

public class basic {

    public static void main(String[] args) {
        String message  = greet().strip();
        System.out.println(message);
    }
    static  String greet() {
        return "    hello world";
    }
}
