package com.Extension.web.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.Extension.web.Service.ExtensionService;

@Controller
public class ExtensionController {

	@Autowired
	ExtensionService service;

	@GetMapping("/index")
	public String index(Model model) {
		Map<String, Object> map = service.onload();
		model.addAttribute("value", map.get("value"));
		model.addAttribute("Count", map.get("Count"));
		return "index";
	}

}
