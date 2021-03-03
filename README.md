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
17. [Properties](#properties)
18. [유효성 검사](#validatetest)
19. [Spring MVC](#spring-mvc)
20. [Request Mapping](#springrequest)
21. [파라미터 주입](#parameter)
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
---
### Properties    
Properties 파일 사용 테스트
**Properties**  
주로 절대 변하지 않는 값(상수)들을 관리할 때 사용하는 파일이다.

**파일 생성하기**  
`root\WEB-INF`디렉토리 내에 자율적으로 파일을 생성한다. (확장자는 .properties)  
※한글 입력 시 유니코드로 변환되어 작성되므로, Eclipse 같은 경우, 별도의 플러그인 설치가 필요하다.
```text
database.dbms = oracle 11g
database.username = oracle
```
**@PropertySource**  
@PropertySource 어노테이션을 통해 사용 할 프로퍼티 파일을 불러올 수 있다.
```java
//ControllerClass
@Controller
@PropertySource("/WEB-INF/properties/constant.properties")
public class PropController {
	@GetMapping("/properties")
	public String properties() {
		return "prop";
	}
}
```
**@Value**
해당 프로퍼티에서 정의한 값을 가져오기 위한 어노테이션.  
주입받을 변수에 `@Value(${key})` 형태로 선언해 사용한다.
```java
@PropertySource("/WEB-INF/properties/constant.properties")
public class PropController {

	@Value("${database.dbms}")
	private String db_service;

	@Value("${database.username}")
	private String db_username;

	@GetMapping("/properties")
	public String properties() {
		System.out.println(db_service + ", " + db_username);
		return "prop";
	}
}
```
---
### ValidateTest
브라우저 측 (JavaScript)에서 데이터 유효성 검사를 하는 것이 아닌, 서버 측에서 검사 (SpringFramework)  
프론트에서는 단순히 사용자에게 적절한 요구 값을 알려주는 것이지 보안 측면에서 기대할 수 없다.
`JSR`규격의 유효성 검사 라이브러리를 사용할 수 있다.  
**원리**  
Bean에 데이터가 입력될 때 유효성 검사 규칙을 어노테이션으로 지정하고 해당 조건에 따라 오류 정보 제공  

**라이브러리 추가**  
`hibernate`라는 유효성 검사 클래스 라이브러리를 사용
```xml
<!--pom.xml-->
<!-- JavaX Validation -->
<dependency>
	<groupId>javax.validation</groupId>
	<artifactId>validation-api</artifactId>
	<version>2.0.1.Final</version>
</dependency>

<!-- hibernate validator -->
<dependency>
	<groupId>org.hibernate.validator</groupId>
	<artifactId>hibernate-validator</artifactId>
	<version>6.1.6.Final</version>
</dependency>
```
**Bean에 어노테이션 설정**  
유혀성 검사를 위한 어노테이션은 해당 `Bean`객체에 정의해야한다.
```java
//VO (DataBean)
public class DataBean {
	@Length(max = 10, min = 5) // 최소 5글자 ~ 최대 10글자 이내
	private String userId;
	@NotBlank // 빈 값 허용하지 않음
	@Length(max = 20, min = 5) // 최소 5글자 ~ 최대 10글자 이내
	private String userPw;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
}
```
규칙에 따른 어노테이션을 선언하였으면 주입 받는 Bean 객체에 `@Valid`를 설정하여 유효성 검사를 시행할 수 있다.  
```java
//Controller
@Controller
public class LoginController {
	@PostMapping("result")
	//해당 Bean 객체에 @Valid를 설정해주고, BindingResult 객체를 주입받아야 한다.
	public String login(@Valid DataBean dataBean, BindingResult res) {
		System.out.println("userId : " + dataBean.getUserId());
		System.out.println("userPW : " + dataBean.getUserPw());
		System.out.println("Validation Result : " + res);
		return "registry";
	}
}
```
**출력값**  
Veiw 페이지에서 사용자가 입력 값을 제대로 주었다면, res값에 `org.springframework.validation.BeanPropertyBindingResult: 0 errors` 라고 출력 될 것이다.  
만약 임의로 해당 범위 값 이상으로 제출하였다면 오류에 대한 정보를 담는다. (그렇다고 실제 서비스에서 오류를 발생시키지 않는다, 직접 컨트롤하여야 한다.)
```text
Validation Result : org.springframework.validation.BeanPropertyBindingResult: 2 errors
Field error in object 'dataBean' on field 'userPw': rejected value [afdqsdasfqEfqcwqadsvcxzsadbsfd]; codes [Length.dataBean.userPw,Length.userPw,Length.java.lang.String,Length]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [dataBean.userPw,userPw]; arguments []; default message [userPw],20,5]; default message [길이가 5에서 20 사이여야 합니다]
Field error in object 'dataBean' on field 'userId': rejected value [yondo123123231213123123]; codes [Length.dataBean.userId,Length.userId,Length.java.lang.String,Length]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [dataBean.userId,userId]; arguments []; default message [userId],10,5]; default message [길이가 5에서 10 사이여야 합니다]
```
**메소드**  
유혀성 검사에서 위반한 부분을 출력하거나 분기처리를 통해 접근을 제한시킨다.
```java
@Controller
public class LoginController {
	@PostMapping("result")
	public String login(@Valid DataBean dataBean, BindingResult res) {
		System.out.println("userId : " + dataBean.getUserId());
		System.out.println("userPW : " + dataBean.getUserPw());
		System.out.println("Validation Result : " + res);

		if (res.hasErrors()) {
			for (ObjectError err : res.getAllErrors()) {
				System.out.println("Message : " + err.getDefaultMessage());
				System.out.println("Error Code : " + err.getCode());
				System.out.println("Object Name : " + err.getObjectName());
				System.out.println("--------------------------------------");
			}
			return "index"; //만약 유효성 검사에 위배된 경우, 입력페이지 재요청
		}
		return "registry";
	}
}
```
+ **res.hasError()**
  + 유효성 검사에서 위반 여부를 반환 `bool`
+ **res.getAllErrors()**
  + 위반된 내용들을 반환 `Object`
    + **getDefaultMessage** : deault 오류 내용 반환
    + **getCode** : 오류 코드 반환
    + **getObjectName** : 해당 bean 객체 이름 반환
    + **getCodes** 해당 유효성 검사 정보 (검사타입.객체.데이터)를 배열 형태로 반환 `Array`
  
**에러 메시지 설정**  
기본적으로 출력되는 메시지는 `JSR-303`에서 정의한 메시지이다.  
`properties`설정을 통해 에러 메시지를 커스텀할 수 있다.(일부만 가능)  
1. **Properties 파일 생성**  
   ```text
	#error_message.properties
	Length.dataBean.userId = Input ID min 5 ~ max 10 Length Please.
	NotBlank.dataBean.userPw = Please enter the password you want.
	Length.dataBean.userPw = Input Password min 5 ~ max 10 Length Please.
   ```
2. **스프링 설정 파일에서 메시지 소스 등록**
   ```java
	//properties 파일을 메시지로 등록
	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource res = new ReloadableResourceBundleMessageSource();
		res.setBasename("/WEB-INF/properties/error_message"); //파일 이름까지만 등록
		return res;
	}
   ```
3. **view 영역에서 codes[]메소드 호출**
	`getFieldError`의 codes 메소드를 호출해 설정한 에러메시지를 호출한다.
	```jsp
	<form action="result" method="post">
		<input type="text" name="userId" /><br />
		<spring:hasBindErrors name="dataBean">
			<c:if test="${errors.hasFieldErrors('userId') }">
				<spring:message code="${errors.getFieldError('userId').codes[0] }"></spring:message><br/>
			</c:if>
		</spring:hasBindErrors>
		<input type="password" name="userPw" />
		<spring:hasBindErrors name="dataBean">
			<c:if test="${errors.hasFieldErrors('userPw') }">
				<spring:message code="${errors.getFieldError('userPw').codes[0] }"></spring:message><br/>
			</c:if>
		</spring:hasBindErrors>
		<button type="submit">Submit</button>
	</form>
	```
**JSR 어노테이션**  
JSR-303, 380 어노테이션을 지원한다.  
+ **@AssertTrue/false**
  + true/false 값 확인
+ **@DecimalMax / Min**
  + 해당 value보다 같거나 초과 / 미만인지 검사
  + `inclusive`는 해당 값도 포함인지의 여부
+ **@Null**
  + 값이 들어오면 오류가 발생
+ **@NotNull**
  + 값이 들어오지 않으면 오류 발생
+ **@Digits**
  + 지정된 자릿수의 숫자가 아닐 경우 오류 발생 
  + Integer : 정수 자릿수, fraction : 실수 자릿수
+ **@Size**
  + 지정된 글자수 보다 짧거나 크면 오류가 발생
+ **@Pattern**
  + 지정된 정규식에 위배되면 오류가 발생
  ```java
	@Pattern(regexp = "[a-zA-Z]*") //영문자만 허용
  ```
+ **@NotBlank**
  + (공백 미포함) 문자열 길이가 0이면 오류 발생

---
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

### SpringRequest
요청 관련 어노테이션 학습  
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
### parameter
파라미터 주입 학습
**HttpServletRequest**  
기본적으로 제공하는 http 서블릿 객체를 이용해 파라미터를 받을 수 있다.
```java
@Controller
public class RequestController {

	// GET
	@GetMapping("/test")
	public String test(HttpServletRequest request) {
		// 단일 파라미터
		String data1 = request.getParameter("data1");
		String data2 = request.getParameter("data2");
		System.out.println(data1 + '\n' + data2);
		// 다중 파라미터
		String[] dupData = request.getParameterValues("dupData");
		for (String val : dupData) {
			System.out.println("username : " + val);
		}
		return "result";
	}

	// POST
	@PostMapping("/postResult")
	public String postResult(HttpServletRequest request) {
		String userName = request.getParameter("userName");
		String userId = request.getParameter("userId");
		String[] userHobby = request.getParameterValues("hobby");
		System.out.println("username, userid : " + userName + ", " + userId);
		if (userHobby != null) {
			for (String hobby : userHobby) {
				System.out.println("취미 : " + hobby);
			}
		}
		return "result";
	}
}
```

**WebRequest**  
`HttpServletRequest` 확장 클래스 (사용 메소드는 동일하고, 기능이 추가되었다.)
```java
	//WebRequest GET
	@GetMapping("/webReqTest")
	public String webReqTest(WebRequest request) {
		String data1 = request.getParameter("data1");
		String data2 = request.getParameter("data2");
		System.err.println(data1 + ", " + data2);
		return "result";
	}
```

**@PathVariable**  
URL 경로에 변수를 주입해주는 어노테이션  
URL 구분자 경로에서 값을 처리할 때 주로 사용한다.
+ controller
	```java
		//@pathVariable
		@GetMapping("/board/{subPath}/{detailPath}")
		public String values(@PathVariable String subPath, @PathVariable String detailPath) {

			System.out.println("중분류 :" + subPath);
			System.out.println("소분류 :" + detailPath);
			return "result";
		}
	```
+ view
	```html
	<a href="board/sports/football">FOOTBALL BOARD</a>
	```

**@RequestParam**  
요청한 파라미터를 받는 어노테이션, 받을 프로퍼티 이름과 변수명을 지정해준다.
```java
	GetMapping("/football")
	public String post(@RequestParam String post, @RequestParam String user) {
		System.out.println("post number : " + post);
		System.out.println("post writer : " + user);
		return "result";
	}
```
위와 같이 사용하면, 요청한 파라미터가 없을 경우 오류가 발생하게된다.  
(넘겨질 파라미터를 받ㄷ지 않는 것은 문제가 되지 않지만, 파라미터가 존재하지 않는 경우에 로직을 수행하는 것이 불가능하다.)  
따라서 `default`값을 줄 수 있다.
+ **required** : `false`로 설정된 경우, null 값으로 받을 수 있다.
+ **defaultValue** : 파라미터의 기본 값을 설정할 수 있다.
```java
	GetMapping("/football")
	public String post(@RequestParam String post, @RequestParam String user) {
		System.out.println("post number : " + post);
		System.out.println("post writer : " + user);
		return "result";
	}
```
