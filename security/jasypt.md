## Jasypt란?

> 최소한의 노력으로 프로젝트에 기본 암호화 기능을 추가할 수 있는 Java 라이브러리

⇒ 설정파일의 **프로퍼티**를 암호화하는데 사용

## 사용한 이유

- 자동 배포시 민감한 설정파일을 노출할 수 없기 때문에 적용

### 대칭키 암호

- 해당 암호화 알고리즘은 DES방식 암호화를 이용한다.
- 복호화키와 암호화키가 동일

### jasypt Config 작성

```jsx
@Bean("jasyptStringEncryptor")
    public StringEncryptor stringEncryptor() {
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(System.getProperty("jasypt.encryptor.password"));
        config.setAlgorithm("PBEWithMD5AndDES");
        config.setKeyObtentionIterations("10");
        config.setPoolSize("1");
        config.setProviderName("SunJCE");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setIvGeneratorClassName("org.jasypt.iv.RandomIvGenerator");
        config.setStringOutputType("base64");
        encryptor.setConfig(config);
        return encryptor;
    }
```

- 로컬에서 실행할때는 jasypt의 비밀번호를 Vm option에 추가

![Untitled](https://user-images.githubusercontent.com/62232531/224720258-1094b521-c65a-4e10-b4af-da61b7054227.png)

## 암호화 적용

```jsx
@SpringBootTest
class JasyptConfigTest {

    @Test
    public void jasyt_test() {
        String plainText = "암호화할 테스트";

        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword("비밀번호가 동일해야함!!");
        config.setAlgorithm("PBEWithMD5AndDES");
        config.setKeyObtentionIterations("10");
        config.setPoolSize("1");
        config.setProviderName("SunJCE");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setIvGeneratorClassName("org.jasypt.iv.RandomIvGenerator");
        config.setStringOutputType("base64");
        encryptor.setConfig(config);

        String encryptText = encryptor.encrypt(plainText);
        System.out.println("encryptText = " + encryptText);
        String decryptText = encryptor.decrypt(encryptText);
        Assertions.assertThat(plainText).isEqualTo(decryptText);

    }

}
```

실행결과 **암호문을 복사**해서 ENC( )로 감싸서 application properites에 작성

### application-prod.properties 결과문

```jsx
# MySQL ??
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

  # DB Source URL
spring.datasource.url=ENC(vdvtDZ0LDp7fZylGJm8aLtLbk6qzZcbdjBWXutb75KP8y8p+AkcZMkTTfgf1vZRk/NKNpwEe3JSNPexPnVs86gFFFK/G/RRApcHDjRgfb8Sc8I0J/o29Gj5cOJuMRsCAkpE45/Qp4xc=)

#  #DB Username
spring.datasource.username=ENC(dxSeOokz7mYyX8mnITkrlbMMJimX/5ET)

#
#  #DB P assword
spring.datasource.password=ENC(vq7v9ZRy2H/hrs/T3RycYFBWqNvoui1S)

jasypt.encryptor.bean=jasyptStringEncryptor
```
