package com.restful.webservice.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.restful.webservice.bean.UserDetails;
import com.restful.webservice.utils.UserConstant;

@Component
public class UserDaoService {

	private static List<UserDetails> userList = new ArrayList<>();

	private static Integer userCount = 0;

	static {
		userList.add(new UserDetails(++userCount, "Rajshekhar", LocalDate.now().minusYears(30)));
		userList.add(new UserDetails(++userCount, "Mahadeo", LocalDate.now().minusYears(35)));
		userList.add(new UserDetails(++userCount, "Satish", LocalDate.now().minusYears(20)));
		userList.add(new UserDetails(++userCount, "Manoj", LocalDate.now().minusYears(16)));
		userList.add(new UserDetails(++userCount, "Suraj", LocalDate.now().minusYears(73)));
		userList.add(new UserDetails(++userCount, "Tanaji", LocalDate.now().minusYears(11)));
	}

	public List<UserDetails> findAll() {
		System.out.println("getting all the user details");
		return userList;
	}

	public UserDetails getUser(Integer userId) {
		return userList.stream().filter(user -> user.getUserId().equals(userId)).findFirst().orElse(null);
	}

	public UserDetails createUser(UserDetails newUser) {
		Optional<UserDetails> userDetails = userList.stream()
				.filter(user -> user.getUserId().equals(newUser.getUserId())).findFirst();
		if (userDetails.isPresent()) {
			return newUser;
		} else {
			newUser.setUserId(++userCount);
			userList.add(new UserDetails(newUser.getUserId(), newUser.getName(), newUser.getDateOfBirth()));
			return newUser;
		}
	}
}
