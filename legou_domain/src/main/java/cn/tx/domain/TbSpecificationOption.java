package cn.tx.domain;

import java.io.Serializable;

/**
 * 规格项
 */
public class TbSpecificationOption implements Serializable {
    private Long id;

    private String optionName;

    private Long specId;

    private Integer orders;

    @Override
    public String toString() {
        return "TbSpecificationOption{" +
                "id=" + id +
                ", optionName='" + optionName + '\'' +
                ", specId=" + specId +
                ", orders=" + orders +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName == null ? null : optionName.trim();
    }

    public Long getSpecId() {
        return specId;
    }

    public void setSpecId(Long specId) {
        this.specId = specId;
    }

    public Integer getOrders() {
        return orders;
    }

    public void setOrders(Integer orders) {
        this.orders = orders;
    }
}