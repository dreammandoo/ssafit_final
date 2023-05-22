package com.ssafy.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.board.model.dao.MessageDao;
import com.ssafy.board.model.dto.Message;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageDao messageDao;
	
	@Override
	public List<Message> selectMy(int id) {
		return messageDao.selectMy(id);
	}

	@Override
	public int sendMessage(Message message) {
		return messageDao.sendMessage(message);
	}

	@Override
	public int checkMessage(Message message) {
		return messageDao.checkMessage(message);
	}

}
