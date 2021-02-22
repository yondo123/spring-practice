## spring-practice

:leaves:  
Spring Frame 워크 예제 코드 테스트 및 학습 내용 정리

## 개발 환경

| 구분             | 버전   |
| ---------------- | ------ |
| Java             | 1.8    |
| Spring Framework | 4.3.25 |

## 디렉토리 위키

### IoC

IOC 컨테이너 개념 학습, Bean 객체 개념, `xml` 설정 파일 생성  
**IOC**  
관리할 클래스들이 등록된 `xml`파일을 로드하여 구동하는 개념.  
클라이언트의 요청이 들어온 순간 `xml`파일을 참조하여 객체 생성, 객체의 생명주기 관리.

---

### BeanTest

Bean 속성 테스트  
**Bean**

- class : 객체를 생성하기 위해 사용할 클래스
- id : 객체를 가져오기 위해 사용하는 이름 지정 `(유일성)`
- lazy-init : `xml파일을 로딩`할 때 객체 생성 여부 설정
- scope : 객체의 범위 설정
  - singleton : 객체를 하나만 생성 (싱글톤)
  - prototype : 객체를 가져올 때 마다 객체 생성

---

### BeanLifeCycle

빈 생명주기 테스트  
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

BeanFactory 전/후처리기 생성 연습
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

의존성 주입(DI)의 개념 확인 및 setter 방식의 의존성 주입 테스트.  
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
  			<value>안산시 상록구</value>
  			<value>안산시 단원구</value>
  			<value>안산시 상록구</value>
  		</set>
  	</property>
  ```

---

### AutowireTest

자동주입 테스트, 객체를 명시(주입)하지 않아도 컨테이너가 알아서 자동으로 필요한 객체에 주입해준다.

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
