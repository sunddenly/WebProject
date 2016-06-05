package com.hebut.container;

/**
 * Created by jxy on 2016/6/5.
 */
public class ExampleBean1 {
    public ExampleBean1(){
        System.out.println("实例化ExempleBean1");
    }
    public void execute(){
        System.out.println("执行ExempleBean1");
    }
    public void init(){
        System.out.println("初始化ExempleBean1实例");
    }
    public void destroy(){
        System.out.println("销毁ExempleBean1实例");
    }
}
