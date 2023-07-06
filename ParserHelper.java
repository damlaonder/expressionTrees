package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ParserHelper {

	    public static LinkedList<String> parse(char[] input) {
		    LinkedList<String> parsed = new LinkedList<String>();
		    for (int i = 0; i < input.length; ++i) {
		        char c = input[i];
		        if (Character.isDigit(c)) {
		            String number = input[i] + "";
		            for (int j = i + 1; j < input.length; ++j) {
		                if (Character.isDigit(input[j])) {
		                    number += input[j];
		                    i = j;
		                } else {
		                    break;
		                }
		            }
		            parsed.add(number);
		        } else if (c == '*' || c == '/' || 
		                   c == '+' || c == '^' || 
		                   c == '-' || c == '(' || c == ')') {
		            parsed.add(c + "");
		        }
		    }
		    return parsed;
		}
	}
