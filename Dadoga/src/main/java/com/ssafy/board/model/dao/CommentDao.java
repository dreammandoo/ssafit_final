package com.ssafy.board.model.dao;

import java.util.List;

import com.ssafy.board.model.dto.Comment;

public interface CommentDao {
	
	public List<Comment> selectAll();
	public List<Comment> selectByRecruitId(int recruitid);
	public List<Comment> selectByCreatorId(int creatorid);
	public Comment select(int id);
	public int insertComment(Comment comment);
	public int deleteComment(int creatorid, int recruitid);
	public List<Comment> selectMy(int creatorid);
	
}
