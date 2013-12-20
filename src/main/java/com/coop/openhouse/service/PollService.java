package com.coop.openhouse.service;

import com.coop.openhouse.model.Poll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PollService {

    public List<Poll> findAllPolls() {
        List<Poll> polls = new ArrayList<Poll>();
        polls.add(new Poll("Q1", Arrays.asList("ans11", "ans12", "ans13")));
        polls.add(new Poll("Q2", Arrays.asList("ans21", "ans22", "ans23")));
        polls.add(new Poll("Q3", Arrays.asList("ans31", "ans32", "ans33")));
        return polls;
    }
}
