package day0407;

public class BloodVO {
	private int num;
	private String imgPath, url, info;

	
	public BloodVO(int num, String imgPath, String url, String info) {
		super();
		this.num = num;
		this.imgPath = imgPath;
		this.url = url;
		this.info = info;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	
	
}
