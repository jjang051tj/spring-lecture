package com.jjang051.member.controller;

import com.jjang051.member.dto.MemberDto;
import com.jjang051.member.dto.ModalDto;
import com.jjang051.member.dto.ToastDto;
import com.jjang051.member.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.Map;

//Bean으로 등록
@RequestMapping("/member")
@Controller
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService; //불변성 유지


    @GetMapping("/signup")
    public String signup(Model model) {
        model.addAttribute("memberDto", new MemberDto());
        return "member/signup";
    }

    @PostMapping("/signup")
    public String signup(@Valid @ModelAttribute MemberDto memberDto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "/member/signup";
        }
        int result = memberService.signup(memberDto);
        System.out.println("result : " + result);
        if(result>0) {
            return "redirect:/index/index";
        }
        log.info("signup result : " + result);
        return "/member/signup";
    }
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("memberDto", new MemberDto());
        return "/member/login";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute MemberDto memberDto,
                        BindingResult bindingResult,
                        HttpSession session,
                        RedirectAttributes redirectAttributes) {
        MemberDto loggedMemberDto =  memberService.login(memberDto);

        if(loggedMemberDto!=null) {
            session.setAttribute("loggedMemberDto", loggedMemberDto);
            ModalDto modalDto = ModalDto.builder()
                                        .isShow(true)
                                        .title("로그인")
                                        .content(loggedMemberDto.getUserName()+"님 로그인되었습니다")
                                        .build();
            ToastDto toastDto = ToastDto.builder()
                    .isShow(true)
                    .title("로그인")
                    .content(loggedMemberDto.getUserName()+"님 로그인되었습니다")
                    .build();

            //redirectAttributes.addFlashAttribute("modalDto", modalDto);
            if(bindingResult.hasErrors()) {
                return "/member/login";
            }
            redirectAttributes.addFlashAttribute("toastDto", toastDto);
            return "redirect:/index/index";
        }


        return "/member/login";

    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("loggedMemberDto");
        session.invalidate();
        return "redirect:/index/index";
    }

    @GetMapping("/id-check")
    @ResponseBody
    public Map<String,Integer> idCheck(@RequestParam String userId) {
        int count = memberService.idCheck(userId);
        Map<String,Integer> map = new HashMap<>();
        map.put("count",count);
        return map;
    }

    //http://localhost/member/jjang051
    @GetMapping("/{userId}")
    public String info(@PathVariable String userId, Model model) {
        MemberDto infoMemberDto = memberService.findById(userId);
        model.addAttribute("infoMember", infoMemberDto);
        return "/member/info";
    }

    @GetMapping("/delete/{userId}")
    public String delete(@PathVariable String userId) {
        return "/member/delete";
    }

    @PostMapping("/delete/{userId}")
    public String delete(@PathVariable String userId,
                         @RequestParam("userPw") String userPw,
                         HttpSession session,
                         @SessionAttribute MemberDto loggedMemberDto,
                         RedirectAttributes redirectAttributes
    ) {
        int result = memberService.deleteMember(userId,userPw);
        if(result>0) {
            ModalDto modalDto = ModalDto.builder()
                    .title("회원탈퇴")
                    .content(loggedMemberDto.getUserName()+"님 삭제되었습니다.")
                    .isShow(true)
                    .build();
            session.invalidate();
            redirectAttributes.addFlashAttribute("modalDto", modalDto);
            return "redirect:/index/index";
        }
        return "/member/delete";
    }

    @DeleteMapping("/delete/{userId}")
    @ResponseBody
    public Map<String,String> deletAjax(@PathVariable String userId,
                         @RequestParam("userPw") String userPw
    ) {
        int result = memberService.deleteMember(userId,userPw);
        Map<String,String> map = new HashMap<>();
        if(result>0) {
            map.put("delete","success");
        }else {
            map.put("delete","fail");
        }
        return map;
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public Map<String,String> deletAjax(@RequestBody MemberDto memberDto) {
        System.out.println("@RequestBody MemberDto memberDto : " + memberDto.toString());
        int result = memberService.deleteMember(memberDto);
        Map<String,String> map = new HashMap<>();
        if(result>0) {
            map.put("delete","success");
        }else {
            map.put("delete","fail");
        }
        return map;
    }


}
