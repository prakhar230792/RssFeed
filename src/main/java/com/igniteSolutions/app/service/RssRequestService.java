package com.igniteSolutions.app.service;

import java.util.Map;

import com.igniteSolutions.app.model.Feed;

public interface RssRequestService {

	Feed helloWorld();

	Feed fetchData(String map);
}
