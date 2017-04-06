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
        returnSummaryContent = "file:///android_asset/testHTML.html";
        returnGroomingContent = "SEX_TRAFFICKING_MINOR Grooming Process Content";
        returnWarningSignsContent = "SEX_TRAFFICKING_MINOR Warning Signs Content";
        returnPreventativeMeasure = "SEX_TRAFFICKING_MINOR Preventative Mesaure Content";
    }

    private void setSexTraffickingAdult()
    {
        returnSummaryContent = "SEX_TRAFFICKING_ADULT Summary content";
        returnGroomingContent = "SEX_TRAFFICKING_ADULT Grooming Process Content";
        returnWarningSignsContent = "SEX_TRAFFICKING_ADULT Warning Signs Content";
        returnPreventativeMeasure = "SEX_TRAFFICKING_ADULT Preventative Mesaure Content";
    }

    private void setLaborTrafficking()
    {
        returnSummaryContent = "LABOR_TRAFFICKING Summary content";
        returnGroomingContent = "SEX_TRAFFICKING_ADULT Grooming Process Content";
        returnWarningSignsContent = "SEX_TRAFFICKING_ADULT Warning Signs Content";
        returnPreventativeMeasure = "SEX_TRAFFICKING_ADULT Preventative Mesaure Content";
    }

    private void setSextortion()
    {
        returnSummaryContent = "SEXTORTION Summary content";
        returnGroomingContent = "SEXTORTION Grooming Process Content";
        returnWarningSignsContent = "SEXTORTION Warning Signs Content";
        returnPreventativeMeasure = "SEXTORTION Preventative Mesaure Content";
    }

    private void setChildPornography()
    {
        returnSummaryContent = "CHILD_PORNOGRAPHY Summary content";
        returnGroomingContent = "CHILD_PORNOGRAPHY Grooming Process Content";
        returnWarningSignsContent = "CHILD_PORNOGRAPHY Warning Signs Content";
        returnPreventativeMeasure = "CHILD_PORNOGRAPHY Preventative Mesaure Content";
    }

    private void setSocialMediaExploitation()
    {
        returnSummaryContent = "SOCIAL_MEDIA_EXPLOITATION Summary content";
        returnGroomingContent = "SOCIAL_MEDIA_EXPLOITATION Grooming Process Content";
        returnWarningSignsContent = "SOCIAL_MEDIA_EXPLOITATION Warning Signs Content";
        returnPreventativeMeasure = "SOCIAL_MEDIA_EXPLOITATION Preventative Mesaure Content";
    }
}
