package com.kiaev.client.car.controller;

import com.kiaev.client.car.service.CarService;
import com.kiaev.domain.car.entity.Car;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/car")
@RequiredArgsConstructor
public class CarController {
    
    private final CarService carService;

    /**
     * 차량 목록 페이지 조회
     * @param keyword  : 검색창에 입력한 모델명 키워드
     * @param carType  : 선택한 차량 유형 필터 (SUV, 세단 등)
     * @param sort     : 정렬 기준 (최신순, 가격순, 주행거리순)
     * @param model    : 뷰(Thymeleaf)로 데이터를 전달하기 위한 객체
     */
    
    @GetMapping("/list")
    public String carList(
        @RequestParam(value = "keyword", required = false) String keyword,
        @RequestParam(value = "carType", required = false) String carType,
        @RequestParam(value = "sort", required = false) String sort,
        Model model) {

        List<Car> cars = carService.searchCars(keyword, carType, sort);

        model.addAttribute("cars", cars);
        model.addAttribute("keyword", keyword);
        model.addAttribute("carType", carType);
        model.addAttribute("sort", sort);
        
        return "client/car/carList";
    }

    /**
     * 차량 상세 정보 페이지 조회
     * @param carNo : URL 경로에서 받아온 차량 고유 번호(PK)
     */
    @GetMapping("/detail/{carNo}")
    public String carDetail(@PathVariable("carNo") Long carNo, Model model) {
        
        // 서비스에서 ID로 차량 1건의 상세 정보를 조회
        Car car = carService.findCarById(carNo);
        
        // 조회된 차량 데이터를 모델에 담아 상세 페이지로 전달
        model.addAttribute("car", car);
        
        return "client/car/carDetail";
    }
}