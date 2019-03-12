package com.requirement;

import java.util.List;

import com.pojo.Product;

public interface ProductInterface {
	public boolean addProduct(Product product);
	public boolean updateProductQuantityById(int id, int newQuantity);
	public boolean deleteProductById(int id);
	public Product getProductById(int id);
	public List<Product> getProductsByName(String productName);
	public List<Product> getProductsByQuantity(int quantity);
	public List<Product> getAllProducts();
}
