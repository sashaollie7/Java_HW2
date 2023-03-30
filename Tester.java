/**
 * This is a testing framework. Use it extensively to verify that your code is working
 * properly.
 */
public class Tester { 

	private static boolean testPassed = true;
	private static int testNum = 0;
	
	/**
	 * This entry function will test all classes created in this assignment.
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
	
	/* TODO - write a function for each class */
	// Each function here should test a different class. You should test ExpTokenizer as well.

	//BinaryOp
		testAddOp();
		testSubtract();
		testMulty();
		testDevide();
		testPow();
		testValueToken();
		testExpTokenizer();
		testTreeCalculator();


		//...

	//Calculators
		testStackCalculator();
		//...
		
		
		// Notifying the user that the code have passed all tests. 
		if (testPassed) {
			System.out.println("All " + testNum + " tests passed!");
		}
	}

	/**
	 * This utility function will count the number of times it was invoked. 
	 * In addition, if a test fails the function will print the error message.  
	 * @param exp The actual test condition
	 * @param msg An error message, will be printed to the screen in case the test fails.
	 */
	private static void test(boolean exp, String msg) {
		testNum++;
		
		if (!exp) {
			testPassed = false;
			System.out.println("Test " + testNum + " failed: "  + msg);
		}
	}

	/**
	 * Checks the AddOp class.
	 */
	private static void testAddOp() {
		AddOp op = new AddOp();
		test((op.toString().equals("+")), "The string + should be printed.");
		test((op.operate(1.0 , 2.5) == 3.5), "The answer should be 3.5 .");
		test((op.operate(1.0 , 4.0) == 5.0), "The answer should be 5 .");
		test((op.operate(-1.0 , 3.5) == 2.5), "The answer should be 2.5 .");
		test((op.operate(-1.0 , -3.5) == -4.5), "The answer should be -4.5 .");
		test((op.getPrecedence() == 1) , "The answer should be 1 .");


	}
	private static void testSubtract() {
		SubtractOp op = new SubtractOp();
		test((op.toString().equals("-")), "The string - should be printed.");
		test((op.operate(1.0, 2.5) == -1.5), "The answer should be -1.5 .");
		test((op.operate(4.0, 4.0) == 0.0), "The answer should be 0 .");
		test((op.operate(-1.0, 3.5) == -4.5), "The answer should be -4.5 .");
		test((op.operate(-1.0, -3.5) == 2.5), "The answer should be 2.5 .");
		test((op.operate(6.0, 1.0) == 5.0), "The answer should be 5.0 .");
		test((op.getPrecedence() == 1.0) , "The answer should be 1 .");


	}
	private static void testMulty() {
		MultiplyOp op = new MultiplyOp();
		test((op.toString().equals("*")), "The string * should be printed.");
		test((op.operate(1.0, 2.5) == 2.5), "The answer should be 2.5 .");
		test((op.operate(4.0, 4.0) == 16.0), "The answer should be 16 .");
		test((op.operate(-1.0, 3.5) == -3.5), "The answer should be -3.5 .");
		test((op.operate(-1.0, -3.5) == 3.5), "The answer should be 3.5 .");
		test((op.operate(6.0, 0.0) == 0.0), "The answer should be 0.0 .");
		test((op.getPrecedence() == 2.0) , "The answer should be 2 .");

	}

	private static void testDevide() {
		DivideOp op = new DivideOp();
		test((op.toString().equals("/")), "The string / should be printed.");
		test((op.operate(1.0, 2.5) == 0.4), "The answer should be 0.4 .");
		test((op.operate(4.0, 4.0) == 1.0), "The answer should be 1 .");
		test((op.operate(-7.0, 3.5) == -2.0), "The answer should be -2.0 .");
		test((op.operate(0.0, -3.5) == 0.0), "The answer should be 3.5 .");
		test((op.operate(6.0, -2.0) == -3.0), "The answer should be 0.0 .");
		test((op.getPrecedence() == 2.0) , "The answer should be 2 .");

	}

	private static void testPow() {
		PowOp op = new PowOp();
		test((op.toString().equals("^")), "The string ^ should be printed.");
		test((op.operate(2.0, 1.0) == 2.0), "The answer should be 2.0 .");
		test((op.operate(4.0, 2.0) == 16.0), "The answer should be 1 .");
		test((op.operate(-2.0, 3) == -8.0), "The answer should be -8.0 .");
		test((op.operate(0.0, 8.0) == 0.0), "The answer should be 0.0 .");
		test((op.operate(2.0, -2.0) == 0.25), "The answer should be 0.25 .");
		test((op.getPrecedence() == 3.0) , "The answer should be 3 .");

	}

	private static void testValueToken() {
		ValueToken op = new ValueToken(-1.0);
		test((op.getValue() == -1.0), "The answer should be -1.0 .");

	}

	private static void testExpTokenizer() {
		ExpTokenizer op = new ExpTokenizer("( 1 + -2 ) / 3 )");
		test((op.nextElement() instanceof OpenBracket), "The answer should be ( .");
		ValueToken next_val = new ValueToken(1);
		test((((ValueToken)op.nextElement()).is_equal(next_val)), "The answer should be 1 .");
		test(((op.nextElement()).toString() == ("+")), "The answer should be + .");
		ValueToken next_val1 = new ValueToken(-2);
		test((((ValueToken)op.nextElement()).is_equal(next_val1)), "The answer should be -2 .");
		test((op.nextElement().toString() == ")"), "The answer should be ) .");
		test((op.nextElement().toString() == "/"), "The answer should be / .");
		ValueToken next_val2 = new ValueToken(3);
		test((((ValueToken)op.nextElement()).is_equal(next_val2)), "The answer should be 3 .");
		test((op.hasMoreElements()), "The answer should be true .");
		test((op.nextElement().toString() == ")"), "The answer should be ) .");
		test((!op.hasMoreElements()), "The answer should be false .");

	}

	/**
	 * Checks the StackCalculator class.
	 */

	private static void testTreeCalculator() {
		String str1 = "( ( 4 + ( 3 * 7 ) ) - ( 5 / ( 1 + 4 ) ) ) + 6";

		StackCalculator pc = new StackCalculator();

		TreeCalculator tree = new TreeCalculator();
		String postExp4 = pc.infixToPostfix(str1);
		double result = tree.evaluate(postExp4);
		test( result == 30, "The output of \"( ( 4 + ( 3 * 7 ) ) - ( 5 / ( 1 + 4 ) ) ) + 6 -\" should be 30 instead of"+ result);

		TreeCalculator tree2 = new TreeCalculator();
		String str2 = "( ( 4 + ( 3 * -7 ) ) - ( -5 / ( 1 + 4 ) ) ) + 6";
		String postExp2 = pc.infixToPostfix(str2);
		double result2 =  tree2.evaluate(postExp2);
		test( result2 == -10, "The output of \"( ( 4 + ( 3 * -7 ) ) - ( -5 / ( 1 + 4 ) ) ) + 6\" should be -10 "+ result2);
		String result3 = tree2.getInfix();
		test(result3.equals("( ( ( 4.0 + ( 3.0 * -7.0 ) ) - ( -5.0 / ( 1.0 + 4.0 ) ) ) + 6.0 )"), "The output of \"\"4.0 3.0 -7.0 * + -5.0 1.0 4.0 + / - 6.0 +\"\" should be \"( ( ( 4.0 + ( 3.0 * -7.0 ) ) - ( -5.0 / ( 1.0 + 4.0 ) ) ) + 6.0 )\" instead of" + tree2.getInfix());
		String result4 = tree2.getPostfix();
		test(result4.equals("4.0 3.0 -7.0 * + -5.0 1.0 4.0 + / - 6.0 +"), "The output should be 4.0 3.0 -7.0 * + -5.0 1.0 4.0 + / - 6.0 + instead of " + result4);

		TreeCalculator tree3 = new TreeCalculator();
		StackCalculator pc3 = new StackCalculator();
		String str3 = "( ( 4 + ( 3 ^ 2 ) ) + ( -5 / ( 1 + 4 ) ) ) ^ 2";
		String postExp3 = pc3.infixToPostfix(str3);
		double result5 = tree3.evaluate(postExp3);
		test( result5 == 144, "The output of \"( ( 4 + ( 3 ^ 2 ) ) + ( -5 / ( 1 + 4 ) ) ) ^ 2\" should be 144 instead of "+ result5);
		String result6 = tree3.getPrefix();
		test(result6.equals("^ + + 4.0 ^ 3.0 2.0 / -5.0 + 1.0 4.0 2.0"), "The output of ( ( 4 + ( 3 ^ 2 ) ) + ( -5 / ( 1 + 4 ) ) ) ^ 2 should be + - + 4.0 ^ 3.0 2.0 / 5.0 + 1.0 2.0 ^ instead of " + result6);



	}


	private static void testStackCalculator() {

		StackCalculator pc = new StackCalculator();

		String postExp = pc.infixToPostfix("2 + 3");
		test(postExp.equals("2.0 3.0 +") , "The output of \"2 3 -\" should be  2.0 3.0 +");
		double result = pc.evaluate(postExp);
		test(result ==  5.0, "The output of \"2 3 -\" should be 5.0");


		String postExp2 = pc.infixToPostfix("( ( 4 + ( 3 * -7 ) ) - ( -5 / ( 1 + 4 ) ) ) + 6");
		test(postExp2.equals("4.0 3.0 -7.0 * + -5.0 1.0 4.0 + / - 6.0 +") , "The output of \"2 3 -\" should be  2.0 3.0 +");
		double result2 = pc.evaluate(postExp2);
		test(result2 == -10.0, "The output of \"\"4.0 3.0 -7.0 * + -5.0 1.0 4.0 + / - 6.0 +\" -\" should be -10.0 instead got " + result2);

		String postExp3 = pc.infixToPostfix("( ( 4 + ( 3 ^ 2 ) ) + ( -5 / ( 1 + 4 ) ) ) ^ 2");
		test(postExp3.equals("4.0 3.0 2.0 ^ + -5.0 1.0 4.0 + / + 2.0 ^") , "The output of \"2( ( 4 + ( 3 ^ 2 ) ) + ( -5 / ( 1 + 4 ) ) ) ^ 2\" should be  4.0 3.0 2.0 ^ + -5.0 1.0 4.0 + / + 2.0 ^");
		double result3 = pc.evaluate(postExp3);
		test(result3 == 144.0, "The output of \"\"4.0 3.0 -7.0 * + -5.0 1.0 4.0 + / - 6.0 +\" -\" should be 144.0 instead got " + result2);

		String postExp4 = pc.infixToPostfix("( 4 ^ 2 ^ 3 ");
		test(postExp4.equals("4.0 2.0 ^ 3.0 ^") , "The output of \"( 4 ^ 2 ) ^ 3\" should be 4.0 2.0 ^ 3.0 ^");
		double result4 = pc.evaluate(postExp4);
		test(result4 == 4096, "The output of \"\"4.0 2.0 ^ 3.0 ^\" -\" should be 4096.0 instead got " + result4);

		String postExp5 = pc.infixToPostfix("( 4 ^ 0 ^ 3 ");
		test(postExp5.equals("4.0 0.0 ^ 3.0 ^") , "The output of \"( 4 ^ 2 ) ^ 3\" should be 4.0 2.0 ^ 3.0 ^");
		double result5 = pc.evaluate(postExp5);
		test(result5 == 1, "The output of \"\"4.0 2.0 ^ 3.0 ^\" -\" should be 1.0 instead got " + result5);

		String postExp6 = pc.infixToPostfix("4 * 3 + 0 ^ 3");
		test(postExp6.equals("4.0 3.0 * 0.0 3.0 ^ +") , "The output of \"4.0 3.0 * 0.0 3.0 ^ +\" should be 4.0 3.0 * 0.0 3.0 ^ + instead of" + postExp6);
		double result6 = pc.evaluate(postExp6);
		test(result6 == 12, "The output of \"\"4.0 2.0 ^ 3.0 ^\" -\" should be 12.0 instead got " + result6);

		String postExp7 = pc.infixToPostfix("4 * 3 + 2 ^ 3 / 2");
		test(postExp7.equals("4.0 3.0 * 2.0 3.0 ^ 2.0 / +") , "The output of \"4.0 3.0 * 2.0 3.0 ^ +\" should be 4.0 3.0 * 2.0 3.0 ^ +4.0 3.0 * 2.0 3.0 ^ 2.0 / + instead of" + postExp7);
		double result7 = pc.evaluate(postExp7);
		test(result7 == 16, "The output of \"\"4.0 3.0 * 2.0 3.0 ^ 2.0 / +\" -\" should be 16.0 instead got " + result7);

		String postExp8 = pc.infixToPostfix("40 - ( 12 * 2 ) / ( 2 - 1 )");
		test(postExp8.equals("40.0 12.0 2.0 * 2.0 1.0 - / -") , "The output of \"40 - ( 12 * 2 ) / ( 2 - 1 )\" should be 40.0 12.0 2.0 * 2.0 1.0 - / -  instead of " + postExp8);
		double result8 = pc.evaluate(postExp8);
		test(result8 == 16, "The output of \"\"4.0 3.0 * 2.0 3.0 ^ 2.0 / +\" -\" should be 16.0 instead got " + result8);


	}




	}