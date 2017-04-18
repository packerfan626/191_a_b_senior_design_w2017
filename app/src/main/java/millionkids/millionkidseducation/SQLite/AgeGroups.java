package millionkids.millionkidseducation.SQLite;

/**
 * Created by dorimouawad on 4/17/17.
 */

//Generates data from database per age group.
public class AgeGroups {

    //Stores ageID used to identify per scenario
    private int ageId;

    //Stores String of ageGroup for simple identification in user interface
    private String ageGroup;

    //Stores string for accessing the image used for age group
    private String image;

    //Default constructor
    public AgeGroups(){}

    //Generated constructor
    public AgeGroups(int ageId, String ageGroup){
        super();
        this.ageId = ageId;
        this.ageGroup = ageGroup;
        this.image = image;
    }

    //Generates data to be returned as a string
    public String toString(){
        return "AgeGroups [ageId=" + ageId + ", ageGroup=" + ageGroup + "image=" + image+ "]";
    }

    //Setter: ageId
    public void setAgeid(int ageid){
        this.ageId = ageId;
    }

    //Setter: ageGroup
    public void setAgeGroup(String ageGroup){
        this.ageGroup = ageGroup;
    }

    //Setter: image
    public void setImage(String image){
        this.image = image;
    }

}

