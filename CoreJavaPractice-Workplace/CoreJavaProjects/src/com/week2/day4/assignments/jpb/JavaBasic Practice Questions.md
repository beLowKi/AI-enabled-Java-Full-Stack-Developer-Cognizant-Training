
The Java project for each this assignment is inside ../JavaBasicsPractice. I've named the class where I coded each challenge Q1.java, Q2.java, etc. 

## Level 1: Beginner

### Q1. Reverse a Number Without Using String

(code only)

### Q2. Find the Output - Type Casting Challenge

Predicted Output:

13    (narrowing conversion of 10 + 3.5 = 13.5 to int which shaves 0.5)
70    (code of char 'A' is 65; adding 5 would make it 70)
F      (casting 70 to char would give F because that's its code)

### Q3. -> Q6

(code only)

### Q.7 Understand Pass by Value in Java

Predict the output of the following program

~~~java
public class Test {

    static void modify(int x) {
        x = 100;
    }

    static void modifyArray(int[] arr) {
        arr[0] = 100;
    }

    public static void main(String[] args) {

        int a = 10;
        int[] numbers = {10, 20, 30};

        modify(a);
        modifyArray(numbers);

        System.out.println(a);
        System.out.println(numbers[0]);
    }
}
~~~


A: 

10     (Pass by value of a primitive; 'a' is unchanged)
100   (Pass by value of array reference; its first element is changed)

### Q8. - Q9.

(code only)

### Q10. Predict the String Output

Predict the output and explain the behavior.

~~~java
public class StringTest {

    public static void main(String[] args) {

        String s1 = "Java";
        String s2 = "Java";

        String s3 = new String("Java");

        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1.equals(s3));

        StringBuilder sb = new StringBuilder("Java");
        sb.append(" Programming");

        System.out.println(sb);
        System.out.println(s1);
    }
}
~~~

A:

true                   (s1 and s2 are set to literals, so their values, which are equal, are compared)
false                  (s3 was init using new String, so the == is looking at its ref/memory location)
true                   (String.equals always checks the literal string contents)
Java Programming    (sb.append adding " Programming" to init value)
Java                           (s1 is unchanged, so still prints "Java")

### Q11. - Q15.

(code only)

