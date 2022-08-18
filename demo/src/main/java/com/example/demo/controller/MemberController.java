package com.example.demo.Controller;

 import net.sf.json.JSONObject;

 import javax.validation.Valid;

 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
 import org.springframework.web.bind.annotation.GetMapping;
 import org.springframework.web.bind.annotation.RequestBody;
 import org.springframework.web.bind.annotation.RestController;

 import com.example.demo.Service.MemberService;

 @RestController
 @EnableJpaAuditing
 public class MemberController {
    @Autowired
    MemberService memberService;

    @GetMapping("/member/sendEmailCertification")
    public JSONObject SendEmailCertification(@Valid @RequestBody JSONObject input) {
        try{
        return memberService.SendEmailCertification(input.getString("customer_email"));
        }catch(Exception io){
            return memberService.responseError(io.toString());
        }
    }
 }