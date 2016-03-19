package empty;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="hyad_case")
public class Case {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="case_id")
	private int id;
	@Column(name="case_name")
	private String name;
	@Column(name="case_describe")
	private String describe;
	@Column(name="case_headimg")
	private String headimg;
	@Column(name="case_images")
	private String images;
	@Column(name="case_createtime")
	private Timestamp timestamp;
	@Column(name="case_show")
	private int show;
	
	@ManyToMany(targetEntity=Label.class)
	@JoinTable(name="hyad_label_case", joinColumns=@JoinColumn(name="case_id", referencedColumnName="case_id"), inverseJoinColumns=@JoinColumn(name="label_id", referencedColumnName="label_id"))
	private Set<Label> labels;
	
	public Case() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public String getHeadimg() {
		return headimg;
	}

	public void setHeadimg(String headimg) {
		this.headimg = headimg;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public int getShow() {
		return show;
	}

	public void setShow(int show) {
		this.show = show;
	}

	public Set<Label> getLabels() {
		return labels;
	}

	public void setLabels(Set<Label> labels) {
		this.labels = labels;
	}
	
	

}
