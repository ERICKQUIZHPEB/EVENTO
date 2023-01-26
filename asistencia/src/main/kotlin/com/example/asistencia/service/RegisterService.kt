package com.example.asistencia.service

import com.example.asistencia.model.Register
import com.example.asistencia.repository.ConferenceRepository
import com.example.asistencia.repository.MemberRepository
import com.example.asistencia.repository.RegisterRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class RegisterService {
    @Autowired
    lateinit var registerRepository: RegisterRepository
    @Autowired
    lateinit var conferenceRepository: ConferenceRepository
    @Autowired
    lateinit var memberRepository: MemberRepository

    fun list ():List<Register>{
        return registerRepository.findAll()
    }

    fun save (register: Register): Register {
        try{
            conferenceRepository.findById(register.conferenceId)
                ?:throw Exception("El id ${register.conferenceId} de cliente no existe")
            return registerRepository.save(register)
        }
        catch (ex:Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }
    fun update(register: Register): Register {
        try {
            registerRepository.findById(register.id)
                ?: throw Exception("Id Existe")
            return registerRepository.save(register)
        }
        catch(ex: Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun updateName(register: Register): Register {
        try {
            val response = registerRepository.findById(register.id)
                ?: throw Exception("Id Existe")
            response.apply {
                code= register.code
            }
            return registerRepository.save(register)
        }
        catch(ex: Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun delete (id: Long?):Boolean?{
        registerRepository.findById(id)
            ?: throw  Exception()
        registerRepository.deleteById(id!!)
        return true
    }
}