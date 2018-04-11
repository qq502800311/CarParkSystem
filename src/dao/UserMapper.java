package dao;


import org.springframework.stereotype.Repository;

import bean.User;


@Repository
public interface UserMapper {

	public User loginUser(User user);
}
