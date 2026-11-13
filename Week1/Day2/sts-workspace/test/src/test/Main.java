package test;

public class Main {
	
	public static String reverseString(String input) {
		String reversed = "";
		for (int i = input.length() - 1; i >= 0; i--) {
			reversed += input.charAt(i);
		}
		return reversed;
	}
	
	public static void main(String[] args) {
		var sout = System.out;
		String word = "Hello World!";
		
		sout.println("Original: " + word);
		sout.println("Reversed: " + reverseString(word));
	}

}