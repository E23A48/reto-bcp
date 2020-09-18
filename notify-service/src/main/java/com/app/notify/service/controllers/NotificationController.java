package com.app.notify.service.controllers;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.notify.service.models.entity.NotificationRequest;
import com.app.notify.service.models.entity.Category;
import com.app.notify.service.models.entity.Notification;
import com.app.notify.service.models.service.ICategoryService;
import com.app.notify.service.models.service.INotificationService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/v1/notifications")
@Slf4j
public class NotificationController {
	
	@Autowired
	private INotificationService notificationService;
	
	@Autowired
	private ICategoryService categoryService;
	
	@GetMapping("/all")
	public List<Notification> all() {
		return notificationService.findAll();
	}

	
	@GetMapping("/single/id")
	public Notification detail(@PathVariable Long id) {
		return notificationService.findById(id);
	}
	
	@PostMapping("/add")
	public Notification detail(@RequestBody NotificationRequest notificationRequest) {
		
		Date date = Date.from(Instant.now());
		long time = date.getTime();
		Timestamp timestamp = new Timestamp(time);
		
		Category category = categoryService.findById(notificationRequest.getCategory_id());
		Notification notification = new Notification();
		notification.setTitle(notificationRequest.getTitle());
		notification.setMessage(notificationRequest.getMessage());
		notification.setCategory(category);
		notification.setCreadtedAt(timestamp);
				
		return notificationService.save(notification);
	}

}
