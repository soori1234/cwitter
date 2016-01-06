package com.cwitter.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "TWEET")
public class Tweet {
	@Id
	@GeneratedValue
	private Long tweetId;
	
	@Column
	private String tweetDescription;
	
	@Column
	private Date tweetCreationDate;
	
	@Column
	private Long tweetCreatedBy;

	public Long getTweetId() {
		return tweetId;
	}

	public void setTweetId(Long tweetId) {
		this.tweetId = tweetId;
	}

	public String getTweetDescription() {
		return tweetDescription;
	}

	public void setTweetDescription(String tweetDescription) {
		this.tweetDescription = tweetDescription;
	}

	public Date getTweetCreationDate() {
		return tweetCreationDate;
	}

	public void setTweetCreationDate(Date tweetCreationDate) {
		this.tweetCreationDate = tweetCreationDate;
	}

	public Long getTweetCreatedBy() {
		return tweetCreatedBy;
	}

	public void setTweetCreatedBy(Long tweetCreatedBy) {
		this.tweetCreatedBy = tweetCreatedBy;
	}
	
}
