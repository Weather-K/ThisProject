package com.aaa.wkn.service;

import com.aaa.wkn.base.ResultData;
import com.aaa.wkn.model.*;
import com.aaa.wkn.vo.RoleVo;
import com.aaa.wkn.vo.ToKenVo;
import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @author Weather
 * @Company AAA德云社
 * @date 2020/7/16 20:50
 */
@FeignClient(value ="SYSTEM-PROVIDER")
public interface SystemApiService  {

    /**
     *
     * @param user
     * @return
     */
    @PostMapping("/doLogin")
    ToKenVo doLogin(@RequestBody User user);

    /**
     *
     * @param map
     * @return
     */
    @PostMapping("/log/addLoginLog")
    ResultData addLoginLog(@RequestBody Map map);


    /**
     *
     * @param user
     * @return
     */
    @PostMapping("/user/addUser")
    ResultData addUser(@RequestBody User user);

    /**
     *
     * @param map
     * @return
     */
    @PostMapping("/dept/selectAllDept")
    ResultData selectAllDept(@RequestBody HashMap map);

    /**
     *
     * @param dept
     * @return
     */
    @PostMapping("/dept/addDept")
    ResultData addDept(@RequestBody Dept dept);

    /**
     *
     * @param dept
     * @return
     */
    @PostMapping("/dept/updateDept")
    ResultData updateDept(@RequestBody Dept dept);

    /**
     *
     * @param ids
     * @return
     */
    @DeleteMapping("/dept/delDept")
    ResultData delDept(@RequestBody List<Long> ids);

    /**
     *
     * @param ids
     * @return
     */
    @DeleteMapping("/user/delUser")
    ResultData delUser(@RequestBody List<Long> ids);

    /**
     *
     * @param user
     * @return
     */
    @PostMapping("/user/updateUser")
    ResultData updateUser(@RequestBody User user);

    /**
     *
     * @return
     */
    @GetMapping("/user/exportExcle")
    Response exportExcle();


    /**
     *
     * @param map
     * @return
     */
    @PostMapping("/user/selectUser")
    ResultData selectUserAll(@RequestBody HashMap map);

    /**
     *
     * @param mappingUnit
     * @return
     */
    @PostMapping("/utilSelect")
    ResultData  utilSelect(@RequestBody MappingUnit mappingUnit/*, @RequestParam("tokenId") String tokenId*/);


    /**
     *
     * @param feild
     * @return
     */
    @PostMapping("/selectGroupByFeild")
    ResultData selectGroupByFeild(@RequestParam ("feild") String feild);


    /**
     *
     * @param mappingProject
     * @return
     */
    @PostMapping("/projectSelect")
    ResultData  projectSelect(@RequestBody MappingProject mappingProject);

    /**
     *
     * @param name
     * @return
     */
    @PostMapping("/SelectGroupName")
    ResultData SelectGroupName(@RequestParam ("name") String name);

    /**
     *
     * @param hashMap
     * @return
     */
    @PostMapping("/dict/selectAllDictByPage")
    ResultData selectAllDictByPage(@RequestBody HashMap hashMap);

    /**
     *
     * @param dict
     * @return
     */
    @PostMapping("/dict/addDict")
    ResultData addDict(@RequestBody Dict dict);

    /**
     *
     * @param ids
     * @return
     */
    @DeleteMapping("/dict/delDictsById")
    ResultData delDictsById(@RequestBody List<Long> ids);

    /**
     *
     * @param dict
     * @return
     */
    @PostMapping("/dict/updateDict")
    ResultData updateDict(@RequestBody Dict dict);

    /**
     *
     * @param tokenId
     * @return
     */
    @GetMapping("/getRedisToken")
    String getRedisToken(@RequestParam("tokenId") String tokenId);


    /**
     *
     * @param hashMap
     * @return
     */
    @PostMapping("/selcetAllResult")
    ResultData selcetAllResult(@RequestBody HashMap hashMap);


    /**
     *
     * @return
     */
    @PostMapping("/SelectProjectType")
    ResultData SelectProjectType();


    /**
     *
     * @param id
     * @return
     */
    @PostMapping("/resultDetail")
    ResultData resultDetail(@RequestParam("id") String id);

    /**
     *
     * @param id
     * @return
     */
    @PostMapping("/unitDetail")
    ResultData unitDetail(@RequestParam("id") String id);


    /**
     *
     * @param id
     * @return
     */
    @PostMapping("/projectDetail")
    ResultData projectDetail(@RequestParam("id") String id);

    /**
     *
     * @return
     */
    @GetMapping("/menu/getMenus")
    List<Menu> selectAllMenus();

    /**
     *
     * @param menu
     * @return
     */
    @PostMapping("/menu/insertMenuOrButton")
    ResultData<Menu> insertMenuOrButton(@RequestBody Menu menu);


    /**
     *
     * @param menu
     * @return
     */
    @PostMapping("/menu/updateMenuOrButton")
    ResultData<Menu> updateMenuOrButton(@RequestBody Menu menu);


    /**
     *
     * @param menuId
     * @return
     */
    @PostMapping("/menu/deleteMenuOrButton")
    ResultData<Menu> deleteMenuOrButton(@RequestParam("menuId") Long menuId);


    /**
     *
     * @return
     */
    @GetMapping("/role/allRoles")
    ResultData selectAllRole();

    /**
     *
     * @param roleVo
     * @return
     */
    @PostMapping("/role/pageRoles")
    ResultData selectAllRoleByPage(@RequestBody RoleVo roleVo);


    /**
     *
     * @param roleId
     * @return
     */
    @PostMapping("/role/deleteRole")
    ResultData deleteRole(@RequestParam("roleId") Long roleId);

    /**
     *
     * @param roleVo
     * @return
     */
    @PostMapping("/role/insertRole")
    ResultData insertRole(@RequestBody RoleVo roleVo);


    /**
     *
     * @param roleVo
     * @return
     */
    @PostMapping("/role/updateRole")
    ResultData updateRole(@RequestBody RoleVo roleVo);
}
