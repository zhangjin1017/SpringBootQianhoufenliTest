package com.example.service.impl;

import com.example.service.VerifyService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Random;

/**
 * @author 1216916137
 */
@Service
public class VerifyServiceImpl implements VerifyService {
    @Resource
    JavaMailSender sender;
    @Resource
    StringRedisTemplate template;
    @Value("${spring.mail.username}")
    String from;
    @Override
    public void sendVerifyCode(String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("【zhangjin】您的注册验证码");
        Random random = new Random();
        int code =random.nextInt(899999)+100000;
        template.opsForValue().set("VerifyCode:"+email,code+"");
        message.setText("您的注册码为："+code+",三分钟内有效，请及时完成注册！如果不是本人操作，请忽略。");
        message.setTo(email);
        //邮件发送者，这里要与配置文件中的保持一致
        message.setFrom(from);
        //OK，万事俱备只欠发送
        sender.send(message);
    }

    @Override
    public boolean doVerifyCode(String email,String code) {
        String string =template.opsForValue().get("VerifyCode:"+email);
        if (string == null) {
            return false;
        }
        if (!string.equals(code)){
            return false;
        }
        template.delete("VerifyCode:"+email);
        return true;
    }
}
