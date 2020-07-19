package com.example.fjob.lib.component.message;

import java.util.List;

import com.example.fjob.lib.dataset.message.Message;

public interface MessageComponent {
	List<Message> getMessage(String username);
	boolean updSeenFlgMessage(String seen_flg, String username, String id);
	boolean delMessage(String id);
	boolean clearMessage(String username);
	boolean insertMessage(Message message);
}
