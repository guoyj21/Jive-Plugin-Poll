package com.openhouse.jive.plugin.model;

import java.util.ArrayList;
import java.util.List;

public class Poll {
    private String question;
    private List<String> options = new ArrayList();

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

    public int getOptionsCount() {
        return options.size();
    }
}
