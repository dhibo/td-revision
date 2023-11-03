import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Agence agence = new Agence("Agence de location de voitures");

        
        Voiture voiture1 = new Voiture("206", "Peugeot", 2000);
        Voiture voiture2 = new Voiture("X6", "BMW", 2500);
        Voiture voiture3 = new Voiture("300", "Zimota", 3000);

        try{
		agence.ajouterVoiture(voiture1);
		agence.ajouterVoiture(voiture2);
		agence.ajouterVoiture(voiture3);
	}
        catch(VoitureException e){
        	System.out.println("error !!")
        }
        
        
        Client client1 = new Client(1, "Oussema", "Dhib");
        Client client2 = new Client(2, "Oussema1", "Dhib1");
        Client client3 = new Client(3, "OUssema2", "dhib2");

        try{
		agence.louerVoiture(client1, voiture1);
		agence.louerVoiture(client2, voiture2);
		agence.louerVoiture(client3, voiture3);
	}catch{VoitureException e){
		System.out.println("error ! ");}

        
        System.out.println("Liste des clients et leurs voitures louées :");
        agence.afficherClientsEtVoituresLouees();

        
        System.out.println("Liste des clients triés par code :");
        agence.trierClientsParCode().forEach(System.out::println);

        
        System.out.println("Liste des clients triés par nom :");
        agence.trierClientsParNom().forEach(System.out::println);

        
        System.out.println("Liste des voitures de marque Peugeot :");
        agence.listerVoitures(new CritereMarque("Peugeot")).forEach(System.out::println);

        
        System.out.println("Liste des clients qui ont loué une (des) voiture(s) :");
        agence.listerClientsLoueurs().forEach(System.out::println);

        
        System.out.println("Liste des voitures actuellement en état de location :");
        agence.listerVoituresLouees().forEach(System.out::println);

        
        System.out.println("Liste des voitures de prix inférieur à 2500 :");
        agence.listerVoitures(new CriterePrix(2500)).forEach(System.out::println);
    }
}
