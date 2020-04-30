package cn.tx.controller;

import cn.tx.domain.TbTypeTemplate;
import cn.tx.entity.Result;
import cn.tx.service.TypeTemplateService;
import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * controller
 *
 * @author 赵德锋
 * <p>
 * 模板管理模块
 */
@RestController
@RequestMapping("/typeTemplate")
public class TypeTemplateController {

    @Reference
    private TypeTemplateService typeTemplateService;

    /**
     * 返回全部列表
     *
     * @return
     */
    @RequestMapping("/findAll")
    public Result findAll() {
        try {
            List<TbTypeTemplate> list = typeTemplateService.findAll();
            return new Result(true, "查询成功", list);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "查询失败");
        }
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
            PageInfo<TbTypeTemplate> page = typeTemplateService.findPage(pageNum, pageSize);
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
     * @param typeTemplate
     * @return
     */
    @RequestMapping("/add")
    public Result add(@RequestBody TbTypeTemplate typeTemplate) {
        try {
            typeTemplateService.add(typeTemplate);
            return new Result(true, "增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "增加失败");
        }
    }

    /**
     * 修改
     *
     * @param typeTemplate
     * @return
     */
    @RequestMapping("/update")
    public Result update(@RequestBody TbTypeTemplate typeTemplate) {
        try {
            typeTemplateService.update(typeTemplate);
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
            TbTypeTemplate typeTemplate = typeTemplateService.findOne(id);
            return new Result(true, "查询成功", typeTemplate);
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
        System.out.println("delete 方法1");
        try {
            System.out.println(ids);
            typeTemplateService.delete(ids);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
//        return  null    ;
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
    public Result search(@RequestBody TbTypeTemplate typeTemplate, @PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) {
        try {
            // 分页条件查询
            PageInfo<TbTypeTemplate> page = typeTemplateService.findPage(typeTemplate, pageNum, pageSize);
            return new Result(true, "查询成功", page.getTotal(), page.getList());
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "查询失败");
        }
    }

    /**
     * [{"id":"27","text":"网络"},{"id":"32","text":"机身内存"}]
     *
     * @param newValue
     * @return Result
     */
    @RequestMapping("/findSpecList/{newValue}")
    public Result findSpecList(@PathVariable("newValue") Long newValue) {
        try {
            // 返回模板中所有的规格
            List<Map<String, Object>> list = typeTemplateService.findSpecList(newValue);
            return new Result(true, "查询成功", list);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "查询模板:" + newValue + "对应的规格失败");
        }
    }

}
