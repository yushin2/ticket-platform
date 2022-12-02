package com.system.Flatform.API;

import com.system.Flatform.category.dto.CategorySaveDTO;
import com.system.Flatform.category.service.CategoryService;
import com.system.Flatform.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.system.Flatform.utils.Constants.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryAPI {

    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity saveCategory(@RequestBody CategorySaveDTO categorySaveDTO) {
        categoryService.saveCategory(categorySaveDTO);
        return ResponseEntity.ok().body(CREATE_SUCCESS);
    }
}
