# Sistema de Administración de Citas para Veterinaria (Java Web MVC)

Sistema web desarrollado en **Java Web (JEE)** bajo el patrón **MVC**, que permite a una veterinaria administrar de forma segura: **dueños, mascotas, veterinarios, agenda de citas e historial clínico** generado a partir de las consultas realizadas.

---

##  Organización del proyecto
**Veterinaria local** que actualmente administra citas y expedientes de mascotas de forma manual, lo que puede causar:
- Dificultad para organizar agenda
- Pérdida de historial clínico
- Duplicidad o errores en registros

Este sistema busca mitigar esa necesidad mediante una aplicación accesible y centralizada.

---

## Objetivo principal
Digitalizar el proceso de reservación y seguimiento de citas veterinarias, permitiendo:
- Agendar consultas
- Visualizar agenda por fecha o veterinario
- Registrar atención realizada
- Consultar historial clínico por mascota
- Controlar acceso mediante login para administrador

---

## Funcionalidades
| Módulo | Descripción |
|---|---|
| Login Admin | Acceso seguro al sistema mediante credenciales |
| Dueños | Registrar, editar y listar dueños |
| Mascotas | Registrar, actualizar y consultar mascotas por dueño |
| Veterinarios | Alta y listado de médicos veterinarios |
| Agenda de Citas | Crear, actualizar, cancelar y visualizar citas con filtros |
| Historial de Citas | Consultar registros médicos generados cuando una cita fue realizada |

---

## Reglas del sistema
- Solo se genera **historial clínico** cuando una cita es marcada como: **REALIZADA**
- No se permite crear citas si no existen:
  - Dueños registrados
  - Mascotas asociadas a un dueño
  - Veterinarios dados de alta
---

## Tecnologías utilizadas
- Java JEE (Servlets + JSP)
- MySQL (Base de datos relacional)
- Arquitectura MVC
- HttpSession (Control de sesiones)
- POO (Programación Orientada a Objetos)
- Planeación: Trello
