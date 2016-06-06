package com.hebut.container;

/**
 * Created by jxy on 2016/6/5.
 */
public class ExampleBean {
    public ExampleBean(){
        System.out.println("实例化ExempleBean");
    }
    public void execute(){
        System.out.println("执行ExempleBean");
    }
    public void init(){
        System.out.println("初始化ExempleBean实例");
    }
    public void destroy(){
        System.out.println("销毁ExempleBean实例");
    }
}
