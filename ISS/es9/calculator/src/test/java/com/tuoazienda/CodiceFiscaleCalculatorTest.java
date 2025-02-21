package com.tuoazienda;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import com.opencsv.CSVReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.List;

public class CodiceFiscaleCalculatorTest {
    private CodiceFiscaleCalculator c;

    @Before
    public void setUp() throws Exception {
        c = new CodiceFiscaleCalculator();
        assertNotNull(c);
    }

    @After
    public void tearDown() throws Exception {
        c = null;
        assertNull(c);
    }

    @Test
    public void testCalculateCodiceFiscale() throws Exception {
        try (CSVReader reader = new CSVReader(new FileReader("src/test/resources/codice_fiscale_test_data.csv"))) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                String nome = nextLine[0];
                String cognome = nextLine[1];
                String dataDiNascita = nextLine[2];
                char sesso = nextLine[3].charAt(0);
                String comuneDiNascita = nextLine[4];
                String expected = nextLine[5];
                assertEquals(expected, c.calculateCodiceFiscale(nome, cognome, LocalDate.parse(dataDiNascita), sesso, comuneDiNascita));
            }
        }
    }
}
