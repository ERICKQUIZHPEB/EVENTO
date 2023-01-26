package com.example.asistencia.controller

import com.example.asistencia.model.Event
import com.example.asistencia.service.EventService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/event")
class EventController {
    @Autowired
    lateinit var eventService: EventService

    @GetMapping
    fun list():List<Event>{
        return eventService.list()
    }

    @PostMapping
    fun save(@RequestBody @Valid event: Event): ResponseEntity<Event> {
        return ResponseEntity(eventService.save(event), HttpStatus.OK)
    }
    @PutMapping
    fun update(@RequestBody event: Event): ResponseEntity<Event> {
        return ResponseEntity(eventService.update(event), HttpStatus.OK)
    }
    @PatchMapping
    fun updateName(@RequestBody event: Event): ResponseEntity<Event> {
        return ResponseEntity(eventService.updateName(event), HttpStatus.OK)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return eventService.delete(id)
    }

}