/**
 * This class combines several methods with the end goal 
 * of converting an infix notation to a postfix notation
 * 
 * @author Mbami Luka + Zach Morlan
 *
 */
public class Postfix 
{	
		/**
		 * This method checks if a specified character is any of the valid 
		 * BIDMAS operators. 
		 * @param	character
		 * @return	true if the operator is valid + false if otherwise
		 */
	    private boolean isOperator ( char character) 
	    {
	        if ( character == '+' || character == '-' || character == '*' ||
	        		
	        	 character == '/' || character == '^' || character == '(' || 
	        	 
	        	 character == ')' 
	        	)
	        {
	        	return true;
	        }
	        
	        return false;
	    }

	    public int getPrecedence ( char character) 
	    {
	        if ( character == '+' || character == '-') 
	        {        
	            return 1;
	        }
	        else if ( character == '*' || character == '/')
	        {
	            return 2;
	        }

	        else if ( character == '^')
	        {
	            return 3;
	        }
	        return -1;
	    }

	    // Check if the specified character is an operand
	    public boolean isOperand ( char character) 
	    {
	        if (character >= 'a' && character <= 'z' || 
	        	character >= 'A' && character <= 'Z'
	           )
	        {
	        	return true;
	        }
	        return false;
	    }

	    public String convertToPostfix ( String infix) 
	    {
	        Stack<Character> stack = new Stack<Character>();
	        String postfix = "";
	        
	        char character;

	        for ( int i = 0; i < infix.length(); i++) 
	        {
	        	// pick each letter in infix string
	            character = infix.charAt(i);

	            // Then, check if character is an operand
	            // If so, it will be added to the postfix variable
	            if ( isOperand ( character)) 
	            {
	                postfix += ( character);
	            } 
	            else if ( character == '(') 
	            {
	                stack.push ( character);
	            }
	            // If current character is ‘)’, pop and output from stack
	            // when ‘(‘ is encountered we stop popping.
	            else if ( character == ')') 
	            {

	                while ( !stack.isEmpty() && stack.peek() != '(') 
	                {
	                	postfix += stack.pop();
	                }
	                if ( !stack.isEmpty() && stack.peek() != '(')
	                {
	                    return null;
	                }
	                else if ( !stack.isEmpty())
	                {
	                    stack.pop();
	                }
	            }
	            else if 
	            (isOperator ( character)) // operator encountered
	            {
	                if ( !stack.isEmpty() && 
	                	  getPrecedence (character) <= getPrecedence ( stack.peek())) 
	                {
	                	postfix += ( stack.pop());
	                }
	                stack.push ( character);
	            }
	        }

	        while ( !stack.isEmpty()) 
	        {
	        	postfix += ( stack.pop());
	        }
	        return postfix;
	    }
}
