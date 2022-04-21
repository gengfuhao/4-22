package ltd.newbee.mall.newbeemall.vo;

import java.io.Serializable;
import java.util.List;

//第二级分离
public class SecondLevelCategoryVO implements Serializable {
private Long categoryLd;
private Long parentId;
private Byte categoryLevel;
private String categoryName;
private List<ThirdLevelCategoryVO> thiirdLevelCategoryVOS;
public Long getCategoryLd() {
	return categoryLd;
}
public void setCategoryLd(Long categoryLd) {
	this.categoryLd = categoryLd;
}
public Long getParentId() {
	return parentId;
}
public void setParentId(Long parentId) {
	this.parentId = parentId;
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
public List<ThirdLevelCategoryVO> getThiirdLevelCategoryVOS() {
	return thiirdLevelCategoryVOS;
}
public void setThiirdLevelCategoryVOS(List<ThirdLevelCategoryVO> thiirdLevelCategoryVOS) {
	this.thiirdLevelCategoryVOS = thiirdLevelCategoryVOS;
}

}
