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


import com.dao.ShequwenjianDao;
import com.entity.ShequwenjianEntity;
import com.service.ShequwenjianService;
import com.entity.vo.ShequwenjianVO;
import com.entity.view.ShequwenjianView;

@Service("shequwenjianService")
public class ShequwenjianServiceImpl extends ServiceImpl<ShequwenjianDao, ShequwenjianEntity> implements ShequwenjianService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShequwenjianEntity> page = this.selectPage(
                new Query<ShequwenjianEntity>(params).getPage(),
                new EntityWrapper<ShequwenjianEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShequwenjianEntity> wrapper) {
		  Page<ShequwenjianView> page =new Query<ShequwenjianView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ShequwenjianVO> selectListVO(Wrapper<ShequwenjianEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShequwenjianVO selectVO(Wrapper<ShequwenjianEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShequwenjianView> selectListView(Wrapper<ShequwenjianEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShequwenjianView selectView(Wrapper<ShequwenjianEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
