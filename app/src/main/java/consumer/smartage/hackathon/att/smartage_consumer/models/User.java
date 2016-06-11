package consumer.smartage.hackathon.att.smartage_consumer.models;

/**
 * Created by Ru Fang on 6/11/16.
 */
public class User {
    private int id;
    private float longitude;
    private float latitude;
    
    //  The constructor set the default value ( 0 ) to user object
    public User() {
        this.id = 0;
        this.longitude = 0;
        this.latitude = 0;
    }

    //  getter
    public int getId() {
        return id;
    }

    //  setter
    public void setId(int id) {
        this.id = id;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }
}
