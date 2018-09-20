package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	@RequestMapping("/viral")
	public String index() {
		return "viral";
	}
	
	@RequestMapping("/challenge")
	public String challenge (@RequestParam(value = "name") String name, Model model) {
		model.addAttribute("name", name);
		return "challenge";
	}
	
	@RequestMapping(value = {"/challenge","/challenge/{name}"})
	public String challengePath(@PathVariable Optional<String> name, Model model) {
		if(name.isPresent()) {
			model.addAttribute("name",name.get());
		}
		else {
			model.addAttribute("name", "KB");
		}
		return "challenge";
	}
	
	@RequestMapping("/generator")
	public String generator (@RequestParam(value = "a", required = false, defaultValue="0") String aValue,@RequestParam(value = "b", required = false, defaultValue = "0") String bValue, String kalimat, Model model) {
		model.addAttribute("a", aValue);
		model.addAttribute("b", bValue);
		int temp1 = Integer.parseInt(aValue);
		int temp2 = Integer.parseInt(bValue);
		kalimat = "";
		if(temp1>=0&&temp1<2) {
			if(temp2>=0&&temp2<2) {
				kalimat = "hm";
			}
			else {
				String Hem = "hm";
				for (int i=0;i<temp2;i++) {
					kalimat += Hem;
					kalimat +=" ";
				}
			}
		}
		else {
			String CustomWord = "h";
			for (int i=0; i<temp1;i++) {
				 CustomWord+= "m";
			}
			for (int j=0;j<temp2;j++) {
				CustomWord+= " ";
				kalimat+= CustomWord;
			}
		}
		model.addAttribute("kalimat", kalimat);
		return "viralgenerator";
	}
}
