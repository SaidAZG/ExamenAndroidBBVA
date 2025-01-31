Examen Aplicación BBVA:

Se realizó la aplicación solicitada cumpliendo con las siguientes características:

1. Pantalla Splash
2. Pantalla Login
3. Pantalla Dashboard
4. El proyecto se encuentra en un repositorio público en el perfil del desarrollador.

---

1. Pantalla Splash contiene:
   - Diseño básico introductorio
   - Validación de la variable de sesión
   - Redirección a Login para sesión no iniciada
   - Redirección a Dashboard para sesión iniciada

2. Pantalla Login contiene:
   - EditText email
   - EditText password
   - Button entrar
   - Se envían los datos ingresados a la API
   - Se valida la respuesta de la API
   - Se despliega el texto "No se puede iniciar sesión" si la respuesta no es válida
   - Se guarda la llave de sesión en SharedPreferences
   - Se guardan los datos obtenidos de la API en SharedPreferences para persistencia de datos
   - Se redirige al usuario al Dashboard si la respuesta del API es válida

3. Pantalla Dashboard:
   - TextView name
   - TextView lastName
   - TextView id
   - TextView gender
   - TextView age
   - Button logout
   - El valor de cada campo es obtenido de los datos guardados en el SharedPreferences
   - Se consulta el API para obtener la url de la imagen
   - Se validan las respuestas del API
   - AsynImage con Coil para desplegar la imagen de la url obtenida de la API
   - Al hacer logout se realiza lo siguiente: Se eliminan los datos del usuario almacenados en SharedPreferences, se cambia el estado de la variable de sesión, se redirige al usuario a la pantalla de Login.

---

Se hizo uso de las librerías:
- Hilt
- Dagger
- Jetpack Compose
- Preference Manager
- Retrofit
- Gson
- Coil

---

Se basó la estructura del proyecto en lo establecido por la arquitectura Clean.
Se utilizaron patrones de diseño como MVVM, Singleton, Factory, Dependency Injection
