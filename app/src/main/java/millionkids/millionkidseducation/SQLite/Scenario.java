package millionkids.millionkidseducation.SQLite;

/**
 * Created by dorimouawad on 4/16/17.
 */

public class Scenario {
    private int scenarioid;
    private int ageid;
    private String location;
    private String image;

    //Default Constructor
    public Scenario(){}

    //Constructor
    public Scenario(int scenarioid, int ageid, String location, String image){
        super();
        this.scenarioid = scenarioid;
        this.ageid = ageid;
        this.location = location;
        this.image = image;
    }
}
