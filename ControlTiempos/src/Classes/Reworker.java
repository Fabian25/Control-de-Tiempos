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
public class Reworker {
     int idReworker;
    String NombreReworker;
    String passReworker;
    Byte Status;

    public Reworker() {
    }

    public Reworker(int idReworker, String NombreReworker, String passReworker, Byte Status) {
        this.idReworker = idReworker;
        this.NombreReworker = NombreReworker;
        this.passReworker = passReworker;
        this.Status = Status;
    }

    public int getIdReworker() {
        return idReworker;
    }

    public String getNombreReworker() {
        return NombreReworker;
    }

    public String getPassReworker() {
        return passReworker;
    }

    public Byte getStatus() {
        return Status;
    }
    
    
}
