package ModeloDAO;

import Config.Conexion;
import Interfaces.CRUD;
import Modelo.Persona;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

public class ModeloDAO implements CRUD{

    Conexion cn = new Conexion();
    Connection con;
    CallableStatement cs;
    ResultSet rs;
    Persona p = new Persona();
    
    
    @Override
    public List listar() {
        
        ArrayList<Persona>list = new ArrayList<>();
        String sql = "{call listar()}";
        try {
            con = cn.getConnection();
            cs = con.prepareCall(sql);
            rs = cs.executeQuery();
            while(rs.next()){
                Persona per = new Persona();
                per.setId_doc(rs.getInt(1));
                per.setNom(rs.getString(2));
                per.setAp1(rs.getString(3));
                per.setAp2(rs.getString(4));
                list.add(per);
            }
        } catch (Exception e) {
        }
        
        return list;
    }

    @Override
    public Persona list(int id_doc) {
        Persona per = new Persona();
        String sql="{call listar_id_doc(?)}";
        try {
            con = cn.getConnection();
            cs = con.prepareCall(sql);
            cs.setInt(1, id_doc);
            rs = cs.executeQuery();
            
            while (rs.next()){
                
                per.setId_doc(rs.getInt(1));
                per.setNom(rs.getString(2));
                per.setAp1(rs.getString(3));
                per.setAp2(rs.getString(4));
            }
        } catch (Exception e) {
        }
        return per;
    }

    @Override
    public int add(Persona per) {
        int r = 0;
        String sql ="{call registrar(?,?,?,?)}";
        try {
            con = cn.getConnection();
            cs = con.prepareCall(sql);
            cs.setInt(1, per.getId_doc());
            cs.setString(2, per.getNom());
            cs.setString(3, per.getAp1());
            cs.setString(4, per.getAp2());
            
            r = cs.executeUpdate();
            if(r == 0 ){
                throw new SQLException();
            }
            cs.close();
        } catch (Exception e) {
        }
        
        return r;
    }

    @Override
    public int edit(Persona per) {
        int r = 0;
        String sql ="{call actualizar(?,?,?,?)}";
        try {
            con = cn.getConnection();
            cs = con.prepareCall(sql);
            
            cs.setInt(1, per.getId_doc());
            cs.setString(2, per.getNom());
            cs.setString(3, per.getAp1());
            cs.setString(4, per.getAp2());
            
            
            r = cs.executeUpdate();
            if(r == 0 ){
                throw new SQLException();
            }
            cs.close();
        } catch (Exception e) {
        }
        
        return r;

    }

    @Override
    public boolean eliminar(int id_doc) {
        String sql = "{call eliminar(?)}";
        try {
            con = cn.getConnection();
            cs = con.prepareCall(sql);
            cs.setInt(1, id_doc);
            
            int r= cs.executeUpdate();
            
            if (r == 0){
                throw new SQLException();
            }
            
            cs.close();
        } catch (Exception e) {
        }
        return false;
    }

    
    
}
