package cn.tx.groupEntity;

import cn.tx.domain.TbGoods;
import cn.tx.domain.TbGoodsDesc;
import cn.tx.domain.TbItem;

import java.io.Serializable;
import java.util.List;

/**
 * 商品组合类
 * ： spu ： sku 和sku 描述 tb_goods t_goodsDesc
 * sku: tb_item 一对多
 */
public class Goods implements Serializable {
    // spu
    private TbGoods tbGoods;
    // spu详细信息
    private TbGoodsDesc tbGoodsDesc;
    // 多个sku
    private List<TbItem> itemList;

    public TbGoods getTbGoods() {
        return tbGoods;
    }

    public void setTbGoods(TbGoods tbGoods) {
        this.tbGoods = tbGoods;
    }

    public TbGoodsDesc getTbGoodsDesc() {
        return tbGoodsDesc;
    }

    public void setTbGoodsDesc(TbGoodsDesc tbGoodsDesc) {
        this.tbGoodsDesc = tbGoodsDesc;
    }

    public List<TbItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<TbItem> itemList) {
        this.itemList = itemList;
    }

    public Goods() {
    }

    public Goods(TbGoods tbGoods, TbGoodsDesc tbGoodsDesc, List<TbItem> itemList) {
        this.tbGoods = tbGoods;
        this.tbGoodsDesc = tbGoodsDesc;
        this.itemList = itemList;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "tbGoods=" + tbGoods +
                ", tbGoodsDesc=" + tbGoodsDesc +
                ", itemList=" + itemList +
                '}';
    }
}
