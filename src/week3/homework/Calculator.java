package week3.homework;

public class Calculator {
    public AbstractOperation operation;

    Calculator(AbstractOperation operation) {
        this.operation = operation;
    }

    public void setCalculator(AbstractOperation operation) {
        this.operation = operation;
    }

    public double calculate(int firstNumber, int secondNumber) {
        return this.operation.operate(firstNumber, secondNumber);
    }
}