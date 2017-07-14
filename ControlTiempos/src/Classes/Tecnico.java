/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Jonathan
 */
public class Tecnico {
    int idTecnico;
    String NombreTecnico;
    String passTecnico;
    Byte Status;

    public Tecnico() {
    }

    public Tecnico(int idTecnico, String NombreTecnico, String passTecnico, Byte Status) {
        this.idTecnico = idTecnico;
        this.NombreTecnico = NombreTecnico;
        this.passTecnico = passTecnico;
        this.Status = Status;
    }

    public int getIdTecnico() {
        return idTecnico;
    }

    public void setIdTecnico(int idTecnico) {
        this.idTecnico = idTecnico;
    }

    public String getNombreTecnico() {
        return NombreTecnico;
    }

    public void setNombreTecnico(String NombreTecnico) {
        this.NombreTecnico = NombreTecnico;
    }

    public String getPassTecnico() {
        return passTecnico;
    }

    public void setPassTecnico(String passTecnico) {
        this.passTecnico = passTecnico;
    }

    public Byte getStatus() {
        return Status;
    }

    public void setStatus(Byte Status) {
        this.Status = Status;
    }
    
    
}
