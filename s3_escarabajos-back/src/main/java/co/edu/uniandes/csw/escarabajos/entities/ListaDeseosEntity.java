/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.escarabajos.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author Mateo
 */
@Entity
public class ListaDeseosEntity implements Serializable{
    
    //----------------------------------------------------
    // Atributos
    //----------------------------------------------------
    
    /**
     * id autogenerado
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /**
     * precio total del listadeseos
     */
    private Double precioTotal=0.0;
    
    /**
     *  lista de items del listadeseos
     */
    @PodamExclude
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "LISTA_DESEOS_ITEMS", joinColumns = @JoinColumn(name = "LISTA_DESEOS_ID"), inverseJoinColumns = @JoinColumn(name="ITEM_ID"))
    private List<ItemEntity> items = new ArrayList<>();
    
    /**
     * cliente dueño del listadeseos
     */
    @PodamExclude
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private ClienteEntity cliente;
    
       
    //----------------------------------------------------
    // Getters y Setters
    //----------------------------------------------------

    /**
     * @return el precio total del listadeseos 
     */
    public Double getPrecioTotal() {
        return precioTotal;
    }
    
    /**
     * asigna el precio total
     * @param precioTotal el nuevo precioTotal
     */
    public void setPrecioTotal(Double precioTotal) {
        this.precioTotal = precioTotal;
    }
    
    /**
     * 
     * @return la lista de items del listadeseos
     */
    public List<ItemEntity> getItems() {
        return items;
    }

    /**
     * asigna la lista de items del listadeseos
     * @param items la nueva lista de items
     */
    public void setItems(List<ItemEntity> items) {
        this.items = items;
    }
    /**
     * 
     * @return el cliente dueño del listadeseos 
     */
    public ClienteEntity getCliente() {
        return cliente;
    }
    /**
     * asigna el cliente del listadeseos
     * @param cliente  el nuevo cliente
     */
    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ListaDeseosEntity other = (ListaDeseosEntity) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public int hashCode() {
        if (this.getId() != null) {
            return this.getId().hashCode();
        }
        return super.hashCode();
    }
    
}
