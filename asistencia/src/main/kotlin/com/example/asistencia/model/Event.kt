package com.example.asistencia.model

import java.util.Date
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.NotBlank

@Entity
@Table(name="event")
class Event {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    @NotBlank(message="Obligatorio")
    var description: String? = null
    @Column(name="start_date")
    var startDate: Date? = null
    @Column(name="end_date")
    var endDate: Date? = null
    @Column(name="total_attendees")
    var totalAttendees: Long? = null
    @NotBlank(message="Obligatorio")
    var city: String? = null

}