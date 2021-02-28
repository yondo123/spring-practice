## spring-practice

:leaves: Spring FrameWork 예제 코드 테스트 및 학습 내용 정리

## 개발 환경
| 구분             | 버전   |
| ---------------- | ------ |
| Java             | 1.8    |
| Spring Framework | 4.3.25, 5.2.9 |
| DBMS			   | Oracle 11g |
| Apache/Tomcat    | 9.0	|
| Servlet 	       | 4.0 	|

## 참고 자료
| 구분 | 자료 명 |
| --- | --- |
| 도서 | 스프링 퀵 스타트, 채규태 |
| 강의 | SoftCampus 스프링 입문 강의, 윤재성 | 

## :open_file_folder: Directory Wiki
1. [IoC 컨테이너](#ioc)
2. [Bean 객체](#beantest)
3. [Bean 생명주기](#beanlifecycle)
4. [Bean Processor](#beanprocessor)
5. [DI(의존성 주입) - Setter](#setterinjection)
6. [DI(의존성 주입) - 생성자 방식](#constructor-di)
7. [컬렉션 주입](#collectioninjection)
8. [자동 주입](#autowiretest)
9. [Annotation](#javabeanconfing)
10. [Annotation 의존성 주입](#annotationdi)
11. [Annotation 다양한 속성](#annotationproperties)
12. [AOP](#aop)
13. [XML 방식 AOP 실습](#aop_xml)
14. [Annotation 방식 AOP 실습](#aop_annotation)
15. [JDBC 연동](#jdbctest)
16. [MyBatis 연동](#mybatis-test)
17. [Spring MVC](#spring-mvc)
18. [Request Mapping](#)
---
### IoC
IOC 컨테이너 개념 학습, Bean 객체 개념, `xml` 설정 파일 생성  
**IOC**  
관리할 클래스들이 등록된 `xml`파일을 로드하여 구동하는 개념.  
클라이언트의 요청이 들어온 순간 `xml`파일을 참조하여 객체 생성, 객체의 생명주기 관리.

---
### BeanTest

Bean 속성 학습

**Bean**
- class : 객체를 생성하기 위해 사용할 클래스
- id : 객체를 가져오기 위해 사용하는 이름 지정 `(유일성)`
- lazy-init : `xml파일을 로딩`할 때 객체 생성 여부 설정
- scope : 객체의 범위 설정
  - singleton : 객체를 하나만 생성 (싱글톤)
  - prototype : 객체를 가져올 때 마다 객체 생성

---

### BeanLifeCycle

빈 생명주기 학습  
**init-method**  
생성자 호출 후 자동으로 호출  
**destory-method**  
객체가 소멸될 때 자동으로 호출  
**default-init-method**  
`init-method`를 설정하지 않았을 때 자동으로 호출  
**default-destroy-method**  
`destroy-method`를 설정하지 않았을 때 자동으로 호출

---

### BeanProcessor

BeanFactory 전/후처리기 생성 학습   
**PostProcessBeforeInitialization**  
`init-method`에 지정된 메소드가 호출되기 전에 호출  
**postProcessAfterInitialization**  
`init-method`에 지정된 메소드가 호출된 이후에 호출

**beanPostProcessor 생성**

```java
public class TestBeanPostProcessor implements BeanPostProcessor{

	// init-method 호출 전
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("bean processor>> before"); //해당 bean의 객체주소 값
		System.out.println("before bean>>"+bean+"\n"+"beabName >>"+beanName); //해당 bean의 id 값
		return bean;
	}

	// init-method 호출 후
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("bean processor>> after");
		System.out.println("after bean>>"+bean+"\n"+"beabName >>"+beanName);
		return bean;
	}
}
```

**xml 등록**

```xml
<beans xmlns="http://www.springframework.org/schema/beans"
	<!-- beanProcess 설정, class만 명시 -->
	<bean class="com.springtest.processor.TestBeanPostProcessor"/>
</beans>
```

---

### SetterInjection

의존성 주입(DI)의 개념 확인 및 setter 방식의 의존성 주입 학습  
**Dependency Injection(DI)**  
의존성 주입, 객체 사이의 의존 관계를 스프링 설정 파일 `xml`에 등록된 정보를 바탕으로 컨테이너가 자동으로 처리해준다.

**setter 방식 DI**  
`setter`메소드를 이용해 의존성 주입 처리

```java
public class TestBean {
	private int data1;

	public int getData1() {
		return data1;
	}

	public void setData1(int data1) {
		this.data1 = data1;
	}
}
```

```xml
<bean id="t1" class="com.springtest.beans.TestBean">
		<!-- name : 메소드 명, value : 주입 값(문자열-실수-정수 우선순위) -->
		<property name="data1" value="100"></property>
</bean>
```

**ref (클래스 객체 주입)**  
이미 정의된 bean 객체를 주입

```java
public class TestBean {
	private DataBean dataBean;

	public DataBean getDataBean() {
		return dataBean;
	}

	public void setDataBean(DataBean dataBean) {
		this.dataBean = dataBean;
	}

}
```

```xml
<bean id="t1" class="com.springtest.beans.TestBean">
		<property name="data5" ref="data_bean"></property>
	</bean>
<bean id="data_bean" class="com.springtest.beans.DataBean"></bean>
```

---

### Constructor DI

---

### CollectionInjection

자바에서 지원하는 Collection API를 주입시키는 방법.

- list

  ```xml
  <property name="listExam">
  	<list>
  		<value>문자열</value>
  		<value>문자열2</value>
  		<value>문자열3</value>
  	</list>
  </property>

  <property name="listRef">
  	<list>
  		<value type="int">100</value>
  		<value type="int">200</value>
  		<value type="int">300</value>
  	</list>
  </property>
  ```

- Map
  ```xml
  		<!-- map -->
      	<property name="mapUserInfo">
      		<map>
      			<entry key="userId" value="sjchoi"></entry>
      			<entry key="userPw" value="abcd123"></entry>
      			<entry key="authCode" value="1" value-type="int"></entry>
      			<!-- Map 내부 list 삽입 -->
      			<entry key="accessMenu">
      				<list>
      					<value>MAIN</value>
      					<value>OPTN</value>
      					<value>ADMN</value>
      				</list>
      			</entry>
      		</map>
      	</property>
  ```
- Set (중복된 데이터 삽입되지 않는다.)
  ```xml
  <property name="setAddr">
  		<set>
  			<value>value I</value>
  			<value>value II</value>
  			<value>value III</value>
				<value>value I</value>
  		</set>
  	</property>
  ```

---

### AutowireTest

자동주입 학습, 객체를 명시(주입)하지 않아도 컨테이너가 알아서 자동으로 필요한 객체에 주입해준다.

- byName
  - 프로퍼티의 이름과 같은 이름을 갖는 빈 객체를 설정
- byType
  - 빈 객체의 프로퍼티 타입과 정의된 빈의 타입이 일치할 경우 주입, 동일한 타입의 빈 객체가 둘 이상 정의되어 있으면 오류가 발생

---

### JavaBeanConfing

Annotation 방식의 bean 객체 생성 테스트.  
**@Configuration**  
현재 자바 파일이 `bean 등록을 위한 자바파일`임을 명시 (xml 설정파일 역할)  
**@Bean**  
bean 객체를 정의할 때 사용, 메소드의 이름이 bean의 이름이 된다.  
**@Bean(name)**  
반환하는 bean 객체의 Id가 메소드의 이름이 아닌 name 값으로 반환  
**@Lazy**  
`lazy-init`속성을 정의 (true로 설정시 getBean 메소드 호출 시 객체 생성)  
**@Scope**  
getBean() 메소드 호출 때마다 새로운 객체 생성
**init, destory 메소드 설정**

```java
@Bean(initMethod="init", destroyMethod="destroy")
@Lazy
public SecondTestBean secondBean(){
	SecondTestBean stb = new SecondTestBean();
	return stb;
}
```

---

### AnnotationDI

Annotation 방식을 활용한 의존성주입(DI) 테스트.  
**생성자 방식**  
`@Bean`객체 정의 시 반환 값에 직접 초기화

```java
@Configuration
public class BeanConfig {
	@Bean
	@Lazy
	public TestBean beanJava(){
		return new TestBean(10, "hello", new DataBean()); //객체 생성
	}
}
```

**setter 방식**  
객체 생성 후 `set`메소드를 통해 값 주입

```java
@Bean
	public TestBean beanJavaSetter(){
		TestBean tb = new TestBean(); //객체 생성
		tb.setNumber(200);
		tb.setString("setter type");
		tb.setBean(new DataBean);
		return tb;
	}
```

**Autowrie**  
Spring 4 버전까지 사용하는 방식

- Name

  ```java
  @Configuration
  public class BeanConfig {
  	//name 타입을 기준으로 자동주입 : 메소드의 이름과 맞춰준다.
  	@Bean
  	public DataBean data1(){
  		return new DataBean();
  	}

  	@Bean
  	public DataBean data2(){
  		return new DataBean();
  	}

  	//name 기준의 자동 주입 설정
  	@Bean(autowire = Autowire.BY_NAME)
  	public AutowireBean auto(){
  		return new AutowireBean();
  	}
  }
  ```

- Type

  ```java
  @Configuration
  public class BeanConfig {
  	@Bean
  	public SecondDataBean data() {
  		return new SecondDataBean();
  	}

  	@Bean(autowire = Autowire.BY_TYPE)
  	public AutowireTypeBean autoType() {
  		return new AutowireTypeBean();
  	}
  }
  ```

---

### AnnotationProperties

```

```
---
### AOP
AOP 개념 학습

**AOP 개념**
비즈니스 로직에서 실제 수행되는 로직을 `핵심 관심(Core Contents)`, 공통으로 비즈니스 로직 수행시 중복적으로 수행되는 로직을 `횡단 관심(Crosscutting Contents)`라고 하면 이 둘 관심을 분리하는 것.

**AOP 용어**
+ **Joint Point**
  + 모듈이 삽입되어 동작하게 되는 특정 위치(메소드 호출 등)
+ **Point Cut**
  + 다양한 Joint Point 중에서 어떤 것을 사용할지에 대한 설정
+ **Advice**
  + 횡단 관심에 해당하는 공통기능의 코드 (독립된 클래스의 메소드로 작성)
    + **before**
      + 메소드 호출 전 
    + **after-running**
      + 예외 없이 호출된 메소드의 동작이 완료
    + **after-throwing**
      + 호출된 메소드 동작 중 `예외가 발생`하였을 때
    + **after**
      + 예외 관계없이 메소드의 동작이 완료되었을 때
    + **around**
      + 메소드 호출 전-후에 동작
      + 메소드 호출 자체를 가로채 비즈니스 메소드 실행 전후에 처리할 로직 수행
      + 클라이언트가 호출한 비즈니스 메소드를 호출하기 위해서 `proceedingJoinPoint`객체를 매개변수로 받는다.
		```java
		public Object aroundMethod(ProceedingJoinPoint joinpoint) throws Throwable {
			// 비즈니스 메소드 호출
			Object resultObj = joinpoint.proceed();
			return resultObj;
		}
		```
+ **Weabing**
  + `Advice`를 핵심 로직 코드(핵심 관심)에 적용하는 것 
  + 비즈니스 메소드를 수정하지 않고도 횡단 관심에 해당하는 기능을 추가/수정 가능
  + 스프링에서는 런타임 위빙만 지원
+ **Advisor(Aspect)**
  + Point Cut + Advice (어떤 포인트 컷 메소드에 대해서 어떤 어드바이스 메소드를 실행할지 결정)
---
### AOP_XML
XML 기반의 AOP 어드바이저 생성 연습

**<aop:config> 엘리먼트 생성**  
```xml
	<!-- Advisor 클래스 등록 -->
	<bean id="advisor" class="com.springtest.advisor.AdvisorClass"></bean>
	<!-- Aop 설정 -->
	<aop:config>
		<!--ref 속성에 등록한 Advisor 빈 객체의 id를 삽입-->
		<aop:aspect ref="advisor">
			<!--Elements-->
		</aop:aspect>
	</aop:config>
```

**Aspect 엘리먼트 생성**  
어드바이스의 동작 시점에 호출 할 클래스들을 정의한다.  
```java
public class AdvisorClass {
	//before
	public void advBefore() {
		System.out.println("Advisor:: Before Method");
	}
	
	//after
	public void advAfter() {
		System.out.println("Advisor:: After Method");
	}

	//around
	public Object aroundMethod(ProceedingJoinPoint joinpoint) throws Throwable {
		Object text = joinpoint.proceed();
		System.out.println("around Method!");
		// 원래 메소드 호출
		return text;
	}

	//after return
	public void advAfterReturn() {
		System.out.println("Advisor :: After Returning Method");
	}

	//after throwing (error)
	public void throwsMethod() {
		System.out.println("Advisor :: Error!!");
	}
}
```
`aop:asperct`하위 요소로 포인트 컷과 시점을 정의한다.  
포인트 컷은 여러 개 정의할 수 있으며 id를 통해 포인트 컷을 참조한다.  
```xml
	<!-- Aop 설정 -->
	<aop:config>
		<aop:aspect ref="advisor">
			<!-- pointcut 설정 -->
			<aop:pointcut expression="execution(* displayHello())" id="advisorPoint"/>
			<!-- advisorPoint(pointcut-ref 메소드) 호출 전 시행  -->
			<aop:before method="advBefore" pointcut-ref="advisorPoint"/>
			<!-- advisorPoint(pointcut-ref 메소드) 호출 후 시행  -->
			<aop:after method="advAfter" pointcut-ref="advisorPoint"/>
			<!-- aop around 설정 -->
			<aop:around method="aroundMethod" pointcut-ref="advisorPoint"/>
			<!-- afterReturning 메소드,  메소드 정상 호출 후 시행-->
			<aop:after-returning method="advAfterReturn" pointcut-ref="advisorPoint"/>
			<!--예외처리 메소드, 에러 발생시-->
			<aop:after-throwing method="throwsMethod" pointcut-ref="advisorPoint"/>
		</aop:aspect>
	</aop:config>
```

**Point Cut 표현식**
```java
//execution([리턴타입] [패키지 경로].[클래스명].[메소드/매개변수])
execution(* com.springtest.beans.*Bean.displayHello(..));
```
+ **리턴타입**
	| 표현식 | 내용 |
	| ---- | ----|
	| * | 모든 리턴타입 허용 |
	| void | 리턴타입이 void인 메소드 |
	| !void | 리턴타입이 void가 아닌 메소드 |
  
+ **패키지**
  	| 표현식 | 내용 |
	| ---- | ----|
	| com.springtest | 정확한 com/springtest 단일 패키지 선택 |
	| com.springtest.. | com.springtest 패키지로 시작하는 모든 패키지 |
	| com.springtest..biz | com.springtest로 시작하면서 biz로 끝나는 이름을 가진 패키지 |

+ **클래스**
  	| 표현식 | 내용 |
	| ---- | ----|
	| ClassName | ClassName 클래스만 선택 |
	| *Name | 'Name'으로 끝나는 클래스명을 가진 클래스 선택 |
	| Class+ | 클래스로부터 파생된 모든 자식 클래스 or 해당 인터페이스를 구현한 모든 클래스 선택 |

+ **메소드**
  	| 표현식 | 내용 |
	| ---- | ----|
	| *(..) | 기본 설정, 모든 메소드 선택 |
	| display*(..) | 메소드 이름이 'display'으로 시작하는 모든 메소드 |
---

### AOP_Annotation
Annotation 기반의 AOP 설정 학습
**XML 설정 파일에 aspectj-autoproxy 등록**  
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:context="http://www.springframework.org/schema/context"
	xmlns:aop="http://www.springframework.org/schema/aop"
	xsi:schemaLocation="http://www.springframework.org/schema/beans
						http://www.springframework.org/schema/beans/spring-beans.xsd
						http://www.springframework.org/schema/context
						http://www.springframework.org/schema/context/spring-context.xsd
						http://www.springframework.org/schema/aop
						http://www.springframework.org/schema/aop/spring-aop.xsd">
	
	<!-- advisor 클래스에 설정되어 있는 Annotation 셋팅 -->
	<aop:aspectj-autoproxy></aop:aspectj-autoproxy>
</beans>
```

**@EnableAspectAutoProxy**
`BeanConfig`클래스에 해당 속성을 정의한다.
```java
@ComponentScan(basePackages={"com.springtest.beans, com.springtest.advisor"})
@EnableAspectJAutoProxy
public class BeanConfig {
	//code
}
```
**Aspect 설정**
어드바이저 클래스에 `@Aspect` 속성을 정의한다.
```java
@Aspect
@Component
public class AdvisorClass {

}
```

**Aspect 지원 어노테이션**
+ **@Before** : 관심사 동작 이전에 호출
+ **@After** : 관심사 동작 이후에 호출
+ **@Around** : 관심사 동작 이전-이후
+ **@AfterReturning** : 정삭적으로 종료되었을 때 호출
+ **@AfterThrowing** : 예외가 발생하였을 때 호출 
---

### JDBCTest
JDBC 드라이버 연동 학습  
**라이브러리 추가**  
+ spring-jdbc, ojdbc, dbcp 

**JDBC Template**  
`JDBC Template` 클래스를 통해 JDBC 연동

**템플릿 메소드**  
+ update()
  + INSERT, UPDATE, DELETE 구문 
+ queryForObject()
  + SELECT문의 실행결과를 객체 형식으로 받음
+ query()
  + SELECT문의 결과가 목록일 때

**DataSource 설정**  
DB 연결을 위해 DBMS에 관한 정보를 설정  
**XML**
```xml
<!--DataSource 설정-->
<context:property-placeholder location="classpath:config/database.properties" destroy-method="close">
<bean id="source" class="org.apahe.commons.dbcp.BasicDataSource">
	<property name="driverClassName" value="oracle.jdbc.OracleDriver">
	<property name="url" value="jdbc:oracle:thin:@localhost:1521:xe">
	<property name="username" value="spring">
	<property name="password" value="spring">
</bean>
```
**Annotation**
```java
	@Bean
	public BasicDataSource source() {
		BasicDataSource src = new BasicDataSource();
		// DBMS 접속정보 생성
		src.setDriverClassName("oracle.jdbc.OracleDriver");
		src.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		src.setUsername("spring");
		src.setPassword("spring");
		return src;
	}
```

**VO 클래스 작성**  
데이터 전달을 목적으로 사용하는 클래스  
`private`접근 제한자를 이용해 DB에 저장되어 있는 컬럼과 같은 이름의 멤버변수 설정  
```sql
CREATE TABLE user_table
( 
	name varchar2(10) not null,
	sex varchar(2),
	hobby varchar2(10)
);
```

```java
//VOClass.java
@Component //bean 생성을 위한 component
@Scope("prototype") // Query 실행 시 객체 생성
public class JdbcBean {
	//테이블 컬럼 프로퍼티 변수 생성
	private String name;
	private String sex;
	private String hobby;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
}
```
**JdbcTemplate 메소드 연동**  
1. 스프링 설정 파일에 `JdbcTemplate`설정
	```java
	//BeanConfig.java
		@Bean
		public JdbcTemplate db(BasicDataSource source) {
			// 데이터 소스 (접속정보 가지고 있는 객체, DBCP)
			JdbcTemplate db = new JdbcTemplate(source);
			return db;
		}
	```
2. JdbcTemplate 객체에 DataSource의존성 주입
	```java
	//DAOClass.java
	@Component
	public class JdbcDAO {
		// jdbc 관리 객체(JdbcTemplate 주입)
		@Autowired
		private JdbcTemplate db;
		// Mapper클래스 주입
		@Autowired
		private MapperClass mp;

		// INSERT
		public void data_insert(JdbcBean bean) {
			String sql = "insert into USER_TABLE (NAME, SEX, HOBBY) values(?,?,?)";
			// 각각의 insert 값에 binding
			db.update(sql, bean.getName(), bean.getSex(), bean.getHobby());
		}

		// SELECT
		public List<JdbcBean> data_select() {
			String sql = "SELECT NAME, HOBBY, SEX FROM USER_TABLE";
			List<JdbcBean> list = db.query(sql, mp);
			return list;
		}
	}
	```
**Mapper**  
`select`쿼리를 사용할 때 어떤 컬럼의 값을 bean 객체에 주입할 것인지 결정  
1. Mapper 클래스 작성
	```java
	//MapperClass.java
	@Component
	public class MapperClass implements RowMapper<JdbcBean> {
		public JdbcBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			JdbcBean bean = new JdbcBean();
			bean.setName(rs.getString("NAME"));
			bean.setSex(rs.getString("SEX"));
			bean.setHobby(rs.getString("HOBBY"));

			return bean;
		}
	}
	```
2. `Dao`클래스에서 query 메소드에 쿼리문과 mapper 객체를 전달
	```java
	//DAOClass.java
	@Component
	public class JdbcDAO {
		// jdbc 관리 객체(JdbcTemplate 주입)
		@Autowired
		private JdbcTemplate db;
		// Mapper클래스 주입
		@Autowired
		private MapperClass mp;
		// SELECT
		public List<JdbcBean> data_select() {
			String sql = "SELECT NAME, HOBBY, SEX FROM USER_TABLE";
			List<JdbcBean> list = db.query(sql, mp);
			return list;
		}
	}
	```
---
### MyBatis Test
MyBatis 라이브러리 연동 학습  
**라이브러리 추가**  
mybatis, mybatis-spring 라이브러리 두개를 추가
```xml
<dependency>
    <groupId>org.mybatis</groupId>
    <artifactId>mybatis</artifactId>
    <version>3.4.6</version>
</dependency>

<dependency>
    <groupId>org.mybatis</groupId>
    <artifactId>mybatis-spring</artifactId>
    <version>1.3.2</version>
</dependency>
```

**VO 클래스 작성**
```java
@Component
@Scope("prototype") //쿼리실행시 동작하도록 설정
public class UserVO {
	private String name;
	private String sex;
	private String hobby;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

}
```
**Mapper Interface**  
DB연동에 필요한 SQL 명령어들을 작성  
```java
public interface MapperInterface {
	//select
	@Select("SELECT NAME, SEX, HOBBY FROM USER_TABLE")
	List<UserVO> selectData();

	//insert
	@Insert("INSERT INTO USER_TABLE (NAME, SEX, HOBBY) VALUES(#{name}, #{sex}, #{hobby})")
	void insertData(UserVO bean);
}
```

**MyBatis 환경설정(BasicDataSource)**  
DB 커넥션 정보를 담은 dbcp 객체를 `SqlSessionFactory`에 주입하고, 다시 `Mapper`인터페이스에 주입시킨다. 
```java
@Configuration
@ComponentScan(basePackages = "com.springtest.beans")
public class BeanConfig {
	// dbcp datasource
	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource src = new BasicDataSource();
		src.setDriverClassName("oracle.jdbc.OracleDriver");
		src.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		src.setUsername("spring");
		src.setPassword("spring");
		return src;
	}

	// SqlSessionFactory (JDBC 처리 객체)
	// BasicDataSource 주입
	@Bean
	public SqlSessionFactory factory(BasicDataSource src) throws Exception {
		SqlSessionFactoryBean factoryBaan = new SqlSessionFactoryBean();
		factoryBaan.setDataSource(src);
		SqlSessionFactory factory = factoryBaan.getObject();
		return factory;
	}

	// Mapper
	// SqlSessionFactory 주입
	// 다수의 mapper 관리를 위해 bean 호출 시 name으로 호출
	@Bean
	public MapperFactoryBean<MapperInterface> usertbl_mapper(SqlSessionFactory factory) throws Exception {
		MapperFactoryBean<MapperInterface> factoryBean = new MapperFactoryBean<MapperInterface>(MapperInterface.class);
		factoryBean.setSqlSessionFactory(factory);
		return factoryBean;
	}
}
```
### Spring MVC
Spring MVC 패턴 개념 학습
**개념**
`Model-View-Controller` 세 개의 계층(Layer)으로 이루어져 있는 구조  
사용자 인터페이스와 애플리케이션 로직 분리하는데 사용하는 패턴  

+ Model  
애플리케이션의 비즈니스 계층 정의

+ Controller  
애플리케이션의 흐름 관리 `(Model과 View 계층 연결)`

+ View  
애플리케이션 presentation 계층 정의 (사용자에게 보여지는 부분)

**Spring MVC 구조**
+ Dispatcher Servlet  
클라이언트 요청을 분석하여 어느 컨트롤러와 매칭시킬지 결정하는 서블릿 클래스

+ WebApplicationContext  
개발영역, `viewResolver`에게 전달하고 해당 리졸버가 클라이언트에게 전달  
---

### Request Mapping
**@RequestMapping**
클라이언트로부터 요청이 왔을 때, 처리 메소드를 매핑해주겠다는 의미  
+ value : 요청주소 `(실제 물리적인 주소가 아닌 가상의 주소)`
+ method : 요청 타입 (POST, GET..) 
```java
@Controller
public class MainController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String IndexController() {
		return "index";
	}
}
```
**하위 경로 설정**  
특정 URL에 하위 경로가 여러개로 나누어 진다면 매핑 컨트롤러 내부에 중첩해서 사용이 가능하다. 예를들어 /board/sports, /board/game.. 등 상위 path가 동일하다면 일일이 분리 할 필요가 없다.
```java
@Controller
@RequestMapping("/board")
public class MainController {
	@RequestMapping(value = "/sports", method = RequestMethod.GET)
	public String sports() {
		return "board/sports";
	}

	@RequestMapping(value = "/study", method = RequestMethod.GET)
	public String study() {
		return "board/study";
	}
```

**Request 어노테이션**
RequestMapping 대신 요청별로 메소드를 지정할 수 있다. (요청 메소드 별 처리 로직이 다를 때 사용한다.)  
`value` 속성을 생략할 수 있다.
```java
@Controller
public class MainController {
	@ResponseBody
	@GetMapping("/getString") //value="/getString"
	public String testData() {
		return "return Data";
	}

	@ResponseBody
	@PostMapping("/postString") //value="/getString"
	public String testData() {
		return "return Data";
	}
}
```

**Request 동시 설정**  
요청 방식에 따라 처리방법이 동일 할 경우, 동시에 메서드를 설정할 수 있다.
```java
@Controller
public class MainController {
	@RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.POST})
	public String IndexController() {
		return "index";
	}
}
```