package cn.tx.domain;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * spu 一个手机型号 比如小米10pro
 * sku: 一部具体的手机 比如 小米10pro 5G 版本 12+256版本
 * CREATE TABLE `tb_goods` (
 * `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
 * `seller_id` varchar(20) DEFAULT NULL COMMENT '商家ID',
 * `goods_name` varchar(100) DEFAULT NULL COMMENT 'SPU名',
 * `default_item_id` bigint(20) DEFAULT NULL COMMENT '默认SKU',
 * `audit_status` varchar(2) DEFAULT NULL COMMENT '状态',
 * `is_marketable` varchar(1) DEFAULT NULL COMMENT '是否上架',
 * `brand_id` bigint(10) DEFAULT NULL COMMENT '品牌',
 * `caption` varchar(100) DEFAULT NULL COMMENT '副标题',
 * `category1_id` bigint(20) DEFAULT NULL COMMENT '一级类目',
 * `category2_id` bigint(10) DEFAULT NULL COMMENT '二级类目',
 * `category3_id` bigint(10) DEFAULT NULL COMMENT '三级类目',
 * `small_pic` varchar(150) DEFAULT NULL COMMENT '小图',
 * `price` decimal(10,2) DEFAULT NULL COMMENT '商城价',
 * `type_template_id` bigint(20) DEFAULT NULL COMMENT '分类模板ID',
 * `is_enable_spec` varchar(1) DEFAULT NULL COMMENT '是否启用规格',
 * `is_delete` varchar(1) DEFAULT NULL COMMENT '是否删除',
 * PRIMARY KEY (`id`) USING BTREE
 * ) ENGINE=InnoDB AUTO_INCREMENT=149187842867971 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
 */
public class TbGoods implements Serializable {
    // id 主键
    private Long id;
    //商家ID
    private String sellerId;
    //SPU名
    private String goodsName;
    //默认SKU
    private Long defaultItemId;
    //状态
    private String auditStatus;
    //是否上架
    private String isMarketable;
    //品牌id
    private Long brandId;
    // 副标题
    private String caption;
    //一级分类
    private Long category1Id;
    //二级分类
    private Long category2Id;
    //三级分类
    private Long category3Id;
    //小图
    private String smallPic;
    //商城价
    private BigDecimal price;
    // 分类模板ID
    private Long typeTemplateId;
    //是否启用规格
    private String isEnableSpec;
    //是否删除
    private String isDelete;

    public TbGoods(Long id, String sellerId, String goodsName, Long defaultItemId, String auditStatus, String isMarketable, Long brandId, String caption, Long category1Id, Long category2Id, Long category3Id, String smallPic, BigDecimal price, Long typeTemplateId, String isEnableSpec, String isDelete) {
        this.id = id;
        this.sellerId = sellerId;
        this.goodsName = goodsName;
        this.defaultItemId = defaultItemId;
        this.auditStatus = auditStatus;
        this.isMarketable = isMarketable;
        this.brandId = brandId;
        this.caption = caption;
        this.category1Id = category1Id;
        this.category2Id = category2Id;
        this.category3Id = category3Id;
        this.smallPic = smallPic;
        this.price = price;
        this.typeTemplateId = typeTemplateId;
        this.isEnableSpec = isEnableSpec;
        this.isDelete = isDelete;
    }

    public TbGoods() {
    }

    public TbGoods(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "TbGoods{" +
                "id=" + id +
                ", sellerId='" + sellerId + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", defaultItemId=" + defaultItemId +
                ", auditStatus='" + auditStatus + '\'' +
                ", isMarketable='" + isMarketable + '\'' +
                ", brandId=" + brandId +
                ", caption='" + caption + '\'' +
                ", category1Id=" + category1Id +
                ", category2Id=" + category2Id +
                ", category3Id=" + category3Id +
                ", smallPic='" + smallPic + '\'' +
                ", price=" + price +
                ", typeTemplateId=" + typeTemplateId +
                ", isEnableSpec='" + isEnableSpec + '\'' +
                ", isDelete='" + isDelete + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Long getDefaultItemId() {
        return defaultItemId;
    }

    public void setDefaultItemId(Long defaultItemId) {
        this.defaultItemId = defaultItemId;
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getIsMarketable() {
        return isMarketable;
    }

    public void setIsMarketable(String isMarketable) {
        this.isMarketable = isMarketable;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public Long getCategory1Id() {
        return category1Id;
    }

    public void setCategory1Id(Long category1Id) {
        this.category1Id = category1Id;
    }

    public Long getCategory2Id() {
        return category2Id;
    }

    public void setCategory2Id(Long category2Id) {
        this.category2Id = category2Id;
    }

    public Long getCategory3Id() {
        return category3Id;
    }

    public void setCategory3Id(Long category3Id) {
        this.category3Id = category3Id;
    }

    public String getSmallPic() {
        return smallPic;
    }

    public void setSmallPic(String smallPic) {
        this.smallPic = smallPic;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getTypeTemplateId() {
        return typeTemplateId;
    }

    public void setTypeTemplateId(Long typeTemplateId) {
        this.typeTemplateId = typeTemplateId;
    }

    public String getIsEnableSpec() {
        return isEnableSpec;
    }

    public void setIsEnableSpec(String isEnableSpec) {
        this.isEnableSpec = isEnableSpec;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }
}