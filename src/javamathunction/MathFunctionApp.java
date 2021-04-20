package javamathunction;

@FunctionalInterface
//This Function Implemented IMathfunction interface
interface IMathFunction {
    int calculate(int a,int b) ;
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

        //Add & Multiply two numbers using lambda expression
        System.out.println("Addition is " + add.calculate(6,3));
        System.out.println("Multiplication is " + multiply.calculate(6,3));
        System.out.println("Division is " + divide.calculate(6,3));
        System.out.println("Substract is "+ substract.calculate(6 ,3));
    }
}
