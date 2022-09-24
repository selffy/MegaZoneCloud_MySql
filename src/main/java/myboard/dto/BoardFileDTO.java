package myboard.dto;

import java.io.Serializable;

public class BoardFileDTO implements Serializable{

	public static final long serialVersionUID = 438943214785314561L;
	
	private int bfid;
	private String bfcfn;
	private String bfsfn;
	private int bfsize;
	private int bfbid;

	public BoardFileDTO() {	
	}

	public BoardFileDTO(String bfcfn, String bfsfn, int bfsize, int bfbid) {
		this.bfcfn = bfcfn;
		this.bfsfn = bfsfn;
		this.bfsize = bfsize;
		this.bfbid = bfbid;
	}
	
	public int getBfid() {
		return bfid;
	}

	public void setBfid(int bfid) {
		this.bfid = bfid;
	}

	public String getBfcfn() {
		return bfcfn;
	}

	public void setBfcfn(String bfcfn) {
		this.bfcfn = bfcfn;
	}

	public int getBfsize() {
		return bfsize;
	}

	public void setBfsize(int bfsize) {
		this.bfsize = bfsize;
	}

	public int getBfbid() {
		return bfbid;
	}

	public void setBfbid(int bfbid) {
		this.bfbid = bfbid;
	}

	public String getBfsfn() {
		return bfsfn;
	}

	public void setBfsfn(String bfsfn) {
		this.bfsfn = bfsfn;
	}

	@Override
	public String toString() {
		return "BoardFileDTO [bfid=" + bfid + ", bfcfn=" + bfcfn + ", bfsfn=" + bfsfn + ", bfsize=" + bfsize
				+ ", bfbid=" + bfbid + "]";
	}
	
	
}


