package millionkids.millionkidseducation.Parent;

/**
 * Created by walki on 3/30/2017.
 */

public class Content
{

    private String returnSummaryContent = "",
            returnGroomingContent = "",
            returnWarningSignsContent = "",
            returnPreventativeMeasure = "",
            currentContent = "";
    private final String SEX_TRAFFICKING_MINOR = "sex trafficking minor",
            SEX_TRAFFICKING_ADULT = "sex trafficking adult",
            LABOR_TRAFFICKING = "labor trafficking",
            SEXTORTION = "sextortion",
            CHILD_PORNOGRAPHY = "child pornography",
            SOCIAL_MEDIA_EXPLOITATION = "social media exploitation";

    //constructor
    public Content(String currentContent)
    {
        this.currentContent = currentContent;
        setContents(currentContent);
    }

    //create methods to return information contents
    public String summaryContent() {return returnSummaryContent; }
    public String groomingProcessContent() { return returnGroomingContent; }
    public String warningSignsContent() { return returnWarningSignsContent; }
    public String preventativeMeasureContent() { return returnPreventativeMeasure; }

    public String getCurrentContent() { return currentContent; }
    //set methods
    public void setcurrentContent(String currentContent)
    {
        this.currentContent = currentContent;
        setContents(currentContent);
    }

    private void setContents(String currentContent)
    {
        if(currentContent.equalsIgnoreCase(SEX_TRAFFICKING_MINOR))
            setSexTraffickingMinor();
        else if (currentContent.equalsIgnoreCase(SEX_TRAFFICKING_ADULT))
            setSexTraffickingAdult();
        else if (currentContent.equalsIgnoreCase(LABOR_TRAFFICKING))
            setLaborTrafficking();
        else if (currentContent.equalsIgnoreCase(SEXTORTION))
            setSextortion();
        else if (currentContent.equalsIgnoreCase(CHILD_PORNOGRAPHY))
            setChildPornography();
        else if (currentContent.equalsIgnoreCase(SOCIAL_MEDIA_EXPLOITATION))
            setSocialMediaExploitation();
    }

    private void setSexTraffickingMinor()
    {
        returnSummaryContent = "file:///android_asset/SexTraffickingMinor/SEXTRAFFICKINGMINOR_Summary.html";
        returnGroomingContent = "file:///android_asset/ChildPornography/CHILDPORNOGRAPHY_Grooming-Process.html";
        returnWarningSignsContent = "file:///android_asset/SexTraffickingMinor/SEXTRAFFICKINGMINOR_Warning-Signs.html";
        returnPreventativeMeasure = "file:///android_asset/SexTraffickingMinor/SEXTRAFFICKINGMINOR_Preventative-Measure.html";
    }

    private void setSexTraffickingAdult()
    {
        returnSummaryContent = "file:///android_asset/SexTraffickingAdult/SEXTRAFFICKINGADULT_Summary.html";
        returnGroomingContent = "file:///android_asset/SexTraffickingAdult/SEXTRAFFICKINGADULT_Grooming-Process.html";
        returnWarningSignsContent = "file:///android_asset/SexTraffickingAdult/SEXTRAFFICKINGADULT_Warning-Signs.html";
        returnPreventativeMeasure = "file:///android_asset/SexTraffickingAdult/SEXTRAFFICKINGADULT_Preventative-Measure.html";
    }

    private void setLaborTrafficking()
    {
        returnSummaryContent = "file:///android_asset/LaborTrafficking/LABORTRAFFICKING_Summary.html";
        returnGroomingContent = "file:///android_asset/LaborTrafficking/LABORTRAFFICKING_Grooming-Process.html";
        returnWarningSignsContent = "file:///android_asset/LaborTrafficking/LABORTRAFFICKING_Warning-Signs.html";
        returnPreventativeMeasure = "file:///android_asset/LaborTrafficking/LABORTRAFFICKING_Preventative-Measure.html";
    }

    private void setSextortion()
    {
        returnSummaryContent = "file:///android_asset/Sextortion/SEXTORTION_Summary.html";
        returnGroomingContent = "file:///android_asset/Sextortion/SEXTORTION_Grooming-Process.html";
        returnWarningSignsContent = "file:///android_asset/Sextortion/SEXTORTION_Warning-Signs.html";
        returnPreventativeMeasure = "file:///android_asset/Sextortion/SEXTORTION_Preventative-Measure.html";
    }

    private void setChildPornography()
    {
        returnSummaryContent = "file:///android_asset/ChildPornography/CHILDPORNOGRAPHY_Summary.html";
        returnGroomingContent = "file:///android_asset/ChildPornography/CHILDPORNOGRAPHY_Grooming-Process.html";
        returnWarningSignsContent = "file:///android_asset/ChildPornography/CHILDPORNOGRAPHY_Warning-Signs.html";
        returnPreventativeMeasure = "file:///android_asset/ChildPornography/CHILDPORNOGRAPHY_Preventative-Measure.html";
    }

    private void setSocialMediaExploitation()
    {
        returnSummaryContent = "file:///android_asset/SocialMediaExploitation/SOCIAL_Summary.html";
        returnGroomingContent = "file:///android_asset/SocialMediaExploitation/SOCIAL_Grooming-Process.html";
        returnWarningSignsContent = "file:///android_asset/SocialMediaExploitation/SOCIAL_Warning-Signs.html";
        returnPreventativeMeasure = "file:///android_asset/SocialMediaExploitation/SOCIAL_Preventative-Measure.html";
    }
}
