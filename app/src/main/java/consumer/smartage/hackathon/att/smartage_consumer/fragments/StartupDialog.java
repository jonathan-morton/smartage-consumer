package consumer.smartage.hackathon.att.smartage_consumer.fragments;


import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import consumer.smartage.hackathon.att.smartage_consumer.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class StartupDialog extends android.app.DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder =new AlertDialog.Builder(getActivity());
        builder.setTitle("Choose user type")
                .setMessage("Who are you?");
        return builder.create();
    }
}
