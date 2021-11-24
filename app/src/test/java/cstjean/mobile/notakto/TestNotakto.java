package cstjean.mobile.notakto;

import org.junit.Test;

import static org.junit.Assert.*;


public class TestNotakto {

    final boolean[] listeDepart = {false,false,false,false,false,false,false,false,false};

    final boolean[] listePerdanteHorizontale = {true,true,true,false,false,false,false,false,false};


    @Test
    public void testReinitialiser() {
        SingletonNotakto.getInstance().setTourJoueur1(false);
        SingletonNotakto.getInstance().setCaseUtilise(listePerdanteHorizontale);

        Notakto.reinitialiser();

        assertTrue(SingletonNotakto.getInstance().getTourJoueur1());
        for (int i = 0 ; i < 9 ; i++){
            assertTrue(SingletonNotakto.getInstance().getCaseUtilise()[i] == listeDepart[i]);
        }

    }

    @Test
    public void testverificationDefaite() {
        assertEquals(false, Notakto.verificationDefaite());

        SingletonNotakto.getInstance().setCaseUtilise(listePerdanteHorizontale);
        assertEquals(true, Notakto.verificationDefaite());
    }
}