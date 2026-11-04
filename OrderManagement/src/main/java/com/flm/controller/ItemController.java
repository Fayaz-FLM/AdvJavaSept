package com.flm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flm.dto.ItemRequestDTO;
import com.flm.dto.ItemResponseDTO;
import com.flm.dto.UpdateItemRequestDTO;
import com.flm.service.ItemService;

@RestController
@RequestMapping("/items")
public class ItemController {
	
	@Autowired
	ItemService itemService;
	
	@PostMapping("/add")
	public ItemResponseDTO addItem(@RequestBody ItemRequestDTO item) {
		return itemService.saveItem(item);
	}
	
	@GetMapping("/{id}")
	public ItemResponseDTO getItemById(@PathVariable long id) {
		return itemService.getItemById(id);
	}
	
	@GetMapping
	public List<ItemResponseDTO> getAllItems(){
		return itemService.getAllItems();
	}
	
	@PutMapping("/update/{id}")
	public ItemResponseDTO updateItem(@PathVariable long id, @RequestBody UpdateItemRequestDTO itemRequestDTO) {
		return itemService.updateItem(id, itemRequestDTO);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteItemById(@PathVariable long id) {
		itemService.deleteItemById(id);
	}

}
