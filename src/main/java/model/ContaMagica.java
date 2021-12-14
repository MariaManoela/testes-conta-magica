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
        String deposita = saldo.toString();

        if (valor.compareTo(new BigDecimal(0)) == 0 || (valor.compareTo(new BigDecimal(0))) < 0){
            System.out.println("Não é possível depositar valores negativos ou nulos!");
        }
        else {
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
    }

    public void retirada(BigDecimal valor) {
        if (valor.compareTo(getSaldo()) > 0){
            System.out.println("Saldo insuficiente! Selecione um novo valor.");
        }
        else{
            String retirada = saldo.toString();
            saldo = new BigDecimal(retirada).subtract(valor);

            if (getStatus().equals(Categoria.PLATINUM)){
                if (saldo.compareTo(new BigDecimal(100000)) < 0) {
                    categoria = Categoria.GOLD;
                    System.out.println("Você passou da categoria PLATINUM para GOLD.");
                }
            }
            else if(getStatus().equals(Categoria.GOLD)){
                if (saldo.compareTo(new BigDecimal(25000)) < 0) {
                    categoria = Categoria.SILVER;
                    System.out.println("Você passou da categoria GOLD para SILVER.");
                }
            }
        }
    }

    public Categoria getStatus() {
        if (saldo.compareTo(new BigDecimal(50000)) < 0) {
            categoria = Categoria.SILVER;
        }
        else if(saldo.compareTo(new BigDecimal(50000)) == 0 || (saldo.compareTo(new BigDecimal(50000)) > 0 && saldo.compareTo(new BigDecimal(200000)) < 0)) {
            categoria = Categoria.GOLD;
        }
        else{
            categoria = Categoria.PLATINUM;
        }
        return categoria;
    }
}