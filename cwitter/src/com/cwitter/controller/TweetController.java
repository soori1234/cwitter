package com.cwitter.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cwitter.constants.CwitterConstants;
import com.cwitter.dto.Tweet;
import com.cwitter.dto.User;
import com.cwitter.service.TweetLocalService;
import com.cwitter.service.TweetLocalServiceImpl;
import com.cwitter.service.UserLocalServiceImpl;

@Controller
public class TweetController {
	@RequestMapping(value="/postTweetAction", method = RequestMethod.POST)
	public ModelAndView registerAction(@ModelAttribute("tweet")Tweet tweet, BindingResult result)
	{
		TweetLocalService tweetLocalService = new TweetLocalServiceImpl();
		tweet = tweetLocalService.saveTweet(tweet);
		return new ModelAndView("success", "tweetSuccess", CwitterConstants.tweetSuccess);
	}

}
