package com.openhouse.jive.plugin.dao;

import com.jivesoftware.base.database.dao.JiveJdbcDaoSupport;
import com.openhouse.jive.plugin.model.Poll;
import org.springframework.jdbc.core.RowMapper;

import java.util.Random;

public class PollDao extends JiveJdbcDaoSupport {

    private String savePollQuestion = "insert into poll (Id, CreatedOn,PublishedOn,ExpiredOn,VisibleTill,CreatedBy,PollQuestion,PollTypeId,PollCategoryId,Active,Published) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private String savePollOptions = "insert into polloptions (Id, PollId,OptionText,Active) VALUES (?, ?, ?, ?);";
    private String QUESTIONQUERY = "select OptionText,PollQuestion from poll as cp ,polloptions as cpo";
    private RowMapper<Poll> rowMapper;

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
    public Poll getall(){
        return getSimpleJdbcTemplate().queryForObject(QUESTIONQUERY, rowMapper);
    }


    private long generatePrimaryKey() {
        return new Random().nextLong();
    }
}
