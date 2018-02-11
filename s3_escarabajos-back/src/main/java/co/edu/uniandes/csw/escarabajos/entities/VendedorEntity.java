/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.escarabajos.entities;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author s.beltran
 */
@Entity
public class VendedorEntity extends BaseEntity implements Serializable{
     
    private String direccion;
    private String telefono;
    private String factura;
    
    public String getDireccion(){
        return direccion;
    }
    public void setDireccion(String direccion){
        this.direccion = direccion;
    }
    public String getTelefono(){
        return telefono;
    }
    public void setTelefono(String telefono){
        this.telefono = telefono;
    }
    public String getFactura(){
        return factura;
    }
    public void setFactura(String factura){
        this.factura = factura;
    }
}
