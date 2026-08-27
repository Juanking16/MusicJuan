# 🎵 MusicJuan - Reproductor de Música Completo para Android

## Descripción
MusicJuan es un reproductor de música profesional desarrollado en Java para Android con todas las características necesarias para una experiencia de usuario excepcional.

## Características ✨

### Reproducción de Música
- ✅ Reproducir archivos de música locales
- ✅ Pausa, play, siguiente y anterior
- ✅ Barra de progreso interactiva
- ✅ Control de volumen
- ✅ Visualización de duración actual y total

### Gestión de Canciones
- ✅ Lista de canciones en RecyclerView
- ✅ Búsqueda de canciones por título, artista o álbum
- ✅ Información detallada: título, artista, álbum
- ✅ Carátula de álbum

### Playlists
- ✅ Crear playlists personalizadas
- ✅ Agregar/eliminar canciones de playlists
- ✅ Guardar playlists en base de datos

### Experiencia de Usuario
- ✅ Tema oscuro/claro automático
- ✅ Interfaz intuitiva y moderna
- ✅ Servicio de fondo para reproducción continua
- ✅ Notificaciones de reproducción

## Tecnologías Utilizadas 🛠️

- **Lenguaje**: Java
- **API mínima**: Android 7.0 (API 24)
- **API destino**: Android 14 (API 34)
- **Librerías principales**:
  - Android X (AppCompat, RecyclerView, Room)
  - Media3/ExoPlayer para reproducción de audio
  - Glide para cargas de imágenes
  - ViewModel y LiveData para gestión de estado

## Estructura del Proyecto 📁

```
MusicJuan/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/musicjuan/app/
│   │   │   │   ├── MainActivity.java          # Actividad principal
│   │   │   │   ├── model/
│   │   │   │   │   ├── Song.java              # Modelo de canción
│   │   │   │   │   └── Playlist.java          # Modelo de playlist
│   │   │   │   ├── service/
│   │   │   │   │   └── MusicService.java      # Servicio de reproducción
│   │   │   │   ├── adapter/
│   │   │   │   │   └── MusicAdapter.java      # Adaptador RecyclerView
│   │   │   │   └── util/
│   │   │   │       └── MusicLoader.java       # Cargador de canciones
│   │   │   └── res/
│   │   │       ├── layout/                    # Layouts XML
│   │   │       └── values/                    # Recursos
│   │   └── AndroidManifest.xml
│   └── build.gradle                           # Dependencias
└── README.md
```

## Instalación 🚀

1. **Clonar el repositorio**
   ```bash
   git clone https://github.com/Juanking16/MusicJuan.git
   cd MusicJuan
   ```

2. **Abrir en Android Studio**
   - File → Open → Selecciona la carpeta MusicJuan
   - Espera a que Gradle se sincronice

3. **Conectar dispositivo o emulador**
   - Asegúrate de tener un dispositivo Android conectado
   - O usa un emulador de Android Studio

4. **Ejecutar la aplicación**
   - Click en "Run" (Ctrl+R)
   - Selecciona tu dispositivo

## Permisos Requeridos 🔐

- `READ_EXTERNAL_STORAGE` - Para acceder a archivos de música
- `READ_MEDIA_AUDIO` - Para leer archivos de audio (Android 13+)
- `INTERNET` - Para futuras características en línea

## Uso 📖

1. **Reproducir una canción**
   - Abre la aplicación
   - La lista de canciones se carga automáticamente
   - Toca cualquier canción para reproducirla

2. **Controlar reproducción**
   - Usa los botones Play/Pausa, Anterior, Siguiente
   - Arrastra la barra de progreso para cambiar de posición

3. **Ver información**
   - Cada canción muestra: Título, Artista, Álbum
   - Duración total y actual en la barra de progreso

## Roadmap 🗺️

- [ ] Interfaz mejorada con Jetpack Compose
- [ ] Búsqueda avanzada
- [ ] Gestión completa de playlists
- [ ] Estadísticas de reprodución
- [ ] Sincronización en la nube
- [ ] Widget de reproducción
- [ ] Ecualizador de audio
- [ ] Integración con Spotify

## Contribuciones 🤝

Las contribuciones son bienvenidas. Para cambios importantes:

1. Fork el proyecto
2. Crea una rama para tu feature (`git checkout -b feature/AmazingFeature`)
3. Commit tus cambios (`git commit -m 'Add some AmazingFeature'`)
4. Push a la rama (`git push origin feature/AmazingFeature`)
5. Abre un Pull Request

## Licencia 📄

Este proyecto es de código abierto y está disponible bajo licencia MIT.

## Autor ✍️

**Juanking16** - Desarrollo principal

## Contacto 📧

¿Preguntas o sugerencias? Abre un issue en GitHub.

---

**Disfruta tu música con MusicJuan** 🎵✨
