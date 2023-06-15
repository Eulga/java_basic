package week3.homework;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator(new DivideOperation());
        System.out.println(calculator.calculate(10, 4));
        calculator.setCalculator(new AddOperation());
        System.out.println(calculator.calculate(10, 4));
    }
}