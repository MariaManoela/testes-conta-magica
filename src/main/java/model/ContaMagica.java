package model;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContaMagica {
    private String nome;
    private BigDecimal saldo;
    private Categoria categoria = Categoria.SILVER;

    public void deposito(BigDecimal valor) {
        saldo.add(valor);
        System.out.println("Valior atual da conta: R$ " + getSaldo());
    }

    public void retirada(BigDecimal valor) {
        if((saldo.doubleValue() - valor.doubleValue()) < 0) {
            System.out.println("Saldo insuficiente!");
        }else{
            saldo.subtract(valor);
        }
    }

    public Categoria getStatus() {
        return getCategoria();
    }
}