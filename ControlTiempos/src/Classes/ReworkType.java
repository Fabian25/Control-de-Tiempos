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
public class ReworkType {
    String idReworkType;
    byte Status;

    public ReworkType() {
    }

    public ReworkType(String idReworkType, byte Status) {
        this.idReworkType = idReworkType;
        this.Status = Status;
    }

    public String getIdReworkType() {
        return idReworkType;
    }

    public void setIdReworkType(String idReworkType) {
        this.idReworkType = idReworkType;
    }

    public byte getStatus() {
        return Status;
    }

    public void setStatus(byte Status) {
        this.Status = Status;
    }
    
    
}
