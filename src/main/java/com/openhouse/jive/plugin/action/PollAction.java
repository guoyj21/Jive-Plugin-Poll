package com.openhouse.jive.plugin.action;

import com.google.gson.Gson;
import com.openhouse.jive.plugin.model.Poll;
import com.openhouse.jive.plugin.service.PollService;
import com.jivesoftware.community.action.ContentActionSupport;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PollAction extends ContentActionSupport {
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private List<String> jsonList;
    private PollService pollService;

    public PollAction() {
    }

    public String savePoll() {
        Poll poll = new Poll(question, Arrays.asList(option1, option2, option3));
        pollService.save(poll);
        return SUCCESS;
    }

    public String newPoll() {
        return SUCCESS;
    }

    public void json(){
        setQuestion("");
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Poll> getPolls(){
        return pollService.findAll();
    }

    public void setPollService(PollService pollService) {
        this.pollService = pollService;
    }
}
