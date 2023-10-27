// Java implementation of the approach
import java.util.*;

class GFG {

	// Function to find the reduced string
	public static String reduced_String(int k, String s)
	{

		// Base Case
		if (k == 1) {
			// all elements remove,send empty string
			return "";
		}

		// Creating a stack of type Pair
		Stack<Pair> st = new Stack<Pair>();

		// Length of the string S
		int l = s.length();
		int ctr = 0;

		// iterate through the string
		for (int i = 0; i < l; i++) {
			// if stack is empty then simply add the
			// character with count 1 else check if
			// character is same as top of stack
			if (st.size() == 0) {
				st.push(new Pair(s.charAt(i), 1));
				continue;
			}

			// if character at top of stack is same as
			// current character increase the number of
			// repetitions in the top of stack by 1
			if (st.peek().c == s.charAt(i)) {
				Pair p = st.peek();
				st.pop();
				p.ctr += 1;
				if (p.ctr == k) {
					continue;
				}
				else {
					st.push(p);
				}
			}
			else {
				st.push(new Pair(s.charAt(i), 1));
			}
		}

		// iterate through the stack
		// append characters in String

		StringBuilder output = new StringBuilder();

		while (st.size() > 0) {
			char c = st.peek().c;
			int cnt = st.peek().ctr;
			// If frequency of a character is cnt, then
			// append that character to cnt times in String
			while (cnt-- > 0)
				output.append(String.valueOf(c));
			st.pop();
		}
		output.reverse();
		return output.toString();
	}

	// Driver code
	public static void main(String[] args)
	{
		int k = 2;
		String st = "geeksforgeeks";
		String ans = reduced_String(k, st);
		System.out.println(ans);
	}

	// Pair Class
	static class Pair {
		char c;
		int ctr;
		Pair(char c, int ctr)
		{
			this.c = c;
			this.ctr = ctr;
		}
	}
}

// This Code has been contributed by shubhamm050402
