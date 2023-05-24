package com.ssafy.board.model.dao;

import java.util.List;

import com.ssafy.board.model.dto.Timer;

public interface TimerDao {
	public List<Timer> selectMy(int userid);
	public int insertTimer(Timer timer);
	public int updateTimer(Timer timer);
	public int deleteOne(int id);
	public int deleteAll(int userid);
}
