package com.igniteSolutions.app.service;

import org.springframework.stereotype.Service;

import com.igniteSolutions.app.model.Feed;
@Service
public class RssRequestServiceImpl implements RssRequestService{


	@Override
	public Feed helloWorld() {
		return new Feed("google.com");
	}

}
