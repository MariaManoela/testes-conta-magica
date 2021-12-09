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
        if(saldo.doubleValue() >= 50000) {
            setCategoria(Categoria.GOLD);
            saldo.add(saldo.multiply(BigDecimal.valueOf(0.01)));
            System.out.println("Status atual da conta: GOLD");
        }
        else if(saldo.doubleValue() >= 200000){
            setCategoria(Categoria.PLATINUM);
            saldo.add(saldo.multiply(BigDecimal.valueOf(0.025)));
            System.out.println("Status atual da conta: PLATINUM");
        }
        System.out.println("Valor atual da conta: R$ " + getSaldo());
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