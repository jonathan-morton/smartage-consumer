package consumer.smartage.hackathon.att.smartage_consumer.models;

/**
 * Created by Ru Fang on 6/11/16.
 */
public class Trash {
    private int id;
    private String type;
    private String optionalDescription;

    //  Constructor: default
    public Trash() {
        this.id = 0;
        this.type = null;
        this.optionalDescription = null;
    }

    //  Setter and Getter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOptionalDescription() {
        return optionalDescription;
    }

    public void setOptionalDescription(String optionalDescription) {
        this.optionalDescription = optionalDescription;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
