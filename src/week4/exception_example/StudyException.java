package week4.exception_example;

public class StudyException {
    public static void main(String[] args) {
        OurClass ourClass = new OurClass();
//        ourCla|ss.thisMethodIsDangerous();

        try {
            // 1. 위험한 메소드의 실행을 "시도" 해 봅니다.
            // "시도" 해보는 코드가 들어가는 블럭입니다.
            ourClass.thisMethodIsDangerous();
        } catch (OurBadException e) {
            // 2. 예외가 발생하면, "잡아서" handling 합니다.
            // 예외가 발생하는경우 "handling" 하는 코드가 들어가는 블럭입니다.
            // 즉 try 블럭 내의 구문을 실행하다가 예외가 발생하면
            // 예외가 발생한 줄에서 바로 코드 실행을 멈추고
            // 여기 있는 catch 블럭 내의 코드가 실행됩니다.
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        } finally {
            // 3. 예외의 발생 여부와 상관없이, 실행시켜야 하는 코드가 들어갑니다.
            // 무조건 실행되는 코드가 들어가는 블럭입니다.
            System.out.println("예외 처리를 handling했음 정상 처리 되던, 예외가 발생하던 finally는 항상 실행됨");
        }
    }
}
