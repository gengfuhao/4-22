package ltd.newbee.mall.newbeemall.vo;

import java.io.Serializable;
import java.util.List;

//数据第一层分离

public class NewBeeMallIndexCategoryVO implements Serializable {
private Long categoryId;
private Byte categoryLevel;
private String categoryName;
//数据第二层
private List<SecondLevelCategoryVO> secondLevelCategoryVOS;

public Long getCategoryId() {
	return categoryId;
}
public void setCategoryId(Long categoryId) {
	this.categoryId = categoryId;
}
public Byte getCategoryLevel() {
	return categoryLevel;
}
public void setCategoryLevel(Byte categoryLevel) {
	this.categoryLevel = categoryLevel;
}
public String getCategoryName() {
	return categoryName;
}
public void setCategoryName(String categoryName) {
	this.categoryName = categoryName;
}
public List<SecondLevelCategoryVO> getSecondLevelCategoryVOS() {
	return secondLevelCategoryVOS;
}
public void setSecondLevelCategoryVOS(List<SecondLevelCategoryVO> secondLevelCategoryVOS) {
	this.secondLevelCategoryVOS = secondLevelCategoryVOS;
}


	
}
