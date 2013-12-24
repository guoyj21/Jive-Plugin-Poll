package com.openhouse.jive.plugin.dao;

import com.jivesoftware.base.database.dao.JiveJdbcDaoSupport;
import com.openhouse.jive.plugin.model.Poll;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;

public class PollDao extends JiveJdbcDaoSupport {

    private final static String SAVE_POLL_SQL = "insert into poll (Id, CreatedOn,PublishedOn,ExpiredOn,VisibleTill,CreatedBy,PollQuestion,PollTypeId,PollCategoryId,Active,Published) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

    private final static String SAVE_POLL_OPTIONS_SQL = "insert into polloptions (Id, PollId,OptionText,Active) VALUES (?, ?, ?, ?);";

    private final static String FIND_ALL_POLL_QUESTION_SQL = "select Id,PollQuestion from poll";
    private final static String FIND_ALL_POLL_OPTIONS_SQL = "select OptionText from polloptions where PollId = ?";


    public void save(Poll poll) {
        try {
            long pollId = generatePrimaryKey();
            getSimpleJdbcTemplate().update(SAVE_POLL_SQL, pollId, 100L, 100L, 100L, 100L, "Apurva", poll.getQuestion(), 1L, 1L, true, true);
            for (String option : poll.getOptions()) {
                getSimpleJdbcTemplate().update(SAVE_POLL_OPTIONS_SQL, generatePrimaryKey(), pollId, option, true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Poll> findAll() {
        List<Poll> allPolls = findAllPolls();
        for (Poll poll : allPolls) {
            List<String> options = findAllPollOptions(poll.getId());
            poll.setOptions(options);
        }
        return allPolls;
    }

    private List<Poll> findAllPolls() {
        return getSimpleJdbcTemplate().query(FIND_ALL_POLL_QUESTION_SQL, new RowMapper<Poll>() {
            @Override
            public Poll mapRow(ResultSet rs, int rowNum) throws SQLException {
                Poll poll = new Poll();
                poll.setId(rs.getLong(1));
                poll.setQuestion(rs.getString(2));
                return poll;
            }
        });
    }

    private List<String> findAllPollOptions(long pollId) {
        return getSimpleJdbcTemplate().query(FIND_ALL_POLL_OPTIONS_SQL, new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rs.getString(1);
            }
        }, pollId);
    }


    private long generatePrimaryKey() {
        return new Random().nextLong();
    }
}
