import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CompanyAds {
    // ATTRIBUTI
    String nome;
    ArrayList<AdCampaign> campagne = new ArrayList<>();

    // COSTRUTTORI
    public CompanyAds(String nome) throws NullPointerException, IllegalArgumentException {
        if (nome == null)
            throw new NullPointerException("Nome nullo");
        if (nome.equals(""))
            throw new IllegalArgumentException("Nome vuoto");

        this.nome = nome;
    }

    // METODI
    public String getNome() {
        return nome;
    }

    public void inserisciCampagna(AdCampaign ac) throws NullPointerException, CampaignExistsException {
        if (ac == null)
            throw new NullPointerException("campagna inserita nulla");
        for (AdCampaign adCampaign : campagne) {
            if (ac.equals(adCampaign))
                throw new CampaignExistsException("La campagna esiste già");
        }

        campagne.add((AdCampaign) ac.clone());
        assert repOk();
    }

    public AdCampaign get(String nome) throws NullPointerException, NoSuchElementException {
        if (nome == null)
            throw new NullPointerException("Nome nullo");

        for (AdCampaign adCampaign : campagne) {
            if (adCampaign.getNome().equals(nome))
                return adCampaign;
        }
        throw new NoSuchElementException("Campagna non presente");
    }

    // REPOK
    public boolean repOk() {
        if (campagne == null)
            return false;

        for (AdCampaign adCampaign : campagne) {
            if (adCampaign == null)
                return false;
        }

        return true;
    }

    // OVERRIDE

    @Override
    public String toString() {
        String res = "Campagne di " + nome + "\n";
        for (AdCampaign adCampaign : campagne) {
            res += "\t" + adCampaign + "\n";
        }
        return res;
    }

    // ITERATORI
    public Iterator<AdCampaign> iterator() { // FILO HA FATTO UNA COSA STRANA CON @SuppressWarning, SERVE DAVVERO?
        return new Iterator<AdCampaign>() {
            Iterator<AdCampaign> i = campagne.iterator();

            @Override
            public boolean hasNext() {
                return i.hasNext();
            }

            @Override
            public AdCampaign next() {
                return i.next();
            }
        };

    }
}
