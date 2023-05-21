package com.ssafy.board.model.dao;

import java.util.List;

import com.ssafy.board.model.dto.Apply;

public interface ApplyDao {
	
	public List<Apply> selectAll();
	public List<Apply> selectByRecruitId(int recruitid);
	public List<Apply> selectByCreatorId(int creatorid);
	public Apply select(int id);
	public int insertApply(Apply apply);
	public int deleteApply(int creatorid, int recruitid);
	public List<Apply> selectMy(int creatorid);
	
}
