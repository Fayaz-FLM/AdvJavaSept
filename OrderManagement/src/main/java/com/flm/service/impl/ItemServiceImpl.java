package com.flm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flm.dao.ItemRepository;
import com.flm.dto.ItemRequestDTO;
import com.flm.dto.ItemResponseDTO;
import com.flm.dto.UpdateItemRequestDTO;
import com.flm.model.Item;
import com.flm.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	ItemRepository itemRepository;

	@Override
	public ItemResponseDTO saveItem(ItemRequestDTO itemRequestDTO) {
		
		Item item = new Item();
		item.setItemName(itemRequestDTO.getItemName());
		item.setCategory(itemRequestDTO.getCategory());
		item.setBrand(itemRequestDTO.getBrand());
		item.setPrice(itemRequestDTO.getPrice());
		item.setQuantity(itemRequestDTO.getQuantity());
		item.setDiscount(itemRequestDTO.getDiscount());
		item.setRating(0);
		
		Item savedItem = itemRepository.save(item);
		
		ItemResponseDTO itemResponseDTO = new ItemResponseDTO();
		itemResponseDTO.setItemId(savedItem.getItemId());
		itemResponseDTO.setItemName(savedItem.getItemName());
		itemResponseDTO.setBrand(savedItem.getBrand());
		itemResponseDTO.setCategory(savedItem.getCategory());
		itemResponseDTO.setDiscount(savedItem.getDiscount());
		itemResponseDTO.setQuantity(savedItem.getQuantity());
		itemResponseDTO.setPrice(savedItem.getPrice());
		itemResponseDTO.setRating(savedItem.getRating());
		
		return itemResponseDTO;
	}

	@Override
	public ItemResponseDTO getItemById(long id) {
		
		Item item = itemRepository.findById(id).get();
		
		ItemResponseDTO itemResponseDTO = new ItemResponseDTO();
		
		BeanUtils.copyProperties(item, itemResponseDTO);
		
		return itemResponseDTO;
	}

	@Override
	public List<ItemResponseDTO> getAllItems() {
		
		List<Item> list = itemRepository.findAll();
		
		List<ItemResponseDTO> items = new ArrayList<ItemResponseDTO>();
		
		for(Item item : list) {
			
			ItemResponseDTO itemResponseDTO = new ItemResponseDTO();
			
			BeanUtils.copyProperties(item, itemResponseDTO);
			
			items.add(itemResponseDTO);
		}
		return items;
	}

	@Override
	public ItemResponseDTO updateItem(long id, UpdateItemRequestDTO itemRequestDTO) {
		
		Item item = itemRepository.findById(id).get();
		
		BeanUtils.copyProperties(itemRequestDTO, item);
		
		Item savedItem = itemRepository.save(item);
		
		ItemResponseDTO itemResponseDTO = new ItemResponseDTO();
		
		BeanUtils.copyProperties(savedItem, itemResponseDTO);
		
		return itemResponseDTO;
	}

	@Override
	public void deleteItemById(long id) {
		itemRepository.deleteById(id);
	}

}
