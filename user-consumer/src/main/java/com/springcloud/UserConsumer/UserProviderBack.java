package com.springcloud.UserConsumer;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.springcloud.UserAPI.Person;
@Component
public class UserProviderBack implements ConsumerApi {

	@Override
	public String alive() {


		
		return "降级了";
	}

	@Override
	public String getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person postPserson(Person person) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getUserInfoByUserId(String userId) {
		return null;
	}

	@Override
	public Object getAllUserInfo(Integer page, Integer pageSize) {
		return null;
	}

	@Override
	public String genWayBillNo(String bigType) {
		return null;
	}

	@Override
	public Map<Integer, String> getMap(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Integer, String> getMap2(Integer id, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Integer, String> getMap3(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Integer, String> postMap(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

}
