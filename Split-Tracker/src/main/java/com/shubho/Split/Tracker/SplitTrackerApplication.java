package com.shubho.Split.Tracker;

import com.shubho.Split.Tracker.controller.UserController;
import com.shubho.Split.Tracker.model.SplitType;
import com.shubho.Split.Tracker.model.User;
import com.shubho.Split.Tracker.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SplitTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SplitTrackerApplication.class, args);
	}

	@Component
	private class DriverClass implements CommandLineRunner {
		@Autowired
		UserController userController;

		@Autowired
		UserService userService;

		@Override
		public void run(String... args) throws Exception {
			this.userController.addUser(new User(1, "Shubham", "123447", "subham@gmail.com"));
			this.userController.addUser(new User(2, "Sonam", "677672", "sonam@gmail.com"));
			this.userController.addUser(new User(3, "Anish", "8364826", "anish@gmail.com"));

			User user1 = this.userService.findUserById(1);
			User user2 = this.userService.findUserById(2);
			User user3 = this.userService.findUserById(3);
			List<User> users = Stream.of(user2, user3).collect(Collectors.toList());
			List<Integer> values = new ArrayList<>();
			this.userService.splitMoney(1, 1200, 2, users, SplitType.EQUAL, values);
		}
	}
}
