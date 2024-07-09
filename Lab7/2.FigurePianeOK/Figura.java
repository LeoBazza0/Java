public interface Figura extends Comparable<Figura> {

    public double perimetro();

    @Override
    public default int compareTo(Figura f) {
        return Double.compare(f.perimetro(), perimetro()); // Ordine decrescente
    }
    
}