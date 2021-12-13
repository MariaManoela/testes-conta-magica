package model;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
public class ContaMagica {
    private String nome;
    private BigDecimal saldo = new BigDecimal(0);
    private Categoria categoria;

    public void deposito(BigDecimal valor) {
        String deposita = saldo.toString();

        if (getStatus().equals(Categoria.SILVER)) {
            saldo = new BigDecimal(deposita).add(valor);
        }
        else if (getStatus().equals(Categoria.GOLD)) {
            BigDecimal valor2 = valor;
            valor = valor.multiply(new BigDecimal(0.01));
            valor = valor.add(valor2);
            saldo = new BigDecimal(deposita).add(valor);
        }
        else if (getStatus().equals(Categoria.PLATINUM)) {
            BigDecimal valor2 = valor;
            valor = valor.multiply(new BigDecimal(0.025));
            valor = valor.add(valor2);
            saldo = new BigDecimal(deposita).add(valor);
        }
    }

    public void retirada(BigDecimal valor) {
        String retirada = saldo.toString();
        saldo = new BigDecimal(retirada).subtract(valor);

        if (saldo.compareTo(new BigDecimal(100000)) == -1) {
            categoria = Categoria.GOLD;
            System.out.println("Você passou da categoria PLATINUM para GOLD.");
        }
        else if (saldo.compareTo(new BigDecimal(25000)) == -1) {
            categoria = Categoria.SILVER;
            System.out.println("Você passou da categoria GOLD para SILVER.");
        }
    }

    public Categoria getStatus() {
        if (saldo.compareTo(new BigDecimal(50000)) == -1) {
            categoria = Categoria.SILVER;
        }
        else if(saldo.compareTo(new BigDecimal(50000)) == 0 || (saldo.compareTo(new BigDecimal(50000)) == 1 && saldo.compareTo(new BigDecimal(200000)) == -1)) {
            categoria = Categoria.GOLD;
        }
        else{
            categoria = Categoria.SILVER;
        }
        return categoria;
    }
}