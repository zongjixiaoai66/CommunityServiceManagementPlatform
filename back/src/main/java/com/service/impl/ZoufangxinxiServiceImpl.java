package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.ZoufangxinxiDao;
import com.entity.ZoufangxinxiEntity;
import com.service.ZoufangxinxiService;
import com.entity.vo.ZoufangxinxiVO;
import com.entity.view.ZoufangxinxiView;

@Service("zoufangxinxiService")
public class ZoufangxinxiServiceImpl extends ServiceImpl<ZoufangxinxiDao, ZoufangxinxiEntity> implements ZoufangxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZoufangxinxiEntity> page = this.selectPage(
                new Query<ZoufangxinxiEntity>(params).getPage(),
                new EntityWrapper<ZoufangxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZoufangxinxiEntity> wrapper) {
		  Page<ZoufangxinxiView> page =new Query<ZoufangxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZoufangxinxiVO> selectListVO(Wrapper<ZoufangxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZoufangxinxiVO selectVO(Wrapper<ZoufangxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZoufangxinxiView> selectListView(Wrapper<ZoufangxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZoufangxinxiView selectView(Wrapper<ZoufangxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
