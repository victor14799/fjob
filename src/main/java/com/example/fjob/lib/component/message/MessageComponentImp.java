package com.example.fjob.lib.component.message;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.fjob.common.CommonUtils;
import com.example.fjob.lib.dataset.message.Message;
import com.example.fjob.lib.mapper.message.MessageMapper;

@Component
public class MessageComponentImp implements MessageComponent {

	MessageMapper mapper;

	@Autowired
	public MessageComponentImp(MessageMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public boolean updSeenFlgMessage(String seen_flg, String username, String id) {

		return mapper.updSeenFlgMessage(seen_flg, username, id);
	}

	@Override
	public boolean clearMessage(String username) {
		// TODO Auto-generated method stub
		return mapper.clearMessage(username);
	}

	@Override
	public boolean delMessage(String id) {
		// TODO Auto-generated method stub
		return mapper.delMessage(id);
	}

	@Override
	public List<Message> getMessage(String username) {
		// TODO Auto-generated method stub
		return mapper.getMessage(username);
	}

	@Override
	public boolean insertMessage(Message message) {
		// TODO Auto-generated method stub
		message.setId(CommonUtils.randomID());
		return mapper.insertMessage(message);
	}

}
