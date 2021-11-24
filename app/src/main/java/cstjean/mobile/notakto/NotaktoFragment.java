package cstjean.mobile.notakto;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import java.util.Objects;

/**
 * Classe pour le fragment du notakto.
 *
 * @author Hakim-Anis Hamani
 */

public class NotaktoFragment extends Fragment implements View.OnClickListener {
    /**
     * Liste ayant les boutons de l'interface.
     */
    private static final Button[] buttons = new Button[9];

    /**
     * TexteView ayant pour but de montrer le status de la partie.
     */
    private TextView tourJouer;

    /**
     * Methode onCreate chargent l'instance si celle-ci est sauvegarder.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * Méthode ayant pour but de charger l'activiter et l'attribution des composant utilisé dans l'activité.
     */
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (savedInstanceState != null) {

            // TODO
        }
        View view = inflater.inflate(R.layout.fragment_notakto, container, false);

        for (int i = 0; i < buttons.length; i++) {
            String buttonId = "button" + i;
            int resssoureId = getResources().getIdentifier(buttonId,
                    "id", Objects.requireNonNull(getActivity()).getPackageName());
            buttons[i] = view.findViewById(resssoureId);
            buttons[i].setOnClickListener(this);
        }
        tourJouer = view.findViewById(R.id.textView2);
        tourJouer.setOnClickListener(this);

        Button btnReset = view.findViewById(R.id.buttonRenitialiser);
        btnReset.setOnClickListener(this);
        return view;
    }

    /**
     * Methode onSaveInstanceState ayant pour but de sauvegarder l'information de l'instance.
     */
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

    }

    /**
     * Methode ayant pour but de gérer le comportement des boutons lors du click.
     */
    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.buttonRenitialiser) {
            Notakto.reinitialiser();

            for (Button button : buttons) {
                button.setText("");
                button.setEnabled(true);
            }
        } else {
            ((Button) v).setText("X");
            (v).setEnabled(false);
            String nomButton = v.getResources().getResourceName(v.getId());
            int positionButton = Integer.parseInt(nomButton.substring(nomButton.length() - 1));
            SingletonNotakto.getCaseUtilise()[positionButton] = true;
            if (SingletonNotakto.getTourJoueur1()) {
                SingletonNotakto.setTourJoueur1(false);
                tourJouer.setText(getResources().getString(R.string.tour_Deuxieme));
            } else {
                SingletonNotakto.setTourJoueur1(true);
                tourJouer.setText(getResources().getString(R.string.tour_Premier));
            }
            if (Notakto.verificationDefaite()) {
                for (Button button : buttons) {
                    button.setEnabled(false);
                }
                if (SingletonNotakto.getTourJoueur1()) {
                    tourJouer.setText(getResources().getString(R.string.victoire_Premier));
                } else {
                    tourJouer.setText(getResources().getString(R.string.victoire_Deuxieme));
                }

            }
        }
    }
}
