package pl.dayfit.echovaultclient.controller

import org.springframework.http.ResponseEntity
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import pl.dayfit.echovaultclient.dto.PasswordDto
import pl.dayfit.echovaultclient.service.PasswordManagerService
import java.security.Principal
import java.util.UUID

@RestController
class PasswordController (var passwordManagerService: PasswordManagerService) {

    @GetMapping("/get-for-website/{domain}")
    fun getForWebsite(@AuthenticationPrincipal principal: Principal, @PathVariable domain: String): ResponseEntity<PasswordDto>
    {
        val passwordModel = passwordManagerService.getPasswordForDomain(domain, UUID.fromString(principal.name))
        return ResponseEntity
            .ok(
                PasswordDto(passwordModel.domain, passwordModel.password)
            )
    }
}