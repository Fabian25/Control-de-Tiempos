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
public class ProdNo {
    String idProdNo;
    String idArea;
    int idDepartamento;
    String idBU;

    public ProdNo() {
    }

    public ProdNo(String idProdNo, String idArea, int idDepartamento, String idBU) {
        this.idProdNo = idProdNo;
        this.idArea = idArea;
        this.idDepartamento = idDepartamento;
        this.idBU = idBU;
    }

    public String getIdProdNo() {
        return idProdNo;
    }

    public void setIdProdNo(String idProdNo) {
        this.idProdNo = idProdNo;
    }

    public String getIdArea() {
        return idArea;
    }

    public void setIdArea(String idArea) {
        this.idArea = idArea;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getIdBU() {
        return idBU;
    }

    public void setIdBU(String idBU) {
        this.idBU = idBU;
    }
    
    
}
