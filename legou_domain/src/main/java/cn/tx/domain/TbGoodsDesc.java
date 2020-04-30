package cn.tx.domain;

import java.io.Serializable;

/**
 * spu详情
 * CREATE TABLE `tb_goods_desc` (
 * `goods_id` bigint(20) NOT NULL COMMENT 'SPU_ID',
 * `introduction` varchar(3000) DEFAULT NULL COMMENT '描述',
 * `specification_items` varchar(3000) DEFAULT NULL COMMENT '规格结果集，所有规格，包含isSelected',
 * `custom_attribute_items` varchar(3000) DEFAULT NULL COMMENT '自定义属性（参数结果）',
 * `item_images` varchar(3000) DEFAULT NULL 'spu 的照片们',
 * `package_list` varchar(3000) DEFAULT NULL COMMENT '包装列表',
 * `sale_service` varchar(3000) DEFAULT NULL COMMENT '售后服务',
 * PRIMARY KEY (`goods_id`) USING BTREE
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
 */
public class TbGoodsDesc implements Serializable {
    // SPU_ID 主键
    private Long goodsId;

    // 介绍 描述
    private String introduction;
    // 规格项 规格结果集，所有规格，包含isSelected
    private String specificationItems;
    //自定义属性（参数结果）
    private String customAttributeItems;

    // spu 的照片们
    private String itemImages;
    //包装列表
    private String packageList;
    //售后服务
    private String saleService;

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public String getSpecificationItems() {
        return specificationItems;
    }

    public void setSpecificationItems(String specificationItems) {
        this.specificationItems = specificationItems == null ? null : specificationItems.trim();
    }

    public String getCustomAttributeItems() {
        return customAttributeItems;
    }

    public void setCustomAttributeItems(String customAttributeItems) {
        this.customAttributeItems = customAttributeItems == null ? null : customAttributeItems.trim();
    }

    public String getItemImages() {
        return itemImages;
    }

    public void setItemImages(String itemImages) {
        this.itemImages = itemImages == null ? null : itemImages.trim();
    }

    public String getPackageList() {
        return packageList;
    }

    public void setPackageList(String packageList) {
        this.packageList = packageList == null ? null : packageList.trim();
    }

    public String getSaleService() {
        return saleService;
    }

    public void setSaleService(String saleService) {
        this.saleService = saleService == null ? null : saleService.trim();
    }

    @Override
    public String toString() {
        return "TbGoodsDesc{" +
                "goodsId=" + goodsId +
                ", introduction='" + introduction + '\'' +
                ", specificationItems='" + specificationItems + '\'' +
                ", customAttributeItems='" + customAttributeItems + '\'' +
                ", itemImages='" + itemImages + '\'' +
                ", packageList='" + packageList + '\'' +
                ", saleService='" + saleService + '\'' +
                '}';
    }
}