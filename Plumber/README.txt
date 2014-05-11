CLASE PRINCIPAL:   Plumber.java
-----------------------------------------
CLASES DE OBJETOS: PanelTuberias.java
		   PanelSuperior.java
		   Nivel.java
		   Tuberias.java
		   Grifo.java
		   BarraProgreso.java
		   Fondo.java
		   Reiniciar.java
----------------------------------------
CLASES AUXILIARES: ThreadMensajes.java
----------------------------------------
IMAGENES:          Grifo.png
		   Tuberia90.png
		   Tuberia180.png
		   Tuberia270.png
		   Tuberia360.png
		   TuberiaHorizontal.png
		   TuberiaVertical.png
		   Tuberia90Llena.png
		   Tuberia180Llena.png
		   Tuberia270Llena.png
		   Tuberia360Llena.png
		   TuberiaHorizontalLlena.png
		   TuberiaVerticalLlena.png
		   TuberiaFinal.png			


Existe la posibilidad de que se genere un panel que no se pueda resolver ya que la inserción de las tuberías
la realizo de forma aleatoria ya que resulta mucho más sencillo y más rápido. En el caso de que se produzca
este hecho valdría con realizar una solución no válida y reiniciar el juego a través del boton situado a la derecha.

La idea era realizar el juego con varios niveles, como el del formato web, pero para ello hubiera necesitado 
realizar una aplicación con multiples threads para que el thread principal que pinta las tuberias no se quedase bloqueado
esperando una contestación al mensaje y para que se pudiese visualizar las tuberias llenas antes de reiniciar el
juego. No he conseguido hacer funcionar dicha función pero he dejado funciones y atributos indicados. Lo mismo me ha pasado
con la barra de tiempo ya que no me dejaba añadir valores desde un thread independiente a una aplicacion. 

