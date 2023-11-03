public class Voiture {
private int immariculation;
private String marque; private float
prixLocation; public Voiture(int
immariculation,
String marque, float prixLocation) {
this.marque = marque ;
this.immariculation = immariculation ;
this.prixLocation = prixLocation ;
}
public int getImmariculation() {
return immariculation;
}
public void setImmariculation(int
immariculation) { this.immariculation
= immariculation;
}
public String getMarque() {
return marque;
}
public void setMarque(String marque) {
this.marque = marque;
}
public float getPrixLocation() {
return prixLocation;
}
public void setPrixLocation(float
prixLocation) { this.prixLocation =
prixLocation;
}
public int hashCode() {
    int result = 17; 
    result = 31 * result + immariculation;
    result = 31 * result + (marque != null ? marque.hashCode() : 0);
    return result;
}

public boolean equals(Object obj) {
    return immariculation == obj.immariculation &&
           (marque == null ? obj.marque == null : marque.equals(obj.marque));
}
public String toString() {
    return "Voiture{" +
           "immatriculation=" + immariculation +
           ", marque='" + marque + '\'' +
           ", prixLocation=" + prixLocation +
           '}';
}

}
