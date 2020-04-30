package cn.tx.service.impl;

import cn.tx.domain.Brand;
import cn.tx.mapper.BrandMapper;
import cn.tx.service.BrandService;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 服务层
 */

@Transactional
@Service
public class BrandServiceImpl implements BrandService {

    // 服务层注入dao层
    @Autowired
    private BrandMapper brandMapper;

    /**
     * 查询所有品牌数据
     *
     * @return
     */
    @Override
    public List<Brand> findAll() {
        List<Brand> list = brandMapper.findAll();
        return list;
    }

    @Override
    public  PageInfo<Brand> findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        // 设置了pageHelper 以后自动的对下一条查询语句利用aop进行增强
        List<Brand> list = brandMapper.findAll();
        // 封装数据到 PageInfo
        PageInfo<Brand> pageInfo = new PageInfo<>(list);

        return pageInfo;
    }
    /**
     * 新增品牌
     * @param brand
     * @return
     */
    @Override
    public void save(Brand brand) {

        brandMapper.save(brand);
    }

    /**
     * 通过id查询数据
     * @param id
     * @return
     */
    @Override
    public Brand findOne(long id) {
        return  brandMapper.findOne(id);
    }

    /**
     * 修改数据
     * @param brand
     */
    @Override
    public void update(Brand brand) {
        brandMapper.update(brand);
    }

    /**
     * 根据id删除id
     * @param id
     */
    @Override
    public void delete(Long id) {
        brandMapper.delete(id);
    }


}
