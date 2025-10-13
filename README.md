# EchoVault 
**A self-hosted, zero-knowledge password manager built with Java and Spring Boot.**

---

## Overview
EchoVault is a privacy-first password manager designed for **self-hosting** — users deploy it on their own hardware, whether that’s a home server, NAS, or small VPS.  
The system applies **end-to-end encryption (E2EE)** to ensure that all sensitive data remains fully protected and inaccessible to intermediaries.

The application architecture separates encryption and transport logic:  
the **local instance** performs all encryption and key management, while an **external backend** (hosted by EchoVault) securely routes and synchronizes encrypted payloads.

---

## Architecture

**Conceptual Components**
1. **Local Uploader (Self-hosted Instance)**  
   - Runs on a private server or local device.  
   - Performs all encryption and decryption locally.  
   - Manages user keys and encrypted storage.  
   - Communicates securely with the external backend.

2. **External Transport Backend**  
   - Routes encrypted data between self-hosted clients.  
   - Provides metadata validation, synchronization, and storage indexing.  
   - Never has access to plaintext data or encryption keys.  

3. **Storage & Synchronization (in development)**  
   - The final stack for persistent storage and metadata handling is under active development.  

---

## Security Model

| Layer | Mechanism | Responsibility |
|-------|------------|----------------|
| Encryption | End-to-end, client-side | Protects all user data |
| Key Management | Local generation and storage | No keys leave the user’s environment |
| Communication | Encrypted channel with mutual authentication | Protects data in transit |
| Backend Access | Zero-knowledge design | Backend cannot read or modify user data |

**Zero-knowledge principle:**  
EchoVault’s backend operates without any knowledge of user secrets.  
All encryption, decryption, and key handling occur exclusively within the user’s self-hosted environment.

---

## Design Principles
- **Self-hosted first:** complete ownership and independence.  
- **Zero-knowledge:** encryption before transport.  
- **Simplicity:** minimal configuration, small footprint.  
- **Transparency:** auditable and open design.  
- **Extendability:** modular backend and pluggable storage layer (in development).

---

## Current Status
EchoVault is currently **in active development**.  
The backend stack and synchronization protocols are being defined and implemented.  
Future releases will include detailed setup guides and deployment configurations for self-hosted environments.
