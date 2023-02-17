import java.time.LocalDate;

public class Client{

    private int id
    private String nom;
    private String prenom;
    private String email;
    private LocalDate naissance;

    public Client(String nom, String prenom, String email, LocalDate naissance){
        this.nom = nom;
        this.prenom=prenom;
        this.email=email;
        this.naissance=naissance;

    }

}

