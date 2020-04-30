package cn.tx.controlle;

import cn.tx.domain.TbSpecification;
import cn.tx.entity.Result;
import cn.tx.groupEntity.Specification;
import cn.tx.service.SpecificationService;
import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * springmvc controller
 * 操作规格项 和规格的控制层
 *
 * @author 赵德锋
 */
// @RestController = @Controller + @ResponseBody
@RestController
@RequestMapping("/specification")
public class SpecificationController {

    /**
     * 从注册中心订阅 对应的业务层 版本号默认
     */
    @Reference
    private SpecificationService specificationService;

    /**
     * 分页查询数据
     * "../specification/findPage/"+$scope.paginationConf.currentPage+"/"+$scope.paginationConf.itemsPerPage
     *
     * @return result 向前端返回的结果集
     */
    @RequestMapping("/findPage/{pageNum}/{pageSize}")
    public Result findPage(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) {
        Result result = null;
        try {
            PageInfo<TbSpecification> pageInfo = specificationService.findPage(pageNum, pageSize);
            System.out.println("总条数 ：  " + pageInfo.getTotal());
            result = new Result(true, "分页查询成功", pageInfo.getTotal(), pageInfo.getList());
        } catch (Exception e) {
            e.printStackTrace();
            result = new Result(false, "分页查询失败");
        }

        return result;
    }

    /**
     * 新增 规格 和规格项
     * java逻辑使用外键 数据库不适用外键保证性能
     *
     * @param spcification
     * @return
     */
    @RequestMapping("/save")
    public Result save(@RequestBody Specification spcification) {
        System.out.println(spcification);
        Result result = null;
        try {
            specificationService.save(spcification);
            result = new Result(true, "新增成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new Result(false, "新增失败");
        }

        return result;
    }

    /**
     * 查询对应的 规格和规格项
     *
     * @param id
     * @return
     */

    @RequestMapping("/findOne/{id}")
    public Result findOne(@PathVariable("id") Long id) {
        System.out.println(id);
        Result result = null;
        try {
            Specification specification = specificationService.findOne(id);
            result = new Result(true, "查询成功", specification);
        } catch (Exception e) {
            e.printStackTrace();
            result = new Result(false, "查询失败");
        }

        return result;
    }

    /**
     * 更新  规格 和规格项
     *
     * @param spcification
     * @return
     */
    @RequestMapping("/update")
    public Result update(@RequestBody Specification spcification) {
        System.out.println(spcification);
        Result result = null;
        try {
            specificationService.update(spcification);
            result = new Result(true, "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new Result(false, "修改失败");
        }

        return result;
    }

    /**
     * 更新  规格 和规格项
     *
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    public Result delete(Long[] ids) {
        System.out.println("delete： " + ids);
        Result result = null;
        try {
            for (Long id : ids) {
                specificationService.delete(id);
            }

            result = new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new Result(false, "删除失败");
        }

        return result;
    }

    /**
     * 查询所有的数据
     * 返回的格式：
     * $scope.brandList = {data:[{id:1,text:'联想'},{id:2,text:'华为'},{id:3,text:'小米'}]};
     *
     * @return
     */
    @RequestMapping("/findSpecificationList")
    public Result findSpecificationList() {
        Result result = null;
        try {
            List<Map<String, String>> brandList = new ArrayList<Map<String, String>>();
            System.out.println("findSpecificationList");
            List<TbSpecification> list = specificationService.findAll();
            for (TbSpecification brand : list) {
                Map<String, String> map = new LinkedHashMap();
                map.put("id", brand.getId().toString());
                map.put("text", brand.getSpecName());
                brandList.add(map);
            }
            result = new Result(true, "品牌查询成功", brandList);
        } catch (Exception e) {
            e.printStackTrace();
            result = new Result(false, "品牌查询失败");
        }

        return result;
    }

}
