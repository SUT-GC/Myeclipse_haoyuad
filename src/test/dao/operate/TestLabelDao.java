package test.dao.operate;

import org.apache.commons.codec.binary.Base64;

import dao.operate.LabelDao;
import empty.Label;

public class TestLabelDao {
	public static void main(String[] args) {
		Label label = new Label();
		label.setName(Base64.encodeBase64String("哈".getBytes()));
		LabelDao.addLabel(label);
	}
}
