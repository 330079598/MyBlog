package com.myblog.controller.admin;

import com.myblog.entity.Options;
import com.myblog.service.OptionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: stone
 * @Date: 2020/01/12 18:18:34
 * @ClassName: BackOptionsConntroller
 * @Description:
 **/

@Controller
@RequestMapping("/admin/options")
public class BackOptionsConntroller {

	@Autowired
	private OptionsService optionsService;

	@RequestMapping(value = "/editSubmit", method = RequestMethod.POST)
	public String editOptionSubmit(Options options) {
		//如果记录不存在,那就新建
		Options optionsCustom = optionsService.getOptions();
		if (optionsCustom.getOptionId() == null) {
			optionsService.insertOptions(options);
		} else {
			optionsService.updateOptions(options);
		}
		return "redirect:/admin/options";
	}
}
