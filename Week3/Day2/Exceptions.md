
Most programming languages have these. They're thrown when something goes so wrong that whatever was happening can't continue: bad input, missing file, division by zero, etc. Many languages have a way to handle these explicitly. In Java:

~~~java
try {
	// Code that throws Exception
} catch (Exception e) {
	// Moves to this block when Exception is thrown
}
~~~

## Stack Trace

When an exception is thrown, a lot of languages show what's called the "stack trace". It's a list of all the lines of code that ran right before the Exception. This helps trace where and why the error occurred.