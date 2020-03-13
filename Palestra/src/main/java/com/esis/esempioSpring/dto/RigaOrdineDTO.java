package com.esis.esempioSpring.dto;

import java.io.Serializable;

/**
 *
 * @author silvano
 */
public class RigaOrdineDTO implements Serializable {

    private Integer numeroPezzi;
    private String codiceArticolo;
    private String descrizione;
    
    public RigaOrdineDTO() {
    }

    public String getCodiceArticolo() {
        return codiceArticolo;
    }

    public void setCodiceArticolo(String codiceArticolo) {
        this.codiceArticolo = codiceArticolo;
    }

    public Integer getNumeroPezzi() {
        return numeroPezzi;
    }

    public void setNumeroPezzi(Integer numeroPezzi) {
        this.numeroPezzi = numeroPezzi;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
}
