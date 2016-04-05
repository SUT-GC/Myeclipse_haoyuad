package empty;

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
@Table(name = "hyad_label")
public class Label {
	@Id
	@Column(name = "label_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "label_name")
	private String name;

	@Column(name = "label_show")
	private int show;

	@ManyToMany(targetEntity = Case.class)
	@JoinTable(name = "hyad_label_case", joinColumns = @JoinColumn(name = "label_id", referencedColumnName = "label_id"), inverseJoinColumns = @JoinColumn(name = "case_id", referencedColumnName = "case_id"))
	private Set<Case> cases;

	public Label() {
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

	public Set<Case> getCases() {
		return cases;
	}

	public void setCases(Set<Case> cases) {
		this.cases = cases;
	}

	public int getShow() {
		return show;
	}

	public void setShow(int show) {
		this.show = show;
	}

	@Override
	public String toString() {
		return "Label [id=" + id + ", name=" + name + ", show=" + show + "]";
	}

}
