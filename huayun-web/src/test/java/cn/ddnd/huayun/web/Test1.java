package cn.ddnd.huayun.web;

public class Test1<T> {

    public Object get() {
        Object o = this;
        System.out.println();
        return "";
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
