package hello.login.web;

import hello.login.domain.member.Member;
import hello.login.domain.member.MemberRepository;
import hello.login.web.session.SessionManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {
    private final MemberRepository memberRepository;
    private final SessionManager sessionManager;

    //@GetMapping("/")
    public String home() {
        return "home";
    }

    //@GetMapping("/")
    public String homeLogin(@CookieValue(name = "memberId", required = false) Long memberId,
                            Model model) {
        if (memberId == null) {
            return "home";
        }
        //로그인
        Member loginMember = memberRepository.findById(memberId);
        if (loginMember == null) {
            return "home";
        }

        model.addAttribute("member", loginMember);
        return "loginHome";
    }

    //@GetMapping("/")
    public String homeLoginV2(HttpServletRequest httpServletRequest, Model model) {
        //세션 관리자에 저장된 회원 정보 조회
        Member member = (Member) sessionManager.getSession(httpServletRequest);

        if (member == null) {
            return "home";
        }

        model.addAttribute("member", member);
        return "loginHome";
    }

    @GetMapping("/")
    public String homeLoginV3(HttpServletRequest httpServletRequest, Model model) {
        //세션 관리자에 저장된 회원 정보 조회
        HttpSession httpSession = httpServletRequest.getSession(false);
        if (httpSession == null) {
            return "home";
        }

        Member loginMember = (Member)httpSession.getAttribute(SessionConst.LOGIN_MEMBER);

        if (loginMember == null) {
            return "home";
        }

        //세션 유지되면 로그인 이동
        model.addAttribute("member", loginMember);
        return "loginHome";
    }

    //@GetMapping("/")
    public String homeLoginV3Spring(
            @SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Member member
            , Model model) {

        if (member == null) {
            return "home";
        }

        //세션 유지되면 로그인 이동
        model.addAttribute("member", member);
        return "loginHome";
    }

    //@PostMapping("/logout")
    public String logout(HttpServletResponse response) {
        extracted(response, "memberId");
        return "redirect:/";
    }

    //@PostMapping("/logout")
    public String logoutV2(HttpServletRequest httpServletRequest) {
        sessionManager.expire(httpServletRequest);
        return "redirect:/";
    }

    @PostMapping("/logout")
    public String logoutV3(HttpServletRequest httpServletRequest) {
        HttpSession httpSession = httpServletRequest.getSession(false);
        if (httpSession != null) {
            httpSession.invalidate();
        }
        return "redirect:/";
    }
    private static void extracted(HttpServletResponse response, String cookieName) {
        Cookie cookie = new Cookie(cookieName, null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }
}