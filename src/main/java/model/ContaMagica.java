package model;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
public class ContaMagica {
    private String nome;
    private BigDecimal saldo;
    private Categoria categoria = Categoria.SILVER;

    public ContaMagica(String nome, BigDecimal saldo) {
        this.nome = nome;
        this.saldo = saldo;
    }

    public void deposito(BigDecimal valor) {
        if (valor.compareTo(new BigDecimal(0)) <= 0){
            System.out.println("Não é possível depositar valores negativos ou nulos!");
        }
        else{
            saldo = saldo.add(valor);

            if (saldo.compareTo(new BigDecimal(50000)) >= 0 && saldo.compareTo(new BigDecimal(200000)) < 0 && categoria == Categoria.SILVER){
                categoria = Categoria.GOLD;
                saldo = saldo.add(valor.multiply(new BigDecimal(0.01)));
            }
            else if (saldo.compareTo(new BigDecimal(200000)) >= 0 && (categoria == Categoria.GOLD || categoria == Categoria.SILVER)) {
                categoria = Categoria.PLATINUM;
                saldo = saldo.add(valor.multiply(new BigDecimal(0.025)));
            }
            else if (saldo.compareTo(new BigDecimal(50000)) < 0 && categoria == Categoria.SILVER){
                categoria = Categoria.SILVER;
            }
        }
    }

    public void retirada(BigDecimal valor) {
        if (valor.compareTo(getSaldo()) > 0){
            System.out.println("Saldo insuficiente! Selecione um novo valor.");
        }
        else {
            saldo = saldo.subtract(valor);

            if (categoria == Categoria.PLATINUM){
                if (saldo.compareTo(new BigDecimal(100000)) < 0) {
                    categoria = Categoria.GOLD;
                    System.out.println("Você passou da categoria PLATINUM para GOLD.");
                }
            }
            else if (categoria == Categoria.GOLD){
                if (saldo.compareTo(new BigDecimal(25000)) < 0) {
                    categoria = Categoria.SILVER;
                    System.out.println("Você passou da categoria GOLD para SILVER.");
                }
            }
        }
    }
}