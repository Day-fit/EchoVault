package pl.dayfit.echovaultclient.service

import org.springframework.stereotype.Service
import pl.dayfit.echovaultclient.model.Password
import pl.dayfit.echovaultclient.repository.PasswordRepository
import java.util.UUID

@Service
class PasswordManagerService(val passwordRepository: PasswordRepository) {

    fun getPasswordForDomain(domain: String, uuid: UUID): Password
    {
        return passwordRepository.getPasswordByDomainAndUserId(domain, uuid)
    }
}