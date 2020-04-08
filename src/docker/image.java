package docker;

public class image {
	private String imageName;
	private String imageId;
	private String localhostPort;
	private String containerPort;
	
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public String getImageId() {
		return imageId;
	}
	public void setImageId(String imageId) {
		this.imageId = imageId;
	}
	public String getLocalhostPort() {
		return localhostPort;
	}
	public void setLocalhostPort(String localhostPort) {
		this.localhostPort = localhostPort;
	}
	public String getContainerPort() {
		return containerPort;
	}
	public void setContainerPort(String containerPort) {
		this.containerPort = containerPort;
	}
	
}
