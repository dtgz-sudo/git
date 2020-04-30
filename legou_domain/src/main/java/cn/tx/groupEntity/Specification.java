package cn.tx.groupEntity;

import cn.tx.domain.TbSpecification;
import cn.tx.domain.TbSpecificationOption;

import java.io.Serializable;
import java.util.List;

/**
 * @author 赵德锋
 */
public class Specification implements Serializable {

    // 规格
    TbSpecification tbSpecification;
    // 规格项 一对多
    List<TbSpecificationOption> tbSpecificationOptionList;

    public Specification() {
    }

    public TbSpecification getTbSpecification() {
        return tbSpecification;
    }

    public void setTbSpecification(TbSpecification tbSpecification) {
        this.tbSpecification = tbSpecification;
    }

    public List<TbSpecificationOption> getTbSpecificationOptionList() {
        return tbSpecificationOptionList;
    }

    public void setTbSpecificationOptionList(List<TbSpecificationOption> tbSpecificationOptionList) {
        this.tbSpecificationOptionList = tbSpecificationOptionList;
    }

    @Override
    public String toString() {
        return "Spcification{" +
                "tbSpecification=" + tbSpecification +
                ", tbSpecificationOptionList=" + tbSpecificationOptionList +
                '}';
    }

    public Specification(TbSpecification tbSpecification, List<TbSpecificationOption> tbSpecificationOptionList) {
        this.tbSpecification = tbSpecification;
        this.tbSpecificationOptionList = tbSpecificationOptionList;
    }
}
