package constructorAndMethodReferences;

public class Introduction {
/*
=====================================================
Method reference
We can have below type of method references
ClassName :: instance-methodName
ClassName :: static-methodName
Instance :: methodName

* It can be applicable where lambda expression is referring to method directly. ex String::toUpperCase()

======================================================
Constructor reference
We can have below type of constructor reference
ClassName :: new

* It can be used in reference to functional interfaces
example:
Supplier<Student> s = Student::new; //valid | and then we can do s.get() as many times as we want....

Student student = Student::new;     //invalid


Important:
reference change its behavior as per its implementation for example.
Supplier<Student> s = Student::new;                         //Supplier
Consumer<Student> consumer = System.out :: println;         //Consumer
Function<String, String> f1 =  String::toLowerCase;         //Function,
Function<Student, Double> stdGPA = Student::getGpa;         //Function

so now later this code can be plugged in as per requirement like map() methods can take an function to do something
*/
}
