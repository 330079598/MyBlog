package com.myblog.service.impl;

import com.myblog.entity.Options;
import com.myblog.mapper.OptionsMapper;
import com.myblog.service.OptionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @Author: stone
 * @Date: 2020/01/12 18:20:10
 * @ClassName: OptionsServiceImpl
 * @Description:
 **/

@Service
public class OptionsServiceImpl implements OptionsService {

	@Autowired(required = false)
	private OptionsMapper optionsMapper;

	@Override
	@Cacheable(value = "default", key = "'options'")
	public Options getOptions() {
		return optionsMapper.getOptions();
	}

	@Override
	@CacheEvict(value = "default", key = "'options'")
	public void insertOptions(Options options) {
		optionsMapper.insert(options);
	}

	@Override
	@CacheEvict(value = "default", key = "'options'")
	public void updateOptions(Options options) {
		optionsMapper.update(options);
	}
}
