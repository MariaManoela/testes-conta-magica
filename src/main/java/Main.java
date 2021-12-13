import model.ContaMagica;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        ContaMagica conta1 = new ContaMagica("Manu", new BigDecimal(100));

        conta1.deposito(new BigDecimal(50));
        System.out.println(conta1.getStatus());
    }
}
