/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.escarabajos.resources;

import co.edu.uniandes.csw.escarabajos.dtos.FiltrosDTO;
import co.edu.uniandes.csw.escarabajos.dtos.InfoDTO;
import co.edu.uniandes.csw.escarabajos.dtos.ModeloDetailDTO;
import co.edu.uniandes.csw.escarabajos.dtos.PaginacionDTO;
import co.edu.uniandes.csw.escarabajos.ejb.ModeloLogic;
import co.edu.uniandes.csw.escarabajos.entities.ModeloEntity;
import co.edu.uniandes.csw.escarabajos.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * <pre>Clase que implementa el recurso "modelos".
 * URL: /api/catalogo
 * </pre>
 * <i>Note que la aplicación (definida en {@link RestConfig}) define la ruta
 * "/api" y este recurso tiene la ruta "catalogo".</i>
 *
 * <h2>Anotaciones </h2>
 * <pre>
 * Path: indica la dirección después de "api" para acceder al recurso
 * Produces/Consumes: indica que los servicios definidos en este recurso reciben y devuelven objetos en formato JSON
 * RequestScoped: Inicia una transacción desde el llamado de cada método (servicio).
 * </pre>
 *
 * @author Andres
 * @version 1.0
 */
@Path("catalogo")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class CatalogoResource {

    @Inject
    ModeloLogic modeloLogic;

    /**
     * <h1>GET /api/catalogo/marcas/accesorios : Obtener todas las marcas de la
     * aplicacion</h1>
     *
     * <pre>busca todas las marcas disponibles.
     *
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve las marcas.
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existen marcas..
     * </code>
     * </pre>
     *
     * @return JSONArray {@link InfoDTO} - El modelo buscado throws
     * WebApplicationException {@link WebApplicationExceptionMapper} - Error de
     * lógica que se genera cuando no falla la busqueda
     */
    @GET
    @Path("marcas/accesorios")
    public List<InfoDTO> getMarcasAccesorios() {
        return listString2Info(modeloLogic.getMarcasAccesorios());
    }

    /**
     * <h1>GET /api/catalogo/categorias/accesorios : Obtener todas las
     * categorias de accesorios de la aplicacion</h1>
     *
     * <pre>busca todas las categorias de accesorios disponibles.
     *
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve las categorias.
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existen categorias..
     * </code>
     * </pre>
     *
     * @return JSONArray {@link InfoDTO} - El modelo buscado throws
     * WebApplicationException {@link WebApplicationExceptionMapper} - Error de
     * lógica que se genera cuando no falla la busqueda
     */
    @GET
    @Path("categorias/accesorios")
    public List<InfoDTO> getCategoriasAccesorios() {
        return listString2Info(modeloLogic.getCategoriasAccesorios());
    }

    /**
     * <h1>GET /api/catalogo/colores/accesorios : Obtener todos los colores de
     * accesorios de la aplicacion</h1>
     *
     * <pre>busca todos los colores de accesorios disponibles.
     *
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve los colores.
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existen colores..
     * </code>
     * </pre>
     *
     * @return JSONArray {@link InfoDTO} - El modelo buscado throws
     * WebApplicationException {@link WebApplicationExceptionMapper} - Error de
     * lógica que se genera cuando no falla la busqueda
     */
    @GET
    @Path("colores/accesorios")
    public List<InfoDTO> getColoresAccesorios() {
        return listString2Info(modeloLogic.getColoresAccesorios());
    }

    private List<InfoDTO> listString2Info(List<String> entityList) {
        ArrayList<InfoDTO> list = new ArrayList<>();
        for (String entity : entityList) {
            list.add(new InfoDTO(entity));
        }
        return list;
    }

    /**
     * <h1>GET /api/catalogo/marcas/bicicletas : Obtener todas las marcas de las
     * bicicletas la aplicacion</h1>
     *
     * <pre>busca todas las marcas disponibles.
     *
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve las marcas.
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existen marcas..
     * </code>
     * </pre>
     *
     * @return JSONArray {@link InfoDTO} - El modelo buscado throws
     * WebApplicationException {@link WebApplicationExceptionMapper} - Error de
     * lógica que se genera cuando no falla la busqueda
     */
    @GET
    @Path("marcas/bicicletas")
    public List<InfoDTO> getMarcasBicicletas() {
        return listString2Info(modeloLogic.getMarcasBicicletas());
    }

    /**
     * <h1>GET /api/catalogo/categorias/bicicletas : Obtener todas las
     * categorias de bicicletas de la aplicacion</h1>
     *
     * <pre>busca todas las categorias de bicicletas disponibles.
     *
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve las categorias.
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existen categorias..
     * </code>
     * </pre>
     *
     * @return JSONArray {@link InfoDTO} - El modelo buscado throws
     * WebApplicationException {@link WebApplicationExceptionMapper} - Error de
     * lógica que se genera cuando no falla la busqueda
     */
    @GET
    @Path("categorias/bicicletas")
    public List<InfoDTO> getCategoriasBicicletas() {
        return listString2Info(modeloLogic.getCategoriasBicicletas());
    }

    /**
     * <h1>GET /api/catalogo/colores/bicicletas : Obtener todos los colores de
     * bicicletas de la aplicacion</h1>
     *
     * <pre>busca todos los colores de bicicletas disponibles.
     *
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve los colores.
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existen colores..
     * </code>
     * </pre>
     *
     * @return JSONArray {@link InfoDTO} - El modelo buscado throws
     * WebApplicationException {@link WebApplicationExceptionMapper} - Error de
     * lógica que se genera cuando no falla la busqueda
     */
    @GET
    @Path("colores/bicicletas")
    public List<InfoDTO> getColoresBicicletas() {
        return listString2Info(modeloLogic.getColoresBicicletas());
    }

    /**
     * <h1>GET /api/catalogo/precio/bicicletas : Obtener el precio de la
     * bicicleta mas cara de la aplicacion</h1>
     *
     * <pre>busca el precio de la bicicleta mas cara
     *
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve el precio.
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existen bicicletas..
     * </code>
     * </pre>
     *
     * @return InfoDTO con el precio buscado WebApplicationException
     * {@link WebApplicationExceptionMapper} - Error de lógica que se genera
     * cuando no falla la busqueda
     */
    @GET
    @Path("precio/bicicletas")
    public InfoDTO getPrecioBicicletas() {
        return new InfoDTO(modeloLogic.getPrecioBicicletas().toString());
    }

    /**
     * <h1>GET /api/catalogo/precio/accesorios : Obtener el precio del accesorio
     * mas caro de la aplicacion</h1>
     *
     * <pre>busca el precio del accesorio mas caro.
     *
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve el precio.
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existen bicicletas..
     * </code>
     * </pre>
     *
     * @return InfoDTO con el precio buscado WebApplicationException
     * {@link WebApplicationExceptionMapper} - Error de lógica que se genera
     * cuando no falla la busqueda
     */
    @GET
    @Path("precio/accesorios")
    public InfoDTO getPrecioAccesorios() {
        return new InfoDTO(modeloLogic.getPrecioAccesorios().toString());
    }

    /**
     * Metodo que se encarga de llamar al metodo de la logica que filtra los
     * modelos de bicicletas
     *
     * @param filtros filtros a revisar
     * @param pagina pagina a buscar
     * @param maxRecords numero de records a retornar.
     * @return objeto de paginacion con lista de modelos y numero total de
     * items.
     * @throws BusinessLogicException si los filtros no estan en el formato
     * adecuado
     */
    @POST
    @Path("modelos/bicicletas/{pagina: \\d+}/{records: \\d+}")
    public PaginacionDTO getModelosBicicletasByFiltros(FiltrosDTO filtros, @PathParam("pagina") Integer pagina,
            @PathParam("records") Integer maxRecords) throws BusinessLogicException {
        return new PaginacionDTO(listModeloEntity2DetailDTO(modeloLogic.getModelosBicicletasFiltrados(filtros.getMarcas(),
                filtros.getCategorias(), filtros.getColores(), filtros.getPrecioMin(), filtros.getPrecioMax(), filtros.getCalificacionMin(),
                pagina, maxRecords)), modeloLogic.getNumeroBicicletasConFiltros(filtros.getMarcas(),
                        filtros.getCategorias(), filtros.getColores(), filtros.getPrecioMin(), filtros.getPrecioMax(), filtros.getCalificacionMin()));
    }

    /**
     * Metodo que se encarga de llamar al metodo de la logica que filtra los
     * modelos de accesorios
     *
     * @param filtros filtros a revisar
     * @param pagina pagina a buscar
     * @param maxRecords numero de records a retornar.
     * @return objeto de paginacion con lista de modelos y numero total de
     * items.
     * @throws BusinessLogicException si los filtros no estan en el formato
     * adecuado
     */
    @POST
    @Path("modelos/accesorios/{pagina: \\d+}/{records: \\d+}")
    public PaginacionDTO getModelosAccesoriosByFiltros(FiltrosDTO filtros, @PathParam("pagina") Integer pagina,
            @PathParam("records") Integer maxRecords) throws BusinessLogicException {
        return new PaginacionDTO(listModeloEntity2DetailDTO(modeloLogic.getModelosAccesoriosFiltrados(filtros.getMarcas(),
                filtros.getCategorias(), filtros.getColores(), filtros.getPrecioMin(), filtros.getPrecioMax(), filtros.getCalificacionMin(),
                pagina, maxRecords)), modeloLogic.getNumeroAccesoriosConFiltros(filtros.getMarcas(),
                        filtros.getCategorias(), filtros.getColores(), filtros.getPrecioMin(), filtros.getPrecioMax(), filtros.getCalificacionMin()));
    }

    /**
     * Metodo que se encarga de pasar una lista de modeloEntity a
     * modeloDetailDTO
     *
     * @param entityList lista de entities a transferir
     * @return lista de detailDTOS
     */
    private List<ModeloDetailDTO> listModeloEntity2DetailDTO(List<ModeloEntity> entityList) {
        List<ModeloDetailDTO> list = new ArrayList<>();
        for (ModeloEntity entity : entityList) {
            list.add(new ModeloDetailDTO(entity));
        }
        return list;
    }
}
