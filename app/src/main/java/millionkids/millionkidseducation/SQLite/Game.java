package millionkids.millionkidseducation.SQLite;

/**
 * Created by dorimouawad on 4/20/17.
 */

//Getters and Setters for Game
public class Game {

    //Data Pulled from SQLite GameData Table
    private int questionId;
    private int scenarioId;
    private String questionText;
    private int showChild;
    private String backgroundImage;
    private String answer1;
    private String answer2;
    private String answer3;
    private int correctAnswer;
//    private int answer1screen;
//    private int answer2screen;
//    private int answer3screen;

    private String answer1text;
    private String answer2text;
    private String answer3text;

    //Default Constructor
    public Game(){}

    //toString for all GameData
    public String toString(){
        return "GameData [questionId=" + questionId + ", scenarioId=" + scenarioId + ", questionText="
                + questionText + ", showChild=" + showChild + ", backgroundImage=" + backgroundImage
                + ", answer1=" + answer1 + ", answer2=" + answer2 + ", answer3" + answer3 +
                ", correctAnswer="+ correctAnswer + ", answer1text=" + answer1text +
                ", answer2text="+ answer2text + ", answer3text=" + answer3text + "]";
    }

    public void setQuestionId(int questionId){
        this.questionId = questionId;
    }

    public void setScenarioId(int scenarioId){
        this.scenarioId = scenarioId;
    }

    public void setQuestionText(String questionText){
        this.questionText = questionText;
    }

    public void setShowChild(int showChild){
        this.showChild = showChild;
    }

    public void setBackgroundImage(String backgroundImage){ this.backgroundImage = backgroundImage; }

    public void setAnswer1(String answer1){
        this.answer1 = answer1;
    }

    public void setAnswer2(String answer2){
        this.answer2 = answer2;
    }

    public void setAnswer3(String answer3){
        this.answer3 = answer3;
    }

    public void setCorrectAnswer(int correctAnswer){
        this.correctAnswer = correctAnswer;
    }

    public void setAnswer1text(String answer1text){
        this.answer1text = answer1text;
    }

    public void setAnswer2text(String answer2text){
        this.answer2text = answer2text;
    }

    public void setAnswer3text(String answer3text){
        this.answer3text = answer3text;
    }

    public int getQuestionId(){return questionId;}

    public int getScenarioId(){return scenarioId;}

    public String getQuestionText(){return questionText;}

    public int getShowChild(){return showChild;}

    public String getBackgroundImage(){return backgroundImage;}

    public String getAnswer1(){return answer1;}

    public String getAnswer2(){return answer2;}

    public String getAnswer3(){return answer3;}

    public int getCorrectAnswer(){return correctAnswer;}

    public String getAnswer1text(){return answer1text;}

    public String getAnswer2text(){return answer2text;}

    public String getAnswer3text(){return answer3text;}
}
