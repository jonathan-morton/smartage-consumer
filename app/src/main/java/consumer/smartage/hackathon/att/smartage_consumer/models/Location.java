package consumer.smartage.hackathon.att.smartage_consumer.models;

/**
 * Created by geek on 11/6/16.
 */
public class Location {
    double longitude;
    double latitude;

    public void Location() {
        longitude = 0.0;
        latitude = 0.0;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLongitude(double longit) {
        longitude = longit;
    }

    public void setLatitude(double lat) {
        latitude = lat;
    }
}
