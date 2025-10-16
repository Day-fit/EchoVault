package pl.dayfit.echovaultclient.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.util.UUID

@Entity
data class Password(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    var id: UUID,
    var domain: String,
    var password: String,
    var userId: UUID
)