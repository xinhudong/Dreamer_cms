package cc.iteachyou.cms.taglib.tags;

import cc.iteachyou.cms.common.ExceptionEnum;
import cc.iteachyou.cms.common.StateCodeEnum;
import cc.iteachyou.cms.dao.CategoryMapper;
import cc.iteachyou.cms.entity.Category;
import cc.iteachyou.cms.exception.CategoryNotFoundException;
import cc.iteachyou.cms.exception.CmsException;
import cc.iteachyou.cms.service.SystemService;
import cc.iteachyou.cms.taglib.IParse;
import cc.iteachyou.cms.taglib.annotation.Attribute;
import cc.iteachyou.cms.taglib.annotation.Tag;
import cc.iteachyou.cms.taglib.utils.RegexUtil;
import cc.iteachyou.cms.taglib.utils.URLUtils;
import cc.iteachyou.cms.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Tag(beginTag="{dreamer-cms:tree}",endTag="{/dreamer-cms:tree}",regexp="\\{dreamer-cms:tree[\\s]*.*?/\\}", attributes={
	@Attribute(name = "root",regex = "[ \t]+root=[\"\'].*?[\"\']"),
})
public class TreeTag implements IParse {
	@Autowired
	private SystemService systemService;
	@Autowired
	private CategoryMapper categoryMapper;
	
	/**
	 * 执行类型：
	 * P：解析
	 * S：生成静态化
	 */
	private String t;
	
	@Override
	public String parse(String html) throws CmsException {
		return this.parse(html, "");
	}

	@Override
	public String parse(String html, String params) throws CmsException {
		cc.iteachyou.cms.entity.System system = systemService.getSystem();
		
		Tag annotation = TreeTag.class.getAnnotation(Tag.class);
		List<String> treeTags = RegexUtil.parseAll(html, annotation.regexp(), 0);
		Attribute[] attributes = annotation.attributes();
		if(treeTags == null || treeTags.size() <= 0) {
			return html;
		}
		
		String newHtml = new String(html);

		for(int i = 0;i < treeTags.size();i++) {
			String tag = treeTags.get(i);
			StringBuilder tree = new StringBuilder();

			for (Attribute attribute : attributes) {
				String condition = RegexUtil.parseFirst(tag, attribute.regex(), 0);
				if (StringUtil.isBlank(condition)) {
					continue;
				}
				String key = condition.split("=")[0];
				String value = condition.split("=")[1];
				key = key.trim();
				value = value.replace("\"", "").replace("\'", "");

				Category root;
				String typeUrl = "/";
				if("-1".equals(value)){
					root = new Category();
					root.setId("-1");
					root.setCnname(system.getTitle());
					root.setEnname(system.getTitle());
				}else{
                    root = categoryMapper.queryCategoryByCode(value);
                    if (root == null || root.getIsShow() == 0) {
						throw new CategoryNotFoundException(
								ExceptionEnum.CAT_NOTFOUND_EXCEPTION.getCode(),
								ExceptionEnum.CAT_NOTFOUND_EXCEPTION.getMessage(),
								"栏目不存在，请检查标签中是否调用了不存在的（root）。");
					}
					typeUrl = URLUtils.parseURL(system, root, this.t);
				}

				tree.append("<ul class='dreamer-tree'>");
				tree.append("<li class='dreamer-tree-root'>");
                tree.append("<div class='dreamer-tree-root-div'>").append("<a href='" + typeUrl + "' title='" + root.getCnname() + "'>").append(root.getCnname()).append("</a>");
				recursion(tree, root.getId()); // 递归处理下级
				tree.append("</div>");
				tree.append("</li>");
				tree.append("</ul>");
			}
			newHtml = newHtml.replace(tag, tree.toString());
		}
		
		return newHtml;
	}

	public String getT() {
		return t;
	}

	public void setT(String t) {
		this.t = t;
	}

	private void recursion(StringBuilder tree, String id){
		cc.iteachyou.cms.entity.System system = systemService.getSystem();
		Map<String,Object> entity = new HashMap<String,Object>();
		entity.put("parentId", id);
		entity.put("isShow", 1);
		List<Category> children = categoryMapper.queryListByParams(entity);
		if(children != null && children.size() > 0){
			tree.append("<ul class='dreamer-tree-children'>");
			for (int j = 0; j < children.size(); j++) {
				Category category = children.get(j);
				tree.append("<li class='dreamer-tree-node'>");
				String childUrl = URLUtils.parseURL(system, category, this.t);
				tree.append("<div class='dreamer-tree-node-div'>").append("<a href='" + childUrl + "' title='" + category.getCnname() + "'>").append(category.getCnname()).append("</a>");
				recursion(tree, category.getId());
				tree.append("</div>");
				tree.append("</li>");
			}
			tree.append("</ul>");
		}
	}

}
