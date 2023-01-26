package com.example.asistencia.controller

import com.example.asistencia.model.Register
import com.example.asistencia.service.RegisterService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/register")
class RegisterController {
    @Autowired
    lateinit var registerService: RegisterService

    @GetMapping
    fun list():List<Register>{
        return registerService.list()
    }

    @PostMapping
    fun save(@RequestBody @Valid register: Register): ResponseEntity<Register> {
        return ResponseEntity(registerService.save(register), HttpStatus.OK)
    }
    @PutMapping
    fun update(@RequestBody register: Register): ResponseEntity<Register> {
        return ResponseEntity(registerService.update(register), HttpStatus.OK)
    }
    @PatchMapping
    fun updateName(@RequestBody register: Register): ResponseEntity<Register> {
        return ResponseEntity(registerService.updateName(register), HttpStatus.OK)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return registerService.delete(id)
    }
}