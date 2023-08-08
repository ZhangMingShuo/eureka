package com.springcloud.UserAPI;

import org.springframework.web.bind.annotation.*;

@RequestMapping("/User")
public interface UserApi {

	/**
	 * 老师，工作中有专门起一个公共api服务的吗
	 *
	 * 查看当前服务状态~~~
	 * @return (* ￣3)(ε￣ *)
	 */
	@GetMapping("/alive")
	public String alive();

	@GetMapping("/getById")
	public String getById(Integer id);


	@PostMapping("/postPserson")
	public Person postPserson(@RequestBody Person person);

	@GetMapping("/getUserInfoByUserId")
	public Object getUserInfoByUserId(@RequestParam String userId);

	@GetMapping("/getAllUserInfo")
	public Object getAllUserInfo(@RequestParam Integer page,
								 @RequestParam Integer pageSize);
	@GetMapping("/genWayBillNo")
	public String genWayBillNo(@RequestParam String bigType);
 }
