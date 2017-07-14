/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.sql.Date;

/**
 *
 * @author Jonathan
 */
public class Reporte {
    int idReporte;
    int idEmpleado;
    String idProdNo;
    String SerialNo;
    String idReworktype;
    String comentario;
    Date IdleTime;
    Date SATime;
    Date EATime;

    public Reporte() {
    }

    public Reporte(int idReporte, int idEmpleado, String idProdNo, String SerialNo, String idReworktype, String comentario, Date IdleTime, Date SATime, Date EATime) {
        this.idReporte = idReporte;
        this.idEmpleado = idEmpleado;
        this.idProdNo = idProdNo;
        this.SerialNo = SerialNo;
        this.idReworktype = idReworktype;
        this.comentario = comentario;
        this.IdleTime = IdleTime;
        this.SATime = SATime;
        this.EATime = EATime;
    }

    public int getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(int idReporte) {
        this.idReporte = idReporte;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getIdProdNo() {
        return idProdNo;
    }

    public void setIdProdNo(String idProdNo) {
        this.idProdNo = idProdNo;
    }

    public String getSerialNo() {
        return SerialNo;
    }

    public void setSerialNo(String SerialNo) {
        this.SerialNo = SerialNo;
    }

    public String getIdReworktype() {
        return idReworktype;
    }

    public void setIdReworktype(String idReworktype) {
        this.idReworktype = idReworktype;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getIdleTime() {
        return IdleTime;
    }

    public void setIdleTime(Date IdleTime) {
        this.IdleTime = IdleTime;
    }

    public Date getSATime() {
        return SATime;
    }

    public void setSATime(Date SATime) {
        this.SATime = SATime;
    }

    public Date getEATime() {
        return EATime;
    }

    public void setEATime(Date EATime) {
        this.EATime = EATime;
    }
    
    
}
