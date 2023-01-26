package com.example.asistencia.service
import com.example.asistencia.model.Member
import com.example.asistencia.repository.MemberRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class MemberService {
    @Autowired
    lateinit var memberRepository: MemberRepository

    fun list ():List<Member>{
        return memberRepository.findAll()
    }

    fun save (member: Member):Member{
        return memberRepository.save(member)
    }
    fun update(member: Member):Member{
      try {
          memberRepository.findById(member.id)
              ?: throw Exception("Id Existe")
          return memberRepository.save(member)
      }
      catch(ex: Exception){
          throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
      }
    }

    fun updateName(member: Member):Member{
        try {
            val response = memberRepository.findById(member.id)
                ?: throw Exception("Id Existe")
            response.apply {
                fullname= member.fullname
            }
            return memberRepository.save(member)
        }
        catch(ex: Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun delete (id: Long?):Boolean?{
        memberRepository.findById(id) ?:
        throw  Exception()
        memberRepository.deleteById(id!!)
        return true
    }
}