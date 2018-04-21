Sistema de registro de pesadas para bascula camionera con lectura de puerto COM

Los requerimientos son:

Un sistema de escritorio que permita capturar los datos referentes a la pesada de una bascula camionera que administra pesadas de clientes y proveedores de una empresa.

Los datos que se requieren capturar son:

Especificar si se trata de cliente o proveedor
Usuario que captura
Nombre de la empresa de transportes
Nombre del chofer
Placas del vehiculo
Hora y fecha de entrada
Peso de entrada (Si es proveedor el peso es del camion con carga, si es cliente el peso es del camion vacio.)
Hora y fecha de salida
Peso de salida (Si es proveedor el peso es del camion vacio, si es cliente el peso es del camion con carga.)
El sistema debe seguir el flujo siguiente:

Se debe generar un nuevo registro de pesada
Se debe capturar los datos de la empresa transportista, chofer y placas del vehiculo.
Se debe registrar la hora y peso de entrada.
Se debe guardar el registro.
Una vez cargado o descargado el camion segun sea el caso, se debe buscar el registro correspondiente a la pesada y seleccionarlo
Una vez seleccionado el registro de la pesada, se debe registrar la hora y peso de salida del vehiculo
Una vez que se termino de capturar la informacion previa, se debe permitir al usuario imprimir un comprobante de pesada que contenga la informacion antes capturada.
Se guarda el registro.
El sistema debe permitir:

Generar nuevos registros
Buscar registros abiertos (Sin peso de salida)
Se debe contar con un registro de estatus de cada pesada
El metodo de obtencion de el peso de la bascula debe ser a traves de el puerto Serial COM de la computadora.
Debe existir un archivo de configuracion desde el cual se pueda definir los parametros de conexión de base de datos
Debe existir un archivo de configuracion desde el cual se pueda definir los parametros de configuracion del puerto COM.
