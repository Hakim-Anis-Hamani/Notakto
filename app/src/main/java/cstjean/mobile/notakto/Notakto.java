package cstjean.mobile.notakto;

/**
 * Classe Principale pour le fonctionnement du Notakto.
 *
 * @author Hakim-Anis Hamani
 */
public class Notakto {

    /**
     * Classe permettant la vérification de victoire.
     *
     * @return possibité de défaite
     */
    public static Boolean verificationDefaite() {
        for (int[] positionPerdante : SingletonNotakto.getInstance().getPosibilitePerdante()) {
            if (SingletonNotakto.getCaseUtilise()[positionPerdante[0]] &&
                    SingletonNotakto.getCaseUtilise()[positionPerdante[0]] ==
                            SingletonNotakto.getCaseUtilise()[positionPerdante[1]] &&
                    SingletonNotakto.getCaseUtilise()[positionPerdante[0]] ==
                            SingletonNotakto.getCaseUtilise()[positionPerdante[2]]) {
                return true;

            }
        }
        return false;
    }

    /**
     * Méthode permettant initialisation et la réinitialisation du jeu.
     */
    public static void reinitialiser() {
        SingletonNotakto.setTourJoueur1(true);
        for (int i = 0; i < 9; i++) {
            SingletonNotakto.getCaseUtilise()[i] = false;
        }
    }
}