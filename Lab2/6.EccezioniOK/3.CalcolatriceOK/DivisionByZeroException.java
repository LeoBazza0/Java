public class DivisionByZeroException extends ArithmeticException {

    public DivisionByZeroException() {
        super();
    }

    public DivisionByZeroException(String s) {
        super(s);
    }
 // si poteva mettere una normale IllegalArgumentExeption, ma così ha un nome più significativo 
}
