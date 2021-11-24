package cstjean.mobile.notakto;

/**
 * */
public class Notakto {
    /**
 * */
 public static Boolean verificationDefaite() {
        for (int[] positionPerdante : SingletonNotakto.getInstance().getPosibilitePerdante()) {
            if (SingletonNotakto.getInstance().getCaseUtilise()[positionPerdante[0]] &&
                    SingletonNotakto.getInstance().getCaseUtilise()[positionPerdante[0]] == SingletonNotakto.getInstance().getCaseUtilise()[positionPerdante[1]] &&
                    SingletonNotakto.getInstance().getCaseUtilise()[positionPerdante[0]] == SingletonNotakto.getInstance().getCaseUtilise()[positionPerdante[2]]) {
                return true;

            }
        }
        return false;
    }
    /**
     * */
    public static void reinitialiser() {
        SingletonNotakto.getInstance().setTourJoueur1(true);
        for (int i = 0; i < 9; i++) {
            SingletonNotakto.getInstance().getCaseUtilise()[i] = false;
        }
    }
}