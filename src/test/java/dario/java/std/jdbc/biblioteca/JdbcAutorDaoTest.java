package dario.java.std.jdbc.biblioteca;

import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JdbcAutorDaoTest {
    
    private AutorDao autorDao = new JdbcAutorDao();
    
    @Test
    public void testGrabar() {
        Autor garciaMarquez = new Autor("Gabriel", "Garcia Marquez", "Colombia");
        Autor grabado =  autorDao.grabar(garciaMarquez);

        Assert.assertNotNull(grabado.getId());
    }
    
    @Test
    public void testFindById() {
        Autor garciaMarquez = new Autor("Gabriel", "Garcia Marquez", "Colombia");
        Autor grabado =  autorDao.grabar(garciaMarquez);
        
        Autor buscado = autorDao.traerPorId(grabado.getId());

        Assert.assertEquals(grabado, buscado);
    }
        
}
