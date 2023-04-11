
package rubricatelefonica;

import java.util.ArrayList;
import java.util.*;
import java.util.Scanner;

class Contatto {
    private String nome;
    private String cognome;
    private String telefono;
    private String email;

    public Contatto(String nome, String cognome, String telefono, String email) {
        this.nome = nome;
        this.cognome = cognome;
        this.telefono = telefono;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

class Rubrica {
    private ArrayList<Contatto> contatti;

    public Rubrica() {
        contatti = new ArrayList<Contatto>();
    }

    public void aggiungiContatto(Contatto contatto) {
        contatti.add(contatto);
    }

    public void modificaContatto(int indice) {
        Scanner input = new Scanner(System.in);

        Contatto contatto = contatti.get(indice);

        System.out.print("Nuovo nome: ");
        String nome = input.nextLine();
        contatto.setNome(nome);

        System.out.print("Nuovo cognome: ");
        String cognome = input.nextLine();
        contatto.setCognome(cognome);

        System.out.print("Nuovo telefono: ");
        String telefono = input.nextLine();
        contatto.setTelefono(telefono);

        System.out.print("Nuova email: ");
        String email = input.nextLine();
        contatto.setEmail(email);

        contatti.set(indice, contatto);
    }

    public void rimuoviContatto(int indice) {
        contatti.remove(indice);
    }

    public void ordinaContattiPerNome() {
        Collections.sort(contatti, new Comparator<Contatto>() {
            public int compare(Contatto c1, Contatto c2) {
                return c1.getNome().compareTo(c2.getNome());
            }
        });
    }

    public void mostraContatti() {
        System.out.println("Elenco contatti:");

        for (int i = 0; i < contatti.size(); i++) {
            Contatto contatto = contatti.get(i);
            System.out.println(i + ". " + contatto.getNome() + " " + contatto.getCognome() + " - " + contatto.getTelefono() + " - " + contatto.getEmail());
        }
    }
}

public class RubricaTelefonica {
    public static void main(String[] args) {
        Rubrica rubrica = new Rubrica();
        Scanner input = new Scanner(System.in);
        int scelta = 0;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Aggiungi contatto");
            System.out.println("2. Modifica contatto");
            System.out.println("3. Rimuovi contatto");
            System.out.println("4. Ordina contatti per nome");
            System.out.println("5. Mostra tutti i contatti");
            System.out.println("0. Esci");
            System.out.print("\nScelta: ");
            scelta = input.nextInt();

            switch (scelta) {
                case 1:
                    input.nextLine(); // Consuma il newline rimasto
                    System.out.print("Nome: ");
                    String nome = input.nextLine();

                    System.out.print("Cognome: ");
                    String cognome = input.nextLine();

                    System.out.print("Telefono: ");
                    String telefono = input.nextLine();

                    System.out.print("Email: ");
                    String email = input.nextLine();

                    Contatto nuovoContatto = new Contatto(nome, cognome, telefono, email);
                    rubrica.aggiungiContatto(nuovoContatto);
                    break;
                case 2:
                    rubrica.mostraContatti();

                    System.out.print("Indice del contatto da modificare: ");
                    int indiceModifica = input.nextInt();
                    input.nextLine(); // Consuma il newline rimasto

                    rubrica.modificaContatto(indiceModifica);
                    break;
                case 3:
                    rubrica.mostraContatti();

                    System.out.print("Indice del contatto da rimuovere: ");
                    int indiceRimozione = input.nextInt();

                    rubrica.rimuoviContatto(indiceRimozione);
                    break;
                case 4:
                    rubrica.ordinaContattiPerNome();
                    System.out.println("Contatti ordinati per nome.");
                    break;
                case 5:
                    rubrica.mostraContatti();
                    break;
                case 0:
                    System.out.println("Arrivederci!");
                    break;
                default:
                    System.out.println("Scelta non valida.");
                    break;
            }

        } while (scelta != 0);

        input.close();
    }
}
