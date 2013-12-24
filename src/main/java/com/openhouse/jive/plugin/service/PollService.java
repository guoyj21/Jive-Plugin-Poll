package com.openhouse.jive.plugin.service;

import com.openhouse.jive.plugin.dao.PollDao;
import com.openhouse.jive.plugin.model.Poll;

import java.util.List;

public class PollService {

    private PollDao pollDao;

    public List<Poll> findAll() {
        return pollDao.findAll();
    }

    public void save(Poll poll) {
        pollDao.save(poll);
    }

    public void setPollDao(PollDao pollDao) {
        this.pollDao = pollDao;
    }

}
