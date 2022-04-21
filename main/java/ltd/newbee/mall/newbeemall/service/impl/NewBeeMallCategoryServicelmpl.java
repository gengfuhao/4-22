package ltd.newbee.mall.newbeemall.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import ltd.newbee.mall.newbeemall.dao.GoodsCategoryMapper;
import ltd.newbee.mall.newbeemall.entity.NewBeeMallGoods;
import ltd.newbee.mall.newbeemall.entity.GoodsCategory;
import ltd.newbee.mall.newbeemall.service.NewBeeMallCategoryService;
import ltd.newbee.mall.vo.NewBeeMallGoodsDetailVO;
import ltd.newbee.mall.newbeemall.vo.NewBeeMallIndexCategoryVO;
import ltd.newbee.mall.newbeemall.vo.SecondLevelCategoryVO;
import ltd.newbee.mall.newbeemall.vo.ThirdLevelCategoryVO;

@Service
public class NewBeeMallCategoryServicelmpl implements NewBeeMallCategoryService {

	@Resource
	private GoodsCategoryMapper GoodsCategorymapper;

	public List<NewBeeMallIndexCategoryVO> getCategoriesForIndex() {

		// TODO 自動生成されたメソッド・スタブ
		List<Long> Parentlist = new ArrayList<Long>();
		Parentlist.add(0L);
		List<GoodsCategory> cat1list = new ArrayList<>();
		cat1list = GoodsCategorymapper.selectByLevelAndParentIdsAndNumber(Parentlist, 1, 30);

		List<Long> cat1list1 = new ArrayList<>();
		for (GoodsCategory cg : cat1list) {
			cat1list1.add(cg.getCategoryId());
		}

		List<GoodsCategory> cat2list = new ArrayList<>();
		cat2list = GoodsCategorymapper.selectByLevelAndParentIdsAndNumber(cat1list1, 2, 100);
		
		List<Long> cat2list2 = new ArrayList<>();
		for (GoodsCategory cg : cat2list) {
			cat2list2.add(cg.getCategoryId());
		}

		List<GoodsCategory> cat3list = new ArrayList<>();
		cat3list = GoodsCategorymapper.selectByLevelAndParentIdsAndNumber(cat2list2, 3, 100);
		
		List<Long> cat3list3 = new ArrayList<>();
		for (GoodsCategory cg : cat2list) {
			cat3list3.add(cg.getCategoryId());
		}
		
		//entity形换成 VO形
		
		List<NewBeeMallIndexCategoryVO> vo1 =new ArrayList<>();
		
		for (GoodsCategory cg1 : cat1list) {
          NewBeeMallIndexCategoryVO vo11 = new NewBeeMallIndexCategoryVO();
			vo11.setCategoryId(cg1.getCategoryId());
			vo11.setCategoryName(cg1.getCategoryName());
			vo11.setCategoryLevel(cg1.getCategoryLevel());

			List<SecondLevelCategoryVO> vo2 =new ArrayList<>();
			for (GoodsCategory cg2 : cat2list) {
				SecondLevelCategoryVO vo22= new SecondLevelCategoryVO();
				if (cg2.getParentId() == vo11.getCategoryId()) {
					vo22.setCategoryLd(cg2.getCategoryId());
					vo22.setCategoryName(cg2.getCategoryName());
					vo22.setCategoryLevel(cg2.getCategoryLevel());
					vo22.setParentId(cg2.getParentId());
				}
					
					List<ThirdLevelCategoryVO> vo3 = new ArrayList<>();
					for (GoodsCategory cg3 : cat3list) {
						ThirdLevelCategoryVO vo33 = new ThirdLevelCategoryVO();
						if (vo22.getParentId() == cg3.getCategoryId())
								{
							vo33.setCategoryName(cg3.getCategoryName());
							vo33.setCategoryLevel(cg3.getCategoryLevel());
							vo33.setCategoryId(cg3.getCategoryId());
							vo3.add(vo33);
							vo22.setThiirdLevelCategoryVOS(vo3);
						}
					}
					vo2.add(vo22);
			}
			vo11.setSecondLevelCategoryVOS(vo2);
			vo1.add(vo11);
		}

		return vo1;
	}
	
}
