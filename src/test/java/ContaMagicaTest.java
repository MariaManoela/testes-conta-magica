import static org.junit.jupiter.api.Assertions.*;

import model.Categoria;
import model.ContaMagica;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class ContaMagicaTest {
    ContaMagica conta1;

    @BeforeEach
    public void setUp(){
        conta1 = new ContaMagica("Manu", new BigDecimal(0));
    }

    @Test
    public void deposita(){
        System.out.println("=======DEPOSITANDO=======");
        conta1.deposito(new BigDecimal(30000));
        assertEquals(new BigDecimal(30000), conta1.getSaldo());
        System.out.println(conta1.getSaldo());
    }

    @Test
    public void depositaNegativoOuNulo(){
        System.out.println("=======DEPÓSITO NEGATIVO OU NULO=======");
        conta1.deposito(new BigDecimal(5000));
        conta1.deposito(new BigDecimal(-100));
        assertEquals(new BigDecimal(5000), conta1.getSaldo());
        System.out.println(conta1.getSaldo());
    }

    @Test
    public void retira(){
        System.out.println("=======RETIRANDO=======");
        conta1.deposito(new BigDecimal(5000));
        conta1.retirada(new BigDecimal(2000));
        assertEquals(new BigDecimal(3000), conta1.getSaldo());
        System.out.println(conta1.getSaldo());
    }

    @Test
    public void retiraValorMaiorQueSaldo(){
        System.out.println("=======RETIRANDO VALOR MAIOR QUE O SALDO=======");
        conta1.deposito(new BigDecimal(1000));
        conta1.retirada(new BigDecimal(1001));
        assertEquals(new BigDecimal(1000), conta1.getSaldo());
        System.out.println(conta1.getSaldo());
    }

    @Test
    public void verificaContaSilver(){
        System.out.println("=======CONTA SILVER=======");
        conta1.deposito(new BigDecimal(49999));
        assertEquals(Categoria.SILVER, conta1.getCategoria());
        System.out.println(conta1.getCategoria());
    }

    @Test
    public void verificaContaGold(){
        System.out.println("=======CONTA GOLD=======");
        conta1.deposito(new BigDecimal(50000));
        assertEquals(Categoria.GOLD, conta1.getCategoria());
        System.out.println(conta1.getCategoria());
    }

    @Test
    public void verificaContaPlatinum(){
        System.out.println("=======CONTA PLATINUM=======");
        conta1.deposito(new BigDecimal(200000));
        assertEquals(Categoria.PLATINUM, conta1.getCategoria());
        System.out.println(conta1.getCategoria());
    }

    @Test
    public void verificaPlatinumParaGold(){
        System.out.println("=======PLATINUM PARA GOLD=======");
        conta1.deposito(new BigDecimal(200000));
        conta1.retirada(new BigDecimal(170000));
        conta1.retirada(new BigDecimal(10000));
        assertEquals(Categoria.GOLD, conta1.getCategoria());
        System.out.println(conta1.getCategoria());
    }
}
