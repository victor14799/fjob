package com.example.fjob.service.service.message;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fjob.lib.component.message.MessageComponent;
import com.example.fjob.lib.dataset.message.Message;

@Service
public class MessageServiceImp implements MessageService {

	MessageComponent component;

	@Autowired
	public MessageServiceImp(MessageComponent component) {
		// TODO Auto-generated constructor stub
		this.component = component;
	}

	@Override
	public List<Message> getMessage(String username) {
		// TODO Auto-generated method stub
		return component.getMessage(username);
	}

	@Override
	public boolean updSeenFlgMessage(String seen_flg, String username, String id) {
		// TODO Auto-generated method stub
		return component.updSeenFlgMessage(seen_flg, username, id);
	}

	@Override
	public boolean delMessage(String id) {
		// TODO Auto-generated method stub
		return component.delMessage(id);
	}

	@Override
	public boolean clearMessage(String username) {
		// TODO Auto-generated method stub
		return component.clearMessage(username);
	}

	@Override
	public boolean insertMessage(Message message) {
		// TODO Auto-generated method stub
		return component.insertMessage(message);
	}

}
