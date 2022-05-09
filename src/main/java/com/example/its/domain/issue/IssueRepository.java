package com.example.its.domain.issue;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface IssueRepository {

	@Select("select * from issues")
	List<IssueEntity> findAll();

	@Insert("insert into issues (summary, description) values (#{summary}, #{description})")
	void insert(@Param("summary") String summary, @Param("description") String description);

	@Select("select * from issues where id = #{issueId}")
	IssueEntity findById(long issueId);
}
