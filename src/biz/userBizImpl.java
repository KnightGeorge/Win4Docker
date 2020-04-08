package biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.userMapper;
import pojo.user;

@Service
public class userBizImpl implements userBiz {
	@Autowired
	private userMapper uMap;
	
	public void setuMap(userMapper uMap) {
		this.uMap = uMap;
	}

	@Override
	public user queryByName(user u) {
		user cu=uMap.selectByName(u.getUsername());
		if(!cu.getPassword().equals(u.getPassword())) {
			cu=null;
		}
		return cu;
	}

}
