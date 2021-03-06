package cn.tx.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * sku  具体到具体的一部手机
 */
public class TbItem implements Serializable {
    //商品id，同时也是商品编号
    private Long id;
    //商品标题
    private String title;
    //商品卖点
    private String sellPoint;
    //商品价格，单位为：元
    private BigDecimal price;
    //库存数量 字段不用
    private Integer stockCount;
    //库存数量
    private Integer num;
    //商品条形码
    private String barcode;
    //商品图片
    private String image;
    //所属类目，叶子类目 第三级分类ID
    private Long categoryid;
    //商品状态，0 未审核 1-正常，2-下架，3-删除
    private String status;
    //创建时
    private Date createTime;
    //修改时间
    private Date updateTime;
    // 备案编号
    private String itemSn;
    // 原材料价格
    private BigDecimal costPirce;
    //市场价格
    private BigDecimal marketPrice;

    private String isDefault;
    //
    private Long goodsId;

    private String sellerId;

    private String cartThumbnail;
    //  分类名称
    private String category;
    // sku 品牌
    private String brand;
    //规格项
    private String spec;
    // 销售商家
    private String seller;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getSellPoint() {
        return sellPoint;
    }

    public void setSellPoint(String sellPoint) {
        this.sellPoint = sellPoint == null ? null : sellPoint.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStockCount() {
        return stockCount;
    }

    public void setStockCount(Integer stockCount) {
        this.stockCount = stockCount;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode == null ? null : barcode.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public Long getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Long categoryid) {
        this.categoryid = categoryid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getItemSn() {
        return itemSn;
    }

    public void setItemSn(String itemSn) {
        this.itemSn = itemSn == null ? null : itemSn.trim();
    }

    public BigDecimal getCostPirce() {
        return costPirce;
    }

    public void setCostPirce(BigDecimal costPirce) {
        this.costPirce = costPirce;
    }

    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault == null ? null : isDefault.trim();
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId == null ? null : sellerId.trim();
    }

    public String getCartThumbnail() {
        return cartThumbnail;
    }

    public void setCartThumbnail(String cartThumbnail) {
        this.cartThumbnail = cartThumbnail == null ? null : cartThumbnail.trim();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec == null ? null : spec.trim();
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller == null ? null : seller.trim();
    }

    @Override
    public String toString() {
        return "TbItem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", sellPoint='" + sellPoint + '\'' +
                ", price=" + price +
                ", stockCount=" + stockCount +
                ", num=" + num +
                ", barcode='" + barcode + '\'' +
                ", image='" + image + '\'' +
                ", categoryid=" + categoryid +
                ", status='" + status + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", itemSn='" + itemSn + '\'' +
                ", costPirce=" + costPirce +
                ", marketPrice=" + marketPrice +
                ", isDefault='" + isDefault + '\'' +
                ", goodsId=" + goodsId +
                ", sellerId='" + sellerId + '\'' +
                ", cartThumbnail='" + cartThumbnail + '\'' +
                ", category='" + category + '\'' +
                ", brand='" + brand + '\'' +
                ", spec='" + spec + '\'' +
                ", seller='" + seller + '\'' +
                '}';
    }
}