package com.openhouse.jive.plugin.model;

import java.util.ArrayList;
import java.util.List;

public class Poll {
    private long id;
    private String question;
    private List<String> options = new ArrayList();

    public Poll() {
    }

    public Poll(String question, List<String> options) {
        this.question = question;
        this.options.addAll(options);
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public int getOptionsCount() {
        return options.size();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
