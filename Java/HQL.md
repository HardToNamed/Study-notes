http://www.cnblogs.com/zilong882008/archive/2011/11/03/2234859.html
HQL语句是面向对象的查询语言,返回的是匹配的单个或多个对象, 对大小写敏感
使用方式
session = HibernateUtil.getSession();
Query q = session.createQuery(hql);  //查询
emplist = q.list();  //将查询结果转为list

参数绑定机制， 顺序占位符?
hql="from Employee emp where  emp.flag=?"
Query q = session.createQuery(hql);  //预编译
q.setParameter(0, "man") //执行查询
emplist = q.list();  //将查询结果转为list

引用占位符:parameter
hql="from Employee emp where  emp.flag=:flag"
Query q = session.createQuery(hql);  //预编译
q.setParameter("flag", "man") //执行查询
emplist = q.list();  //将查询结果转为list


语法：
select "对象.属性名" from "对象" where "过滤条件" group by "对象.属性名" having "分组条件" order by "对象.属性名"

select * from Employee emp where emp.flag="1" 
等价于 from Employee emp where  emp.flag="1" //即不用前面的select

获取指定字段
select new person(id, name) from person per //通过new关键词对实体对象动态实例化



