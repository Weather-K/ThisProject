package com.aaa.wkn.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
/**
 * @author Weather
 * @Company AAA德云社
 * @date 2020/7/16 20:18
 */
@Table(name = "t_role")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Role implements Serializable {
    /**
     * 角色ID
     */
    @Id
    @Column(name = "ROLE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    /**
     * 角色名称
     */
    @Column(name = "ROLE_NAME")
    private String roleName;

    /**
     * 角色描述
     */
    @Column(name = "REMARK")
    private String remark;

    /**
     * 创建时间
     */
    @Column(name = "CREATE_TIME")
    private String createTime;

    /**
     * 修改时间
     */
    @Column(name = "MODIFY_TIME")
    private String modifyTime;
}
