package com.eShopping.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eShopping.entity.ProductDetails;
import com.eShopping.repository.ProductRepository;

@Component
public class ProductDAOImpl implements ProductDAO {
	private static final ProductDetails ProductDetails = null;
	@Autowired
	ProductRepository productRepository;

	@Override
	public ProductDetails getProductById(int id) {
		return productRepository.findByProductid(id);
	}

	@Override
	public List<ProductDetails> allProductDetails() {
		return productRepository.findAll();

	}

	@Override
	public ProductDetails insertProductDetails(ProductDetails productDetails) {
		//System.out.println(productRepository.getClass());
		return productRepository.save(productDetails);
	}

	@Override
	public ProductDetails updateProducts(com.eShopping.entity.ProductDetails productDetails) {

		return productRepository.save(productDetails);
	}

	@Override
	public boolean deleteProductById(int id) {
		productRepository.deleteById(id);
com.eShopping.entity.ProductDetails findByProductid = getProductById(id);
		 if (findByProductid!=null) {
			 return false;
		} else {
			return true;
		}
		
		
	}

	@Override
	public List<ProductDetails> filterProducts(String filterby) {
		 return productRepository.readByBrandOrCategoryOrProductname(filterby);
		
	}

}
