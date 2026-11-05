package com.flm.service;

import java.util.List;

import com.flm.dto.ItemRequestDTO;
import com.flm.dto.ItemResponseDTO;
import com.flm.dto.UpdateItemRequestDTO;

public interface ItemService {
	
	public ItemResponseDTO saveItem(ItemRequestDTO item);

	public ItemResponseDTO getItemById(long id);

	public List<ItemResponseDTO> getAllItems();

	public ItemResponseDTO updateItem(long id, UpdateItemRequestDTO itemRequestDTO);

	public void deleteItemById(long id);
	
	public List<ItemResponseDTO> getAllItemsStartingWithName(String itemName);
	
	public List<ItemResponseDTO> getAllItemsContainingName(String itemName);
	
	
	public List<ItemResponseDTO> getAllItemsByRatingGreaterThan(double rating);
	
	public List<ItemResponseDTO> getAllItemsByPriceInBetween(double minPrice,double maxPrice);
	
	
}
