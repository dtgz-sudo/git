package cn.tx.service.impl;

import cn.tx.domain.TbSpecification;
import cn.tx.domain.TbSpecificationOption;
import cn.tx.domain.TbSpecificationOptionExample;
import cn.tx.groupEntity.Specification;
import cn.tx.mapper.TbSpecificationMapper;
import cn.tx.mapper.TbSpecificationOptionMapper;
import cn.tx.service.SpecificationService;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 处理规格的 业务层 服务注册到 dubbo 的注册中心zookeeper
 * com.alibaba.dubbo.config.annotation.Service ： 将此服务注册到注册中心
 * 需要引入 dao层的
 * TbSpecificationMapper
 * TbSpecificationOptionMapper 接口
 */

@Transactional
@Service
@org.springframework.stereotype.Service
public class SpecificationImpl implements SpecificationService {

    // 操作规格
    @Autowired
    private TbSpecificationMapper tbSpecificationMapper;
    // 操作 规格项
    @Autowired
    private TbSpecificationOptionMapper tbSpecificationOptionMapper;

    @Override
    public PageInfo<TbSpecification> findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        // 查询全部数据
        List<TbSpecification> tbSpecifications = tbSpecificationMapper.selectByExample(null);

        return new PageInfo<TbSpecification>(tbSpecifications);
    }

    /**
     * 新增规格 和规格项到数据库
     *
     * @param spcification
     */
    @Override
    public void save(Specification spcification) {

        TbSpecification tbSpecification = spcification.getTbSpecification();
        // 新增数据到数据库并且把主键封装回来
        //不要忘了 修改mapper的配置文件 返回主键
        tbSpecificationMapper.insert(tbSpecification);

        // 利用 规格返回来的 主键 封装到规格项的主外键 并且挨个保存到 数据库

        List<TbSpecificationOption> list = spcification.getTbSpecificationOptionList();
        for (TbSpecificationOption option : list) {
            System.out.println(option);
            option.setSpecId(tbSpecification.getId());
            tbSpecificationOptionMapper.insert(option);
        }
    }

    /**
     * 查询对应的 规格和规格项
     *
     * @param id
     * @return Specification
     */
    @Override
    public Specification findOne(Long id) {
        Specification specification = new Specification();
        //查询规格
        TbSpecification tbSpecification = tbSpecificationMapper.selectByPrimaryKey(id);
        specification.setTbSpecification(tbSpecification);
        Long optionID = tbSpecification.getId();
        TbSpecificationOptionExample tbSpecificationOptionExample = new TbSpecificationOptionExample();
        TbSpecificationOptionExample.Criteria criteria = tbSpecificationOptionExample.createCriteria();
        criteria.andSpecIdEqualTo(id);
        List<TbSpecificationOption> list = tbSpecificationOptionMapper.selectByExample(tbSpecificationOptionExample);
        specification.setTbSpecificationOptionList(list);

        return specification;
    }

    /**
     * 更新规格项 和规格
     * 逻辑是更新规格
     * 规格项 的逻辑是 全部删除后重新插入
     *
     * @param spcification
     */
    @Override
    public void update(Specification spcification) {
        TbSpecification tbSpecification = spcification.getTbSpecification();
        // 通过主键 更新规格
        tbSpecificationMapper.updateByPrimaryKey(tbSpecification);

        TbSpecificationOptionExample example = new TbSpecificationOptionExample();
        // 内部类负责封装数据
        TbSpecificationOptionExample.Criteria criteria = example.createCriteria();
        criteria.andSpecIdEqualTo(tbSpecification.getId());

        // 删除全部数据项
        tbSpecificationOptionMapper.deleteByExample(example);

        //讲新的 数据项插入到数据库

        List<TbSpecificationOption> list = spcification.getTbSpecificationOptionList();
        for (TbSpecificationOption option : list) {
            System.out.println(option);
            option.setSpecId(tbSpecification.getId());
            tbSpecificationOptionMapper.insert(option);
        }
    }

    /**
     * 通过主键删除 规格和规格项
     *
     * @param id
     */
    @Override
    public void delete(Long id) {
        TbSpecificationOptionExample example = new TbSpecificationOptionExample();
        // 删除规格项
        TbSpecificationOptionExample.Criteria criteria = example.createCriteria();
        criteria.andSpecIdEqualTo(id);

        // 删除全部数据项
        tbSpecificationOptionMapper.deleteByExample(example);
        tbSpecificationMapper.deleteByPrimaryKey(id);

    }

    /**
     * 返回全部数据
     *
     * @return
     */
    @Override
    public List<TbSpecification> findAll() {
        return tbSpecificationMapper.selectByExample(null);
    }
}
