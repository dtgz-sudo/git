package cn.tx.controlle;

import cn.tx.domain.TbItemCat;
import cn.tx.entity.Result;
import cn.tx.service.ItemCatService;
import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * controller
 *
 * @author Administrator
 * <p>
 * 商品分类模块
 */
@RestController
@RequestMapping("/itemCat")
public class ItemCatController {

    @Reference
    private ItemCatService itemCatService;

    /**
     * 返回全部列表
     *
     * @return
     */
    @RequestMapping("/findAll")
    public List<TbItemCat> findAll() {
        return itemCatService.findAll();
    }

    /**
     * 返回全部列表
     *
     * @return
     */
    @RequestMapping("/findPage/{pageNum}/{pageSize}")
    public Result findPage(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) {
        try {
            // 调用业务层，查询
            PageInfo<TbItemCat> page = itemCatService.findPage(pageNum, pageSize);
            return new Result(true, "查询成功", page.getTotal(), page.getList());
        } catch (Exception e) {
            // 打印异常
            e.printStackTrace();
            // 返回错误提示信息
            return new Result(false, "查询失败");
        }
    }

    /**
     * 增加
     *
     * @param itemCat
     * @return
     */
    @RequestMapping("/add")
    public Result add(@RequestBody TbItemCat itemCat) {
        try {
            itemCatService.add(itemCat);
            return new Result(true, "增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "增加失败");
        }
    }

    /**
     * 修改
     *
     * @param itemCat
     * @return
     */
    @RequestMapping("/update")
    public Result update(@RequestBody TbItemCat itemCat) {
        try {
            itemCatService.update(itemCat);
            return new Result(true, "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "修改失败");
        }
    }

    /**
     * 获取实体
     *
     * @param id
     * @return
     */
    @RequestMapping("/findOne/{id}")
    public Result findOne(@PathVariable("id") Long id) {
        try {
            // 通过主键查询
            TbItemCat itemCat = itemCatService.findOne(id);
            return new Result(true, "查询成功", itemCat);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "查询失败");
        }
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    public Result delete(Long[] ids) {
        try {
            System.out.println(ids);
            itemCatService.delete(ids);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
    }

    /**
     * 查询+分页
     *
     * @param
     * @param
     * @param
     * @return
     */

    @RequestMapping("/search/{pageNum}/{pageSize}")
    public Result search(@RequestBody TbItemCat itemCat, @PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) {
        try {
            // 调用业务层，查询
            PageInfo<TbItemCat> page = itemCatService.findPage(itemCat, pageNum, pageSize);
            return new Result(true, "查询成功", page.getTotal(), page.getList());
        } catch (Exception e) {
            // 打印异常
            e.printStackTrace();
            // 返回错误提示信息
            return new Result(false, "查询失败");
        }
    }


    /**
     * 通过上级分类的id查询下一级分类
     *
     * @param parentId
     * @return
     */

    @RequestMapping("/findByParentId/{parentId}")
    public Result findByParentId(@PathVariable("parentId") Long parentId) {
        System.out.println("findByParentId");
        try {
            // 调用业务层，查询
            List<TbItemCat> list = itemCatService.findByParentId(parentId);
            System.out.println(list);
            return new Result(true, "查询成功", list);
        } catch (Exception e) {
            // 打印异常
            e.printStackTrace();
            // 返回错误提示信息
            return new Result(false, "查询失败");
        }
    }

    /**
     * 分类编辑回显数据
     * 通过分类的id查询分类数据
     * 返回该分类对象
     *
     * @param id
     * @return
     */
    @RequestMapping("/findById/{id}")
    public Result findById(@PathVariable("id") Long id) {
        System.out.println(" findById : " + id);
        try {
            // 调用业务层，查询
            TbItemCat tbItemCat = itemCatService.findById(id);
            System.out.println(tbItemCat);
            return new Result(true, "查询成功", tbItemCat);
        } catch (Exception e) {
            // 打印异常
            e.printStackTrace();
            // 返回错误提示信息
            return new Result(false, "查询失败");
        }
    }

}
