package com.openhouse.jive.plugin.action;

import com.openhouse.jive.plugin.dao.PollDao;
import com.openhouse.jive.plugin.model.Poll;
import com.openhouse.jive.plugin.service.PollService;
import com.jivesoftware.community.action.ContentActionSupport;

import java.util.Arrays;
import java.util.List;

public class PollAction extends ContentActionSupport {
    private String question;
    private String option1;
    private String option2;
    private String option3;

    //TODO: Move to service
    private PollService pollService;
    private PollDao pollDao;


    public PollAction() {
    }

    public String savePoll() {
        Poll poll = new Poll(question, Arrays.asList(option1, option2, option3));
        pollDao.save(poll);
        return SUCCESS;
    }

    public String newPoll() {
        return SUCCESS;
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

    public void setPollDao(PollDao pollDao) {
        this.pollDao = pollDao;
    }

    public Poll getPoll() {
        return new Poll("Q", Arrays.asList("x"));
    }

    public List<Poll> getPollList() {
        return getPolls();
    }

    public List<Poll> getPolls(){
        return pollService.findAllPolls();
    }

    public void setPollService(PollService pollService) {
        this.pollService = pollService;
    }
}
