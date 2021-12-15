package model;

import java.math.BigDecimal;

public class MktBanco {
    ContaMagica contaMagica;

    public MktBanco (ContaMagica contaMagica){
        this.contaMagica = contaMagica;
    }

    public BigDecimal faltanteProxCategoria(){
        Categoria categoria = contaMagica.getCategoria();
        BigDecimal valor;

        if (categoria == Categoria.SILVER){
            return valor = new BigDecimal(50000).subtract(contaMagica.getSaldo());
        }
        else if (categoria == Categoria.GOLD){
            return valor = new BigDecimal(200000).subtract(contaMagica.getSaldo());
        }
        else{
            return BigDecimal.ZERO;
        }
    }

    public Categoria proxCategoria(){
        Categoria categoria = contaMagica.getCategoria();

        if (categoria == Categoria.SILVER){
            return Categoria.GOLD;
        }
        else if (categoria == Categoria.GOLD){
            return Categoria.PLATINUM;
        }
        else {
            return Categoria.PLATINUM;
        }
    }
}
