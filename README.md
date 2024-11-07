# Java-Project-Inside-Out

Basado en la película **Inside Out** 🇬🇧🇺🇸 [_Del Revés_ 🇪🇸, _Intensa-Mente_ (🇦🇷🇧🇴🇨🇱🇨🇴🇨🇷🇨🇺🇩🇴🇪🇨🇸🇻🇬🇹🇭🇳🇲🇽🇳🇮🇵🇾🇵🇪🇵🇷🇺🇾🇻🇪)] se ha pedido una aplicación de consola con la cual el usuario pueda gestionar las emociones de momentos vividos en un diario cada momento contará con un título una fecha en que ocurrió y una emoción asignada; además de un identificador fecha de creación y fecha de modificación.

![Emociones: personajes de la pelicula INSIDE OUT Joy, Sadness, Anger, Disgust, Fear, Anxiety, Envy, Shame, Boredom. Nostalgia](images/inside-out-2-1280x540-17820.jpg)

## Descripción con SIPNOSIS del proyecto 

### Planificación del proyecto

>    1. Se realizo la planificacion utilizando [Jira](https://www.atlassian.com/software/jira?referer=jira.com)
>    2. El projecto fue bajo el nombre  [javaProjectInsideOut](https://albertocasasofiuco-1730202167115.atlassian.net/jira/software/projects/JPIO/boards/2)
>    3. Los diagramas se encuentran en un el archivo [projectoInsideOut.drawio](https://drive.google.com/file/d/1NVHUrTjYrLSpKclKpEaub4_o8r0NiPPG/view?usp=drive_link)

### Realización de Diagramas

>    - Clasesh
>    - Historia de Usuario
>    - Modelo Vista Controlador (MVC)



## Pre Requisitos (Que se necesita instalar para poder ejecutar el proyecto) 

>- Java 21
>- Maven
>    · Hamcrest (Dependencia)
>- Extensiones (VSC) - Visual Studio Code

>    · **Extension Pack for Java** del editor Microsoft <sup>este instalará los que aparecen a continuación</sup>

        ![ExtPk4Java](images/ExtPk4Java.png)

>        1. Language Support for Java(TM) by Red Hat
>        2. Debugger for Java
>        3. Test Runner for Java
>        4. Maven for Java
>        5. Gradle for Java
>        6. Project Manager for Java 
>        7. IntelliCode

>  - JUnit5 JAR Downloader extensión by Raj Kundu
>
>      
        ![Junit5](images/JUnit5.png)
>

## Pasos para la instalación 

De las URL que aparecen a continuación realizar las descargas de los paquetes correspondientes a los programas (Java 21, Apache Maven, VSC - Visual Studio Code) en este caso Java en la versión 21

### Java 21


- Windows

    https://www.oracle.com/es/java/technologies/downloads/#java21 (jdk 21)
    https://download.oracle.com/java/21/latest/jdk-21_windows-x64_bin.exe (sha256)

- Mac

    https://download.oracle.com/java/21/latest/jdk-21_macos-x64_bin.dmg (sha256) (ojo procesador)
+
    https://formulae.brew.sh/formula/maven#default

#### Configuración variables de entorno windows


## Ejecución del test (Capturas de cobertura) 

## Diagramas Realizados 

  - DIAGRAMA DE CLASES

    ![Diagrama de Clases](images/projectoInsideOut-CLASES.webp)

```mermaid
---
title: DIAGRAMA DE CLASES 
---
classDiagram
    App.java <|--> TerminalMenu
    TerminalMenu <|--> MomentController
    Moments <|--> EmotionType
 
    class App.java{
        Inicio
        public void run() (run app.java automatically)
        private void displayMenu() (display main menu from TerminalMenu)
        private void exit()
    }

    class EmotionType{
        Index
        Joy()
        Sadness()
        Anger()
        Disgust()
        Fear()
        Anxiety()
        Envy()
        Shame()
        Boredom()
        Nostalgy()
    }

    class Moments{
        +int id
        +str title
        +str description
        +LocalDateTime momentDate
        +private (EmotionType) emotion
        +private (LocalDateTime) createdDate
        +private (LocalDateTime) updatedDate
    }

    class TerminalMenu{
        +int Scanner
        public void displayMainMenu()
        public void displayFilterMenu()
        public String getInput()
        public void displayMessage(): String
        public void displayMomentList() List<Moment>
        public void displayEmotionOptions()
    } 
 
    class MomentController{
        +param
        private void addMoment()
        private void viewMoments()
        private void deleteMoment()
        private void filterMomentsByEmotion()
        private void filterMomentsByDate()
    }

```
    
  - HISTORIAS DE USUARIOS

    ![Historia de Usuario](images/projectoInsideOut-ACTIONS.webp)


    ![Moment Emotion Controller](images/MomentEmotionController.png)

>    ```mermaid
>    zenuml
>    title Moment Emotion Controller
>    @Actor Riley #FFEBE6
>    @Boundary TerminalMenu #0747A6
>    @control <<Moment>> Controller #E3FCEF
>    group MomentContoller {
>      @database Setter
>      @entity Getter
>    }
>
>    @Starter(Riley)
>    // `App/mainMenu`
>    TerminalMenu.post(scanner) {
>      Controller.run(getInput) {
>        moment = new Moment(EmotionType)
>        if(EmotionType != null) {
>          par {
>            Setter.create(moment)
>            Setter.update(moment)
>            Getter.view(moment)
>            Getter.filter(moment)
>            Setter.delete(moment)      
>          }      
>        }
>      }
>    }
>    
>    ```
>

    
  - MODELO VISTA CONTROLADOR

    ![Modelo, Vista, Controlador](images/projectoInsideOut-MVC.webp)

## Autores:  

- Nadiia Alaieva [@tizzifona](https://github.com/tizzifona)
- Oksana Muzalevska [@omuzalevska](https://github.com/omuzalevska)
- José Manuel Arango [@jose30-back](https://github.com/jose30-back)
- Alberto Casas [@ofiucoder](https://github.com/ofiucoder)
