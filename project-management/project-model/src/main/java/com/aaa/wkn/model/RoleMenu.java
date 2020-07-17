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
 * @date 2020/7/16 20:20
 */
@Table(name = "t_role_menu")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class RoleMenu implements Serializable {
    @Column(name = "ROLE_ID")
    private Long roleId;

    @Column(name = "MENU_ID")
    private Long menuId;
}
