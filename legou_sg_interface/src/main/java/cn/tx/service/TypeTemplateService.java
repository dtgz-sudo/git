package cn.tx.service;

import cn.tx.domain.TbTypeTemplate;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * 服务层接口
 *
 * @author 赵德锋
 */
public interface TypeTemplateService {

	/**
	 * 返回全部列表
	 *
	 * @return
	 */
	public List<TbTypeTemplate> findAll();

	/**
	 * 返回分页列表
	 *
	 * @return
	 */
	public PageInfo<TbTypeTemplate> findPage(int pageNum, int pageSize);

	/**
	 * 增加
	 */
	public void add(TbTypeTemplate typeTemplate);

	/**
	 * 修改
	 */
	public void update(TbTypeTemplate typeTemplate);

	/**
	 * 根据ID获取实体
	 *
	 * @param id
	 * @return
	 */
	public TbTypeTemplate findOne(Long id);

	/**
	 * 批量删除
	 *
	 * @param ids
	 */
	public void delete(Long[] ids);

	/**
	 * 分页
	 *
	 * @param pageNum  当前页 码
	 * @param pageSize 每页记录数
	 * @return
	 */
	public PageInfo<TbTypeTemplate> findPage(TbTypeTemplate typeTemplate, int pageNum, int pageSize);

	/**
     * 根据 模板id查询对应的 规格
     *
     * @param TbTypeTemplateId
     * @return List<TbSpecification> 规格集合
     * [{"id":"27","text":"网络"},{"id":"32","text":"机身内存"}]
     */
    public List<Map<String, Object>> findSpecList(Long TbTypeTemplateId);
}
