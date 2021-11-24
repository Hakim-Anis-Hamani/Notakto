package cstjean.mobile.notakto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestNotakto {

    final boolean[] listeDepart = {false, false, false, false, false, false, false, false, false};

    final boolean[] listePerdanteHorizontale = {true, true, true, false, false, false, false, false, false};


    @Test
    public void testReinitialiser() {
        SingletonNotakto.setTourJoueur1(false);
        SingletonNotakto.setCaseUtilise(listePerdanteHorizontale);

        Notakto.reinitialiser();

        assertTrue(SingletonNotakto.getTourJoueur1());
        for (int i = 0; i < 9; i++) {
            assertTrue(SingletonNotakto.getCaseUtilise()[i] == listeDepart[i]);
        }

    }

    @Test
    public void testverificationDefaite() {
        assertEquals(false, Notakto.verificationDefaite());

        SingletonNotakto.setCaseUtilise(listePerdanteHorizontale);
        assertEquals(true, Notakto.verificationDefaite());
    }
}