package com.springtest.controller;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.springtest.beans.DataBean;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	@GetMapping("/shop")
	public ResponseEntity<ArrayList<DataBean>> shop() {
		// 데이터 객체 생성
		DataBean regShop1 = new DataBean("마리오 상점", 13, "경기도 안산시", true);
		DataBean regShop2 = new DataBean("피치 카페", 100, "서울", false);

		// 리스트 생성
		ArrayList<DataBean> list = new ArrayList<DataBean>();
		list.add(regShop1);
		list.add(regShop2);

		// 응답 전문 생성
		ResponseEntity<ArrayList<DataBean>> entry = new ResponseEntity<ArrayList<DataBean>>(list, HttpStatus.OK);
		return entry;
	}
}
