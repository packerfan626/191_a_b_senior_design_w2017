package millionkids.millionkidseducation.SQLite;

/**
 * Created by dorimouawad on 4/16/17.
 */

public class Scenario {
    private int scenarioid;
    private int ageid;
    private String location;
    private String image;
    private String imagePath;

    //Default Constructor
    public Scenario(){}

    //Constructor
    public Scenario(int scenarioid, int ageid, String location, String image, String imagePath){
        super();
        this.scenarioid = scenarioid;
        this.ageid = ageid;
        this.location = location;
        this.image = image;
        this.imagePath = imagePath;
    }

    //Scenario toString to transport data
    public String toString(){
        return "Scenario [scenarioid="+ scenarioid + ", ageid=" + ageid + ", location=" +location
        + ", image=" + image+ "]";
    }

    //SetScenario ID
    public void setScenarioid(int scenarioid){
        this.scenarioid = scenarioid;
    }

    //Set AGEId
    public void setAgeid(int ageid){
        this.ageid = ageid;
    }

    //Set Location
    public void setLocation(String location){
        this.location = location;
    }

    //Set Image
    public void setImage(String image){
        this.image = image;
    }

    //Set Image Path
    public void setImagePath(String path){
        this.imagePath = path;
    }

    //Set Get Path
    public String getImagePath(){
        return this.imagePath;
    }

    //Get Image
    public String getImage(){ return this.image; }

    //Get id
    public  int getScenarioid(){ return this.scenarioid; }

    //Get Location
    public String getLocation(){ return this.location; }
}
