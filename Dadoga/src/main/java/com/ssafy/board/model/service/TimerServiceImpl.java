package com.ssafy.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.board.model.dao.TimerDao;
import com.ssafy.board.model.dto.Timer;

@Service
public class TimerServiceImpl implements TimerService {

	@Autowired
	private TimerDao timerDao;
	
	@Override
	public List<Timer> selectMy(int userid) {
		return timerDao.selectMy(userid);
	}

	@Transactional
	@Override
	public int insertTimer(Timer timer) {
		return timerDao.insertTimer(timer);
	}

	@Transactional
	@Override
	public int updateTimer(Timer timer) {
		return timerDao.updateTimer(timer);
	}

	@Transactional
	@Override
	public int deleteOne(int id) {
		return timerDao.deleteOne(id);
	}

	@Transactional
	@Override
	public int deleteAll(int userid) {
		return timerDao.deleteAll(userid);
	}

}
