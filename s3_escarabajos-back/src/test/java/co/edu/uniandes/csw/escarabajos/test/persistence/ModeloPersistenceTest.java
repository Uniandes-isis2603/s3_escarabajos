package co.edu.uniandes.csw.escarabajos.test.persistence;

import co.edu.uniandes.csw.escarabajos.entities.ModeloEntity;
import co.edu.uniandes.csw.escarabajos.persistence.ModeloPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @modelo Andres
 */
@RunWith(Arquillian.class)
public class ModeloPersistenceTest {


    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(ModeloEntity.class.getPackage())
                .addPackage(ModeloPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

 
    @Inject
    private ModeloPersistence modeloPersistence;

 
    @PersistenceContext
    private EntityManager em;

  
    @Inject
    UserTransaction utx;

    /**
     * Configuración inicial de la prueba.
     *
     * 
     */
    @Before
    public void configTest() {
        try {
            utx.begin();
            em.joinTransaction();
            clearData();
            insertData();
            utx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                utx.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    /**
     * Limpia las tablas que están implicadas en la prueba.
     *
     * 
     */
    private void clearData() {
        em.createQuery("delete from ModeloEntity").executeUpdate();
    }

    /**
     * 
     */
    private List<ModeloEntity> data = new ArrayList<ModeloEntity>();

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las pruebas.
     *
     * 
     */
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            ModeloEntity entity = factory.manufacturePojo(ModeloEntity.class);
            
            em.persist(entity);
            data.add(entity);
        }
    }
    /**
     * Prueba para crear un Modelo.
     *
     * 
     */
    @Test
    public void createModeloTest() {
        PodamFactory factory = new PodamFactoryImpl();
        ModeloEntity newEntity = factory.manufacturePojo(ModeloEntity.class);
        ModeloEntity result = modeloPersistence.create(newEntity);
        Assert.assertNotNull(result);

        ModeloEntity entity = em.find(ModeloEntity.class, result.getId());

        Assert.assertEquals(newEntity.getReferencia(), entity.getReferencia());
    }

    /**
     * Prueba para consultar la lista de Modelos.
     *
     * 
     */
    
    @Test
    public void getModelosTest() {
        List<ModeloEntity> list = modeloPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (ModeloEntity ent : list) {
            boolean found = false;
            for (ModeloEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * Prueba para consultar un Modelo.
     *
     * 
     */
    @Test
    public void getModeloTest() {
        ModeloEntity entity = data.get(0);
        ModeloEntity newEntity = modeloPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getReferencia(), newEntity.getReferencia());
        Assert.assertTrue(entity.getCalificacionMedia() == newEntity.getCalificacionMedia());
    }

    /**
     * Prueba para eliminar un Modelo.
     *
     * 
     */
    @Test
    public void deleteModeloTest() {
        ModeloEntity entity = data.get(0);
        modeloPersistence.delete(entity.getId());
        ModeloEntity deleted = em.find(ModeloEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Prueba para actualizar un Modelo.
     *
     * 
     */
    @Test
    public void updateModeloTest() {
        ModeloEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        ModeloEntity newEntity = factory.manufacturePojo(ModeloEntity.class);

        newEntity.setId(entity.getId());

        modeloPersistence.update(newEntity);

        ModeloEntity resp = em.find(ModeloEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getReferencia(), resp.getReferencia());
    }
}