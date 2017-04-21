<!-- 定义多对一关联，配置在product里面 -->
<many-to-one  name="factory" class="com.test.factory">
    <column name="factoryid">
</many-to-one>

<!-- 定义一对多关联，配置在factory里面，inverse设置为true表示factory不再是主控方，而是将关联关系的维护交给product类来进行 -->
<set name="products" inverse="true">  
    <key column="factoryid"/>
    <one-to-many class="com.test.products" />
</set>

<!-- 定义一对一主键关联，cascade设置为all表示当公民的对象进行save、update、delete操作时，card对象也同步进行, 取值范围all/none/save-update/delete -->
<one-to-one  name="com.test.IDcard" cascade="all" />


<!-- 定义一对一外键关联 -->
<many-to-one name="idcard" unique="true">   //people表
  <column name="card_id"/>
</many-to-one>

<id name="id" column="id" type="int">   //card表
   <generator class="foreign">
        <param name="property">people</param>
   </generator>
</id>


<!-- 定义多对多关联,使用第三张表tab_mapping映射两个表的外键  -->
<!-- user实体对象的配置 -->
<set name="roles" table="tab_mapping">
    <key column="user_id"> </key>  //user_id为该表主键映射的第三张mapping表的外键
    <many-to-many class="com.test.role" column="role_id" />  //多对多关联的实体对象
</set>

<!-- roles实体对象的配置 -->
<set name="users"  table="tab_mapping">
    <key column="role_id"> </key>  //role_id为该表主键映射的第三张mapping表的外键
    <many-to-many class="com.test.user" column="user_id" />  //多对多关联的实体对象
</set>


<!-- 实体继承关系映射 -->
<!-- 声明一个鉴别器 -->
        <discriminator column="type" type="string"/> //相当于声明增加一个列
         <!-- 映射自有属性 -->
        <property name="name" not-null="true"/>
        <property name="age" type="int"/>
         <property name="sex" type="string"/>
         <!-- 声明子类Student -->
        <subclass name="Student" discriminator-value="学生">  //“学生”是在声明的列中存储的默认信息
            <property name="school"/>
        </subclass>
         <!-- 声明子类Staffer -->
        <subclass name="Staffer" discriminator-value="职员">//“职员”是在声明的列中存储的默认信息
            <property name="company"/>
        </subclass>


<!-- 每个子类映射成一张表 -->
<class name="Person" table="tab_person1">
         <id name="id">
            <generator class="native"/>
        </id>
         <!-- 映射自有属性 -->
        <property name="name" not-null="true"/>
        <property name="age" type="int"/>
         <property name="sex" type="string"/>
         <!-- 映射子类Student -->
        <joined-subclass name="Student" table="tab_student">
            <key column="id"/>
            <property name="school"/>
        </joined-subclass>
        <!-- 映射子类Staffer -->
        <joined-subclass name="Staffer" table="tab_staffer">
            <key column="id" />
            <property name="company"/>
        </joined-subclass>
     </class>


<!-- 每个具体类（非抽象类）映射一张表 -->
<class name="Person" abstract="true">
         <id name="id">
            <!-- 主键生成策略为手动分配 -->
            <generator class="assigned"/>
        </id>
         <!-- 映射自有属性 -->
        <property name="name" not-null="true"/>
        <property name="age" type="int"/>
         <property name="sex" type="string"/>
         <!-- 映射子类Student -->
        <union-subclass name="Student" table="tab_student2">
            <property name="school"/>
        </union-subclass>
        <!-- 映射子类Staffer -->
        <union-subclass name="Staffer" table="tab_staffer2">
            <property name="company"/>
        </union-subclass>
     </class>
