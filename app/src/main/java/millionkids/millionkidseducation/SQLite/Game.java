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
    private int answer1screen;
    private int answer2screen;
    private int answer3screen;

    //Default Constructor
    public Game(){}

    //toString for all GameData
    public String toString(){
        return "GameData [questionId=" + questionId + ", scenarioId=" + scenarioId + ", questionText="
                + questionText + ", showChild=" + showChild + ", backgroundImage=" + backgroundImage
                + ", answer1=" + answer1 + ", answer2=" + answer2 + ", answer3" + answer3 +
                ", correctAnswer="+ correctAnswer + ", answer1screen=" + answer1screen +
                ", answer2screen="+ answer2screen + ", answer3screen=" + answer3screen + "]";
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

    public void setBackgroundImage(String backgroundImage){
        this.backgroundImage = backgroundImage;
    }

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

    public void setAnswer1screen(int answer1screen){
        this.answer1screen = answer1screen;
    }

    public void setAnswer2screen(int answer2screen){
        this.answer2screen = answer2screen;
    }

    public void setAnswer3screen(int answer3screen){
        this.answer3screen = answer3screen;
    }
}
