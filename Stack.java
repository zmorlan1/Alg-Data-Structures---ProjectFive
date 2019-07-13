/*                                                                             
ZacharyMorlan_02 exercise creating an array-based implementaition methods
of creating an empty stack push and pop onto stack and peek at the top of 
the stack

@author Zachary Morlan
CS exercise/ Classwork
Mac OS, Macbook, JGrasp

metathesis- a change of place or condition

You know, God gave me a gift to do other things besides play the game 
of basketball.
LeBron James Born: December 30, 1984 
*/
import java.util.Arrays;
import java.util.EmptyStackException;

public final class Stack<T> implements StackInterface<T> 
{
   
   private T[] stack;     // Array of Stack Entries 
   private int topIndex;   // Index of op Entry 
   private boolean integrityOK;
   private static final int DEFAULT_CAPACITY = 50;
   private static final int MAX_CAPACITY = 10000;
   
   public Stack() {
      this(DEFAULT_CAPACITY);
   }// End default constructor
	// ************************************************************************

	/**
	 * creates the array stack with some initial capacity for objects 
	 * 
	 * @param initialCapcity of the array stack
	 * 
	 * @return none.
	 */  
   public Stack ( int initialCapacity) 
   {
      
      integrityOK = false;
      checkCapacity(initialCapacity);
      
      T[] tempStack = (T[])new Object[initialCapacity];
      stack = tempStack;
      topIndex = -1;
      integrityOK = true;
      
   }// End constructor
  	// ************************************************************************

	/**
	 * Adds a new entry to this collection
	 * 
	 * @param newEntry  The object to be added to the collection
	 * 
	 * @return none.
	 */
   public void push(T newEntry) {
   
      checkIntegrity();
      ensureCapacity();
      stack[topIndex + 1] = newEntry;
      topIndex++;
   }// End push
// ************************************************************************

	/**
	 * takes the top entry from the top of the stack
	 * 
	 * @param none
	 * @return top entry in the stack.
    * @throw StackException if the Stack isEmpty is true
	 */
   public T pop() {
    
      if (isEmpty()) {
         
         throw new EmptyStackException();
    }  
    else {
    
      T top = stack[topIndex];
      stack[topIndex] = null;
      topIndex--;
      return top;
    }
   }// End pop
// ************************************************************************

	/**
	 * takes a look at the top entry on the stack without affecting the stack
	 * 
	 * @param none
	 * 
	 * @throw Empty Stack Exception if the method isEmpty is true for the stack
	 */
   public T peek() {
   
      checkIntegrity();
      
      if (isEmpty()){
      
         throw new EmptyStackException();
      }
      else {
      
         return stack[topIndex];
      }
   }// End peek
// ************************************************************************

	/**
	 * checks to see if the stack is empty 
	 * 
	 * @param none
	 * @return True if the stack is empty. 
	 */
   public boolean isEmpty(){
     
      if(topIndex == -1) {
         return true;
      }
      else {
      
         return false;
      }
   }// End isEmpty
   	// ************************************************************************

	/**
	 * clears stack by placing top index back at -1
	 * 
	 * @param none.
	 * @return none
	 */
   public void clear(){
      
       topIndex = -1;
       
   }// End clear
// ************************************************************************

	/**
	 * ensures Stack capacity by increasing length of stack
	 * 
	 * @param none
	 * @return none
	 */
   private void ensureCapacity(){
   
      if (topIndex == stack.length - 1) {
         int newLength = 2 * stack.length;
         checkCapacity(newLength);
         stack = Arrays.copyOf(stack, newLength);      
      }
   }// End ensurecapacity
// ************************************************************************
	/**
	 * checks to see if the list is greater than the max capacity 
	 * 
	 * @param capacity of the array stack
	 * @throws exception if the capacity is greater than the MAX_CAPACITY 
	 */ 
   private void checkCapacity(int capacity){
      if (capacity > MAX_CAPACITY){
         throw new IllegalStateException(" Attempt to create stack " +
                                         " that exceeds allowed " + 
                                         "maximum of " + MAX_CAPACITY);
      }
   }// End check Capacity
// ************************************************************************
	/**
	 * Checks if the Integrity of the object is true
	 * 
	 * @param none
	 * @throws exeception if the integrity is false.
	 */
   private void checkIntegrity(){
      if (!integrityOK) {
         throw new SecurityException("Array object is corrupt.");
      }
   }// End check Integrity
}// End ArrayStack