package cstjean.mobile.notakto;

/**
 * Classe pour le singleton du notakto.
 *
 * @author Hakim-Anis Hamani
 */
public class SingletonNotakto {
    /**
     * Instance garder en mémoire du singleton.
     */
    private static SingletonNotakto instance = null;

    /**
     * Booléen permettant de connaitre si il s'agit du tour du premier joueur.
     */
    private static Boolean tourJoueur1 = true;

    /**
     * Liste permettant de connaitre si le button à un certain index à déjà était utilisé.
     */
    private static boolean[] caseUtilise = {false, false, false, false, false, false, false, false, false};

    /**
     * Liste regroupant les nombreuses possibilités de défaite.
     */
    private static final int[][] possibilitePerdante = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
            {0, 4, 8}, {2, 4, 6}
    };

    private SingletonNotakto() {

    }

    /**
     * Méthode permettant la vérification et la génération d'une instance du singleton.
     *
     * @return instance du singleton si il existe
     */
    public static SingletonNotakto getInstance() {
        if (instance == null) {
            instance = new SingletonNotakto();
        }
        return instance;
    }

    public static boolean[] getCaseUtilise() {
        return caseUtilise;
    }

    /**
     * Méthode permettant de retourner l'état des boutons.
     *
     * @param caseUtilise est la liste des état des boutons
     */
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
        return possibilitePerdante;
    }
}