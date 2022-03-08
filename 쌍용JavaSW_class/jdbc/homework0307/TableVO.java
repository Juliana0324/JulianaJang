package homework0307;

public class TableVO {
	private String tname;
	private String tabtype, clusterid;
	private String column_name;
	private String data_type;
	private int data_length;
	
	public TableVO() {
	}
	public TableVO(String tname, String tabtype, String clusterid) {
		super();
		this.tname = tname;
		this.tabtype = tabtype;
		this.clusterid = clusterid;
	}

	public TableVO(String tname, String column_name,  int data_length) {
		super();
		this.tname = tname;
		this.column_name = column_name;
		this.data_length = data_length;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getTabtype() {
		return tabtype;
	}
	public void setTabtype(String tabtype) {
		this.tabtype = tabtype;
	}
	public String getColumn_name() {
		return column_name;
	}
	public void setColumn_name(String column_name) {
		this.column_name = column_name;
	}
	public String getData_type() {
		return data_type;
	}
	public void setData_type(String data_type) {
		this.data_type = data_type;
	}
	public int getData_length() {
		return data_length;
	}
	public void setData_length(int data_length) {
		this.data_length = data_length;
	}
	public String getClusterid() {
		return clusterid;
	}
	public void setClusterid(String clusterid) {
		this.clusterid = clusterid;
	}

	
	
	
}
