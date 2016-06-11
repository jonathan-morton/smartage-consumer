package consumer.smartage.hackathon.att.smartage_consumer.models;

import android.net.Uri;
import android.content.Intent;
import android.view.Menu;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;

/**
 * Created by joshabrams on 6/11/16.
 */
public class Route {
    private Trashcan[] waypoints;

    public Route() {
        this.waypoints = new Trashcan[2];
    }

    public void plotRoute() {
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse("http://maps.google.com/maps?saddr=" + waypoints[0].latitude + "," + waypoints[0].longitude + "&daddr=" + waypoints[1].latitude + "," + waypoints[1].longitude));
        startActivity(intent);
    }
}
