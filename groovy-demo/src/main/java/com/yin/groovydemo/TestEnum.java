package com.yin.groovydemo;

/**
 * 类的描述
 *
 * @author yinguilong
 * @Time 2019/4/24 18:02
 **/
public enum TestEnum {
    /**
     *    是
     *
     *
     *
     */
    YES(1,"是"),

    /**
     *    否
     *
     *
     *
     */
    NO(0,"否"),

    /**
     *    可选
     *
     *
     *
     */
    OPTIONAL(2,"可选");

    private  Integer value;

    private  String name;

    private TestEnum(Integer value, String name) {
        this.value=value;
        this.name=name;
    }

    public Integer getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public static TestEnum getOptionByCode(int energyTypeCode) {
        for (TestEnum item : values()) {
            if (item.getValue()==energyTypeCode) {
                return item;
            }
        }
        return null;
    }
}
