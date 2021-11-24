package cstjean.mobile.notakto;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;


public class NotaktoFragment extends Fragment implements View.OnClickListener {

    private static final Button[] buttons = new Button[9];

    private TextView tourJouer;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            caseUtilisé = savedInstanceState();
        }
        View view = inflater.inflate(R.layout.fragment_notakto, container, false);

        for (int i = 0; i < buttons.length; i++) {
            String buttonId = "button" + i;
            int resID = getResources().getIdentifier(buttonId, "id", getActivity().getPackageName());
            buttons[i] = view.findViewById(resID);
            buttons[i].setOnClickListener(this);
        }
        tourJouer = view.findViewById(R.id.textView2);
        tourJouer.setOnClickListener(this);

        Button btn_reset = view.findViewById(R.id.buttonRenitialiser);
        btn_reset.setOnClickListener(this);
        return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putChar(ANSWER_ONE_BUTTON_ISCLICKED,"X" );
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.buttonRenitialiser) {
            Notakto.reinitialiser();

            for (Button button: buttons) {
                button.setText("");
                button.setEnabled(true);
            }
        } else {
            ((Button) v).setText("X");
            (v).setEnabled(false);
            String nomButton = v.getResources().getResourceName(v.getId());
            int positionButton = Integer.parseInt(nomButton.substring(nomButton.length() - 1));
            SingletonNotakto.getInstance().getCaseUtilise()[positionButton] = true;
            if (SingletonNotakto.getInstance().getTourJoueur1()) {
                SingletonNotakto.getInstance().setTourJoueur1(false);
                tourJouer.setText("Tour au Joueur 2");
            } else {
                SingletonNotakto.getInstance().setTourJoueur1(true);
                tourJouer.setText("Tour au Joueur 1");
            }
            if (Notakto.verificationDefaite()) {
                for (Button button: buttons) {
                    button.setEnabled(false);
                }
                if (SingletonNotakto.getInstance().getTourJoueur1()) {
                    tourJouer.setText("Joueur 1 est victorieux!");
                    Toast.makeText(Objects.requireNonNull(getActivity()).getApplicationContext(), "Joueur 1 a gagné!", Toast.LENGTH_SHORT).show();

                } else {
                    tourJouer.setText("Joueur 2 est victorieux!");
                    Toast.makeText(getActivity().getApplicationContext(), "Joueur 2 a gagné!", Toast.LENGTH_SHORT).show();

                }

            }
        }
    }
}
