package ltd.newbee.mall.newbeemall.service;

import java.util.List;

import ltd.newbee.mall.newbeemall.entity.GoodsCategory;
import ltd.newbee.mall.newbeemall.vo.NewBeeMallIndexCategoryVO;

//业务模块的逻辑设计，和dao层一样先设计接口在创建要实现的类，然后在配置文件中进行配置其实现关联，
//接下来就可以在service层调用接口进行业务逻辑应用的处理
public interface NewBeeMallCategoryService {

	List<NewBeeMallIndexCategoryVO> getCategoriesForIndex();

}