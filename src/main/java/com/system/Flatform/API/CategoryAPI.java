package com.system.Flatform.API;

import com.system.Flatform.category.record.CategorySaveRecord;
import com.system.Flatform.category.record.CategoryUpdateRecord;
import com.system.Flatform.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.system.Flatform.utils.Constants.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryAPI {

    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity saveCategory(@RequestBody CategorySaveRecord categorySaveRecord) {
        categoryService.saveCategory(categorySaveRecord);
        return ResponseEntity.ok().body(CREATE_SUCCESS);
    }

    @PutMapping
    public ResponseEntity updateCategory(@RequestBody CategoryUpdateRecord categoryUpdateRecord) {
        categoryService.updateCategory(categoryUpdateRecord);
        return ResponseEntity.ok().body(UPDATE_SUCCESS);
    }



}
