package com.example.apachecommons.lang;

import com.example.apachecommons.model.User;
import org.junit.jupiter.api.Test;

/**
 * @author yukiloh
 * @version 0.1
 * @date 2020/7/6 13:42
 */
class BuilderTest {

    /**
     * builder,实现一些java对象的辅助处理
     * api比较简单,CompareToBuilder EqualsBuilder HashCodeBuilder ToStringBuilder(ToStringStyle)
     * 一般都是通过new来创建实例,再通过append添加条件,最后toXxx返回对象
     * 没仔细研究
     */
    @Test
    void toStringTest() {
        System.out.println(new User().toString());
        //打印结果: com.example.apachecommons.model.User@6c9f5c0d[my-id=<null>,my-username=<null>]

    }

}
