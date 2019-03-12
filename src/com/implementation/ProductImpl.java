package com.implementation;

import java.util.ArrayList;
import java.util.List;

import com.pojo.Product;
import com.requirement.ProductInterface;

public class ProductImpl implements ProductInterface {
	private List<Product> productList = new ArrayList<>();
	private static int count = 0;

	@Override
	public boolean addProduct(Product product) {
			productList.add(count, product);
			count++;
			return true;
	}

	@Override
	public boolean updateProductQuantityById(int id, int newQuantity) {
		for (int i = 0; i < productList.size(); i++) {
			if (productList.get(i).getId() == id) {
				productList.get(i).setQuantity(newQuantity);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean deleteProductById(int id) {
		List<Product> productArrList = new ArrayList<>(productList);
		for (int i = 0; i < productList.size(); i++) {
			if (productList.get(i).getId() == id) {
				productArrList.remove(i);
				count--;
				return true;
			}
		}
		return false;
	}

	@Override
	public Product getProductById(int id) {
		Product product = null;
		for (int i = 0; i < count; i++) {
			if (productList.get(i).getId() == id) {
				product = productList.get(i);
				break;
			}
		}
		return product;
	}

	@Override
	public List<Product> getProductsByName(String productName) {
		List<Product> products = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			if (productList.get(i).getProductName().equals(productName)) {
				products.add(productList.get(i));
			}
		}
		return products;
	}

	@Override
	public List<Product> getProductsByQuantity(int quantity) {
		List<Product> products = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			if (productList.get(i).getQuantity() == quantity) {
				products.add(productList.get(i));
			}
		}
		return products;
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> newProducts = null;
		if (count > 0) {
			newProducts = new ArrayList<>(productList);
		}
		return newProducts;
	}

}
