package cc.iteachyou.cms.taglib;

import cc.iteachyou.cms.taglib.tags.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cc.iteachyou.cms.common.SearchEntity;
import cc.iteachyou.cms.exception.CmsException;

@Component
public class ParseEngine {
	@Autowired
	private IncludeTag includeTag;//Include标签解析器
	@Autowired
	private GlobalTag globalTag;
	@Autowired
	private TemplateTag templateTag;
	@Autowired
	private ChannelArtListTag channelArtListTag;
	@Autowired
	private ChannelTag channelTag;
	@Autowired
	private ListTag listTag;
	@Autowired
	private LabelTag labelTag;
	@Autowired
	private LocationTag locationTag;
	@Autowired
	private TypeTag typeTag;
	@Autowired 
	private IfTag ifTag;
	@Autowired
	private VariableTag variableTag;
	@Autowired
	private CategoryTag categoryTag;
	@Autowired
	private TopCategoryTag topCategoryTag;
	@Autowired
	private PageListTag pageListTag;
	@Autowired
	private ArticleTag articleTag;
	@Autowired
	private PrevNextTag prevNextTag;
	@Autowired
	private AttachmentTag attachmentTag;
	@Autowired
	private TreeTag treeTag;
	@Autowired
	private SqlTag sqlTag;
	
	/**
	 * HTML解析入口
	 * @param html
	 * @return
	 */
	public String parse(String html)  throws CmsException{
		String newHtml = new String(html);
		newHtml = includeTag.parse(newHtml);
		newHtml = globalTag.parse(newHtml);
		newHtml = variableTag.parse(newHtml);
		newHtml = templateTag.parse(newHtml);
		typeTag.setT("P");
		newHtml = typeTag.parse(newHtml);
		channelArtListTag.setT("P");
		newHtml = channelArtListTag.parse(newHtml);
		channelTag.setT("P");
		newHtml = channelTag.parse(newHtml);
		listTag.setT("P");
		newHtml = listTag.parse(newHtml);
		locationTag.setT("P");
		newHtml = locationTag.parse(newHtml);
		treeTag.setT("P");
		newHtml = treeTag.parse(newHtml);
		newHtml = labelTag.parse(newHtml);
		newHtml = attachmentTag.parse(newHtml);
		newHtml = ifTag.parse(newHtml);
		newHtml = sqlTag.parse(newHtml);
		return newHtml;
	}
	
	/**
	 * 栏目页解析
	 * @param html
	 * @return
	 */
	public String parseCategory(String html, String typeid) throws CmsException {
		String newHtml = new String(html);
		categoryTag.setT("P");
		newHtml = categoryTag.parse(newHtml, typeid);
		// 顶级栏目
		topCategoryTag.setT("P");
		newHtml = topCategoryTag.parse(newHtml, typeid);
		// 当前位置
		locationTag.setT("P");
		newHtml = locationTag.parse(newHtml, typeid);
		// 栏目树
		treeTag.setT("P");
		newHtml = treeTag.parse(newHtml);
		newHtml = labelTag.parse(newHtml);
		newHtml = attachmentTag.parse(newHtml);
		newHtml = sqlTag.parse(newHtml);
		return newHtml;
	}
	
	/**
	 * 列表页面解析
	 * @param html
	 * @param typeid
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public String parsePageList(String html, String typeid, Integer pageNum, Integer pageSize) throws CmsException {
		String newHtml = new String(html);
		pageListTag.setT("P");
		newHtml = pageListTag.parse(newHtml, typeid, pageNum, pageSize);
		// 栏目树
		treeTag.setT("P");
		newHtml = treeTag.parse(newHtml);
		newHtml = labelTag.parse(newHtml);
		newHtml = attachmentTag.parse(newHtml);
		newHtml = sqlTag.parse(newHtml);
		return newHtml;
	}
	
	/**
	 * 文章详情页面解析
	 * @param html
	 * @param id
	 * @return
	 */
	public String parseArticle(String html, String id) throws CmsException{
		String newHtml = new String(html);
		newHtml = articleTag.parse(newHtml, id);
		locationTag.setT("P");
		newHtml = locationTag.parse(newHtml, id);
		// 栏目树
		treeTag.setT("P");
		newHtml = treeTag.parse(newHtml);
		newHtml = labelTag.parse(newHtml);
		newHtml = attachmentTag.parse(newHtml);
		newHtml = sqlTag.parse(newHtml);
		return newHtml;
	}

	public String parsePrevAndNext(String html, String id) throws CmsException{
		String newHtml = new String(html);
		newHtml = prevNextTag.parse(newHtml, id);
		return newHtml;
	}
	
	/**
	 * 列表页面解析
	 * @param html
	 * @param params
	 * @return
	 */
	public String parsePageList(String html, SearchEntity params) throws CmsException{
		String newHtml = new String(html);
		pageListTag.setT("P");
		newHtml = pageListTag.parse(newHtml, params);
		// 栏目树
		treeTag.setT("P");
		newHtml = treeTag.parse(newHtml);
		newHtml = labelTag.parse(newHtml);
		newHtml = attachmentTag.parse(newHtml);
		newHtml = sqlTag.parse(newHtml);
		return newHtml;
	}

	public String generate(String html) throws CmsException{
		String newHtml = new String(html);
		newHtml = includeTag.parse(newHtml);
		newHtml = globalTag.parse(newHtml);
		newHtml = variableTag.parse(newHtml);
		newHtml = templateTag.parse(newHtml);
		typeTag.setT("S");
		newHtml = typeTag.parse(newHtml);
		channelArtListTag.setT("S");
		newHtml = channelArtListTag.parse(newHtml);
		channelTag.setT("S");
		newHtml = channelTag.parse(newHtml);
		listTag.setT("S");
		newHtml = listTag.parse(newHtml);
		// 栏目树
		treeTag.setT("S");
		newHtml = treeTag.parse(newHtml);
		newHtml = labelTag.parse(newHtml);
		newHtml = attachmentTag.parse(newHtml);
		newHtml = ifTag.parse(newHtml);
		newHtml = sqlTag.parse(newHtml);
		return newHtml;
	}
	
	/**
	 * 栏目页解析
	 * @param html
	 * @return
	 */
	public String generateCategory(String html, String typeid) throws CmsException{
		String newHtml = new String(html);
		categoryTag.setT("S");
		newHtml = categoryTag.parse(newHtml, typeid);
		// 顶级栏目
		topCategoryTag.setT("S");
		newHtml = topCategoryTag.parse(newHtml, typeid);
		// 当前位置
		locationTag.setT("S");
		newHtml = locationTag.parse(newHtml, typeid);
		// 栏目树
		treeTag.setT("S");
		newHtml = treeTag.parse(newHtml);
		newHtml = labelTag.parse(newHtml);
		newHtml = attachmentTag.parse(newHtml);
		newHtml = sqlTag.parse(newHtml);
		return newHtml;
	}

	public String generatePageList(String html, String typeid, int pageNum, int pageSize) throws CmsException{
		String newHtml = new String(html);
		pageListTag.setT("S");
		newHtml = pageListTag.parse(newHtml,typeid, pageNum,pageSize);
		// 栏目树
		treeTag.setT("S");
		newHtml = treeTag.parse(newHtml);
		newHtml = labelTag.parse(newHtml);
		newHtml = attachmentTag.parse(newHtml);
		newHtml = sqlTag.parse(newHtml);
		return newHtml;
	}

	/**
	 * 文章详情页面解析
	 * @param html
	 * @param id
	 * @return
	 */
	public String generateArticle(String html, String id) throws CmsException{
		String newHtml = new String(html);
		articleTag.setT("S");
		newHtml = articleTag.parse(newHtml, id);
		locationTag.setT("S");
		newHtml = locationTag.parse(newHtml, id);
		// 栏目树
		treeTag.setT("S");
		newHtml = treeTag.parse(newHtml);
		newHtml = labelTag.parse(newHtml);
		newHtml = attachmentTag.parse(newHtml);
		newHtml = sqlTag.parse(newHtml);
		return newHtml;
	}

	public String generatePrevAndNext(String html, String id) throws CmsException{
		String newHtml = new String(html);
		prevNextTag.setT("S");
		newHtml = prevNextTag.parse(newHtml, id);
		return newHtml;
	}
}
