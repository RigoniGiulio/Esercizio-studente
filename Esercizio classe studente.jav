import java.util.Calendar;
import java.util.Date;

class Studente {
    private String nome;
    private String cognome;
    private Date dataDiNascita;
    private int matricola;
    private String corsoDiStudi;
    private int[] voti = new int[10];

    public Studente(String nome, String cognome, Date dataDiNascita, int matricola, String corsoDiStudi) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
        this.matricola = matricola;
        this.corsoDiStudi = corsoDiStudi;
    }

    // Return x informazioni
    public String getNome() {
        return nome;
    }
    public String getCognome() {
        return cognome;
    }
    public int getMatricola() {
        return matricola;
    }
    public String getCorsoDiStudi() {
        return corsoDiStudi;
    }

    // Impostare le informazioni
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    public void setMatricola(int matricola) {
        this.matricola = matricola;
    }
    public void setCorsoDiStudi(String corsoDiStudi) {
        this.corsoDiStudi = corsoDiStudi;
    }

    // Aggiunge voti
    public void aggiungiVoto(int voto, int indiceCorso) {
        if (indiceCorso >= 0 && indiceCorso < 10 && voto >= 0 && voto <= 10) {
            voti[indiceCorso] = voto;
        }
    }

    // Rimuove voti
    public void rimuoviVoti() {
        for (int i = 0; i < 10; i++) {
            voti[i] = 0;
        }
    }

    // Calcolo media
    public float calcolaMediaVoti() {
        float somma = 0;
        int conteggio = 0;
        for (int i = 0; i < 10; i++) {
            if (voti[i] > 0) {
                somma += voti[i];
                conteggio++;
            }
        }
        if (conteggio > 0) {
            return somma / conteggio;
        } else {
            return 0;
        }
    }

    // Calcolo etá
    public int calcolaEta() {
        Calendar oggi = Calendar.getInstance();
        Calendar dataNascita = Calendar.getInstance();
        dataNascita.setTime(dataDiNascita);
        int anni = oggi.get(Calendar.YEAR) - dataNascita.get(Calendar.YEAR);
        if (oggi.get(Calendar.DAY_OF_YEAR) < dataNascita.get(Calendar.DAY_OF_YEAR)) {
            anni--;
        }
        return anni;
    }

    // Visualizzare le informazioni
    public String toString() {
        StringBuilder info = new StringBuilder();
        info.append("Nome: ").append(nome).append("\n");
        info.append("Cognome: ").append(cognome).append("\n");
        info.append("Data di Nascita: ").append(dataDiNascita).append("\n");
        info.append("Matricola: ").append(matricola).append("\n");
        info.append("Corso di Studi: ").append(corsoDiStudi).append("\n");
        info.append("Voti:\n");
        for (int i = 0; i < 10; i++) {
            info.append("Voto ").append(i + 1).append(": ").append(voti[i]).append("\n");
        }
        info.append("Media dei voti: ").append(calcolaMediaVoti()).append("\n");
        info.append("Età: ").append(calcolaEta()).append(" anni");
        return info.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        // Creazione degli studenti
        Date dataNascita1 = new Date(2004 - 1900, 5, 15);
        Studente studente1 = new Studente("Giulio", "Rigoni", dataNascita1, 11111, "Informatica");

        Date dataNascita2 = new Date(2001 - 1900, 1, 1);
        Studente studente2 = new Studente("Federico", "Maniglio", dataNascita2, 22222, "Informatica");

	studente1.aggiungiVoto(8, 0);
	studente2.aggiungiVoto(9, 1);

        // Print
        System.out.println("Studente 1:");
        System.out.println(studente1.toString());

        System.out.println("\nStudente 2:");
        System.out.println(studente2.toString());
    }
}