import java.util.Scanner;

public class Decipher {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);  //Initiating the Scanner
		// Getting the message to encode
		System.out.println("Enter a message to encode or decode:");
		String message = scan.nextLine();
		String output = "";
		// Setting the encoding key
		// Since English alphabet length is 26, a key value of 26 is equivalent a 0
		System.out.println("Enter a secret key (-25 to 25):");
		int keyVal = Integer.parseInt(scan.nextLine());  //Store the key value in a int variable
		char key = (char) keyVal;  // Casting the integer key value entered to a char

		//Encode just letters (not spaces)
		for ( int x = 0; x < message.length(); x++ ) {
			char input = message.charAt(x);
			// For uppercase letters
			if (input >= 'A' && input <= 'Z')
			{
				input += key;  //Encode by adding the key
				if (input > 'Z') //Check if the result is after 'Z'
					input -= 26; //Fix by subtracting 26 (English alphabet)
				if (input < 'A') //Check if the result is before 'A'
					input += 26; //Fix by adding 26 (English alphabet length)
			}
			// For lowercase letters
			else if (input >= 'a' && input <= 'z')
			{
				input += key;  //Encode by adding the key
				if (input > 'z') //Check if the result is after 'z'
					input -= 26; //Fix by subtracting 26
				if (input < 'a') //Check if the result is before 'a'
					input += 26; //Fix by adding 26
			}
			// For digits, only digits between -9 and 9
			else if (input >= '0' && input <= '9')
			{
				input += (keyVal % 10); // Using the integer version of key, just values between -9 and 9
				if (input > '9') //Check if the result is greater than 9
					input -= 10;
				if (input < '0')  //Check if the result is less than 0
					input += 10;
			}
			output += input;  // Output message
		}
		System.out.println(output); // Print the encoded message
		scan.close();  //Closing the Scanner
	}
}
