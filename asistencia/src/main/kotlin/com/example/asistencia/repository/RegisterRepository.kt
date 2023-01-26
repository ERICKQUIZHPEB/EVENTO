package com.example.asistencia.repository

import com.example.asistencia.model.Register
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RegisterRepository:JpaRepository<Register,Long> {
    fun findById(id:Long?):Register
}