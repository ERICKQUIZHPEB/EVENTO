package com.example.asistencia.service

import com.example.asistencia.model.Conference
import com.example.asistencia.repository.ConferenceRepository
import com.example.asistencia.repository.EventRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class ConferenceService {
    @Autowired
    lateinit var conferenceRepository: ConferenceRepository
    @Autowired
    lateinit var eventRepository: EventRepository
    fun list ():List<Conference>{
        return conferenceRepository.findAll()
    }

    fun save (conference: Conference): Conference {
      try{
        eventRepository.findById(conference.eventId)
            ?:throw Exception("El id ${conference.eventId} de cliente no existe")
        return conferenceRepository.save(conference)
      }
      catch (ex:Exception) {
          throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
      }
    }

    fun update(conference: Conference): Conference {
        try {
            conferenceRepository.findById(conference.id)
                ?: throw Exception("Id Existe")
            return conferenceRepository.save(conference)
        }
        catch(ex: Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun updateName(conference: Conference): Conference {
        try {
            val response = conferenceRepository.findById(conference.id)
                ?: throw Exception("Id Existe")
            response.apply {
                totalAttendees= conference.totalAttendees
            }
            return conferenceRepository.save(conference)
        }
        catch(ex: Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun delete (id: Long?):Boolean?{
        conferenceRepository.findById(id) ?:
        throw  Exception()
        conferenceRepository.deleteById(id!!)
        return true
    }
}
