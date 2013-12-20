package com.coop.openhouse;

import com.jivesoftware.community.navbar.NavMenuLink;

public class CoopPollLink extends NavMenuLink {

    @Override
    public String getUrl() {
        return "/CoopPoll/new.jspa";
    }
}
