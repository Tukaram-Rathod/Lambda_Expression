package javamathunction;

@FunctionalInterface
//This Function Implemented IMathfunction interface
interface IMathFunction {
    int calculate(int a,int b) ;
    static void printResult(int a,int b,String function,IMathFunction fobj){
        System.out.println("Result of "+function+"is "+fobj.calculate(a, b));
    }
}
public class MathFunctionApp {
    public static void main(String[] args) {

        //Syntax of Lambda Expression
        //Lambda Expression for multiplicaion ,addition,substraction
        // and division  for two parameters.
        IMathFunction add = Integer::sum;
        IMathFunction multiply = (x,y)-> x * y;
        IMathFunction divide = (int x, int y ) -> x /y;
        IMathFunction substract = (x , y)-> x- y;

       //Passing Lambda Expression as Function Parameter to Print Result using Static Function
        IMathFunction.printResult(6,3 ,"Addition",add);
        IMathFunction.printResult(6,3 ,"Multiplication",multiply);
        IMathFunction.printResult(6,3 ,"Division",divide);
        IMathFunction.printResult(6,3 ,"Substraction",substract);

    }
}
