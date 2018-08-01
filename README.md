wms-demo# 基于springboot的服务后台的体系结构

> 从结构上, 我们需要这几样东西:

> 1. 基于gradle的spring-boot工程

> 2. 支持web (spring-mvc+tomcat的套餐)

> 3. 支持mybatis

> 4. 支持mysql

> 5. 支持pagehelpler分页

> 这样一个支持增删盖茶,并且暴露rest接口的web框架就弄好了.

> 以前搭这么个框架可能还需要1天,现在1个小时不到就能凑齐.



检查一下build.gradle,看看是不是这个样子的

```



buildscript {

 repositories {

      mavenCentral()

    }

    dependencies {

        classpath("org.springframework.boot:spring-boot-gradle-plugin:2.0.0.RELEASE")

    }

}

apply plugin: 'io.spring.dependency-management'

apply plugin: 'org.springframework.boot'

apply plugin: 'java'



repositories {

    mavenCentral()

}



dependencies {

  compile('org.springframework.boot:spring-boot-starter-web:2.0.0.RELEASE')

  compile('org.mybatis.spring.boot:mybatis-spring-boot-starter:1.3.2')

  compile('com.github.pagehelper:pagehelper-spring-boot-starter:1.2.5')

  runtime('mysql:mysql-connector-java')

  testCompile('org.springframework.boot:spring-boot-starter-test:2.0.0.RELEASE')

}



```



# 准备工作

> 1. 先把java sublime gradle gitclient 安装好, 当然有idea更好(eclipse就算了).

> 1. https://start.spring.io, 用它的高级功能,把我们需要的东西选择齐全.

>>  gradle java 8 spring-boot 2.0.3  

> 1. 用浏览器把生成的代码框架下载下来.

> 1. 解压之后放好备用.



# 准备工作-第二步 补充配置,让代码能运行.

> 还是先整理思路:

> 1. 这套代码依赖mysql却没有Datasouce, 启动环境就会抛错, 无法build.

> 2. 我们需要准备一个mysql并配置Datasouce才能继续进展.

> 3. 我们还需要定好一个端口,让

> 在resources下创建application.yml,把mybatis需要的数据源配置进去.[多数据源时看这里](https://blog.csdn.net/neosmith/article/details/61202084)

```

server: 

  port: 9090

spring: 

  datasource: 

    driver-class-name: com.mysql.jdbc.Driver

    url: jdbc:mysql://127.0.0.1:3306/test?characterEncoding=UTF-8

    username: root

    password: 1

# yml的格式要求,每个:后面必须加一个空格或者tab.

```

# 第四步, 准备一个数据库, 用户名和密码跟你的配置文件匹配好

```

CREATE TABLE `City` (

  `id` int(11) NOT NULL,

  `name` varchar(250) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,

  `state` varchar(250) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,

  `country` varchar(250) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,

  PRIMARY KEY (`id`) USING BTREE

) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

```



# 第五步,调试下除了分页以外的代码

写一个City的Mapper(相当于dao)

```

package hello;

// 为了mybatis导入的类。

import org.apache.ibatis.annotations.Mapper;

import org.apache.ibatis.annotations.Select;

import org.apache.ibatis.annotations.Insert;



@Mapper

public interface CityMapper {

    @Select("SELECT id, name, state, country FROM city WHERE state = #{state}")

    City findByState(String state);

}

```

写一个对应的PO

```

package hello;

import java.io.Serializable;



public class City implements Serializable {



    private static final long serialVersionUID = 1L;



    private Long id;

    private String name;

    private String state;

    private String country;

    // 此处省略set和get方法

}

```

在在src/test/java/hello 包下创建一个test类,测试一下

```

package hello;



import org.junit.Test;

import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;



import hello.CityMapper;



@RunWith(SpringRunner.class)

@SpringBootTest

public class ApplicationTests {





    @Autowired

    private CityMapper cityMapper;



    @Test

    public void contextLoads() {

        System.out.println(cityMapper.findByState("Tianjin"));

    }

}



```



# 添加分页工具.

呃,其实不需要搞什么,只要给数据库加一点记录, 然后补充一个 PageHelper.startPage就行了,它能在下一次执行select方法时拦截请求,注入分页代码.

```



    @Test

    public void contextLoads() {



        PageHelper.startPage(1, 2);



        System.out.println(cityMapper.findByState("Tianjin"));



        PageHelper.startPage(2, 2);



        System.out.println(cityMapper.findByState("Tianjin"));



    }



```

嗯,springboot让这款插件的集成变得非常简单.

但本身它支持非常复杂的插件配置, 需要看看https://github.com/pagehelper/Mybatis-PageHelper/blob/master/wikis/en/HowToUse.md