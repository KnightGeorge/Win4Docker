package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import docker.image;
import usedocker.doCmd;

@Controller
@RequestMapping("/docker")
public class dockerController {
	//static final String[] ucode= {"application/json;charset=GB2312"};
	
	//测试网络
	@RequestMapping(value="/ping",produces= {"application/json;charset=GB2312"})
	@ResponseBody
	public Object doPing(@RequestParam String ip) {
		return JSONObject.toJSON(new doCmd().doPing(ip));
	}
	
	//查看镜像
	@RequestMapping(value="/showImages",produces= {"application/json;charset=GB2312"})
	@ResponseBody
	public Object showImages() {
		return JSONObject.toJSON(new doCmd().showImages());
	}
	
	//查看所有容器状态
	@RequestMapping(value="/showContainerStatus",produces= {"application/json;charset=GB2312"})
	@ResponseBody
	public Object showContainerStatus() {
		return JSONObject.toJSON(new doCmd().showContainerStatus());
	}
	
	//依赖镜像创建新容器
	@RequestMapping(value="/startNewContainer",produces= {"application/json;charset=GB2312"})
	@ResponseBody
	public Object startNewContainer(@RequestParam String imageName,
									@RequestParam(required=false) String localhostport,
									@RequestParam(required=false) String containerport) {
		image i=new image();
		i.setImageName(imageName);
		i.setLocalhostPort(localhostport);
		i.setContainerPort(containerport);
		return JSONObject.toJSON(new doCmd().startNewContainer(i));
	}
	
	//启动已存在的容器
	@RequestMapping(value="/startOldContainer",produces= {"application/json;charset=GB2312"})
	@ResponseBody
	public Object startOldContainer(@RequestParam String cid) {
		return JSONObject.toJSON(new doCmd().startOldContainer(cid));
	}
	
	//删除容器
	@RequestMapping(value="/delContainer",produces= {"application/json;charset=GB2312"})
	@ResponseBody
	public Object delContainer(@RequestParam String cid) {
		return JSONObject.toJSON(new doCmd().delContainer(cid));
	}
	
	//删除镜像
	@RequestMapping(value="/delImage",produces= {"application/json;charset=GB2312"})
	@ResponseBody
	public Object delImage(@RequestParam String Iid) {
		return JSONObject.toJSON(new doCmd().delImage(Iid));
	}
	
	//自定义cmd指令
	@RequestMapping(value="/doCmd",produces= {"application/json;charset=GB2312"})
	@ResponseBody
	public Object doCmd(@RequestParam String cmd) {
		return JSONObject.toJSON(new doCmd().doDocker(cmd));
	}
	
}
