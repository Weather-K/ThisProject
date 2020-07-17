package com.aaa.wkn.vo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
/**
 * @author Weather
 * @Company AAA德云社
 * @date 2020/7/16 20:24
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class ToKenVo implements Serializable {

    /**
     * token值，也就是uuid
     */
    private String token;

    /**
     * 标识了方法是否执行成功
     */
    private Boolean ifSuccess;

    /**
     * redis的key值，也就是用户的id
     */
    private String redisKey;
}
