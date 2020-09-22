package Modelo;

public class Persona {
    
    int id_doc;
    String nom;
    String ap1;
    String ap2;
    
    public Persona(){
        
    }
    
    public Persona(int id_doc, String nom, String ap1, String ap2){
        this.id_doc = id_doc;
        this.nom = nom;
        this.ap1 = ap1;
        this.ap2 = ap2;
    }

    public int getId_doc() {
        return id_doc;
    }

    public void setId_doc(int id_doc) {
        this.id_doc = id_doc;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAp1() {
        return ap1;
    }

    public void setAp1(String ap1) {
        this.ap1 = ap1;
    }

    public String getAp2() {
        return ap2;
    }

    public void setAp2(String ap2) {
        this.ap2 = ap2;
    }

    
       
}