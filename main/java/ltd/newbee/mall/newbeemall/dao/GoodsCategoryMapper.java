package ltd.newbee.mall.newbeemall.dao;

import java.util.List;


import org.apache.ibatis.annotations.Param;

import ltd.newbee.mall.newbeemall.entity.GoodsCategory;

//dao层首先创建dao接口，接着就可以在配置文件中定义该接口的实现类；接着就可以在模块中调用dao接口进行数据业务的处理
//不用关注此接口的具体实现类是哪一个类，dao层的数据源和数据库连接的参数都是在配置文件中进行配置的 

public interface GoodsCategoryMapper {

 	List<GoodsCategory> selectByLevelAndParentIdsAndNumber(@Param("parentIds") List<Long> parentIds, @Param("categoryLevel") int categoryLevel, @Param("number") int number);
 } 