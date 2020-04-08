package usedocker;

import java.io.IOException;
import java.io.InputStreamReader;

import docker.image;

public class doCmd {
	private ProcessBuilder pb;
	//测试网络
	public String doPing(String ip) {
		pb=new ProcessBuilder("cmd","/c","ping "+ip);
		return showConsole(pb).toString();
	}	
	//查看镜像
	public String showImages() {
		pb=new ProcessBuilder("cmd","/c","docker images");
		return showConsole(pb).toString();
	}
	
	//查看所有容器状态
	public String showContainerStatus() {
		pb=new ProcessBuilder("cmd","/c","docker ps -a");
		return showConsole(pb).toString();
	}
	
	/*//退出并关闭容器
	public void closeContainer() {
		pb=new ProcessBuilder("cmd","/c","exit");
		showConsole(pb);
	}*/
	
	//依赖镜像创建新容器
	public String startNewContainer(image i) {
		if(i.getLocalhostPort()==null&&i.getContainerPort()==null) {
			pb=new ProcessBuilder("cmd","/c","docker run -itd"+i.getImageName());
		}else if(i.getLocalhostPort()==null&&i.getContainerPort()!=null) {
			pb=new ProcessBuilder("cmd","/c","docker run -p 127.0.0.1::"+i.getContainerPort()+"-itd"+i.getImageName());		
		}else if(i.getLocalhostPort()!=null&&i.getContainerPort()==null) {
			return "false";
		}else {
			pb=new ProcessBuilder("cmd","/c","docker run -p "+i.getLocalhostPort()+":"+i.getContainerPort()+"-itd"+i.getImageName());
		}
		
		return showConsole(pb).toString();
	}
	
	//启动已存在的容器
	public String startOldContainer(String cid) {
		pb=new ProcessBuilder("cmd","/c","docker start"+cid);
		return showConsole(pb).toString();
	}
	
	//删除容器
	public String delContainer(String cid) {
		pb=new ProcessBuilder("cmd","/c","docker rm"+cid);
		return showConsole(pb).toString();
	}
	
	//删除镜像
	public String delImage(String Iid) {
		pb=new ProcessBuilder("cmd","/c","docker rmi"+Iid);
		return showConsole(pb).toString();
	}
	
	//输入docker指令
	public String doDocker(String cmd) {
		pb=new ProcessBuilder("cmd","/c",cmd);
		return showConsole(pb).toString();
	}
	
	//控制台显示
	private StringBuffer showConsole(ProcessBuilder pb) {
		StringBuffer sb=new StringBuffer();
		try {
			Process process=pb.start();
			InputStreamReader ins=new InputStreamReader(process.getInputStream(),"GB2312");
			int len=0;
			while((len=ins.read())!=-1) {
				sb.append((char)len);
				System.out.print((char)len);
			}
			System.out.println();
			ins.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb;
	}
}
