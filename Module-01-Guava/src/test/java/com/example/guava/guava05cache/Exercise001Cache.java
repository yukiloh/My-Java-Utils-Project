package com.example.guava.guava05cache;

import com.example.guava.entity.Student;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class Exercise001Cache {

    /**
     * guava的cache,类似于map,但更强大
     * 使用场景:
     * 1.愿意消耗一些内存空间来提升速度。
     * 2.预料到某些键会被多次查询。
     * 3.缓存中存放的数据总量不会超出内存容量。
     * 概括:频繁使用的少量数据可以使用cache
     */

    //用于生成cache时使用,没弄清楚工作原理,暂时保留下来
    private CacheLoader<Integer,Student> cacheLoader = new CacheLoader<Integer,Student>(){
        @Override
        public Student load(Integer integer) throws Exception {
            //模拟从redis或其他数据库中获取student
            Student student = new Student();
            student.setId(integer);
            student.setName("狗蛋"+System.currentTimeMillis());
            return student;
        }
    };

    //设置缓存,指定参数
    private Cache<Integer, Student> studentCache = CacheBuilder.newBuilder()
            //制定缓存策略
            .expireAfterAccess(60, TimeUnit.SECONDS)     //访问后刷新的存活事件,超出后值会变为null
            .expireAfterWrite(60, TimeUnit.SECONDS)      //写入后的存活时间
            .refreshAfterWrite(60, TimeUnit.SECONDS)     //可能是重新写入后刷新的存活时间
            //.weakKeys()                                         //指定为弱引用,当gc后会被清除
            //.recordStats()                                      //开启统计信息,可以通过cache.status()来获取;
            .maximumSize(10)                                      //最大储存数量,超出后最早进入的值会变为null
            .build();
            //.build(cacheLoader);                                  //也可以传入loader,没弄清楚工作原理

    /**
     * 基本的使用
     * 通过cache.put()来存放
     * 通过cache.getIfPresent()来获取
     */
    @Test
    void test01() {
        Student student = new Student();
        student.setId(11);
        student.setName("狗蛋");

        //存入缓存
        studentCache.put(1, student);

        //直接获取缓存
        Student student1 = studentCache.getIfPresent(1);    //不存在返回null
        System.out.println(student1);

        //将所有缓存失效,可以传入obj或一个可迭代的集合来指定让哪些值失效
        studentCache.invalidateAll();
        Student student2 = studentCache.getIfPresent(1);
        System.out.println(student2);   //此时获取null
    }

    /**
     * 另一种获取缓存的方式
     * 假设一个场景,获取一个缓存但guava中的cache可能不存在,需要指定从其他地方获取
     * 此时可以使用cache.get(key,callable)
     * 如果有多个线程来获取时会发生阻塞,但一个callable获取到后会使其他callable线程也获取到值
     */

    @Test
    void test02(){
        try {
            Student getStu = studentCache.get(10, new Callable<Student>() {

                //重写通过callable中的call方法来获取缓存
                @Override
                public Student call() throws Exception {
                    //todo 模拟从其他地方获取到了缓存
                    return new Student();
                }
            });

            System.out.println(getStu);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
