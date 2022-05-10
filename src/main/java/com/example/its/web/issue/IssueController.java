package com.example.its.web.issue;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.its.domain.issue.IssueEntity;
import com.example.its.domain.issue.IssueService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/issues")
@RequiredArgsConstructor
public class IssueController {

	private final IssueService issueService;

	@GetMapping
	public String showList(Model model) {
		model.addAttribute("issueList", issueService.findAll());
		return "issues/list";
	}

	@GetMapping("/creationForm")
	public String showCreationForm(@ModelAttribute IssueForm form) {
		return "issues/creationForm";
	}

	@PostMapping
	public String create(@Validated IssueForm form, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return showCreationForm(form);
		}
		issueService.create(form);
		return "redirect:/issues";
	}

	@GetMapping("/{issueId}")
	public String showDetail(@PathVariable("issueId") long issueId, Model model) {
		model.addAttribute("issue", issueService.findById(issueId));
		return "issues/detail";
	}

	@PostMapping("/{issueId}/delete")
	public String delete(@PathVariable("issueId") long issueId) {
		issueService.delete(issueId);
		return "redirect:/issues";
	}

	@GetMapping("/{issueId}/change")
	public String showChangeForm(@PathVariable("issueId") long issueId, @ModelAttribute IssueChangeForm form,
			BindingResult bindingResult, Model model) {

		IssueEntity issue = issueService.findById(issueId);

		if (!bindingResult.hasErrors()) {
			form.setSummary(issue.getSummary());
			form.setDescription(issue.getDescription());
			form.setDeadline(issue.getDeadline());
			form.setCompletionday(issue.getCompletionday());
			form.setCreateuser(issue.getCreateuser());
			form.setStatus(issue.getStatus());
		}

		model.addAttribute("issue", issue);

		return "issues/changeForm";
	}

	@PostMapping("/{issueId}/change")
	public String change(@PathVariable("issueId") long issueId, @Validated IssueChangeForm form,
			BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return showChangeForm(issueId, form, bindingResult, model);
		}

		issueService.change(issueId, form);

		return "redirect:/issues/" + issueId;
	}

}
