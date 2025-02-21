package com.tuoazienda;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CodiceFiscaleCalculator {

    public String calculateCodiceFiscale(String nome, String cognome, LocalDate dataDiNascita, char sesso, String comuneDiNascita) {
        // Simplified codice fiscale generation: this is a dummy implementation
        String cf = "";
        cf += cognome.substring(0, Math.min(3, cognome.length())).toUpperCase();
        cf += nome.substring(0, Math.min(3, nome.length())).toUpperCase();
        cf += dataDiNascita.format(DateTimeFormatter.ofPattern("yy"));
        cf += (sesso == 'M') ? "M" : "F";
        cf += comuneDiNascita.substring(0, Math.min(3, comuneDiNascita.length())).toUpperCase();

        return cf;
    }
}