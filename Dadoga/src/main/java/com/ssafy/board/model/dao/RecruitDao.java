package com.ssafy.board.model.dao;

import java.util.List;

import com.ssafy.board.model.dto.Recruit;

public interface RecruitDao {

	public List<Recruit> selectAll();
	public Recruit selectOne(int id);
	public List<Recruit> selectMy(int writerid);
	public int update(Recruit recruit);
	public int insert(Recruit recruit);
	public int delete(int id);
	public int addApplier(int id);
	public int delApplier(int id);
	
}
