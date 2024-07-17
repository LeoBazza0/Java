package Simulazioni.Esame2Jan;
public class LockException extends RuntimeException {
	public LockException(String s) {
		super(s);
	}

	public LockException() {
		super();
	}
}