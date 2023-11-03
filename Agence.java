import java.util.*;

public class Agence {
    private String nom;
    private List<Voiture> parking;
    private Map<Client, List<Voiture>> clientVoitureLoue;

    public Agence(String nom) {
        this.nom = nom;
        this.parking = new ArrayList<>();
        this.clientVoitureLoue = new HashMap<>();
    }

    public void ajoutVoiture(Voiture v) throws VoitureException {
        if (v != null) {
            parking.add(v);
        } else {
            throw new VoitureException("error !");
        }
    }

    public void suppVoiture(Voiture v) throws VoitureException {
        if (v != null && parking.contains(v)) {
            parking.remove(v);
        } else {
            throw new VoitureException("error ! ");
        }
    }

    public void loueClientVoiture(Client c, Voiture v) throws VoitureException {
        if (c != null && v != null && parking.contains(v)) {
            List<Voiture> voituresLouees = clientVoitureLoue.get(c);
            if (voituresLouees == null) {
                voituresLouees = new ArrayList<>();
                clientVoitureLoue.put(cl, voituresLouees);
            }
            voituresLouees.add(v);
            parking.remove(v);
        } else {
            throw new VoitureException("error !");
        }
    }

    public void retourClientVoiture(Client cl, Voiture v) throws VoitureException {
        if (cl != null && v != null) {
            List<Voiture> voituresLouees = clientVoitureLoue.get(cl);
            if (voituresLouees != null && voituresLouees.contains(v)) {
                voituresLouees.remove(v);
                parking.add(v);
            } else {
                throw new VoitureException("voiture non louée par ce client");
            }
        } else {
            throw new VoitureException("Client ou voiture non valides");
        }
    }

    public List<Voiture> selectVoitureSelonCritere(Critere critere) {
        List<Voiture> voituresSelectionnees = new ArrayList<>();
        for (Voiture voiture : parking.getVoitures()) {
            if (critere.estSatisfaitPar(voiture)) {
                voituresSelectionnees.add(voiture);
            }
        }
        return voituresSelectionnees;
    }

    public Set<Client> ensembleClientsLoueurs() {
        return clientVoitureLoue.keySet();
    }

    public Collection<List<Voiture>> collectionVoituresLouees() {
        return clientVoitureLoue.values();
    }

    public void afficheLesClientsEtLeursListesVoitures() {
        for (Map.Entry<Client, List<Voiture>> entry : clientVoitureLoue.entrySet()) {
            Client client = entry.getKey();
            List<Voiture> voituresLouees = entry.getValue();
            System.out.println("Client : " + client.getNom());
            System.out.println("Voitures louées : " + voituresLouees);
        }
    }

   public Map<Client, List<Voiture>> triCodeCroissant() {
    Map<Client, List<Voiture>> sortedMap = new LinkedHashMap<>();

    List<Map.Entry<Client, List<Voiture>>> entries = new ArrayList<>(clientVoitureLoue.entrySet());


    Collections.sort(entries, (entry1, entry2) -> entry1.getKey().getCode().compareTo(entry2.getKey().getCode()));

    for (Map.Entry<Client, List<Voiture> entry : entries) {
        sortedMap.put(entry.getKey(), entry.getValue());
    }

    return sortedMap;
}

public Map<Client, List<Voiture>> triNomCroissant() {
    Map<Client, List<Voiture>> sortedMap = new LinkedHashMap<>();

    List<Map.Entry<Client, List<Voiture>>> entries = new ArrayList<>(clientVoitureLoue.entrySet());


    Collections.sort(entries, (entry1, entry2) -> 				   		entry1.getKey().getNom().compareTo(entry2.getKey().getNom()));
 
    for (Map.Entry<Client, List<Voiture> entry : entries) {
        sortedMap.put(entry.getKey(), entry.getValue());
    }

    return sortedMap;
}
}

