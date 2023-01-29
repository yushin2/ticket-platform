package com.system.Flatform.API;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
//@RequestMapping("/")
public class UserAPI {

    @GetMapping("/")
    public ResponseEntity test() {
        return ResponseEntity.ok().body("OK!!!!!");
    }
}
