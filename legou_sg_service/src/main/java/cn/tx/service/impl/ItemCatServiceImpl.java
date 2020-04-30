package cn.tx.service.impl;

import cn.tx.domain.TbItemCat;
import cn.tx.domain.TbItemCatExample;
import cn.tx.mapper.TbItemCatMapper;
import cn.tx.service.ItemCatService;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 服务实现层
 * 分类
 *
 * @author 赵德锋
 */

@Service
@Transactional
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private TbItemCatMapper itemCatMapper;

    /**
     * 查询全部
     */
    @Override
    public List<TbItemCat> findAll() {

        return itemCatMapper.selectByExample(null);
    }

    /**
     * 按分页查询
     */
    @Override
    public PageInfo<TbItemCat> findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<TbItemCat> list = itemCatMapper.selectByExample(null);
        return new PageInfo<>(list);
    }

    /**
     * 增加
     */
    @Override
    public void add(TbItemCat itemCat) {
        itemCatMapper.insert(itemCat);
    }

    /**
     * 修改
     */
    @Override
    public void update(TbItemCat itemCat) {
        itemCatMapper.updateByPrimaryKey(itemCat);
    }

    /**
     * 根据ID获取实体
     *
     * @param id
     * @return
     */
    @Override
    public TbItemCat findOne(Long id) {
        return itemCatMapper.selectByPrimaryKey(id);
    }

    /**
     * 递归删除分类
     */
    @Override
    public void delete(Long[] ids) {
        /**
         * 不能直接删除需啊哟
         */
        for (Long id : ids) {
            delete(id);
        }
    }

    /**
     * 删除一个分类和他的子分类
     * 递归删除
     *
     * @param id
     */
    @Override
    public void delete(Long id) {

//        把该分类的子分类找到
        List<TbItemCat> list = this.findByParentId(id);
        for (TbItemCat tbItemCat : list) {
            this.delete(tbItemCat.getId());
        }
        itemCatMapper.deleteByPrimaryKey(id);
    }

    /**
     * 条件分页查询
     *
     * @param itemCat
     * @param pageNum  当前页 码
     * @param pageSize 每页记录数
     * @return
     */
    @Override
    public PageInfo<TbItemCat> findPage(TbItemCat itemCat, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        TbItemCatExample example = new TbItemCatExample();
        TbItemCatExample.Criteria criteria = example.createCriteria();
        if ( itemCat != null ) {
            if ( itemCat.getName() != null && itemCat.getName().length() > 0 ) {
                criteria.andNameLike("%" + itemCat.getName() + "%");
            }

        }
        // 条件查询
        List<TbItemCat> list = itemCatMapper.selectByExample(example);
        return new PageInfo<>(list);
    }

    /**
     * 通过上级分类的id查询下一级分类
     *
     * @param parentId
     * @return
     */
    @Override
    public List<TbItemCat> findByParentId(Long parentId) {
        TbItemCatExample example = new TbItemCatExample();
        TbItemCatExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        return itemCatMapper.selectByExample(example);

    }

    /**
     * 分类编辑回显数据
     * 通过分类的id查询分类数据
     * 返回该分类对象
     *
     * @param findById
     * @return TbItemCat
     */
    @Override
    public TbItemCat findById(Long findById) {

        return itemCatMapper.selectByPrimaryKey(findById);

    }

}
