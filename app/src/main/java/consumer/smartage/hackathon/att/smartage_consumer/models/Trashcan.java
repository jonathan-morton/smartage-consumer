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

    public int getUsr_reports(){
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
        }
    }

    public void setLattitide(double lattitide){
        canLocation.setLattitude(lattitide);
    }

    public void setLongitude(double longitude){
        canLocation.setLattitude(longitude);
    }
}
