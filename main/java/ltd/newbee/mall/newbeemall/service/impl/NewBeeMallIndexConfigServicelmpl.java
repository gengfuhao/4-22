package ltd.newbee.mall.newbeemall.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import ltd.newbee.mall.newbeemall.dao.IndexConfigMapper;
import ltd.newbee.mall.newbeemall.entity.IndexConfig;
import ltd.newbee.mall.newbeemall.entity.NewBeeMallGoods;
import ltd.newbee.mall.newbeemall.service.NewBeeMallIndexConfigService;
import ltd.newbee.mall.vo.NewBeeMallGoodsDetailVO;
import ltd.newbee.mall.newbeemall.vo.NewBeeMallIndexCategoryVO;
import ltd.newbee.mall.newbeemall.vo.SecondLevelCategoryVO;
import ltd.newbee.mall.newbeemall.vo.ThirdLevelCategoryVO;

@Service
public class NewBeeMallIndexConfigServicelmpl implements NewBeeMallIndexConfigService {

	private IndexConfigMapper IndexConfigMapper;

// 	public List<NewBeeMallGoods> getConfigGoodsesForIndex(int configType,int number) {
	@Override
	public List<NewBeeMallGoodsDetailVO> getConfigGoodsesForIndex(int configType, int number) {

		List<IndexConfig> idxConfList = IndexConfigMapper.findIndexConfigsByTypeAndNum(configType, number);
//		List<IndexConfig> IdxConfList = IndexConfigMapper.findIndexConfigsByTypeAndNum(configType, number);

		List<Long> ids = new ArrayList<Long>();
		// List<IndexConfig> => List<Long>
		for(IndexConfig iConf : idxConfList) {
			ids.add(iConf.getGoodsId());
		// 		return indexConfigMapper.selectByPrimaryKeys(ids);	
 		}
		
	List<NewBeeMallGoods>  entityList = IndexConfigMapper.selectByPrimaryKeys(ids);

	List<NewBeeMallGoodsDetailVO> voList = new ArrayList<NewBeeMallGoodsDetailVO>();


	for(NewBeeMallGoods entity : entityList){
		NewBeeMallGoodsDetailVO vo = new NewBeeMallGoodsDetailVO();

		vo.setGoodsId(entity.getGoodsId());

		vo.setGoodsName(entity.getGoodsName());

		vo.setGoodsIntro(entity.getGoodsIntro());

		vo.setGoodsCoverImg(entity.getGoodsCoverImg());

		vo.setSellingPrice(entity.getSellingPrice());

		String name = vo.getGoodsName();

		if (name.length() > 30) {
			vo.setGoodsName(name.substring(0, 30) + "...");
		}

		voList.add(vo);
	}

	return voList;

	}
//=================================================
	@Override
	public List<NewBeeMallIndexCategoryVO> getCategoriesForIndex() {
		// TODO 自動生成されたメソッド・スタブ
		
			
		
		return null;
	}
	

}
