2.2 新建一个实体类Event  
package com.historycreator.hibernate;  
  
import java.util.Date;  
  
public class Event {  
    private Long id;  
  
    private String title;  
    private Date date;  
  
    public Event() {}  
  
    public Long getId() {  
        return id;  
    }  
  
    private void setId(Long id) {  
        this.id = id;  
    }  
  
    public Date getDate() {  
        return date;  
    }  
  
    public void setDate(Date date) {  
        this.date = date;  
    }  
  
    public String getTitle() {  
        return title;  
    }  
  
    public void setTitle(String title) {  
        this.title = title;  
    }  
}  
  
2.3 在com.historycreator.hibernate下建立配置文件Event.hbm.xml,内容如下  
<?xml version="1.0" encoding="UTF-8"?>  
<!DOCTYPE hibernate-mapping PUBLIC  
        "-//Hibernate/Hibernate Mapping DTD 3.0//EN"  
        "http://hibernate.sourceforge.net/hibernate-mapping-3.0.dtd">  
  
<hibernate-mapping package="com.historycreator.hibernate">  
  
    <class name="Event" table="EVENTS">  
        <id name="id" column="EVENT_ID">  
            <generator class="native" />  
        </id>  
        <property name="date" type="timestamp" column="EVENT_DATE" />  
        <property name="title" />  
    </class>  
  
</hibernate-mapping>  
  
2.4 在src文件夹,也就是在com同级目录下,建立配置文件hibernate.cfg.xml,内容如下:  
<?xml version="1.0" encoding="UTF-8"?>  
<!DOCTYPE hibernate-configuration PUBLIC  
        "-//Hibernate/Hibernate Configuration DTD 3.0//EN"  
        "http://hibernate.sourceforge.net/hibernate-configuration-3.0.dtd">  
  
<hibernate-configuration>  
  
    <session-factory>  
  
        <!-- Database connection settings -->  
        <property name="connection.driver_class">org.gjt.mm.mysql.Driver</property>  
        <property name="connection.url">jdbc:mysql://localhost/event?useUnicode=true&characterEncoding=gbk</property>  
        <property name="connection.username">root</property>  
        <property name="connection.password">test</property>  
  
        <!-- JDBC connection pool (use the built-in) -->  
        <property name="connection.pool_size">1</property>  
  
        <!-- SQL dialect -->  
        <property name="dialect">org.hibernate.dialect.MySQL5Dialect</property>  
  
        <!-- Enable Hibernate's automatic session context management -->  
        <property name="current_session_context_class">thread</property>  
  
        <!-- Disable the second-level cache  -->  
        <property name="cache.provider_class">org.hibernate.cache.NoCacheProvider</property>  
  
        <!-- Echo all executed SQL to stdout -->  
        <property name="show_sql">true</property>  
  
        <!-- Drop and re-create the database schema on startup -->  
        <property name="hbm2ddl.auto">update</property>  
  
        <mapping resource="com/historycreator/hibernate/Event.hbm.xml"/>  
  
    </session-factory>  
  
</hibernate-configuration>  
  
2.5 建工厂类HibernateUtil  
package com.historycreator.hibernate;  
  
import org.hibernate.SessionFactory;  
import org.hibernate.cfg.Configuration;  
  
public class HibernateUtil {  
  
    private static final SessionFactory sessionFactory = buildSessionFactory();  
  
    private static SessionFactory buildSessionFactory() {  
        try {  
            // Create the SessionFactory from hibernate.cfg.xml  
            return new Configuration().configure().buildSessionFactory();  
        }  
        catch (Throwable ex) {  
            // Make sure you log the exception, as it might be swallowed  
            System.err.println("Initial SessionFactory creation failed." + ex);  
            throw new ExceptionInInitializerError(ex);  
        }  
    }  
  
    public static SessionFactory getSessionFactory() {  
        return sessionFactory;  
    }  
  
}  
  
2.6  建类EventManager  
package com.historycreator.hibernate;  
  
import java.util.Date;  
  
import org.hibernate.classic.Session;  
  
public class EventManager {  
  
    public static void main(String[] args) {  
        EventManager mgr = new EventManager();  
  
            mgr.createAndStoreEvent("My Event", new Date());  
          
            HibernateUtil.getSessionFactory().close();  
    }  
  
    private void createAndStoreEvent(String title, Date theDate) {  
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();  
        session.beginTransaction();  
  
        Event theEvent = new Event();  
        theEvent.setTitle(title);  
        theEvent.setDate(theDate);  
        session.save(theEvent);  
  
        session.getTransaction().commit();         
          
    }  
  
}  
  
运行即可.效果就是往数据库中插入了一条记录. 
