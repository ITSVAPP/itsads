package com.example.its.domain.issue;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.its.web.issue.IssueForm;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IssueService {

	private final IssueRepository issueRepository;

	public List<IssueEntity> findAll() {
		return issueRepository.findAll();
	}

	@Transactional
	public void create(IssueForm form) {

		String createuser = "".equals(form.getCreateuser()) ? null : form.getCreateuser();

		issueRepository.insert(form.getSummary(), form.getDescription(), form.getDeadline(), createuser,
				form.getStatus());
	}

	public IssueEntity findById(long issueId) {
		return issueRepository.findById(issueId);
	}
}
