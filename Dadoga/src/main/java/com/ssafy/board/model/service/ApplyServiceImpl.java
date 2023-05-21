package com.ssafy.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.board.model.dao.ApplyDao;
import com.ssafy.board.model.dto.Apply;

@Service
public class ApplyServiceImpl implements ApplyService {

	@Autowired
	private ApplyDao applyDao;
	
	@Override
	public List<Apply> selectAll() {
		return applyDao.selectAll();
	}

	@Override
	public List<Apply> selectByRecruitId(int recruitid) {
		return applyDao.selectByRecruitId(recruitid);
	}

	@Override
	public List<Apply> selectByCreatorId(int creatorid) {
		return applyDao.selectByCreatorId(creatorid);
	}

	@Override
	public Apply select(int id) {
		return applyDao.select(id);
	}

	@Transactional
	@Override
	public int insertApply(Apply apply) {
		return applyDao.insertApply(apply);
	}

	@Transactional
	@Override
	public int deleteApply(int creatorid, int recruitid) {
		return applyDao.deleteApply(creatorid, recruitid);
	}

	@Override
	public List<Apply> selectMy(int creatorid) {
		return applyDao.selectMy(creatorid);
	}

}
