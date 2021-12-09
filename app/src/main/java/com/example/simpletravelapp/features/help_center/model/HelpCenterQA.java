package com.example.simpletravelapp.features.help_center.model;

public class HelpCenterQA {
    private String question;
    private String answer;
    private boolean expanded;



    public HelpCenterQA() {
    }

    public HelpCenterQA(String question, String answer) {
        this.question = question;
        this.answer = answer;
        this.expanded = false;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }
}
