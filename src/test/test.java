package test;

import start.start;
import usedocker.doCmd;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1=new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				new doCmd().doPing("127.0.0.1");
			}
		});
		Thread t2=new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				new doCmd().showImages();
				new doCmd().showContainerStatus();
				new doCmd().doDocker("docker start 772f5523e654");
				new doCmd().showContainerStatus();
				doCmd doc=new doCmd();
				doc.doDocker("docker attach 772f5523e654");
				//doc.doDocker("ipconfig");
				System.out.println(doc.doPing("127.0.0.1"));
			}
		});
		//t1.start();
		//t2.start();
		start.Jdb2C();
		//System.out.println("技术发电房");
	}

}
