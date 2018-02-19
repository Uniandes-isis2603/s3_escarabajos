/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.escarabajos.dtos;

import co.edu.uniandes.csw.escarabajos.entities.BicicletaUsadaEntity;

/**
 * BicicletaUsadaEnVentaDTO Objeto de transferencia de datos de
 * BicicletasUsadasEnVenta. Los DTO contienen las represnetaciones de los JSON
 * que se transfieren entre el cliente y el servidor.
 *
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "id": number,
 *      "categoria: string,
 *      "marca": string,
 *      "color: string,
 *      "precio": double,
 *      "usada: boolean,
 *      "facturaOriginal" : string,
 *      "precioVenta" : double
 *   }
 * </pre> Por ejemplo una bicicletaUsadaEnVenta se representa asi:<br>
 * <pre>
 *   {
 *      "id": 1,
 *      "categoria: BMX,
 *      "marca": We the People,
 *      "color: Negro,
 *      "precio": 2.50,
 *      "usada: true
 *      "facturaOriginal" : "https://cloud10.todocoleccion.online/facturas-antiguas/tc/2010/05/15/19344998.jpg"
 *   }
 *
 * </pre>
 *
 * @author c.santacruza
 */
public class BicicletaUsadaEnVentaDTO extends BicicletaDTO {

    /**
     * Representa la imagen de la factura original del vendedor.
     */
    private String facturaOriginal;
    private String estado;
    private double precioDeReventa;

    /**
     * Por defecto.
     */
    public BicicletaUsadaEnVentaDTO() {

    }

    /**
     * Conviertir Entity a DTO (Crea un nuevo DTO con los valores que recibe en
     * la entidad que viene de argumento.
     *
     * @param bici: Es la entidad que se va a convertir a DTO
     */
    public BicicletaUsadaEnVentaDTO(BicicletaUsadaEntity bici) {
        super(bici);
        this.facturaOriginal = bici.getFacturaOriginal();
        this.precioDeReventa = bici.getPrecioDeReventa();
        this.estado = bici.getEstado();
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getPrecioDeReventa() {
        return precioDeReventa;
    }

    public void setPrecioDeReventa(double precioDeReventa) {
        this.precioDeReventa = precioDeReventa;
    }

    public String getFacturaOriginal() {
        return facturaOriginal;
    }

    public void setFacturaOriginal(String facturaOriginal) {
        this.facturaOriginal = facturaOriginal;
    }

    /**
     * Convertir DTO a Entity
     *
     * @return Un Entity con los valores del DTO
     */
    public BicicletaUsadaEntity toEntity() {
        BicicletaUsadaEntity entity = new BicicletaUsadaEntity();
        super.toEntity(entity);
        entity.setFacturaOriginal(this.facturaOriginal);
        entity.setPrecioDeReventa(this.precioDeReventa);
        entity.setEstado(this.estado);

        return entity;
    }

}
