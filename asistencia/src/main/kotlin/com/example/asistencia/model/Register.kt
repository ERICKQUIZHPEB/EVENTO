package com.example.asistencia.model

import java.sql.Time
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Entity
@Table(name="register")
class Register {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    @NotNull(message="Este campo no debe ser nulo")
    var code: String? = null
    @Column(name="registered_at")
    var registeredAt: String? = null
    @NotBlank(message="Obligatorio")
    var assisted: Long? = null
    @Column(name="conference_id")
    var conferenceId: Long?= null
    @Column(name="member_id")
    var memberId: Long?= null
}