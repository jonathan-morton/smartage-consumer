package consumer.smartage.hackathon.att.smartage_consumer.models;

/**
 * Created by Ru Fang on 6/11/16.
 */
public class Trash {
    private int id;
    private String type;
    private String optDesctip;

    //  Constructor: default
    public Trash() {
        this.id = 0;
        this.type = null;
        this.optDesctip = null;
    }

    //  Getter
    public int getId() {
        return id;
    }

    //  Setter
    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOptDesctip() {
        return optDesctip;
    }

    public void setOptDesctip(String optDesctip) {
        this.optDesctip = optDesctip;
    }
}
