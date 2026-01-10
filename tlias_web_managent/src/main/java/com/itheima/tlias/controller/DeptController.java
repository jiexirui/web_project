package com.itheima.tlias.controller;

import com.itheima.tlias.pojo.Dept;
import com.itheima.tlias.pojo.Result;
import com.itheima.tlias.service.DeptService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

/**
 * RestController注解：
 * 组合注解：是 @Controller 和 @ResponseBody 的组合注解
 * 自动序列化：方法返回值自动序列化为 JSON 格式并写入 HTTP 响应体
 * 组件注册：将类标记为 Spring MVC 控制器组件，自动注册到 Spring 容器中
 * 简化开发：避免在每个方法上添加 @ResponseBody 注解
 * REST API：专门用于构建 REST 风格的 Web 服务，直接返回数据而不是视图名
 * 在 DeptController 类中，使用此注解后所有方法的返回值都会直接作为响应数据返回给客户端。
 * <p>
 * RequestMapping注解：
 * 路径映射：为整个控制器类设置统一的基础路径前缀/depts
 */
@RestController
@RequestMapping("/depts")
public class DeptController {
    @Autowired
    private DeptService deptService;

    @GetMapping
    public Result list() throws IOException {
        List<Dept> deptList = deptService.queryDeptList();
        return Result.success(deptList);
    }

//    @GetMapping("/getObj")
//    public Result getObj() {
//        return Result.success(new Dept(1, "开发部", LocalDateTime.now(), LocalDateTime.now()));
//    }

//    @DeleteMapping("/depts")//原始方式
//    public Result deleteById(HttpServletRequest request) {
//        String id = request.getParameter("id");
//        System.out.println("controller = " + id);
//        return Result.success();
//    }

    /**
     * 删除部门信息（使用RequestParam注解接收参数）接收名为 id 的查询参数,该参数为可选（required = false）当请求中没有该参数时不会报错
     * @param deptId 部门ID，可选参数
     * @return Result 删除操作结果
     */
//    @DeleteMapping("/depts")
//    public Result deleteById(@RequestParam(value = "id", required = false) Integer deptId) {
//        System.out.println("controller = " + deptId);
//        return Result.success();
//    }

    /**
     * 删除部门信息（直接接收参数）
     *
     * @param id 部门ID
     * @return Result 删除操作结果
     */
    @DeleteMapping("/{id}")
    public Result deleteById(Integer id) {
        System.out.println("controller = " + id);
        deptService.deleteById(id);
        return Result.success();
    }

    /**
     * 新增部门信息
     *
     * @param dept 部门对象，包含要保存的部门信息
     * @return Result 操作结果，成功时返回成功状态
     * RequestBody注解作用：
     * 请求体绑定：将 HTTP 请求体中的 JSON 数据绑定到方法参数对象上
     * 数据转换：自动将 JSON 格式的数据转换为 Java 对象
     */
    @PostMapping
    public Result save(@RequestBody Dept dept) {
        System.out.println("controller = " + dept);
        deptService.save(dept);
        return Result.success();
    }

    /**
     * 根据ID获取部门信息的控制器方法
     *
     * @param id 部门ID，通过路径参数传递
     * @return Result 包含操作结果的响应对象
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        System.out.println("deptId = " + id);
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }

    /**
     * 更新部门信息
     *
     * @param dept 部门实体对象，包含需要更新的部门信息
     * @return Result 操作结果对象，返回成功状态
     */
    @PutMapping
    public Result update(@RequestBody Dept dept) {
        System.out.println("controller = " + dept);
        deptService.update(dept);
        return Result.success();
    }

}
