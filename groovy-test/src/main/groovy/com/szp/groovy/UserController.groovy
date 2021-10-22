package com.szp.groovy

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController {

    @GetMapping("/hi")
    String hi() {
        return "hello groovy11213"
    }
}
