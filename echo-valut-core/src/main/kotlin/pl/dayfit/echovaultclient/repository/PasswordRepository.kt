package pl.dayfit.echovaultclient.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import pl.dayfit.echovaultclient.model.Password

import java.util.UUID

@Repository
interface PasswordRepository : JpaRepository<Password, UUID> {
    fun getPasswordByDomainAndUserId(domain: String, userId: UUID): Password
}
