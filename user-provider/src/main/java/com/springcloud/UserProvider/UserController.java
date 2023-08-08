package com.springcloud.UserProvider;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import com.alibaba.fastjson.JSON;
import com.netflix.discovery.converters.Auto;
import com.springcloud.pojo.AppUser;
import com.springcloud.service.SeqService;
import com.springcloud.service.UserService;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.UserAPI.Person;
import com.springcloud.UserAPI.UserApi;

@RestController
public class UserController implements UserApi {


//	@Value("${server.port}")
	@Value("${server.port}")
	String port;


	private AtomicInteger count = new AtomicInteger();

	@Override
	public String alive() {

		try {
			System.out.println("准备睡");

			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int i = count.getAndIncrement();
		System.out.println(port + " 好的 ====第：" + i + "次调用");
		return "port:" + port;
	}

	@Override
	public String getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@GetMapping("/getMap")
	public Map<Integer, String> getMap(@RequestParam("id") Integer id) {



		System.out.println(id);
		return Collections.singletonMap(id, "mmeme");
	}
	@GetMapping("/getMap2")
	public Map<Integer, String> getMap2(Integer id,String name) {
		// TODO Auto-generated method stub
		System.out.println(id);
		return Collections.singletonMap(id, name);
	}

	@GetMapping("/getMap3")
	public Map<Integer, String> getMap3(@RequestParam Map<String, Object> map) {
		// TODO Auto-generated method stub
		System.out.println(map);
		return Collections.singletonMap(Integer.parseInt(map.get("id").toString()), map.get("name").toString());
	}


	@PostMapping("/postMap")
	public Map<Integer, String> postMap(@RequestBody Map<String, Object> map) {
		// TODO Auto-generated method stub
		System.out.println(map);
		return Collections.singletonMap(Integer.parseInt(map.get("id").toString()), map.get("name").toString());
	}

	@Override
	public Person postPserson(Person person) {
		System.out.println(ToStringBuilder.reflectionToString(person));
		return person;
	}

	public Object getUserInfoByUserId(String userId) {
		AppUser userInfo = userService.getUser(userId);
		System.out.println(JSON.toJSON(userInfo));
		return userInfo;
	}

	public Object getAllUserInfo(Integer page,Integer pageSize) {
		List<AppUser> userList = userService.getAllUser(page,pageSize);
		System.out.println(JSON.toJSON(userList));
		return userList;
	}

	/**
	 * 根据ID数量 生成ID 获取ID列表
	 * https://developer.aliyun.com/article/986780
	 * @param num
	 * @return
	 */
	public List<Object> getIDList(int num){
		return new ArrayList<>();
	}

	public String genWayBillNo(String bigType){
		Date dtOrderDate = new Date();
		String wayBillNo = seqService.genWaybillNo(bigType, dtOrderDate);
		return wayBillNo;
	}
	@Autowired
	private UserService userService;
	@Autowired
	private SeqService seqService;
 }
