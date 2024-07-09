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


import com.dao.ZoufangrenwuDao;
import com.entity.ZoufangrenwuEntity;
import com.service.ZoufangrenwuService;
import com.entity.vo.ZoufangrenwuVO;
import com.entity.view.ZoufangrenwuView;

@Service("zoufangrenwuService")
public class ZoufangrenwuServiceImpl extends ServiceImpl<ZoufangrenwuDao, ZoufangrenwuEntity> implements ZoufangrenwuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZoufangrenwuEntity> page = this.selectPage(
                new Query<ZoufangrenwuEntity>(params).getPage(),
                new EntityWrapper<ZoufangrenwuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZoufangrenwuEntity> wrapper) {
		  Page<ZoufangrenwuView> page =new Query<ZoufangrenwuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZoufangrenwuVO> selectListVO(Wrapper<ZoufangrenwuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZoufangrenwuVO selectVO(Wrapper<ZoufangrenwuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZoufangrenwuView> selectListView(Wrapper<ZoufangrenwuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZoufangrenwuView selectView(Wrapper<ZoufangrenwuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
