package org.springboot.rest.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springboot.rest.controller.Topic;
import org.springframework.stereotype.Service;

// business service is singleton
@Service
public class TopicService {

	private List<Topic> topics = new ArrayList<>(Arrays.asList(new Topic("spr", "Power of now", "Spiritual Teaching"),
			new Topic("java", "Head First Java", "Java for beginners"),
			new Topic("fic", "Adventues of guliver", "Gulivers Travels")));

	public List<Topic> getAllTopics() {
		return topics;
	}

	public Topic getTopic(String id) {
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public void addTopic(Topic topic) {
		topics.add(topic);
	}

	public void updateTopic(String id, Topic topic) {
		
		Topic getTopic=topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
		topics.set(topics.indexOf(getTopic), topic);
		
		
	}

	public void deleteTopic(String id) {
		topics.removeIf(t->t.getId().equals(id));
	}

}
