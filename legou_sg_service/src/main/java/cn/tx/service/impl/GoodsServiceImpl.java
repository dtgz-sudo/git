package cn.tx.service.impl;


import cn.tx.domain.*;
import cn.tx.groupEntity.Goods;
import cn.tx.mapper.*;
import cn.tx.service.GoodsService;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 拓薪教育 -- 腾讯课程认证机构
 * 樱木老师
 */

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private TbGoodsMapper tbGoodsMapper;

    @Autowired
    private TbGoodsDescMapper tbGoodsDescMapper;

    @Autowired
    private TbItemMapper tbItemMapper;
    @Autowired
    private TbItemCatMapper itemCatMapper;
    @Autowired
    private BrandMapper brandMapper;

    /**
     * 保存商品
     *
     * @param goods
     */
    @Override
    public void add(Goods goods) throws Exception {
        System.out.println(goods);
        System.out.println("=============================");
        TbGoods tbGoods = goods.getTbGoods();
        TbGoodsDesc tbGoodsDesc = goods.getTbGoodsDesc();
        List<TbItem> itemList = goods.getItemList();
        // 未审核
        tbGoods.setAuditStatus("0");
        // 未上架
        tbGoods.setIsMarketable("0");
        // 正常 如果 是1代表已删除
        tbGoods.setIsDelete("0");

        // 保存spu 并且返回ID


        System.out.println("spu 和 spu 描述插入到数据库");
        tbGoodsMapper.insert(tbGoods);
        System.out.println("spu 和spu描述的主键:" + tbGoods.getId());
        // 保证spu 和spu描述的 id
        tbGoodsDesc.setGoodsId(tbGoods.getId());

        //插入商品扩展数据
        tbGoodsDescMapper.insert(goods.getTbGoodsDesc());
        System.out.println(goods);
        // 判断是否启用规格
        if ( tbGoods.getIsEnableSpec().equals("1") && itemList != null && itemList.size() >= 1 ) {
            // 启用规格
            for (TbItem tbItem : itemList) {

                tbItem = createTbitem(tbItem, tbGoods, tbGoodsDesc);
                tbItemMapper.insert(tbItem);
            }
        } else {
            //   没有启用规格手动 name spu和spu相同
            TbItem tbItem = null;
            tbItem = new TbItem();
            tbItem.setTitle(tbGoods.getCaption());
            tbItem.setPrice(tbGoods.getPrice());
            tbItem.setNum(999);
            tbItem.setCategoryid(tbGoods.getCategory3Id());
            Long category3Id = tbGoods.getCategory3Id();
            TbItemCat tbItemCat = itemCatMapper.selectByPrimaryKey(category3Id);
            tbItem.setCategory(tbItemCat.getName());
            tbItem.setStatus("0");
            tbItem.setCreateTime(new Date());
            tbItem.setUpdateTime(new Date());
            tbItemMapper.insert(tbItem);
        }

    }

    /**
     * @param tbItem
     * @param tbGoods
     * @param tbGoodsDesc
     * @return 149187842867966    ceshi	小米8		0		4	性价比高	558	559	560			35	1
     * 149187842867966	好看&nbsp;<img src="http://localhost:8082/plugins/kindeditor/plugins/emoticons/images/2.gif" border="0" alt="" />	[{"attributeValue":["双卡"],"attributeName":"网络"},{"attributeValue":["16G","32G"],"attributeName":"机身内存"}]	[{"text":"支持","value":"货到付款"},{"text":"满减","value":"满1000减500"}]	[{"color":"白色","url":"http://192.168.25.133/group1/M00/00/00/wKgZhVzk6qaASBz_AAARZvgKQGk395.jpg"}]	试试	试试
     * 1369284	小米88 移动3G 16G		111.00		9999		http://192.168.25.133/group1/M00/00/00/wKgZhVzk8K2AJ9Z1AABXg25FIxU949.jpg	560	1	2019-05-22 14:48:28	2019-05-22 14:48:28				0	149187842867967	ceshi		手机	小米	{"网络":"移动3G","机身内存":"16G"}	测试名称
     */
    private TbItem createTbitem(TbItem tbItem, TbGoods tbGoods, TbGoodsDesc tbGoodsDesc) throws Exception {
        if ( tbItem == null ) {
            tbItem = new TbItem();
        }
        String title = null;
        try {
            // 标题 spu名字 + caption(副标题) +规格 +自定义属性 +  第三级分类名字
            title = tbGoods.getGoodsName();
            //副标题
            title += tbGoods.getCaption();
            // 拼装规格 样式json数组：{"机身内存":"16G","网络":"双卡"}
            String specificationItems = tbItem.getSpec();

            Map<String, String> maps = JSON.parseObject(specificationItems, Map.class);
            for (String str : maps.keySet()) {
                title += maps.get(str);
            }
        } catch (Exception e) {
            System.out.println("解析规格错误");
        }

        try {
            Long category3Id = tbGoods.getCategory3Id();
            TbItemCat tbItemCat = itemCatMapper.selectByPrimaryKey(category3Id);
            title += tbItemCat.getName();
        } catch (Exception e) {
            System.out.println("分类设置错误");
        }
        //封装数据
        tbItem.setTitle(title);
        // 副标题 买点
        tbItem.setSellPoint(tbGoods.getCaption());
        try {
            // 照片
            String itemImages = tbGoodsDesc.getItemImages();
            List<Map> imges = JSON.parseArray(itemImages, Map.class);

            tbItem.setImage(imges.get(0).get("url").toString());
        } catch (Exception e) {
            System.out.println("图片解析出错");
        }
        tbItem.setCategoryid(tbGoods.getCategory3Id());
        //商品状态，0 未审核 1-正常，2-下架，3-删除
        tbItem.setStatus("0");
        tbItem.setCreateTime(new Date());
        tbItem.setUpdateTime(new Date());
        tbItem.setItemSn("00000000000");

        try {
            BigDecimal price = tbItem.getPrice();

            tbItem.setCostPirce(price);
            tbItem.setMarketPrice(tbItem.getPrice());
        } catch (Exception e) {
            System.out.println("价格设置失败");
        }
        tbItem.setGoodsId(tbGoods.getId());
        //设置品牌
        Long brandId = tbGoods.getBrandId();
        Brand one = brandMapper.findOne(brandId);
        if ( one != null ) {
            tbItem.setSeller(one.getName());
            tbItem.setBrand(one.getName());
            tbItem.setSeller(one.getName());
        }
        tbItem.setCategory(tbItem.getCategory());
        return tbItem;
    }

}
