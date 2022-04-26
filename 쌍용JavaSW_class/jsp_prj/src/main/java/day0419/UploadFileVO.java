package day0419;

public class UploadFileVO {
	private int num;
	private String name, original_name, file_system_name, ip_address, input_date;
	
	public UploadFileVO() {
		
	}
	
	public UploadFileVO(int num, String name, String original_name, String file_system_name, String ip_address,
			String input_date) {
		super();
		this.num = num;
		this.name = name;
		this.original_name = original_name;
		this.file_system_name = file_system_name;
		this.ip_address = ip_address;
		this.input_date = input_date;
	}
	
	public String getIp_address() {
		return ip_address;
	}
	public void setIp_address(String ip_address) {
		this.ip_address = ip_address;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOriginal_name() {
		return original_name;
	}
	public void setOriginal_name(String original_name) {
		this.original_name = original_name;
	}
	public String getFile_system_name() {
		return file_system_name;
	}
	public void setFile_system_name(String file_system_name) {
		this.file_system_name = file_system_name;
	}
	public String getInput_date() {
		return input_date;
	}
	public void setInput_date(String input_date) {
		this.input_date = input_date;
	}

	@Override
	public String toString() {
		return "UploadFileVO [num=" + num + ", name=" + name + ", original_name=" + original_name
				+ ", file_system_name=" + file_system_name + ", input_date=" + input_date + "]";
	}

	
	
}
