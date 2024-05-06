package com.cskaoyan.th58.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * jdbc代码能不能写出来？？？？？？？？？？？
 * Class.forName(com.mysql.cj.jdbc.Driver);
 * Connection conn = DriverManager.getConnetion(url,username,password);
 * PreparedStatement psmt = conn.preparedSatatement(sql);
 * psmt.setXXXX(index, param);
 * psmt.executeQuery()/executeUpdate();
 * while(rs.next()){
 *     rs.getXXX(columnaName/index);
 * }
 * @Date 2024/5/6 10:39
 * @Version 1.0
 */
public class GenderTypeHandler extends BaseTypeHandler<String> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
        //赋值  增删改的时候调用，比如新增，实体对象里面的gender是字符串；数据库要求是int
        Integer code = getCodeByGender(parameter);
        ps.setInt(i, code);
    }

    private Integer getCodeByGender(String parameter) {
        if("female".equals(parameter)){
            return 0;
        }
        return 1;
    }

    //下面这几个方法是在查询的时候会调用。数据库里面的是int字段，但是需要的实体对象时字符串类型，需要转换，typeHandler做的事情就是这个事情
    @Override
    public String getNullableResult(ResultSet rs, String columnName) throws SQLException {
        int value = rs.getInt(columnName);
        //实体对象里面需要的是字符串，需要转换成字符串
        String genderValue = getGenderByCode(value);
        return genderValue;
    }

    private String getGenderByCode(int value) {
        if(value == 1){
            return "male";
        }
        return "female";
    }

    @Override
    public String getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        int value = rs.getInt(columnIndex);
        return getGenderByCode(value);
    }

    //这个直接忽略即可，我们基本用不到
    @Override
    public String getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        int value = cs.getInt(columnIndex);
        return getGenderByCode(value);
    }
}
