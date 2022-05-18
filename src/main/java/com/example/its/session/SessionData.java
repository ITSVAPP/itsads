package com.example.its.session;

import java.io.Serializable;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import com.example.its.domain.issue.IssueEntity;

import lombok.Data;

@Component
@SessionScope
@Data
public class SessionData implements Serializable {
	private static final long serialVersionUID = 1L;

	private IssueEntity issueEntity;
}