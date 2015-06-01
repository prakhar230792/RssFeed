package com.igniteSolutions.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.igniteSolutions.app.model.Feed;
import com.igniteSolutions.app.service.RssRequestService;

@Controller
public class RssRequestController {

	
	@Autowired
	private RssRequestService rssRequestService;
	
	@RequestMapping("/hello")
	public @ResponseBody Feed helloWorld()
	{
		return rssRequestService.helloWorld();
	}
}
