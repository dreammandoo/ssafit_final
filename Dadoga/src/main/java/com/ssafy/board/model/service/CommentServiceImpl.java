package com.ssafy.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.board.model.dao.CommentDao;
import com.ssafy.board.model.dto.Comment;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDao commentDao;
	
	@Override
	public List<Comment> selectAll() {
		return commentDao.selectAll();
	}

	@Override
	public List<Comment> selectByRecruitId(int recruitid) {
		return commentDao.selectByRecruitId(recruitid);
	}

	@Override
	public List<Comment> selectByCreatorId(int creatorid) {
		return commentDao.selectByCreatorId(creatorid);
	}

	@Override
	public Comment select(int id) {
		return commentDao.select(id);
	}

	@Override
	public int insertComment(Comment comment) {
		return commentDao.insertComment(comment);
	}

	@Override
	public int deleteComment(int creatorid, int recruitid) {
		return commentDao.deleteComment(creatorid, recruitid);
	}

	@Override
	public List<Comment> selectMy(int creatorid) {
		return commentDao.selectMy(creatorid);
	}

}
