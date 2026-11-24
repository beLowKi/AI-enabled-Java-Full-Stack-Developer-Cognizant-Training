
## 1. What is the difference between throw and throws?

throw creates an Exception object and causes the current code block to be exited. throws declares that a method will throw certain Exception(s)

## 2. Why did the compiler force you to handle AttendanceShortageException but not InvalidMarksException?

AttendanceShortageException is a checked exception because it extends Exception and not RuntimeException. Thus, the compiler forces us to handle it.

## 3. When does the finally block run?

After the try and any catch blocks that may or may not trigger. It always runs unless the program is exited (System.exit) or the JVM somehow crashes during the try block.

## 4. Why is it better to check email == null than to catch NullPointerException?

The check allows the method itself to respond to the error rather than the caller. This produces more readable code in the main method.

## 5. Name one more custom exception the portal could use, and say whether it should be checked or unchecked.

It could check if attendance is greater than 100, which I believe is invalid because it's like a percentage, and throw an InvalidAttendanceException. Since AttendanceShortageException is checked, this one should be as well--especially since IllegalArgumentException isn't completely accurate. The problem is with a property of the Student rather than the argument itself.