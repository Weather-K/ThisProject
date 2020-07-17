package com.aaa.wkn.vo;
import com.aaa.wkn.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;
/**
 * @author Weather
 * @Company AAA德云社
 * @date 2020/7/16 20:24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class RoleVo implements Serializable {


    private List<Long> menuId;

    private Role role;

    private Integer pageNo;

    private Integer pageSize;
}
