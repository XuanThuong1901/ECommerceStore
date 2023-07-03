package com.poly.ecommercestore.service.product;

import com.poly.ecommercestore.entity.*;
import com.poly.ecommercestore.repository.*;
import com.poly.ecommercestore.request.system.ImageProductRequest;
import com.poly.ecommercestore.request.system.ProductRequest;
import com.poly.ecommercestore.request.system.SpecificationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private DetailCategoryRepository detailCategoryRepository;

    @Autowired
    private ImageProductRepository imageProductRepository;

    @Autowired
    private SpecificationRepository specificationRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public Products addProduct(ProductRequest product) {

        DetailCategories detailCateTemp = detailCategoryRepository.getReferenceById(product.getIDDetailCategory());
        if(detailCateTemp == null){
            return null;
        }

        Suppliers supplier = supplierRepository.getReferenceById(product.getIDSupplier());
        if(supplier == null){
            return null;
        }

        Products newProduct = new Products();
        newProduct.setProductName(product.getProductName());
        newProduct.setDetailCategory(detailCateTemp);
        newProduct.setSupplier(supplier);
        newProduct.setQuantity(product.getQuantity());
        newProduct.setPrice(product.getPrice());
        newProduct.setFeature(product.getFeature());
        newProduct.setContents(product.getContents());
        newProduct.setGuarantee(product.getGuarantee());
        newProduct.setExpiry(product.getExpiry());

        List<ImageProducts> imageProducts = new ArrayList<ImageProducts>();
        for (ImageProductRequest imageProduct : product.getImageProduct()){
            ImageProducts imageProductTemp = new ImageProducts(imageProduct.getUrl(), newProduct);
            imageProducts.add(imageProductTemp);
        }
        List<Specifications> specifications = new ArrayList<Specifications>();
        for (SpecificationRequest specification : product.getSpecification()){
            Specifications specificationTemp = new Specifications(specification.getSpecificationName(), specification.getParameter(), newProduct);
            specifications.add(specificationTemp);
        }
        newProduct.setImageProducts(imageProducts);
        newProduct.setSpecifications(specifications);

        imageProductRepository.saveAll(imageProducts);
        specificationRepository.saveAll(specifications);
        productRepository.save(newProduct);

        return newProduct;
    }

    @Override
    public Boolean updateProduct(ProductRequest product, int iDProduct) {
        return null;
    }

    @Override
    public Boolean removeProduct(int iDProduct) {

        Products product = productRepository.getReferenceById(iDProduct);

        if(product == null)
            return false;

        productRepository.delete(product);
        return true;
    }

    @Override
    public Products getProductById(int iDProduct) {
        return productRepository.getReferenceById(iDProduct);
    }

    @Override
    public Page<Products> getProductByPage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return productRepository.getProductsByPage(pageable);
    }

    @Override
    public Page<Products> getProductByDetailCategoryByPage(int iDDetailCategory, int page, int size) {

        Pageable pageable = PageRequest.of(page, size);
        return productRepository.getProductsByDetailCategoryByPage(iDDetailCategory, pageable);
    }
}
