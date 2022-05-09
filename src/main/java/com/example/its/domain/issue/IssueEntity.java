package com.example.its.domain.issue;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class IssueEntity {
	private long id;
	private String summary;
	private String description;
	private Date createdday;
	private Date deadline;
	private Date completionday;
	private String createuser;
	private int status;

	public String getCreateuserView() {

		if (createuser == null) {
			return "未設定";
		}

		return createuser + "さん";
	}

	public String getStatusView() {

		switch (status) {

		case 1:
			return "着手";

		case 2:
			return "完了";

		}
		return "未着手";
	}
}
