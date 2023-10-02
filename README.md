Pasos realizados para el desarrollo de los microservicios:
  *** Microservicio waste-manager ***
  1 - Primeramente haciendo uso de la aplicacion web spring Initialazr fue generado un proyecto base 
      con algunas de las depencias necesarias para este proyecto.
  2 - A partir del modelo ofrecido en el ejercicio se paso a mapear ambas entidades y crear la respectiva
      interfaz Repositry perteneciente a esa Entidad.
  3 - Fueron creados DTO(data transfer objects) de entrada y salida.
  4 - Fue creada una clase ResponseDTO para dar respuesta positiva o de error segun sea el caso a todas las peticiones.
  5 - Fue creada la interfaz del servicio y su respectiva implementacion.
  6 - Se creo el Controller con las operaciones solicitadas.
  7 - La clase principal del proyecto fue anotada con la anotacion @EnableDiscoveryClient.
  8 - Por ultimo fue creado el archivo application.yml con la configuracion necesaria.
  
 *** Microservicio Configserver***
  1 - Primeramente haciendo uso de la aplicacion web spring Initialazr fue generado un proyecto base 
      con algunas de las depencias necesarias para este proyecto.
  2 - La clase principal del proyecto fue anotada con la anotacion @EnableConfigServer.
  3 - Fue creado en Github un repositorio el cual contiene en la rama master los archivos de configuracion 
      que seran utilizados por los microservicios.
  4 - Por ultimo fue creado el archivo application.properties con la configuracion necesaria.
  
  *** Microservicio gatewayservice ****
  1 - Primeramente haciendo uso de la aplicacion web spring Initialazr fue generado un proyecto base 
      con algunas de las depencias necesarias para este proyecto.
  2 - La clase principal del proyecto fue anotada con la anotacion @EnableDiscoveryClient.
  3 - Por ultimo fue creado el archivo application.yml con la configuracion necesaria.
  
  *** Microservicio Namingservice ***
  1 - Primeramente haciendo uso de la aplicacion web spring Initialazr fue generado un proyecto base 
      con algunas de las depencias necesarias para este proyecto.
  2 - La clase principal del proyecto fue anotada con la anotacion @EnableEurekaServer.
  3 - Por ultimo fue creado el archivo application.yml con la configuracion necesaria.
  
Para la ejecucion de los proyectos el entorno de trabajo debe tener instalado Java 17, Apache Maven y como IDE Intellij Idea.
  Pasos para la ejecucion de los proyectos:
  1 - Abrir cada proyecto con el IDE y a traves de maven aplicar "clean install".
  2 - Luego de compilados los proyectos ejecutar en el siguente orden 
      2.1 Microservicio Configserver
      2.2 Microservicio Namingservice
      2.3 Microservicio waste-manager
      2.4 Microservicio gatewayservice
  
Para realizar peticiones al gatewayservice se debe hacer uso de la app Postman u otra app que permita esta accion.
  Endpoints:
  1 - Crear waste manager.
  Verbo Http: Post, Url: http://localhost:8080/wastemanagerservice/wastemanager/create
  cuerpo de la peticion(Body):
  
  {
    "lastModifiedDate": "2023-09-29T12:11:44.253+00:00",
    "createdDate": "2023-09-29T12:11:44.253+00:00",
    "isEnabled": true,
    "nif": "4444",
    "nombre": "mmmm",
    "wasteManagerAddress": {
        "direccion": "fggdf dfg f",
        "isEnabled": true,
        "version": 1,
        "lastModifiedDate": "2023-09-29T12:11:44.253+00:00",
        "createdDate": "2023-09-29T12:11:44.253+00:00"
       }
   }
   
  2 - Modificar waste manager.
  Verbo Http: Put, Url: http://localhost:8080/wastemanagerservice/wastemanager/update
  cuerpo de la peticion(Body):
  
  {
    "id":1,
    "lastModifiedDate": "2023-09-29T12:11:44.253+00:00",
    "createdDate": "2023-09-29T12:11:44.253+00:00",
    "isEnabled": true,
    "nif": "4444",
    "nombre": "mmmm",
    "wasteManagerAddress": {
        "direccion": "fggdf dfg f",
        "isEnabled": true,
        "version": 1,
        "lastModifiedDate": "2023-09-29T12:11:44.253+00:00",
        "createdDate": "2023-09-29T12:11:44.253+00:00"
      }
   }
   
   3 - Obtener waste manager.
    Verbo Http: Get, Url: http://localhost:8080/wastemanagerservice/wastemanager/find/1

  
     
  
