package com.kiaev.client.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * [메인 및 공통 페이지 컨트롤러]
 * 메인화면, 상담신청, 게시판 등 주요 메뉴의 단순 화면 이동 처리
 */
@Controller
public class MainController {

    // 1. 메인 페이지
    @GetMapping("/main")
    public String mainPage() { 
        return "client/main/main"; 
    }

    // 2. 상담 신청 페이지
    @GetMapping("/consult/form")
    public String consultForm() { 
        return "client/consult/consultForm"; 
    }

    // 3. 문의 게시판 목록
    @GetMapping("/board/list")
    public String boardList() { 
        return "client/board/boardList"; 
    }
    
    // 4. 프로모션 목록
    @GetMapping("/promotion/list")
    public String promotionList() { 
        return "client/promotion/promotionList"; 
    }

    // 5. 충전소 확인 및 추천 메인
    @GetMapping("/recommend/main")
    public String recommendMain() { 
        return "client/recommend/recommendMain"; 
    }
    
    // 6. 메인 팝업창
    @GetMapping("/popup")
    public String showPopup() {
        return "client/main/popup";
    }
    
    // 7. 로그인 페이지
    @GetMapping("/login")
    public String loginForm() {
        return "client/member/loginForm";
    }
}