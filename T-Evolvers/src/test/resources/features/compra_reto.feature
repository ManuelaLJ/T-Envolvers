#language:es

Característica: Yo como usuario del sistema quiero agregar productos al carrito y validar el valor total a pagar

  Esquema del escenario: Seleccionar productos agregandolos al carrito
    Dado que el usurio ingresa a la pagina principal
    Cuando el usuario selecciona los productos y agrega varias cantidades
      | CantProductos   | CantUnidades   |
      | <CantProductos> | <CantUnidades> |
    Entonces deberia ver que el precio total coincida con la suma de los valores de los productos

    Ejemplos:
      | CantProductos | CantUnidades |
      | 2             | 2            |

