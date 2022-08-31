package com.example.demo.Controller;

import net.sf.json.JSONObject;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Component.GetMemberInfoParam;
import com.example.demo.Service.MemberService;

@RestController
@EnableJpaAuditing
public class MemberController {
    @Autowired
    MemberService memberService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/member/getMemberInfo")
    public JSONObject getMemberInfo(@Valid @RequestBody GetMemberInfoParam input) {
        try{
            return memberService.getMemberInfo(input);
        }catch(Exception io){
            return memberService.responseError(io.toString());
        }
    }
}
