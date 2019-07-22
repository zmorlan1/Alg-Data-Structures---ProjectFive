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
		 * PEMDAS operators. 
		 * @param	character
		 * @return	true if the operator is valid + false if otherwise
		 */
	    private static boolean isOperator ( char character) 
	    {
	        if ( character == '+' || character == '-' || character == '*' ||
	        		
	        	 character == '/' || character == '^' || character == '(' || 
	        	 
	        	 character == ')' 
	        	)
	        {
	        	return true;
	        }
	        
	        return false;
	    }// End isOperator
//*****************************************************************************	
	    /**
	    * This method returns a value for the specific 
	    * PEMDAS operators. 
	    * @param	   character
	    * @return      1 if the value is a + or -
	    * @return	   2 if the value is a * or /
            * @return	   3 if the value is a ^
	    * @return     -1 if the value is invalid
	    */
	    public static int getPrecedence ( char character) 
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
	    } // End getPrecedence
//*****************************************************************************       
      /**
      * Method checks to see if the number of parentheses 
      * in the infix are the same amount
      * @param	String infix
      * @return	true if even amount of both parentheses
      */
      public boolean parenthesesCheck(String infix) {
         int left = 0;
         int right = 0;
         
            for(int i = 0; i < infix.length(); i++) {
               if(infix.charAt(i) == '(') {
               
                  left++;  
                   
               }// End if
               if(infix.charAt(i) == ')') {
               
                  right++;
                     
               }// End if
            }// End for loop 
            if(left == right){
               
               return true;
               
            } // End if
            else {
            
               return false;
            
            }// End else
       }// End parenthesesCheck
//*****************************************************************************
      /**
      * Method checks to see if the operands all have  
      * an operator next to them 
      * @param	   String infix 
      * @return	   true if no operands are next to eachother
      */
	public static boolean operandCheck ( String infix) {
	      
         String withoutSpaces = infix.replaceAll("\\s+","");
         char first;
         char second;
         
         for(int i = 0; i < withoutSpaces.length() - 1; i++) {
            
            first = withoutSpaces.charAt(i);
            second = withoutSpaces.charAt(i+1);
            
            if(isOperand(first) && isOperand(second)){
               return false;
            }// End if             
         }// End for loop 
         return true;
	 } // End operandCheck
//*****************************************************************************       
	    /**
	    * This method checks if a specified character is within a specific
       * range of characters  
	    * @param	character
	    * @return	true 
	    */
	    public static boolean isOperand ( char character) 
	    {
	        if (character >= 'a' && character <= 'z' || 
	        	character >= 'A' && character <= 'Z'
	           )
	        {
	        	return true;
	        }
	        return false;
	    } // End isOperand
//*****************************************************************************       
	    /**
	    * This method converts a string to a 
            * postfix form  
	    * @param	String characters 
	    * @return	String postfix form initial String
	    */
	    public static String convertToPostfix ( String infix) 
	    {
	        ArrayStack<Character> stack = new ArrayStack<Character>();
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
	            } // End if 
	            else if ( character == '(') 
	            {
	                stack.push ( character);
	            } // End else if
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
	        }// End for loop

	        while ( !stack.isEmpty()) 
	        {
	        	postfix += ( stack.pop());
	        
           } // End while
           return postfix;
      } // end convertToPostfix
   
}// End postfix Class
