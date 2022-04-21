package ltd.newbee.mall.newbeemall.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ltd.newbee.mall.newbeemall.dao.GoodsCategoryMapper;
import ltd.newbee.mall.newbeemall.entity.Carousel;
import ltd.newbee.mall.newbeemall.entity.IndexConfig;
import ltd.newbee.mall.newbeemall.service.NewBeeMallCarouselService;
import ltd.newbee.mall.newbeemall.vo.NewBeeMallIndexCarouselVO;
import ltd.newbee.mall.newbeemall.dao.CarouselMapper;

@Service
public class NewBeeMallCarouselServicelmpl implements NewBeeMallCarouselService {
	@Resource
	private CarouselMapper CarouselMapper;

	@Override
	public List<NewBeeMallIndexCarouselVO> getCarouselsForIndex(int number) {
		
		List<Carousel> carous =CarouselMapper.findCarouselsByNum(1);
		List<NewBeeMallIndexCarouselVO> ids = new ArrayList<>();
			
			for(Carousel cg : carous) {
				NewBeeMallIndexCarouselVO vo1=new NewBeeMallIndexCarouselVO();
				vo1.setCarouselUrl(cg.getCarouselUrl());
				vo1.setRedirectUrl(cg.getRedirectUrl());
				ids.add(vo1);
				
			}
	
		// TODO 自動生成されたメソッド・スタブ
		return ids;
	}

}
