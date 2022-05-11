package com.example.its.domain.issue;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.its.exception.ApplicationException;
import com.example.its.web.issue.IssueChangeForm;
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

		issueRepository.insert(form.getSummary(), form.getDescription(), form.getDeadline(),
				emptyToNull(form.getCreateuser()), form.getStatus());
	}

	public IssueEntity findById(long issueId) throws ApplicationException {
		IssueEntity issue = issueRepository.findById(issueId);

		if (issue == null) {
			throw new ApplicationException("課題がありません。");
		}

		return issueRepository.findById(issueId);
	}

	@Transactional
	public void delete(long issueId) {
		issueRepository.deleteById(issueId);
	}

	@Transactional
	public void change(long issueId, IssueChangeForm form) {

		issueRepository.update(issueId, form.getSummary(), form.getDescription(), form.getDeadline(),
				form.getCompletionday(), emptyToNull(form.getCreateuser()), form.getStatus());
	}

	/**
	 * 空文字だった場合Nullに変換するメソッド
	 * 
	 * @param str
	 * @return
	 */
	private String emptyToNull(String str) {
		return "".equals(str) ? null : str;
	}

}
