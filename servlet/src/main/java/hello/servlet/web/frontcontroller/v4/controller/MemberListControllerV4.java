package hello.servlet.web.frontcontroller.v4.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontcontroller.v4.ControllerV4;
import org.springframework.ui.Model;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class MemberListControllerV4 implements ControllerV4 {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public String process(HashMap<String, String> paramMap, HashMap<String, Object> model) {
        List<Member> members = memberRepository.findAll();


        model.put("members", members);
        return "members";
    }
}
