package consumer.smartage.hackathon.att.smartage_consumer.models;

/**
 * Created by geek on 11/6/16.
 */
public class Trashcan {
    double volume;
    double capacity;
    int id;
    int userReports;
    public Location canLocation= new Location();


    public double getVolume(){
        return volume;
    }

    public double getCapacity(){
        return capacity;
    }


    public int getId(){
        return id;
    }

    public int getReportsCount(){
        return userReports;
    }


    public void setVolume(int vol){
        volume =vol;
    }

    public void setCapacity(int cap){
        capacity=cap;
    }

    public void setId(int giveId){
        id=giveId;
    }

    public void addReport(){
        userReports++;
    }


    public void subReport(){
        if(userReports>=0){
            userReports--;
        }else{
            userReports=0;
        }
    }

    public void setLatitide(double latitide){
        canLocation.setLatitude(latitide);
    }

    public void setLongitude(double longitude){
        canLocation.setLongitude(longitude);
    }

    public double getLatitide(){
        return getLatitide();
    }

    public double getLongitude(){
        return getLongitude();
    }
}
