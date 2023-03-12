# Codify-hackathon
### Всем хаю-хай , Мы команда  "Young Generation"



## Проект под названием "Edu Search" -  платформа для абитуриентов которая поможет им с поиском хорошего универа 🎓
### Веб-сайт представляет собой платформу для поиска школ и вузов по всей стране. В целом, данный сайт представляет собой полезный инструмент для тех, кто ищет подходящую школу или вуз для своего обучения. Он облегчает процесс выбора и помогает найти наиболее подходящее учебное заведение в кратчайшие сроки.

- 🌍 Средний возораст нашей команды - 15 лет
- 💻 Проект написан на языках Java & JavaScript
- 👯 На сайте можно найти полезную информацию про подачу в университеты
- 

[Canva 🏔](https://www.canva.com/design/DAFc8yI2Q9U/EtTroeCMh2ZPEVytsscyJQ/edit?utm_content=DAFc8yI2Q9U&utm_campaign=designshare&utm_medium=link2&utm_source=sharebutton)



</br>


  <details>
  <summary>:zap: Процесс запуска Front-End</summary>
  
 
<!--START_SECTION:activity-->
1. 🚀 Скачать файл VegetableFront
2. 🚀 Октрыть папку page
3. 🚀 И Запустить файл index.html
<!--END_SECTION:activity-->

</details>

---


<details>
  <summary>:zap: Процесс запуска Back-End</summary>
  
 
<!--START_SECTION:activity-->
1. 🚀 Скачиваем папку "secure"
2. 🚀 Настроим application properties (data source)
3. 🚀 Заходим в папку "secure"
4. 🚀 И с терминала запускаем команду mvn spring-boot:run
5. 🚀 Вуаля ваш сервер запустился на порте 8080 (admin пароль: user@gmail.com логин: user)
<!--END_SECTION:activity-->

</details>


Часть кода:

``` java 

package com.abdiev.secure.configuration;


import com.abdiev.secure.filter.UsernameAuthenticationFilter;
import com.abdiev.secure.service.UserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity()
@Configuration

public class WebSecurityConfiguration {
    private final UsernameAuthenticationFilter filter;
    private final UserDetailsService userDetailsService;

    public WebSecurityConfiguration(@Lazy UsernameAuthenticationFilter filter,@Lazy UserDetailsService userDetailsService) {
        this.filter = filter;
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf().disable()
                .authorizeHttpRequests(request -> {
                request.requestMatchers("/auth/**","/error","/favicon.ico","/").permitAll();
                request.anyRequest().authenticated();
                })
                .addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }
}

```
