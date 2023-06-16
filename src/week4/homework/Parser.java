package week4.homework;

import java.util.regex.Pattern;

public class Parser {
    private static final String OPERATION_REG = "[+\\-*/]";
    private static final String NUMBER_REG = "^[0-9]*$";

    private final Calculator calculator = new Calculator();

    public void parseFirstNum(String firstInput) throws BadInputException {
        if (Pattern.matches(NUMBER_REG, firstInput))
            calculator.setFirstNumber(Integer.parseInt(firstInput));
        else throw new BadInputException("숫자");
    }

    public void parseSecondNum(String secondInput) throws BadInputException {
        if (Pattern.matches(NUMBER_REG, secondInput))
            calculator.setSecondNumber(Integer.parseInt(secondInput));
        else throw new BadInputException("숫자");
    }

    public void parseOperator(String operationInput) throws BadInputException {
        if (Pattern.matches(OPERATION_REG, operationInput))
            switch (operationInput) {
                case "+":
                    calculator.setOperation(new AddOperation());
                    break;
                case "-":
                    calculator.setOperation(new SubtractOperation());
                    break;
                case "*":
                    calculator.setOperation(new MultiplyOperation());
                    break;
                case "/":
                    calculator.setOperation(new DivideOperation());
                    break;
            }
        else throw new BadInputException("연산자");
    }

    public double executeCalculator() {
        return calculator.calculate();
    }
}
