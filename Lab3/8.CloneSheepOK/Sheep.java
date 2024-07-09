//Grazie a Nicola Montagnese per il codice

import java.util.ArrayList;
import java.util.InputMismatchException;

public class Sheep implements Cloneable {
	// OVERVIEW: it models a a sheep with a its dna and a unique name
	// note this class is immutable, it doesn't allow manipolators methods
	// if an istance of the class is created it'll be a new one or a clone
	// attributes are therefore final
	final private ArrayList<String> dna;
	final private String nome;

	// COSTRUTTORE
	public Sheep(ArrayList<String> dna, String nome) throws NullPointerException, IllegalArgumentException {
		// MODIFIES: this statements
		// EFFECTS: it creates an unique istance of a sheep
		// note if dna is null, or nome is null or is empty, it throws respectively
		// nullpointer or illegal exception

		if (dna == null)
			throw new NullPointerException("Dna cannot be empty");

		if (nome.equals("") || nome == null)
			throw new InputMismatchException("Name must be declared");

		this.dna = (ArrayList<String>) (dna.clone());
		this.nome = nome;
		assert repOk();
	}

	// METODI:
	public ArrayList<String> getDna() {
		return (ArrayList<String>) this.dna.clone();
	}

	public String getNome() {
		return this.nome;
	}

	public String leggiCromosoma(int indice) throws InputMismatchException {
		// EFFECTS: it returns a String of cromosoma at the indice indicated
		// if indice is < = 0 it throws an InputMismatchException
		if ((indice < 0) || (indice >= this.dna.size()))
			throw new InputMismatchException("indice fuori dal range del dna");

		return this.dna.get(indice);
	}

	public void sostituisciCromosoma(String cromosoma, int indice) throws InputMismatchException {
		// MODIFIES: this
		// EFFECTS: replaces dna at indice with cromosoma
		// throws InputMismatchException if indice is out of array boundaries
		if ((indice <= 0) || (indice >= this.dna.size()))
			throw new InputMismatchException("indice fuori dal range del dna");

		if (cromosoma.equals("") || cromosoma == null)
			throw new InputMismatchException("Name must be declared");
		this.dna.set(indice, cromosoma);
	}

	public boolean repOk() {
		if (this.dna == null)
			return false;

		if (this.nome.equals("") || this.nome == null)
			return false;

		return true;
	}

	// OVERRIDE
	@Override
	public boolean equals(Object o) {
		if (o == null)
			return false;

		if (!(o instanceof Sheep))
			return false;

		Sheep p = (Sheep) o;

		if (!(p.nome.equals(this.nome)))
			return false;

		ArrayList<String> dnaToCompare = p.getDna();

		try {
			for (int i = 0; i < dna.size(); i++)
				if (!(this.leggiCromosoma(i).equals(p.leggiCromosoma(i))))
					return false;

		} catch (InputMismatchException e) {
			return false;
		}

		return true;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		ArrayList<String> lista = this.getDna();
		String nome = this.getNome();

		return new Sheep(lista, nome);
	}

}