import java.util.List;
import java.util.ArrayList;

public class ListVoitures {
    private List<Voiture> voitures;

    public ListVoitures(List<Voiture> voitures) {
        this.voitures = voitures;
    }

    public ListVoitures() {
        this.voitures = new ArrayList<Voiture>();
    }

    public List<Voiture> getVoitures() {
        return voitures;
    }

    public void setVoitures(List<Voiture> voitures) {
        this.voitures = voitures;
    }

    public void ajoutVoiture(Voiture v) throws VoitureException {
        if (v != null) {
            voitures.add(v);
        } else {
            throw new VoitureException("Voiture non valide");
        }
    }

    public void supprimeVoiture(Voiture v) throws VoitureException {
        if (voitures.contains(v)) {
            voitures.remove(v);
        } else {
            throw new VoitureException("La voiture n'existe pas dans la liste");
        }
    }

    public int size() {
        return voitures.size();
    }

    public void affiche() {
        for (Voiture voiture : voitures) {
            System.out.println(voiture);
        }
    }
}

