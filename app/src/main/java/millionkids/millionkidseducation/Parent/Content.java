package millionkids.millionkidseducation.Parent;

/**
 * Created by walki on 3/30/2017.
 */

public class Content
{
    //instantiate
    private String
            returnOverviewContent = "",
            returnGroomingContent = "",
            returnWarningSignsContent = "",
            returnPreventativeMeasure = "",
            currentContent = "",
    //SET CURRENT CONTENT
            SEX_TRAFFICKING_MINOR = "Child Sex Trafficking",
            SEX_TRAFFICKING_ADULT = "Adult Sex Trafficking",
            LABOR_TRAFFICKING = "Labor Trafficking",
            SEXTORTION = "Sextortion",
            CHILD_PORNOGRAPHY = "Child Pornography",
            SOCIAL_MEDIA_EXPLOITATION = "Social Media Exploitation",
    //links to contents HTML
            //sex trafficking minor contents location
            SEX_TRAFFICKING_MINOR_OVERVIEW = "file:///android_asset/Parent/ChildSexTrafficking/Child_Sex_Trafficking_Overview.html",
            SEX_TRAFFICKING_MINOR_GROOM = "file:///android_asset/Parent/ChildSexTrafficking/Child_Sex_Trafficking_Grooming-Process.html",
            SEX_TRAFFICKING_MINOR_WARNING = "file:///android_asset/Parent/ChildSexTrafficking/Child_Sex_Trafficking_Warning-Signs.html",
            SEX_TRAFFICKING_MINOR_PREVENT = "file:///android_asset/Parent/ChildSexTrafficking/Child_Sex_Trafficking_Preventative-Measure.html",
            //Sex trafficking adult contents location
            SEX_TRAFFICKING_ADULT_OVERVIEW = "file:///android_asset/Parent/AdultSexTrafficking/Adult_Sex_Trafficking_Overview.html",
            SEX_TRAFFICKING_ADULT_GROOM = "file:///android_asset/Parent/AdultSexTrafficking/Adult_Sex_Trafficking_Grooming-Process.html",
            SEX_TRAFFICKING_ADULT_WARNING = "file:///android_asset/Parent/AdultSexTrafficking/Adult_Sex_Trafficking_Warning-Signs.html",
            SEX_TRAFFICKING_ADULT_PREVENT = "file:///android_asset/Parent/AdultSexTrafficking/Adult_Sex_Trafficking_Preventative-Measure.html",
            //labor trafficking contents location
            LABOR_TRAFFICKING_OVERVIEW = "file:///android_asset/Parent/LaborTrafficking/Labor_Trafficking_Overview.html",
            LABOR_TRAFFICKING_GROOM = "file:///android_asset/Parent/LaborTrafficking/Labor_Trafficking_Grooming-Process.html",
            LABOR_TRAFFICKING_WARNING = "file:///android_asset/Parent/LaborTrafficking/Labor_Trafficking_Warning-Signs.html",
            LABOR_TRAFFICKING_PREVENT = "file:///android_asset/Parent/LaborTrafficking/Labor_Trafficking_Preventative-Measure.html",
            //sextortion contents location
            SEXTORTION_OVERVIEW = "file:///android_asset/Parent/Sextortion/Sextortion_Overview.html",
            SEXTORTION_GROOM = "file:///android_asset/Parent/Sextortion/Sextortion_Grooming-Process.html",
            SEXTORTION_WARNING = "file:///android_asset/Parent/Sextortion/Sextortion_Warning-Signs.html",
            SEXTORTION_PREVENT = "file:///android_asset/Parent/Sextortion/Sextortion_Preventative-Measure.html",
            //child pornography contents location
            CHILD_PORNOGRAPHY_OVERVIEW = "file:///android_asset/Parent/ChildPornography/Child_Pornography_Overview.html",
            CHILD_PORNOGRAPHY_GROOM = "file:///android_asset/Parent/ChildPornography/Child_Pornography_Grooming-Process.html",
            CHILD_PORNOGRAPHY_WARNING = "file:///android_asset/Parent/ChildPornography/Child_Pornography_Warning-Signs.html",
            CHILD_PORNOGRAPHY_PREVENT = "file:///android_asset/Parent/ChildPornography/Child_Pornography_Preventative-Measure.html",
            //social media contents location
            SOCIAL_MEDIA_EXPLOITATION_OVERVIEW = "file:///android_asset/Parent/SocialMediaExploitation/Social_Media_Exploitation_Overview.html",
            SOCIAL_MEDIA_EXPLOITATION_GROOM = "file:///android_asset/Parent/SocialMediaExploitation/Social_Media_Exploitation_Grooming-Process.html",
            SOCIAL_MEDIA_EXPLOITATION_WARNING = "file:///android_asset/Parent/SocialMediaExploitation/Social_Media_Exploitation_Warning-Signs.html",
            SOCIAL_MEDIA_EXPLOITATION_PREVENT = "file:///android_asset/Parent/SocialMediaExploitation/Social_Media_Exploitation_Preventative-Measure.html";

    //constructor
    public Content(String currentContent)
    {
        this.currentContent = currentContent;
        setContents(currentContent);
    }


    //create methods to return information contents
    public String summaryContent() {return returnOverviewContent; }
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
        returnOverviewContent = SEX_TRAFFICKING_MINOR_OVERVIEW;
        returnGroomingContent = SEX_TRAFFICKING_MINOR_GROOM;
        returnWarningSignsContent = SEX_TRAFFICKING_MINOR_WARNING;
        returnPreventativeMeasure = SEX_TRAFFICKING_MINOR_PREVENT;
    }

    private void setSexTraffickingAdult()
    {
        returnOverviewContent = SEX_TRAFFICKING_ADULT_OVERVIEW;
        returnGroomingContent = SEX_TRAFFICKING_ADULT_GROOM;
        returnWarningSignsContent = SEX_TRAFFICKING_ADULT_WARNING;
        returnPreventativeMeasure = SEX_TRAFFICKING_ADULT_PREVENT;
    }

    private void setLaborTrafficking()
    {
        returnOverviewContent = LABOR_TRAFFICKING_OVERVIEW;
        returnGroomingContent = LABOR_TRAFFICKING_GROOM;
        returnWarningSignsContent = LABOR_TRAFFICKING_WARNING;
        returnPreventativeMeasure = LABOR_TRAFFICKING_PREVENT;
    }

    private void setSextortion()
    {
        returnOverviewContent = SEXTORTION_OVERVIEW;
        returnGroomingContent = SEXTORTION_GROOM;
        returnWarningSignsContent = SEXTORTION_WARNING;
        returnPreventativeMeasure = SEXTORTION_PREVENT;
    }

    private void setChildPornography() {
        returnOverviewContent = CHILD_PORNOGRAPHY_OVERVIEW;
        returnGroomingContent = CHILD_PORNOGRAPHY_GROOM;
        returnWarningSignsContent = CHILD_PORNOGRAPHY_WARNING;
        returnPreventativeMeasure = CHILD_PORNOGRAPHY_PREVENT;
    }

    private void setSocialMediaExploitation()
    {
        returnOverviewContent = SOCIAL_MEDIA_EXPLOITATION_OVERVIEW;
        returnGroomingContent = SOCIAL_MEDIA_EXPLOITATION_GROOM;
        returnWarningSignsContent = SOCIAL_MEDIA_EXPLOITATION_WARNING;
        returnPreventativeMeasure = SOCIAL_MEDIA_EXPLOITATION_PREVENT;
    }
}
