# Contact Manager App

## Descripción

App para contactos 

## Características

- Añadir nuevos contactos con nombre, apellido, número de teléfono y hobby
- Visualizar la lista de contactos guardados
- Navegación entre pantallas utilizando Jetpack Navigation
- Interfaz de usuario moderna y responsive con Jetpack Compose
- Validación de formularios para asegurar que todos los campos estén completos

## Requisitos del sistema

- Android Studio Arctic Fox (2020.3.1) o superior
- Kotlin 1.5.0 o superior
- Gradle 7.0 o superior
- SDK mínimo: API 21 (Android 5.0 Lollipop)
- SDK objetivo: API 33 (Android 13)

## Instalación

1. Clona este repositorio:
   ```
   git clone https://github.com/tu-usuario/contact-manager.git
   ```

2. Abre el proyecto en Android Studio.

3. Sincroniza el proyecto con los archivos Gradle.

4. Ejecuta la aplicación en un emulador o dispositivo físico.

## Estructura del proyecto

- `app/src/main/java/com/yourpackage/name/`
    - `MainActivity.kt`: Punto de entrada de la aplicación
    - `Screen/nav/`
        - `ScreenA.kt`: Pantalla para añadir nuevos contactos
        - `ScreenB.kt`: Pantalla para visualizar la lista de contactos
    - `model/`
        - `Contact.kt`: Clase de datos para representar un contacto

## Uso

1. Al abrir la aplicación, verás la pantalla principal con la lista de contactos (si existen).
2. Para añadir un nuevo contacto, pulsa el botón "Añadir Contacto".
3. Rellena todos los campos del formulario (nombre, apellido, teléfono y hobby).
4. Pulsa "Guardar" para añadir el contacto a la lista.
5. Vuelve a la pantalla principal para ver la lista actualizada de contactos.

## Pruebas

El proyecto incluye pruebas unitarias e instrumentadas para asegurar el correcto funcionamiento de la aplicación. Para ejecutar las pruebas:

- Pruebas unitarias ejecutar: `./gradlew test`
)