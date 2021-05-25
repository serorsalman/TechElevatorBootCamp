package com.techelevator;

public class HomeworkAssignment {
    private int earnedMarks;
    private int possibleMarks;
    private String submitterName;
    private String letterGrade;

    public HomeworkAssignment(int possibleMarks, String submitterName ){
        this.possibleMarks= possibleMarks;
        this.submitterName= submitterName;
    }

    public void setEarnedMarks(int earnedMarks) {
        this.earnedMarks = earnedMarks;
    }

    public int getEarnedMarks() {
        return earnedMarks;
    }

    public int getPossibleMarks() {
        return possibleMarks;
    }

    public String getSubmitterName() {
        return submitterName;
    }

    public String getLetterGrade() {
        double percent= (double) this.earnedMarks/ this.possibleMarks * 100;

        if ( percent >=90){
            return "A";
        }else if ( percent >= 80){
            return "B";
                    } else if ( percent >=70){
            return "C";
        }else if ( percent >=60){
            return "D";
                    }else {
            return "F";

        }
        //return letterGrade;
    }
}
