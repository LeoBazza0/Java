public class AdCampaignSocial extends AdCampaign {
    // ATTRIBUTI
    int nVis;
    int nLike;

    // COSTRUTTORI
    public AdCampaignSocial(String nome) throws IllegalArgumentException {
        super(nome);
        this.nVis = 0;
        this.nLike = 0;
        assert repOk();
    }

    // METODI
    public void aggiornaLikeView(int nLikeNew, int nVisNew) throws CampaignClosedException, IllegalArgumentException {
        if (!isAperta())
            throw new CampaignClosedException("La campagna è gia chiusa");
        if (nLikeNew < 0 || nVisNew < 0)
            throw new IllegalArgumentException("non ci possono essere visualizzazioni negative");
        nLike += nLikeNew;
        nVis += nVisNew;
        assert repOk();
    }

    // METODI OVERRIDE
    @Override
    public double getPerformance() {
        return (double) nLike / nVis;
    }

    // REPOK
    public boolean repOk() {
        if (nLike < 0 || nVis < 0)
            return false;
        if (nLike > nVis)
            return false;
        return super.repOk();
    }

    // OVERRIDE
    @Override
    public String toString() {
        return "Social" + super.toString();
    }
}
