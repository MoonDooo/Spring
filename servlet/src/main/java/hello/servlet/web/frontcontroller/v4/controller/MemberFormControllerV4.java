package hello.servlet.web.frontcontroller.v4.controller;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;
import hello.servlet.web.frontcontroller.v4.ControllerV4;

import java.util.HashMap;
import java.util.Map;

public class MemberFormControllerV4 implements ControllerV4 {
    @Override
    public String process(HashMap<String, String> paramMap, HashMap<String, Object> model) {
        return "new-form";
    }
}
