package cn.tx.service;

import cn.tx.domain.Brand;
import cn.tx.entity.Result;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 商品品牌的 业务层 需要dubbo 提供 提供者
 * 对应的web工程消费
 */
public interface BrandService {

    public List<cn.tx.domain.Brand> findAll();

    /**
     * 调用pageHelper插件进行mybatis分页
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<Brand> findPage(int pageNum, int pageSize);

    /**
     * 新增品牌
     * @param brand
     * @return
     */
  public   void  save(Brand brand);

    /**
     * 通过id查询 数据
     * @param id
     * @return
     */
   public Brand findOne(long id);

    /**
     * 修改数据
     * @param brand
     */
   public  void update(Brand brand);

    /**
     * 根据id删除id
     * @param id
     */
  public  void delete(Long id);
}
