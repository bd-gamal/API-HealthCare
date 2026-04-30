# 🏥 API HealthCare+ - Gestion du Système de Santé

Une API REST complète et robuste pour la gestion d'un système de santé, permettant de gérer les patients, les médecins, les rendez-vous et les dossiers médicaux.

![Build Status](https://img.shields.io/badge/build-passing-brightgreen)
![Java Version](https://img.shields.io/badge/java-21-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.6-green)
![MySQL](https://img.shields.io/badge/MySQL-8.0+-blue)

---

## 🎯 Présentation

**API HealthCare+** est une solution backend moderne pour gérer l'ensemble des opérations d'un établissement de santé. Construite avec **Spring Boot 4.0.6** et **MySQL 8.0+**, elle offre une API REST conforme aux standards RESTful avec une gestion complète des erreurs globalisées.

**Cas d'usage :**
- ✅ Gestion des patients (enregistrement, mise à jour, consultation)
- ✅ Gestion des médecins et leurs spécialités
- ✅ Planification et suivi des rendez-vous
- ✅ Gestion des dossiers médicaux patients
- ✅ États de rendez-vous (planifié, complété, annulé)

---

## ✨ Fonctionnalités

### Gestion des Patients
- 📝 Créer un nouveau patient
- 📋 Consulter la liste complète des patients
- 🔍 Consulter les détails d'un patient
- ✏️ Mettre à jour les informations d'un patient
- 🗑️ Supprimer un patient

### Gestion des Médecins
- 👨‍⚕️ Créer un médecin
- 📊 Consulter la liste des médecins
- 🔎 Consulter les détails d'un médecin
- 📝 Mettre à jour les informations d'un médecin
- 🗑️ Supprimer un médecin

### Gestion des Rendez-vous
- 📅 Créer un rendez-vous
- 🗓️ Consulter tous les rendez-vous
- 🔍 Filtrer les rendez-vous par patient
- ✅ Marquer un rendez-vous comme complété
- ❌ Annuler un rendez-vous
- 📊 Consulter l'état du rendez-vous (PLANNED, COMPLETED, CANCELED)

### Gestion des Dossiers Médicaux
- 📄 Créer un dossier médical pour un patient
- 👁️ Consulter le dossier médical d'un patient
- 🔄 Mettre à jour les observations médicales
- 🗑️ Supprimer un dossier médical

---

### Couches de l'Application

1. **Couche Contrôleur** → Gestion des requêtes HTTP
2. **Couche Service** → Logique métier et validations
3. **Couche Repository** → Accès aux données
4. **Couche Entity** → Modèles de domaine
5. **Couche DTO** → Transfert de données vers les clients

---

## 🛠️ Technologies

| Technologie | Version | Utilisation |
|-------------|---------|------------|
| **Java** | 21 | Langage de programmation |
| **Spring Boot** | 4.0.6 | Framework backend |
| **Spring Data JPA** | 7.0.7 | ORM et accès aux données |
| **MySQL** | 8.0+ | Base de données relationnelle |
| **Hibernate** | 7.2.12 | ORM |
| **MapStruct** | 1.5.5 | Mapping d'objets |
| **Lombok** | 1.18.30 | Réduction du code boilerplate |
| **Flyway** | - | Migration de schémas de base de données |
| **SpringDoc OpenAPI** | 2.3.0 | Documentation Swagger/OpenAPI |
| **H2** | - | Base de données pour tests |
| **JUnit 5** | - | Framework de test |

---

## 🚀 Installation

### 1. Cloner le projet

```bash
git clone https://github.com/votre-repo/API-HealthCare+.git
cd API-HealthCare+
```

### 2. Créer la base de données MySQL

```sql
CREATE DATABASE healthcare_db;
```

### 3. Compiler le projet

```powershell
mvn clean install
```

### 4. Démarrer l'application

#### Via Maven
```powershell
mvn spring-boot:run
```

L'application est accessible à : **http://localhost:8080**

---

## 🔌 Endpoints API

### 📍 Base URL
```
http://localhost:8080/api
```

### 👥 Patients

| Méthode | Endpoint | Description |
|---------|----------|------------|
| **GET** | `/patient` | Récupérer tous les patients |
| **GET** | `/patient/{id}` | Récupérer un patient par ID |
| **POST** | `/patient` | Créer un nouveau patient |
| **PUT** | `/patient/{id}` | Mettre à jour un patient |
| **DELETE** | `/patient/{id}` | Supprimer un patient |


### 👨‍⚕️ Médecins

| Méthode | Endpoint | Description |
|---------|----------|------------|
| **GET** | `/doctor` | Récupérer tous les médecins |
| **GET** | `/doctor/{id}` | Récupérer un médecin par ID |
| **POST** | `/doctor` | Créer un nouveau médecin |
| **PUT** | `/doctor/{id}` | Mettre à jour un médecin |
| **DELETE** | `/doctor/{id}` | Supprimer un médecin |


### 📅 Rendez-vous

| Méthode | Endpoint | Description |
|---------|----------|------------|
| **GET** | `/appointment` | Récupérer tous les rendez-vous |
| **GET** | `/appointment/patient/{patientId}` | Rendez-vous d'un patient |
| **POST** | `/appointment` | Créer un rendez-vous |
| **PUT** | `/appointment/{id}/status` | Mettre à jour l'état |
| **PATCH** | `/appointment/{id}/cancel` | Annuler un rendez-vous |

### 📄 Dossiers Médicaux

| Méthode | Endpoint | Description |
|---------|----------|------------|
| **GET** | `/medical-file/patient/{patientId}` | Dossier d'un patient |
| **POST** | `/medical-file` | Créer un dossier médical |
| **PUT** | `/medical-file/{id}` | Mettre à jour un dossier |
| **DELETE** | `/medical-file/{id}` | Supprimer un dossier |


## 🧪 Tests

### Exécuter tous les tests

```powershell
mvn test
```

### Tests Unitaires

Les tests utilisent **H2 (base de données en mémoire)** et sont configurés avec `@ActiveProfiles("test")`.

Les tests couvrent :
- ✅ Création de rendez-vous
- ✅ Récupération de rendez-vous
- ✅ Filtrage par patient
- ✅ Mise à jour d'état
- ✅ Annulation de rendez-vous

---

## 🐳 Docker

### Construire l'image Docker

```bash
docker build -t healthcare-api:1.0 .
```

## 📖 Documentation Swagger

Accédez à la documentation interactive Swagger :

### Swagger UI
```
http://localhost:8080/swagger-ui.html
```

### OpenAPI JSON
```
http://localhost:8080/api-docs
```

Vous pouvez tester tous les endpoints directement depuis l'interface Swagger !

---

## 🎉 Merci !

Merci d'avoir utilisé **API HealthCare+** ! N'hésitez pas à nous faire des retours et des suggestions pour améliorer le projet.

