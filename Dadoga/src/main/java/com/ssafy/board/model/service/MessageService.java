package com.ssafy.board.model.service;

import java.util.List;

import com.ssafy.board.model.dto.Message;

public interface MessageService {
	public List<Message> selectMy(int id);
	public int sendMessage(Message message);
	public int checkMessage(Message message);
}
