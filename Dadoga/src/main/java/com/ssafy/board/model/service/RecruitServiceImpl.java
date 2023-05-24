package com.ssafy.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.board.model.dao.RecruitDao;
import com.ssafy.board.model.dto.Recruit;

@Service
public class RecruitServiceImpl implements RecruitService {

	@Autowired
	private RecruitDao recruitDao;
	
	@Override
	public List<Recruit> selectAll() {
		// TODO Auto-generated method stub
		return recruitDao.selectAll();
	}

	@Override
	public Recruit select(int id) {
		// TODO Auto-generated method stub
		return recruitDao.selectOne(id);
	}

	@Transactional
	@Override
	public int update(Recruit recruit) {
		// TODO Auto-generated method stub
		return recruitDao.update(recruit);
	}

	@Transactional
	@Override
	public int insert(Recruit recruit) {
		return recruitDao.insert(recruit);
	}

	@Transactional
	@Override
	public int delete(int id) {
		return recruitDao.delete(id);
	}

	@Override
	public List<Recruit> selectMy(int writerid) {
		// TODO Auto-generated method stub
		return recruitDao.selectMy(writerid);
	}

	@Override
	public int addApplier(int id) {
		// TODO Auto-generated method stub
		return recruitDao.addApplier(id);
	}

	@Override
	public int delApplier(int id) {
		// TODO Auto-generated method stub
		return recruitDao.delApplier(id);
	}

}
