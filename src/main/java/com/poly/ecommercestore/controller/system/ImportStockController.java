package com.poly.ecommercestore.controller.system;

import com.poly.ecommercestore.DTO.system.ImportStockDTO;
import com.poly.ecommercestore.service.importstock.ImportStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/import")
public class ImportStockController {

    @Autowired
    private ImportStockService importStockService;

    @GetMapping("/")
    public ResponseEntity<?> getAllImport(){
        return ResponseEntity.ok(importStockService.getAllImportStock());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addImport(@RequestBody ImportStockDTO importStock){
        if(importStock.getImportStockName() == null){
            return ResponseEntity.badRequest().body("Import not name");
        }
        if(importStock.getEmployer() == null){
            return ResponseEntity.badRequest().body("Import not employer");
        }
        if(importStock.getSupplier() == null){
            return ResponseEntity.badRequest().body("Import not supplier");
        }
        if(importStock.getDetailImportStocks() == null){
            return ResponseEntity.badRequest().body("Import not detail import");
        }

        if(importStockService.addImportStock(importStock) == null){
            return ResponseEntity.badRequest().body("import created fail");
        }

        return ResponseEntity.ok("import created");
    }
}
