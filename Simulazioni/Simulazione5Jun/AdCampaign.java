public abstract class AdCampaign implements Comparable<AdCampaign>, Cloneable {
    // ATTRIBUTI
    String nome;
    boolean aperta;

    // COSTRUTTORI
    public AdCampaign(String nome) throws IllegalArgumentException {
        if (nome == null || nome.equals(""))
            throw new IllegalArgumentException("nome non valido");

        this.nome = nome;
        this.aperta = true;
        assert repOk();
    }

    // METODI
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws CampaignClosedException {
        if (!isAperta())
            throw new CampaignClosedException("La campagna è gia chiusa");
        this.nome = nome;
    }

    public abstract double getPerformance();

    public boolean isAperta() {
        return aperta;
    }

    public void apri(AdCampaign adC) {
        aperta = true;
    }

    public void chiudi(AdCampaign adC) {
        aperta = false;
    }

    // REPOK
    public boolean repOk() {
        if (nome == null || nome.equals(""))
            return false;
        return true;

    }

    // OVERRIDE
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AdCampaign other = (AdCampaign) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        return true;
    }

    @Override
    public int compareTo(AdCampaign o) {
        return Double.compare(this.getPerformance(), o.getPerformance());
    }

    @Override
    public String toString() {
        return "name: " + nome + " performance: " + getPerformance();
    }

    @Override
    protected Object clone() {
        AdCampaign ac = null;
        try {
            ac = (AdCampaign) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage());
        }
        return ac;
    }
}
