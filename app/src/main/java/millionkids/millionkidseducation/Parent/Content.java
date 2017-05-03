package millionkids.millionkidseducation.Parent;

/**
 * Created by walki on 3/30/2017.
 */

public class Content
{
    //instantiate
    private String
            returnSummaryContent = "",
            returnGroomingContent = "",
            returnWarningSignsContent = "",
            returnPreventativeMeasure = "",
            currentContent = "";
    //SET CURRENT CONTENT
    private final String
            SEX_TRAFFICKING_MINOR = "sex trafficking minor",
            SEX_TRAFFICKING_ADULT = "sex trafficking adult",
            LABOR_TRAFFICKING = "labor trafficking",
            SEXTORTION = "sextortion",
            CHILD_PORNOGRAPHY = "child pornography",
            SOCIAL_MEDIA_EXPLOITATION = "social media exploitation";
    //links to contents HTML
    private final String
            //sex trafficking minor contents location
            SEX_TRAFFICKING_MINOR_OVERVIEW = "file:///android_asset/SexTraffickingMinor/SEXTRAFFICKINGMINOR_Summary - Copy.html",
            SEX_TRAFFICKING_MINOR_GROOM = "file:///android_asset/ChildPornography/CHILDPORNOGRAPHY_Grooming-Process.html",
            SEX_TRAFFICKING_MINOR_WARNING = "file:///android_asset/SexTraffickingMinor/SEXTRAFFICKINGMINOR_Warning-Signs.html",
            SEX_TRAFFICKING_MINOR_PREVENT = "file:///android_asset/SexTraffickingMinor/SEXTRAFFICKINGMINOR_Preventative-Measure.html",
            //Sex trafficking adult contents location
            SEX_TRAFFICKING_ADULT_OVERVIEW = "file:///android_asset/SexTraffickingAdult/SEXTRAFFICKINGADULT_Summary.html",
            SEX_TRAFFICKING_ADULT_GROOM = "file:///android_asset/SexTraffickingAdult/SEXTRAFFICKINGADULT_Grooming-Process.html",
            SEX_TRAFFICKING_ADULT_WARNING = "file:///android_asset/SexTraffickingAdult/SEXTRAFFICKINGADULT_Warning-Signs.html",
            SEX_TRAFFICKING_ADULT_PREVENT = "file:///android_asset/SexTraffickingAdult/SEXTRAFFICKINGADULT_Preventative-Measure.html",
            //labor trafficking contents location
            LABOR_TRAFFICKING_OVERVIEW = "file:///android_asset/LaborTrafficking/LABORTRAFFICKING_Summary.html",
            LABOR_TRAFFICKING_GROOM = "file:///android_asset/LaborTrafficking/LABORTRAFFICKING_Grooming-Process.html",
            LABOR_TRAFFICKING_WARNING = "file:///android_asset/LaborTrafficking/LABORTRAFFICKING_Warning-Signs.html",
            LABOR_TRAFFICKING_PREVENT = "file:///android_asset/LaborTrafficking/LABORTRAFFICKING_Preventative-Measure.html",
            //sextortion contents location
            SEXTORTION_OVERVIEW = "file:///android_asset/Sextortion/SEXTORTION_Summary.html",
            SEXTORTION_GROOM = "file:///android_asset/Sextortion/SEXTORTION_Grooming-Process.html",
            SEXTORTION_WARNING = "file:///android_asset/Sextortion/SEXTORTION_Warning-Signs.html",
            SEXTORTION_PREVENT = "file:///android_asset/Sextortion/SEXTORTION_Preventative-Measure.html",
            //child porno contents location
            CHILD_PORNOGRAPHY_OVERVIEW = "file:///android_asset/ChildPornography/CHILDPORNOGRAPHY_Summary - Copy.html",
            CHILD_PORNOGRAPHY_GROOM = "file:///android_asset/ChildPornography/CHILDPORNOGRAPHY_Grooming-Process.html",
            CHILD_PORNOGRAPHY_WARNING = "file:///android_asset/ChildPornography/CHILDPORNOGRAPHY_Warning-Signs.html",
            CHILD_PORNOGRAPHY_PREVENT = "file:///android_asset/ChildPornography/CHILDPORNOGRAPHY_Preventative-Measure.html",
            //social media contents location
            SOCIAL_MEDIA_EXPLOITATION_OVERVIEW = "file:///android_asset/SocialMediaExploitation/SOCIAL_Summary.html",
            SOCIAL_MEDIA_EXPLOITATION_GROOM = "file:///android_asset/SocialMediaExploitation/SOCIAL_Grooming-Process.html",
            SOCIAL_MEDIA_EXPLOITATION_WARNING = "file:///android_asset/SocialMediaExploitation/SOCIAL_Warning-Signs.html",
            SOCIAL_MEDIA_EXPLOITATION_PREVENT = "file:///android_asset/SocialMediaExploitation/SOCIAL_Preventative-Measure.html";


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
        returnSummaryContent = SEX_TRAFFICKING_MINOR_OVERVIEW;
        returnGroomingContent = SEX_TRAFFICKING_MINOR_GROOM;
        returnWarningSignsContent = SEX_TRAFFICKING_MINOR_WARNING;
        returnPreventativeMeasure = SEX_TRAFFICKING_MINOR_PREVENT;
    }

    private void setSexTraffickingAdult()
    {
        returnSummaryContent = SEX_TRAFFICKING_ADULT_OVERVIEW;
        returnGroomingContent = SEX_TRAFFICKING_ADULT_GROOM;
        returnWarningSignsContent = SEX_TRAFFICKING_ADULT_WARNING;
        returnPreventativeMeasure = SEX_TRAFFICKING_ADULT_PREVENT;
    }

    private void setLaborTrafficking()
    {
        returnSummaryContent = LABOR_TRAFFICKING_OVERVIEW;
        returnGroomingContent = LABOR_TRAFFICKING_GROOM;
        returnWarningSignsContent = LABOR_TRAFFICKING_WARNING;
        returnPreventativeMeasure = LABOR_TRAFFICKING_PREVENT;
    }

    private void setSextortion()
    {
        returnSummaryContent = SEXTORTION_OVERVIEW;
        returnGroomingContent = SEXTORTION_GROOM;
        returnWarningSignsContent = SEXTORTION_WARNING;
        returnPreventativeMeasure = SEXTORTION_PREVENT;
    }

    private void setChildPornography() {
        returnSummaryContent = CHILD_PORNOGRAPHY_OVERVIEW;
        returnGroomingContent = CHILD_PORNOGRAPHY_GROOM;
        returnWarningSignsContent = CHILD_PORNOGRAPHY_WARNING;
        returnPreventativeMeasure = CHILD_PORNOGRAPHY_PREVENT;
    }

    private void setSocialMediaExploitation()
    {
        returnSummaryContent = SOCIAL_MEDIA_EXPLOITATION_OVERVIEW;
        returnGroomingContent = SOCIAL_MEDIA_EXPLOITATION_GROOM;
        returnWarningSignsContent = SOCIAL_MEDIA_EXPLOITATION_WARNING;
        returnPreventativeMeasure = SOCIAL_MEDIA_EXPLOITATION_PREVENT;
    }
}
