public class TopperExistsException extends RuntimeException { // RuntimeException perché Unchecked
    public TopperExistsException() {
        super();
    }

    public TopperExistsException(String s) {
        super(s);
    }
}
