package com.Extension.web.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Extension.web.Entity.Custom;
import com.Extension.web.Entity.CustomRepository;
import com.Extension.web.Entity.Extension;
import com.Extension.web.Entity.ExtensionRepository;

@Service
public class ExtensionService {

	@Autowired
	ExtensionRepository exRepo;

	@Autowired
	CustomRepository cuRepo;

	public void add(String value) { // 고정 확장자 추가
		if (exRepo.findByExtension(value) == null) { //고정 확장자 존재여부 확인 후 없으면 저장
			Extension ex = new Extension(value);
			exRepo.save(ex);
		}
	}

	public void delete(String value) { //고정 확장자 삭제 
		exRepo.deleteByExtension(value);
	}

	public Map<String, Object> load() {  //기존 저장 값들 불러오기 
		Map<String, Object> map = new HashMap<>();
		map.put("values", exRepo.findValues());
		return map;
	}

	public Map<String, Object> addCustom(String value) {
		if (cuRepo.countCustom() <= 200) {  //커스텀 확장자의 갯수가 200이 넘지 않으면 저장 
			Map<String, Object> map = new HashMap<>();
			Custom custom = new Custom(value);
			try {
				cuRepo.save(custom);		//버튼을 여러번 눌러 duplicate error 대비 
				cuRepo.load(value);
				map.put("load", cuRepo.load(value));
				map.put("count", cuRepo.countCustom());
			} catch (Exception e) {
				return null;			//에러 발생시 null 반환 -> 값이 이미 들어있음 
			}
			return map;   //오류가 없을 경우 map 반환 
		} else
			return null;  //커스텀 확장자 갯수가 200이 넘으면 null반환
	}

	public Map<String, Object> DeleteCustom(int id) {
		Map<String, Object> map = new HashMap<>();
		cuRepo.delete(id); 	//값을 삭제 후 
		map.put("count", cuRepo.countCustom()); //갯수를 카운트 해서 리턴 -> 몇개 남았는지 알기 위함
		return map;
	}

	public Map<String, Object> onload() { //페이지 요청 시, DB 조회
		Map<String, Object> map = new HashMap<>();
		List<Custom> list = cuRepo.findCustom();
		int count = cuRepo.countCustom();
		map.put("value", list);
		map.put("Count", count);
		return map;
	}
}
