package com.example.asistencia.service


import com.example.asistencia.model.Event
import com.example.asistencia.repository.EventRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class EventService  {
    @Autowired
    lateinit var eventRepository:EventRepository

    fun list ():List<Event>{
        return eventRepository.findAll()
    }

    fun save (event: Event): Event {
        try{
            event.description?.takeIf { it.trim().isNotEmpty() }
                    ?:throw Exception("descripcion vacio")
            return eventRepository.save(event)
        }
        catch(ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }
    fun update(event: Event): Event {
        try {
            eventRepository.findById(event.id)
                ?: throw Exception("Id Existe")
            return eventRepository.save(event)
        }
        catch(ex: Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun updateName(event: Event): Event {
        try {
            val response = eventRepository.findById(event.id)
                ?: throw Exception("Id Existe")
            response.apply {
                totalAttendees= event.totalAttendees
            }
            return eventRepository.save(event)
        }
        catch(ex: Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun delete (id: Long?):Boolean?{
        eventRepository.findById(id) ?:
        throw  Exception()
        eventRepository.deleteById(id!!)
        return true
    }

}