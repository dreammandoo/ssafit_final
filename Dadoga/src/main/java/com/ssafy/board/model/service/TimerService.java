package com.ssafy.board.model.service;

import java.util.List;

import com.ssafy.board.model.dto.Timer;

public interface TimerService {
	List<Timer> selectMy(int userid);
	int insertTimer(Timer timer);
	int updateTimer(Timer timer);
	public int deleteOne(int id);
	public int deleteAll(int userid);
}
