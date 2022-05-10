package com.example.its.domain.issue;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface IssueRepository {

	@Select("select * from issues")
	List<IssueEntity> findAll();

	@Insert("insert into issues (summary, description, deadline, createuser, status) values (#{summary}, #{description}, #{deadline}, #{createuser}, #{status})")
	void insert(@Param("summary") String summary, @Param("description") String description,
			@Param("deadline") Date deadline, @Param("createuser") String createuser, @Param("status") int status);

	@Select("select * from issues where id = #{issueId}")
	IssueEntity findById(long issueId);

	@Select("delete from issues where id =  #{issueId}")
	IssueEntity deleteById(long issueId);

}
