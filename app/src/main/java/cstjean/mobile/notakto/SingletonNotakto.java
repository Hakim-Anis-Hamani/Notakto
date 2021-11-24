package cstjean.mobile.notakto;

public class SingletonNotakto {
    private static SingletonNotakto instance = null;

    private static Boolean tourJoueur1 = true;

    private static boolean[] caseUtilise = {false, false, false, false, false, false, false, false, false};

    private static final int[][] posibilitePerdante = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
            {0, 4, 8}, {2, 4, 6}
    };

    private SingletonNotakto() {

    }

    public static SingletonNotakto getInstance() {
        if (instance == null) {
            instance = new SingletonNotakto();
        }
        return instance;
    }

    public static boolean[] getCaseUtilise() {
        return SingletonNotakto.getInstance().caseUtilise;
    }

    /***/
    public static void setCaseUtilise(boolean[] caseUtilise) {
        SingletonNotakto.caseUtilise = caseUtilise;
    }

    public static Boolean getTourJoueur1() {
        return tourJoueur1;
    }

    public static void setTourJoueur1(Boolean tourJoueur1) {
        SingletonNotakto.tourJoueur1 = tourJoueur1;
    }

    public int[][] getPosibilitePerdante() {
        return posibilitePerdante;
    }
}