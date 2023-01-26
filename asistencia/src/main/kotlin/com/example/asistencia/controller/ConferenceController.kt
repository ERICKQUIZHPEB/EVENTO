package com.example.asistencia.controller

import com.example.asistencia.model.Conference
import com.example.asistencia.service.ConferenceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/conference")
class ConferenceController {
    @Autowired
    lateinit var conferenceService: ConferenceService

    @GetMapping
    fun list():List<Conference>{
        return conferenceService.list()
    }

    @PostMapping
    fun save(@RequestBody @Valid conference: Conference): ResponseEntity<Conference> {
        return ResponseEntity(conferenceService.save(conference), HttpStatus.OK)
    }
    @PutMapping
    fun update(@RequestBody conference: Conference): ResponseEntity<Conference> {
        return ResponseEntity(conferenceService.update(conference), HttpStatus.OK)
    }
    @PatchMapping
    fun updateName(@RequestBody conference: Conference): ResponseEntity<Conference> {
        return ResponseEntity(conferenceService.updateName(conference), HttpStatus.OK)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return conferenceService.delete(id)
    }
}