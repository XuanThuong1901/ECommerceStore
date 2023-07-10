package com.poly.ecommercestore.service.product;

import com.poly.ecommercestore.DTO.system.PriceListDTO;
import com.poly.ecommercestore.entity.*;
import com.poly.ecommercestore.repository.*;
import com.poly.ecommercestore.DTO.system.ImageProductDTO;
import com.poly.ecommercestore.DTO.system.ProductDTO;
import com.poly.ecommercestore.DTO.system.SpecificationDTO;
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
    private PriceListService priceListService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ImageProductRepository imageProductRepository;

    @Autowired
    private SpecificationRepository specificationRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public Products addProduct(ProductDTO product, String iDEmployer) {

        Categories category = categoryRepository.getReferenceById(product.getCategory());
        if(category == null){
            return null;
        }

        Suppliers supplier = supplierRepository.getReferenceById(product.getSupplier());
        if(supplier == null){
            return null;
        }

        Products newProduct = new Products();
        newProduct.setProductName(product.getProductName());
        newProduct.setCategory(category);
        newProduct.setSupplier(supplier);
        newProduct.setQuantity(product.getQuantity());
        newProduct.setFeature(product.getFeature());
        newProduct.setContents(product.getContents());
        newProduct.setGuarantee(product.getGuarantee());

        newProduct = productRepository.save(newProduct);

        List<PriceLists> priceLists = new ArrayList<>();
        for (PriceListDTO priceListDTO : product.getPriceListDTOS()){
            PriceLists priceListsTemp = priceListService.addPriceList(priceListDTO, iDEmployer, newProduct.getIDProduct());
            priceLists.add(priceListsTemp);
        }

        List<ImageProducts> imageProducts = new ArrayList<ImageProducts>();
        for (ImageProductDTO imageProduct : product.getImageProduct()){
            ImageProducts imageProductTemp = new ImageProducts(imageProduct.getUrl(), newProduct);
            imageProducts.add(imageProductTemp);
        }
        List<Specifications> specifications = new ArrayList<Specifications>();
        for (SpecificationDTO specification : product.getSpecification()){
            Specifications specificationTemp = new Specifications(specification.getSpecificationName(), specification.getParameter(), newProduct);
            specifications.add(specificationTemp);
        }
        newProduct.setPriceLists(priceLists);
        newProduct.setImageProducts(imageProducts);
        newProduct.setSpecifications(specifications);

        productRepository.save(newProduct);
        imageProductRepository.saveAll(imageProducts);
        specificationRepository.saveAll(specifications);


        return newProduct;
    }

    @Override
    public Boolean updateProduct(ProductDTO product, int iDProduct) {
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
    public Page<Products> getProductByCategoryByPage(int iDCategory, int page, int size) {

        Pageable pageable = PageRequest.of(page, size);
        return productRepository.getProductsByCategoryByPage(iDCategory, pageable);
    }
}
