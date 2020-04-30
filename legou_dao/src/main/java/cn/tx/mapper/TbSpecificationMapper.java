package cn.tx.mapper;

import cn.tx.domain.TbSpecification;
import cn.tx.domain.TbSpecificationExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbSpecificationMapper {
    /**
     * 组合查询的个数
     *
     * @param example
     * @return
     */
    int countByExample(TbSpecificationExample example);

    /**
     * 删除符合条件组合的数据
     *
     * @param example
     * @return
     */
    int deleteByExample(TbSpecificationExample example);

    int deleteByPrimaryKey(Long id);

    /**
     * 新增数据
     * 如果 字段没有数据那么设置成null
     *
     * @param record
     * @return
     */
    int insert(TbSpecification record);

    /**
     * 新增数据 并且进行条件判断 如果 字段没有数据那么 就不就行封装
     *
     * @param record
     * @return
     */
    int insertSelective(TbSpecification record);

    /**
     * 条件组合查询
     *
     * @param example
     * @return
     */
    List<TbSpecification> selectByExample(TbSpecificationExample example);

    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    TbSpecification selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbSpecification record, @Param("example") TbSpecificationExample example);

    int updateByExample(@Param("record") TbSpecification record, @Param("example") TbSpecificationExample example);

    int updateByPrimaryKeySelective(TbSpecification record);

    int updateByPrimaryKey(TbSpecification record);
}