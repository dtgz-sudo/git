package cn.tx.service;

import cn.tx.domain.TbSpecification;
import cn.tx.groupEntity.Specification;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 处理规格的 业务层 服务注册到 dubbo 的注册中心zookeeper
 */
public interface SpecificationService {
    /**
     * 分页查询 出 所有的规格项
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<TbSpecification> findPage(int pageNum, int pageSize);

    /**
     * 讲前端传过来的组合类 specification 新增数据库
     *
     * @param spcification
     */
    void save(Specification spcification);

    /**
     * 查询对应的 规格和规格项
     *
     * @param id
     * @return
     */
    Specification findOne(Long id);

    /**
     * 更新规格项 和规格
     * 逻辑是更新规格
     * 规格项 的逻辑是 全部删除后重新插入
     *
     * @param spcification
     */
    void update(Specification spcification);

    /**
     * 通过主键删除 规格和规格项
     *
     * @param id
     */
    void delete(Long id);

    /**
     * 返回全部数据
     *
     * @return
     */
    public List<TbSpecification> findAll();
}
