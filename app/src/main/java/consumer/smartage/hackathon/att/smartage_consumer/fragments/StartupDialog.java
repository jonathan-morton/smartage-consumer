package consumer.smartage.hackathon.att.smartage_consumer.fragments;


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import consumer.smartage.hackathon.att.smartage_consumer.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class StartupDialog extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder =new AlertDialog.Builder(getActivity());
        builder.setTitle("Choose user type")
                .setMessage("Who are you?")
                .setPositiveButton("Drive", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .setNegativeButton("User", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getActivity(), "You have selected drive mode", Toast.LENGTH_SHORT).show();
                    }
                });

        return builder.create();
    }
}
