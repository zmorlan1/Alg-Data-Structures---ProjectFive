/**
 * This class reads several lines of infix expressions from an input file, 
 * converting them into their respective postfix expressions.
 * 
 * @author Mbami Luka + Zach Morlan
 *
 */
public class MbamiLuka_05 
{

	public static void main(String[] args) 
	{
		Postfix expression = new Postfix();
		
		// testing
		System.out.println
		(expression.convertToPostfix ("a+b*(c^d-e)^(f+g*h)-i"));

	}

}
