package cn.tx.controlle;

import cn.tx.domain.Brand;
import cn.tx.entity.Result;
import cn.tx.service.BrandService;
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
 * 品牌 springmvc controller
 */
// @RestController = @Controller + @ResponseBody
@RestController
@RequestMapping("/brand")
public class BrandController {

    // 注入对象 版本号默认
    @Reference
    private BrandService brandService;

    /**
     * 查询所有的数据
     *
     * @return
     */
    @RequestMapping("/findAll")
    public List<Brand> findAll() {
        System.out.println("findAll");

        return brandService.findAll();
    }

    /**
     * 分页查询使用restful风格
     *
     * @return
     */
    @RequestMapping("/findPage/{pageNum}/{pageSize}")
    public Result findPage(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) {
        System.out.println("findPage");
        Result result = null;
        try {
            // 调用业务层 进行分页查询
            PageInfo<Brand> pageInfo = brandService.findPage(pageNum, pageSize);
            result = new Result(true, "操作成功", pageInfo.getTotal(), pageInfo.getList());
        } catch (Exception e) {
            e.printStackTrace();
            result = new Result(false, "操作失败");
        }

        System.out.println(result);
        return result;
    }

    /**
     * 新增
     *
     * @return
     */
    @RequestMapping("/save")

    public Result save(@RequestBody Brand brand) {
        System.out.println(brand);
        Result result = null;
        try {
            // 调用业务层 进行分页查询
            brandService.save(brand);
            result = new Result(true, "新增成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new Result(false, "新增失败");
        }

        System.out.println(result);
        return result;
    }

    /**
     * 通过 id查询数据
     *
     * @return
     */
    @RequestMapping("/findOne")
    public Result findOne(Long id) {
        System.out.println(id);
        Result result = null;
        try {
            // 调用业务层 进行分页查询
            Brand brand = brandService.findOne(id);
            result = new Result(true, "新增成功", brand);
        } catch (Exception e) {
            e.printStackTrace();
            result = new Result(false, "新增失败");
        }

        System.out.println(result);
        return result;
    }

    /**
     * 新增
     *
     * @return
     */
    @RequestMapping("/update")

    public Result update(@RequestBody Brand brand) {
        System.out.println(brand);
        Result result = null;
        try {
            // 调用业务层 进行分页查询
            brandService.update(brand);
            result = new Result(true, "新增成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new Result(false, "新增失败");
        }

        System.out.println(result);
        return result;
    }

    @RequestMapping("/delete/{ids}")
    public Result delete(@PathVariable("ids") List<Long> ids) {
        System.out.println(ids);
        Result result = null;
        try {
            // 调用业务层 进行删除
            for (Long id : ids) {
                brandService.delete(id);
            }

            result = new Result(true, "新增成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new Result(false, "新增失败");
        }

        System.out.println(result);
        return result;
    }

    /**
     * 查询所有的数据
     * 返回的格式：
     * $scope.brandList = {data:[{id:1,text:'联想'},{id:2,text:'华为'},{id:3,text:'小米'}]};
     *
     * @return
     */
    @RequestMapping("/findBrandList")
    public Result findBrandList() {
        Result result = null;
        try {
            List<Map<String, String>> brandList = new ArrayList<Map<String, String>>();
            System.out.println("findBrandList");
            List<Brand> list = brandService.findAll();
            for (Brand brand : list) {
                Map<String, String> map = new LinkedHashMap();
                map.put("id", brand.getId().toString());
                map.put("text", brand.getName());
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
