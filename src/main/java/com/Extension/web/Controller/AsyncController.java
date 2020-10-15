package com.Extension.web.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Extension.web.Service.ExtensionService;

@RestController
public class AsyncController {

	@Autowired
	ExtensionService service;

	@GetMapping("{value}")  //고정 확장자 저장을 위한 요청 
	public void add(@PathVariable(name = "value") String value) {
		service.add(value);
	}

	@DeleteMapping("{value}") //고정 확장자 제거를 위한 요청
	public void delete(@PathVariable(name = "value") String value) {
		service.delete(value);
	}

	@GetMapping("checkValues")  //체크 된 고정 확장자를 불러오기 위한 요청 
	public Map<String, Object> loadValues() {
		return service.load();
	}

	@PostMapping("{value}")  //커스텀 확장자 추가를 위한 요청
	public Map<String, Object> addCustomExtension(@PathVariable(name = "value") String value) {
		return service.addCustom(value);
	}

	@DeleteMapping("custom/{id}") //커스텀 확장자 삭제를 위한 요청
	public Map<String, Object> deleteCustom(@PathVariable(name = "id") int id) {
		return service.DeleteCustom(id);
	}

}
