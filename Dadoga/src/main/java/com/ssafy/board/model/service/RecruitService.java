package com.ssafy.board.model.service;

import java.util.List;

import com.ssafy.board.model.dto.Recruit;

public interface RecruitService {
	
	public List<Recruit> selectAll();
	public List<Recruit> selectMy(int writerid);
	public Recruit select(int id);
	public int update(Recruit recruit);
	public int insert(Recruit recruit);
	public int delete(int id);
	public int addApplier(int id);
	public int delApplier(int id);
}
