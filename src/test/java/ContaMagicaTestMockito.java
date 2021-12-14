import model.ContaMagica;
import model.MktBanco;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

public class ContaMagicaTestMockito {
    private MktBanco mktBanco;
    private ContaMagica contaMagica;

    @BeforeEach
    public void setUp(){
        contaMagica = Mockito.mock(ContaMagica.class);
        mktBanco = new MktBanco(contaMagica);
    }
}
