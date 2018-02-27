/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.escarabajos.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamExclude;



/**
 *
 * @author jp.carreno
 */
@Entity
public class FacturaEntity extends BaseEntity implements Serializable {

    
    private double dineroT;
    private String usuarioT;
    @PodamExclude
    @OneToMany(mappedBy = "Factura", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<ReclamoEntity> reclamos;
    
    @OneToOne(mappedBy = "Factura")
    private MedioPagoEntity medioDePago;
    
    @OneToOne(mappedBy = "Factura")
    private CarritoEntity carrito;
    
    @ManyToOne
    private ClienteEntity cliente;

    /**
     * @return the dineroT
     */
    public double getDineroT() {
        return dineroT;
    }

    /**
     * @param dineroT the dineroT to set
     */
    public void setDineroT(double dineroT) {
        this.dineroT = dineroT;
    }

    /**
     * @return the usuarioT
     */
    public String getUsuarioT() {
        return usuarioT;
    }

    /**
     * @param usuarioT the usuarioT to set
     */
    public void setUsuarioT(String usuarioT) {
        this.usuarioT = usuarioT;
    }

    /**
     * @return the reclamos
     */
    public List<ReclamoEntity> getReclamos() {
        return reclamos;
    }

    /**
     * @param reclamos the reclamos to set
     */
    public void setReclamos(List<ReclamoEntity> reclamos) {
        this.reclamos = reclamos;
    }

    
    /**
     * @return the carrito
     */
    public CarritoEntity getCarrito() {
        return carrito;
    }

    /**
     * @param carrito the carrito to set
     */
    public void setCarrito(CarritoEntity carrito) {
        this.carrito = carrito;
    }

    /**
     * @return the cliente
     */
    public ClienteEntity getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the medioDePago
     */
    public MedioPagoEntity getMedioDePago() {
        return medioDePago;
    }

    /**
     * @param medioDePago the medioDePago to set
     */
    public void setMedioDePago(MedioPagoEntity medioDePago) {
        this.medioDePago = medioDePago;
    }

    
    
}
