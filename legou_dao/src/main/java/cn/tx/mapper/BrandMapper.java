package cn.tx.mapper;

import cn.tx.domain.Brand;

import java.util.List;

/**
 * 商品品牌的数据库操作接口
 */
public interface BrandMapper {

    public List<Brand> findAll();

    public void save(Brand brand);

   public Brand findOne(Long id);

   public void update(Brand brand);

   public void delete(Long id);
}
