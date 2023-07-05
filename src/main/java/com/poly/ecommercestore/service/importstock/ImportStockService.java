package com.poly.ecommercestore.service.importstock;

import com.poly.ecommercestore.entity.*;
import com.poly.ecommercestore.entity.embeddable.DetailImportStockId;
import com.poly.ecommercestore.repository.*;
import com.poly.ecommercestore.request.system.DetailImportRequest;
import com.poly.ecommercestore.request.system.ImportStockRequest;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ImportStockService implements IImportStockService{

    @Autowired
    private ImportStockRepository importStockRepository;

    @Autowired
    private DetailImportStockRepository detailImportStockRepository;

    @Autowired
    private EmployerRepository employerRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ImportStocks addImportStock(ImportStockRequest importStock) {

        System.out.println(importStock);
        if(importStock.getDetailImportStocks() == null)
            return null;

        Employers employer = employerRepository.getEmployersById(importStock.getEmployer());
        if(employer == null)
            return null;

        Suppliers supplier = supplierRepository.getReferenceById(importStock.getSupplier());
        if(supplier == null)
            return null;

        ImportStocks newImportStock = new ImportStocks();
        newImportStock.setEmployer(employer);
        newImportStock.setSupplier(supplier);
        newImportStock.setImportStockName(importStock.getImportStockName());
        newImportStock.setContents(importStock.getContents());
        newImportStock.setDateAdded(new Date());

        newImportStock = importStockRepository.save(newImportStock);

        List<DetailImportStocks> newDetailImportStocks = new ArrayList<>();
        for (DetailImportRequest detailImport : importStock.getDetailImportStocks()){

            Products product = productRepository.getReferenceById(detailImport.getProduct());

            if(product == null)
                return null;

            DetailImportStockId detailImportStockId = new DetailImportStockId(newImportStock.getIDImportStock(), product.getIDProduct());

            DetailImportStocks detailImportStockTemp = new DetailImportStocks(detailImportStockId, detailImport.getQuantity(), detailImport.getPrice(), newImportStock, product);
            newDetailImportStocks.add(detailImportStockTemp);

            product.setQuantity(product.getQuantity() + detailImport.getQuantity());
            productRepository.save(product);
        }

        detailImportStockRepository.saveAll(newDetailImportStocks);

        return newImportStock;
    }

    @Override
    public List<ImportStocks> getAllImportStock() {
        return importStockRepository.findAll();
    }

    @Override
    public ImportStocks updateImportStock(ImportStockRequest importStock) {
        return null;
    }

    @Override
    public ImportStocks getOneImportStock(int iDImportStock) {
        return importStockRepository.getReferenceById(iDImportStock);
    }
}
