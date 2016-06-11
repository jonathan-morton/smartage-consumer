package consumer.smartage.hackathon.att.smartage_consumer.models;

/**
 * Created by geek on 11/6/16.
 */
public class Location {
    double longitude;
    double lattitude;

    public void Location() {
        longitude = 0.0;
        lattitude = 0.0;
    }

    public double getLogitude() {
        return longitude;
    }

    public double getLattitude() {
        return lattitude;
    }

    public void setLogitude(double longit) {
        longitude = longit;
    }

    public void setLattitude(double lat) {
        lattitude = lat;
    }
}
