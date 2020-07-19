package com.example.fjob.service.controller.message;

import java.util.List;

import javax.websocket.server.PathParam;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.fjob.lib.dataset.message.Message;
import com.example.fjob.service.service.message.MessageService;

@RestController
@RequestMapping("fjob/v1/message")
@Validated
public class MessageController {
	MessageService service;

	@Autowired
	public MessageController(MessageService service) {
		// TODO Auto-generated constructor stub
		this.service = service;
	}

	@GetMapping("/getMessage/{username}")
	List<Message> getMessage(@PathVariable("username") String username) {
		return service.getMessage(username);
	};

	@PutMapping("/updSeenFlg")
	boolean updSeenFlgMessage(@RequestParam("seen_flg") String seen_flg, @RequestParam("username") String username,
			@RequestParam("id") String id) {
		return service.updSeenFlgMessage(seen_flg, username, id);
	};

	@DeleteMapping("/delete/{id}")
	boolean delMessage(@PathVariable("id") String id) {
		return service.delMessage(id);
	};

	@DeleteMapping("/clear/{username}")
	boolean clearMessage(@PathVariable("username") String username) {
		return service.clearMessage(username);
	};

	@PostMapping("/insert")
	boolean insertMessage(@RequestBody Message message) {
		return service.insertMessage(message);
	};
}
