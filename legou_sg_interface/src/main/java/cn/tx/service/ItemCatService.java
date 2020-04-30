package cn.tx.service;

import cn.tx.domain.TbItemCat;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 服务层接口
 *
 * @author Administrator
 */
public interface ItemCatService {

    /**
     * 返回全部列表
     *
     * @return
     */
    public List<TbItemCat> findAll();

    /**
     * 返回分页列表
     *
     * @return
     */
    public PageInfo<TbItemCat> findPage(int pageNum, int pageSize);

    /**
     * 增加
     */
    public void add(TbItemCat itemCat);

    /**
     * 修改
     */
    public void update(TbItemCat itemCat);

    /**
     * 根据ID获取实体
     *
     * @param id
     * @return
     */
    public TbItemCat findOne(Long id);

    /**
     * 批量删除一个数组的数据
     * 递归删除
     *
     * @param ids
     */
    public void delete(Long[] ids);

    /**
     * 删除一个分类和他的子分类
     * 递归删除
     *
     * @param ids
     */
    public void delete(Long ids);

    /**
     * 分页
     *
     * @param pageNum  当前页 码
     * @param pageSize 每页记录数
     * @return
     */
    public PageInfo<TbItemCat> findPage(TbItemCat itemCat, int pageNum, int pageSize);

    /**
     * 通过上级分类的id查询下一级分类
     *
     * @param parentId
     * @return
     */
    public List<TbItemCat> findByParentId(Long parentId);


    /**
     * 分类编辑回显数据
     * 通过分类的id查询分类数据
     * 返回该分类对象
     *
     * @param findById
     * @return TbItemCat
     */
    public TbItemCat findById(Long findById);
}
