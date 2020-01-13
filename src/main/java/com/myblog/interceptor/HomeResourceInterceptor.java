package com.myblog.interceptor;

import com.myblog.entity.Article;
import com.myblog.entity.Category;
import com.myblog.entity.Menu;
import com.myblog.entity.Options;
import com.myblog.enums.ArticleStatus;
import com.myblog.enums.LinkStatus;
import com.myblog.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: stone
 * @Date: 2020/01/12 15:50:24
 * @ClassName: HomeResourceInterceptor
 * @Description:
 **/

@Component
public class HomeResourceInterceptor implements HandlerInterceptor {
	@Autowired(required = false)
	private ArticleService articleService;

	@Autowired(required = false)
	private CategoryService categoryService;

	@Autowired(required = false)
	private TagService tagService;

	@Autowired(required = false)
	private LinkService linkService;

	@Autowired(required = false)
	private OptionsService optionsService;

	@Autowired(required = false)
	private MenuService menuService;

	/**
	 * 在请求处理之前执行，该方法主要是用于准备资源数据的，然后可以把它们当做请求属性放到WebRequest中
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws IOException {

		//菜单显示
		List<Menu> menuList = menuService.listMenu();
		request.setAttribute("menuList", menuList);

		List<Category> categoryList = categoryService.listCategory();
		request.setAttribute("allCategoryList", categoryList);

		//获得网站概况
		List<String> siteBasicStatistics = new ArrayList<String>();
		siteBasicStatistics.add(articleService.countArticle(ArticleStatus.PUBLISH.getValue()) + "");
		siteBasicStatistics.add(articleService.countArticleComment() + "");
		siteBasicStatistics.add(categoryService.countCategory() + "");
		siteBasicStatistics.add(tagService.countTag() + "");
		siteBasicStatistics.add(linkService.countLink(LinkStatus.NORMAL.getValue()) + "");
		siteBasicStatistics.add(articleService.countArticleView() + "");
		request.setAttribute("siteBasicStatistics", siteBasicStatistics);
		//最后更新的文章
		Article lastUpdateArticle = articleService.getLastUpdateArticle();
		request.setAttribute("lastUpdateArticle", lastUpdateArticle);

		//页脚显示
		//博客基本信息显示(Options)
		Options options = optionsService.getOptions();
		request.setAttribute("options", options);

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) {
	}

	@Override
	public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

	}
}