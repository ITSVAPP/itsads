package com.example.its.web.issue;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class IssueForm {

	@NotBlank
	@Size(max = 256)
	private String summary;

	@NotBlank
	@Size(max = 256)
	private String description;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdday;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date deadline;

	@Size(max = 100)
	private String createuser;

	private int status;

}
