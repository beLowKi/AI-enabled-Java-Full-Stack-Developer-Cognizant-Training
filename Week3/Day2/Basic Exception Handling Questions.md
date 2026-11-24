
### 1. What is an exception in Java?

An Exception is an object used to represent unexpected/undesired occurrences that interrupt a program's normal functions. This includes bad input, missing files, issues connecting with a database, etc.

### 2. What is exception handling, and why is it required?

Exception handling is when code anticipates when an Exception might be thrown and, instead of crashing, has a more graceful response like an error message. It's required for reliable software to handle whatever might happen while they're running and prevent users from getting frustrated over a crashing program.

### 3. What is the difference between an error and an exception?

Exceptions are made to be caught while an Error is something so severe that most apps shouldn't account for it. For example, when one of the program's threads is stopped by some external influence.

### 4. What is the difference between a compile-time error and a runtime error?

A compile-time error prevents .java files from being converted to .class files which are run in the JVM. They're also what IDEs like Eclipse are better at identifying. A runtime error won't occur until the program is already compiled, running, and the erroneous bit of code is visited.

### 5. Explain the Java exception hierarchy.

Exception hierarchy refers to the class tree of exceptions and errors. It starts at their shared base class, Throwable, and branches out to subclasses like ArithmeticException and InternalError. The further down the hierarchy, the more specific the exception/error. 

### 6. What is the difference between checked and unchecked exceptions?

Checked Exceptions are checked at compile-time. They need to be declared on functions that throw them using the "throws" keyword or handled by a try-catch statement or else the program won't compile. Unchecked exceptions occur at runtime and don't need to be handled or declared to compile.

### 7. Give examples of checked exceptions in Java.

SQLException when SQL-related exceptions are thrown, FileNotFoundException when an input file doesn't exist, and ClassNotFoundException if an unknown class is referenced.

### 8. Give examples of unchecked exceptions in Java.

ArithmeticException when dividing by zero, NullPointerException when trying to call methods of a null Object, ArrayIndexOutOfBoundsException when attempting to access an index that an array does not have.

### 9. What is the difference between Exception and RuntimeException?

RuntimeException is a subclass which extends Exception. It's unchecked, so methods which throw it do not need to handle or declare it.

### 10. What is the parent class of all exceptions and errors in Java?

Throwable

### 11. Can we handle an exception without using a try-catch block?

No, but you could declare it

### 12. What happens when an exception is not handled?

Unexpected behavior and most likely a program crash

### 13. Can we have multiple catch blocks?

Yes

### 14. Can we write a try block without a catch block?

No

### 15. Can we write a catch block without a try block?

No

## try, catch and finally Questions

### 16. Explain the purpose of try, catch, and finally.

try and catch are the base keywords of try-catch statements which are use for Exception handling. try defines a block of code that's expected to throw an Exception, and each catch clause defines which Exception(s) to not escalate and a block to execute instead. The finally keyword is an optional component of try-catch statements which defines a code block that almost always executes after the try block regardless of whether an Exception was thrown. 

### 17. What is the difference between final, finally, and finalize()?

final declares a variable as constant, finally is a keyword for try-catch statements, and finalize is an Object method used to free its memory.

### 18. Is the finally block always executed?

No. 

### 19. In which situations might the finally block not execute?

The only 2 circumstances in which it won't execute is if System.exit is called or if there's an Error with the JVM whilst inside the try block. Uncaught Exceptions and return statements do not stop the finally block from executing.

### 20. Can we write multiple finally blocks?

No

### 21. Can we write a return statement inside a finally block?

Yes, but IDEs like Eclipse may give a warning

### 22. What happens if an exception occurs inside the finally block?

It behaves like a normal Exception and prevents further code from running.

### 23. Can we have a try block inside another try block?

Yes

### 24. What is nested try-catch?

A try-catch statement inside of a try-catch statement

### 25. What happens if an exception occurs in the catch block?

Finally block still runs, but it's treated as an uncaught exception--escalating to a potential crash.

### 26. Can a single try block have multiple catch blocks?

Yes

### 27. What is the correct order of multiple catch blocks?

If any of the catch blocks' Exceptions extend one another, the subclass(es) should be first. Otherwise, due to polymorphism, the base class's catch would prevent subclass Exceptions' dedicated catch statements from being reached. In that case, the code would actually fail to compile because of unreachable code.

### 28. Why should the parent exception class be placed after the child exception class?

🡑

### 29. What is multi-catch in Java?

When one catch statement is catching multiple types of Exceptions. For example, one statement can catch all ArithmeticExceptions and SQLExceptions

### 30. Can we use System.exit(0) inside a try block? Will finally execute?

Yes, and it will prevent finally from executing

## throw and throws Questions

### 31. What is the difference between throw and throws?

throw creates an Exception object and activates it. If not caught then and there, then it's propagated to wherever its method was called and travels from there. throws is used to declare what Exceptions a method throws.

### 32. Can we throw an exception manually?

Yes using "throw"

### 33. Can we use multiple exceptions with the throws keyword?

No

### 34. Can we use throw and throws together?

Not in the same context, but yes. Inside a method's definition, it can use "throw". In it's declaration, it can use "throws" to let callers know about that Exception.

### 35. Can we throw a checked exception?

Yes

### 36. Can we throw an unchecked exception?

Yes

### 37. Can a method declare an exception without actually throwing it?

Yes

### 38. Can the main method declare throws Exception?

Yes

### 39. What happens when a method throws an exception?

It's thrown to the method caller.

### 40. Can we rethrow an exception from a catch block?

Yes

## Custom Exception Questions

### 41. What is a user-defined exception?

A user-made class that extends Exception. It can be thrown and caught like any other Exception.

### 42. How do you create a custom checked exception?

Extend the base Exception class

### 43. How do you create a custom unchecked exception?

Extend RuntimeException

### 44. What is the difference between extending Exception and RuntimeException?

Extending Exception will create a checked Exception that the compiler will require you handle or declare in the method throwing it. Otherwise, you get an unchecked exception.

### 45. When should we create custom exceptions?

Anytime you want to define program-specific fail states like if you have an Employee class with a salary property that you don't want to accept negative values. This gives you more control and information than a catch-all IllegalArgumentException.

### 46. Can a custom exception have a constructor?

Yes

### 47. How do you pass a custom error message to an exception?

In the constructor, pass a string

### 48. Can we create multiple custom exceptions in a single application?

Yes

## Advanced Exception Handling Questions

### 49. What is exception propagation?

Exception propagation is how the "responsibility" of thrown Exceptions gets continuously escalated until caught by something. For example, if a Dog object is created inside the main method and throws an Exception when its "bark" method is called, it's first in the "bark method". If it isn't caught, it then goes to the main method where it was called for that Dog object. If not caught there, it will continue to escalate until it reaches the JVM which stops the program and prints the stack trace.

### 50. Explain the concept of exception chaining.

This is when one Exception is associated with another, commonly as its cause. For example, you might have a method that performs some backend operation with a database that you'd like to throw a custom BackendException for failures. You may want to include if, say, an ArithmeticException is what caused the BackendException to be thrown.

### 51. What is the difference between getMessage() and toString()?

getMessage is an Exception method that returns its custom message--usually set during construction--while toString is an inherited Object method.

### 52. What is a stack trace?

A stack trace shows all the lines that led up to an Exception or Error. This often includes the file, line number, and method call, and is used to trace where and why a program failure happened.

### 53. What is the purpose of printStackTrace()?

It displays the stack trace which can be used to analyze where and why an Exception or Error was thrown.

### 54. What is try-with-resources?

A variation on a try-catch statement that allows for the construction and automatic closing of objects. The main example is for file IO. You can create all the object required to read a file inside a statement that can also catch any Exceptions (like IOException) and will call its "close" method to free the file for use by other objects or programs.

### 55. What is the advantage of try-with-resources over finally?

Many closeable objects like FileInputStream can throw an Exception when closing, so you'd have to handle that inside of the finally block. This produces bloated, unreadable code very quickly when handling multiple Closeables, and a try-with-resources helps to reduce secondary code like that

### 56. What is the AutoCloseable interface?

It's what classes must implement to function in try-with-resources statements.

### 57. What happens if an exception occurs while closing a resource?

That exception interrupts any further code if not caught

### 58. What are suppressed exceptions?

Exceptions who were thrown, caught, and added to another Exception that then is thrown. They're associated with the Exception that called "addSuppressed" as reasons why it was thrown.

### 59. What is the difference between IOException and FileNotFoundException?

FileNotFoundException is a subclass of IOException. All of the former are the latter, but not all of the latter are the former.

### 60. What are best practices for exception handling in Java?

All possible exceptions must be handled or declared.