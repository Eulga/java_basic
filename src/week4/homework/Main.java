package week4.homework;

public class Main {
    public static void main(String[] args) {
        boolean check = true;
        while (check) {
            try {
                CalculatorApp.start();
                check = false;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                check = true;
//                throw new RuntimeException(e);
            }
        }
    }
}