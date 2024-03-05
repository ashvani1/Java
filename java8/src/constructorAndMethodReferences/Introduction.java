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
Supplier<Student> s = Student::new; //valid
Student student = Student::new;     //invalid
*/
}
