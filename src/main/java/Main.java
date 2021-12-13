import model.ContaMagica;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        ContaMagica conta1 = new ContaMagica();
        conta1.setSaldo(new BigDecimal(0));

        conta1.deposito(new BigDecimal(500));
        conta1.retirada(new BigDecimal(200));
        System.out.println(conta1.getStatus());
        System.out.println(conta1.getSaldo());
    }
}
