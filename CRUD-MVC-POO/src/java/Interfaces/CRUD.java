package Interfaces;

import Modelo.Persona;
import java.util.List;

public interface CRUD {
    
    public List listar();
    public Persona list(int id_doc);
    public int add(Persona per);
    public int edit(Persona per);
    public boolean eliminar(int id_doc);
    
}
