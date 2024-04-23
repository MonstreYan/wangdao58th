Mybatis里面的动态代理
Mapper接口
public interfacce SalaryMapper{

    Salary selectOne(Integer id);

    List<Salary> selectAll();

    Integer insertOne(String name);
}
Mapper.xml映射文件
<select id="selectOne" parameterType="java.lang.Integer" resultType="com.cskaoyan.th58.bean.Salary">
    select * from salary where id = #{id}
</select>

<select id="selectAll" resultType="com.cskaoyan.th58.bean.Salary">
    select * from salary
</select>
<insert id="insertOne" parameterType="java.lang.String">
    insert into salary set name = #{name}
</insert>
程序运行期间，动态地产生一个代理类对象
public class $Proxy0 implments SalaryMapper{

    Salary selectOne(Integer id){
        Connection conn =  dataSource.getConnection();
        prepareStatement psmt = conn.prepareStatement("select * from salary where id = ?");
        psmt.setInteger(1, id);
        ResultSet rs = psmt.executeQuery();
        MetaData metaData = rs.getMetaData();
        while(rs.next()){
            ///里面的代码逻辑和昨天写的基本是一模一样的
        }
    }

    List<Salary> selectAll(){

    }

    Integer insertOne(String name){
        Connection conn =  dataSource.getConnection();
        prepareStatement psmt = conn.prepareStatement("insert into salary set name = ?");
        psmt.setString(1, name);
        psmt.executeUpdate();
        
    }

}