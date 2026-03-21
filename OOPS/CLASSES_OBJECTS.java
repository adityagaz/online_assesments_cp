package OOPS;

public class CLASSES_OBJECTS {

    //this is the main class
    public static void main (String [] args) {
        //create a new object of the class
        //donot pass anything into the object

        Student Aditya = new Student();
        //object name can be capital or a small letter
//        System.out.println(Aditya.name);
        //since we haven't passed anything in the constructor we will have default values
        Student mahek = new Student(1, 21, "Mahek" , 98.7f );

        //call a method greeting
        mahek.Greeting();

    }


}

class Student {
    int roll;
    int age;
    String name;
    float marks;
    boolean isVoter;

    //create a default constructor


    //this constructor will be called when the object is created with nothing passed as arguments

    Student() {
        //this will allot default values
        roll = 12;
        name = "Defalt name . please assign your name";
        age = 18;
        marks = 0.1f;
        isVoter = false;
    }

    /*Create a constructor which accepts many arguments coming from the
    arguments when the object was instantiated
    */
    Student(int roll , int age , String name , float marks) {
        this.name = name;
        this.age = age;
        //the keyword this is replaced by the objects name eg.. Aditya.name
        this.marks = marks;
        this.roll = roll;
        if(age >= 18) {
            this.isVoter = true;
        }
        else{
            this.isVoter = false;
        }
    }

    //now create a greeting function

    void Greeting() {
        System.out.println("Hi! I am "+ this.name);
    }
}
