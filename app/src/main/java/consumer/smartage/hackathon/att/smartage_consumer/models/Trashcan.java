package consumer.smartage.hackathon.att.smartage_consumer.models;

/**
 * Created by geek on 11/6/16.
 */
public class Trashcan {
    double volume;
    int fs;
    int id;
    int nr;
    double latitude;
    double longitude;

    public int getFs() {
        return fs;
    }

    public void setFs(int fs) {
        this.fs = fs;
    }

    public int getNr() {
        return nr;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    public double getVolume() {
        return volume;
    }

    public int getId(){
        return id;
    }


    public void setVolume(int vol){
        volume =vol;
    }

    public void setId(int giveId){
        id=giveId;
    }

    public void addReport(){
        nr++;
    }


    public void subReport(){
        if (nr >= 0) {
            nr--;
        }else{
            nr = 0;
        }
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
