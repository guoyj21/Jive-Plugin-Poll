package com.coop.openhouse.dao;

import com.coop.openhouse.model.Poll;
import com.jivesoftware.base.database.dao.JiveJdbcDaoSupport;

import java.util.Random;

public class PollDao extends JiveJdbcDaoSupport {

    private String savePollQuestion = "insert into CoopPoll (Id, CreatedOn,PublishedOn,ExpiredOn,VisibleTill,CreatedBy,PollQuestion,PollTypeId,PollCategoryId,Active,Published) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private String savePollOptions = "insert into CoopPollOptions (Id, PollId,OptionText,Active) VALUES (?, ?, ?, ?);";
//    private String selectPoll = "select PollQuestion from CoopPoll";

    public void save(Poll poll) {
        try {
            long pollId = generatePrimaryKey();
            getSimpleJdbcTemplate().update(savePollQuestion, pollId, 100L, 100L, 100L, 100L, "Apurva", poll.getQuestion(), 1L, 1L, true, true);
            for (String option : poll.getOptions()) {
                getSimpleJdbcTemplate().update(savePollOptions, generatePrimaryKey(), pollId, option, true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private long generatePrimaryKey() {
        return new Random().nextLong();
    }
}
