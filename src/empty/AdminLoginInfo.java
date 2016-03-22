package empty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hyad_adminlogininfor")
public class AdminLoginInfo {
	@Id
	@Column(name = "adminlogininfor_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "adminlogininfor_adminaccount")
	private String loginaccount;
	@Column(name = "adminlogininfor_loginip")
	private String loginip;
	@Column(name = "adminlogininfor_loginaddress")
	private String loginaddress;
	@Column(name = "adminlogininfor_logindate")
	private String logindate;
	@Column(name = "adminlogininfor_adminid")
	private int adminid;

	public AdminLoginInfo() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLoginip() {
		return loginip;
	}

	public void setLoginip(String loginip) {
		this.loginip = loginip;
	}

	public String getLoginaddress() {
		return loginaddress;
	}

	public void setLoginaddress(String loginaddress) {
		this.loginaddress = loginaddress;
	}

	public String getLogindate() {
		return logindate;
	}

	public void setLogindate(String logindate) {
		this.logindate = logindate;
	}

	public int getAdminid() {
		return adminid;
	}

	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}

	public String getLoginaccount() {
		return loginaccount;
	}

	public void setLoginaccount(String loginaccount) {
		this.loginaccount = loginaccount;
	}

	@Override
	public String toString() {
		return "AdminLoginInfo [id=" + id + ", loginaccount=" + loginaccount
				+ ", loginip=" + loginip + ", loginaddress=" + loginaddress
				+ ", logindate=" + logindate + ", adminid=" + adminid + "]";
	}

}
