package com.hebut.ioc.param.collect;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class MessageBean {
    private String moduleName;
    private int pageSize;
    private String username;
    private String password;
    private List<String> someList;
    private Set<String> someSet;
    private Map<String,Object> someMap;
    private Properties someProps;

    public MessageBean() {
    }

    public MessageBean(String moduleName, int pageSize, String username,
                       String password, List<String> someList, Set<String> someSet,
                       Map<String, Object> someMap, Properties someProps) {
        this.moduleName = moduleName;
        this.pageSize = pageSize;
        this.username = username;
        this.password = password;
        this.someList = someList;
        this.someSet = someSet;
        this.someMap = someMap;
        this.someProps = someProps;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getSomeList() {
        return someList;
    }

    public void setSomeList(List<String> someList) {
        this.someList = someList;
    }

    public Set<String> getSomeSet() {
        return someSet;
    }

    public void setSomeSet(Set<String> someSet) {
        this.someSet = someSet;
    }

    public Map<String, Object> getSomeMap() {
        return someMap;
    }

    public void setSomeMap(Map<String, Object> someMap) {
        this.someMap = someMap;
    }

    public Properties getSomeProps() {
        return someProps;
    }

    public void setSomeProps(Properties someProps) {
        this.someProps = someProps;
    }

    @Override
    public String toString() {
        return "MessageBean [moduleName=" + moduleName + ", pageSize="
                + pageSize + ", username=" + username + ", password="
                + password + ", someList=" + someList + ", someSet=" + someSet
                + ", someMap=" + someMap + ", someProps=" + someProps + "]";
    }
    public void execute(){
        System.out.println("moduleName="+moduleName);
        System.out.println("pageSize="+pageSize);
        System.out.println("username="+username);
        System.out.println("password="+password);

        System.out.println("----List信息------");
        for (String s : someList) {
            System.out.println(s);
        }
        System.out.println("----Set信息------");
        for (String s : someSet) {
            System.out.println(s);
        }
        System.out.println("----Map信息------");
        Set<String> keys = someMap.keySet();
        for (String k : keys) {
            System.out.println(k+"="+someMap.get(k));
        }
        System.out.println("----Properties信息------");
        Set<Object> keySet = someProps.keySet();
        for (Object k : keySet) {
            System.out.println(k+"="+someProps.getProperty(k.toString()));
        }
    }
}
