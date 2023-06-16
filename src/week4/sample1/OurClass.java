package week4.sample1;

public class OurClass {
    private final boolean just = true;

    // throws : 던지다 (=예외를 던지다 / 발생시키다)
    // 위험할 수 있다는 flag를 throws로 명시한 것
    // 그냥 호출될 경우 예외가 발생한다.
    // 예외처리를 꼭 해야함
    public void thisMethodIsDangerous() throws OurBadException {
        // custom logic
        // custom logic
        // custom logic
        if (just) {
            throw new OurBadException();
        }
    }
}
