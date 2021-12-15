import static org.junit.jupiter.api.Assertions.*;

import model.Categoria;
import model.ContaMagica;
import model.MktBanco;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.math.BigDecimal;

public class ContaMagicaTestMockito {
    private MktBanco mktBanco;
    private ContaMagica contaMagica;

    @BeforeEach
    public void setUp(){
        contaMagica = Mockito.mock(ContaMagica.class);
        mktBanco = new MktBanco(contaMagica);
    }

    @Test
    public void deposita(){
        System.out.println("=======DEPÓSITO=======");
        Mockito.when(contaMagica.getSaldo()).thenReturn(new BigDecimal(50000));
        assertEquals(new BigDecimal(50000), contaMagica.getSaldo());
        System.out.println(contaMagica.getSaldo());
    }

    @Test
    public void faltanteSilver(){
        System.out.println("=======FALTANTE PRÓXIMA CATEGORIA SILVER PARA GOLD=======");
        Mockito.when(contaMagica.getSaldo()).thenReturn(new BigDecimal(20000));
        Mockito.when(contaMagica.getCategoria()).thenReturn(Categoria.SILVER);
        assertEquals(new BigDecimal(30000), mktBanco.faltanteProxCategoria());
        System.out.println(mktBanco.faltanteProxCategoria());
    }

    @Test
    public void faltanteGold(){
        System.out.println("=======FALTANTE PRÓXIMA CATEGORIA GOLD PARA PLATINUM=======");
        Mockito.when(contaMagica.getSaldo()).thenReturn(new BigDecimal(150000));
        Mockito.when(contaMagica.getCategoria()).thenReturn(Categoria.GOLD);
        assertEquals(new BigDecimal(50000), mktBanco.faltanteProxCategoria());
        System.out.println(mktBanco.faltanteProxCategoria());
    }

    @Test
    public void faltantePlatinum(){
        System.out.println("=======FALTANTE PLATINUM=======");
        Mockito.when(contaMagica.getSaldo()).thenReturn(new BigDecimal(210000));
        Mockito.when(contaMagica.getCategoria()).thenReturn(Categoria.PLATINUM);
        assertEquals(BigDecimal.ZERO, mktBanco.faltanteProxCategoria());
        System.out.println(mktBanco.faltanteProxCategoria());
    }

    @Test
    public void silverParaGold(){
        System.out.println("=======PRÓXIMA CATEGORIA=======");
        Mockito.when(contaMagica.getCategoria()).thenReturn(Categoria.SILVER);
        assertEquals(Categoria.GOLD, mktBanco.proxCategoria());
        System.out.println(mktBanco.proxCategoria());
    }

    @Test
    public void goldParaPlatinum(){
        System.out.println("=======PRÓXIMA CATEGORIA=======");
        Mockito.when(contaMagica.getCategoria()).thenReturn(Categoria.GOLD);
        assertEquals(Categoria.PLATINUM, mktBanco.proxCategoria());
        System.out.println(mktBanco.proxCategoria());
    }

    @Test
    public void platinumCategoriaMax(){
        System.out.println("=======CATEGORIA MÁXIMA=======");
        Mockito.when(contaMagica.getCategoria()).thenReturn(Categoria.PLATINUM);
        assertEquals(Categoria.PLATINUM, mktBanco.proxCategoria());
        System.out.println(mktBanco.proxCategoria());
    }
}
