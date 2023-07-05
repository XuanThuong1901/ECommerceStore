package com.poly.ecommercestore.service.importstock;

import com.poly.ecommercestore.entity.ImportStocks;
import com.poly.ecommercestore.request.system.ImportStockRequest;

import java.util.List;

public interface IImportStockService {

    ImportStocks addImportStock(ImportStockRequest importStock);

    List<ImportStocks> getAllImportStock();

    ImportStocks updateImportStock(ImportStockRequest importStock);

    ImportStocks getOneImportStock(int iDImportStock);
}
