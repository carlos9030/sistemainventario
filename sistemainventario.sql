-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 27-07-2016 a las 04:01:03
-- Versión del servidor: 5.6.16
-- Versión de PHP: 5.5.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `sistemainventario`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `contratista`
--

CREATE TABLE IF NOT EXISTS `contratista` (
  `idContratista` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Nombres` varchar(50) DEFAULT NULL,
  `Apellidos` varchar(50) DEFAULT NULL,
  `Telefono` int(10) unsigned DEFAULT NULL,
  `Direccion` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idContratista`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `contratista`
--

INSERT INTO `contratista` (`idContratista`, `Nombres`, `Apellidos`, `Telefono`, `Direccion`) VALUES
(1, 'Darwin', 'Vargas Apaza ', 7545345, '6to Anillo del trillo'),
(2, 'Napoleon ', 'Justiniano', 3424231, 'Av 4 de julio');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalledevolucion`
--

CREATE TABLE IF NOT EXISTS `detalledevolucion` (
  `Materiales_IdMaterial` int(10) unsigned NOT NULL,
  `NotaDevolucion_idNotaDevolucion` int(10) unsigned NOT NULL,
  `Unidad` varchar(30) NOT NULL,
  `Cantidad` int(10) unsigned NOT NULL,
  `Estado` varchar(40) DEFAULT NULL,
  KEY `DetalleDevolucion_FKIndex1` (`NotaDevolucion_idNotaDevolucion`),
  KEY `DetalleDevolucion_FKIndex2` (`Materiales_IdMaterial`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detallerecepcion`
--

CREATE TABLE IF NOT EXISTS `detallerecepcion` (
  `Materiales_IdMaterial` int(10) unsigned NOT NULL,
  `NotaRecepcion_idNotaRecepcion` int(10) unsigned NOT NULL,
  `cantidad` int(10) unsigned NOT NULL,
  `unidad` varchar(20) DEFAULT NULL,
  KEY `DetalleRecepcion_FKIndex1` (`NotaRecepcion_idNotaRecepcion`),
  KEY `DetalleRecepcion_FKIndex2` (`Materiales_IdMaterial`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detallesalida`
--

CREATE TABLE IF NOT EXISTS `detallesalida` (
  `Materiales_IdMaterial` int(10) unsigned NOT NULL,
  `SalidaMateriales_idSalidaMateriales` int(10) unsigned NOT NULL,
  `Unidad` varchar(20) DEFAULT NULL,
  `Cantidad` int(10) unsigned DEFAULT NULL,
  KEY `Table_14_FKIndex1` (`SalidaMateriales_idSalidaMateriales`),
  KEY `Table_14_FKIndex2` (`Materiales_IdMaterial`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `detallesalida`
--

INSERT INTO `detallesalida` (`Materiales_IdMaterial`, `SalidaMateriales_idSalidaMateriales`, `Unidad`, `Cantidad`) VALUES
(1, 1, 'Bolsas', 200),
(9, 1, 'Pzas', 3),
(3, 2, 'Pza', 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_pedido`
--

CREATE TABLE IF NOT EXISTS `detalle_pedido` (
  `Unidad` varchar(30) NOT NULL,
  `Materiales_IdMaterial` int(10) unsigned NOT NULL,
  `NotaPedido_idNotaPedido` int(10) unsigned NOT NULL,
  `Cantidad` int(10) unsigned DEFAULT NULL,
  KEY `Detalle_Pedido_FKIndex1` (`NotaPedido_idNotaPedido`),
  KEY `Detalle_Pedido_FKIndex2` (`Materiales_IdMaterial`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_prestamo`
--

CREATE TABLE IF NOT EXISTS `detalle_prestamo` (
  `Materiales_IdMaterial` int(10) unsigned NOT NULL,
  `Nota_Prestamo_idNota_Prestamo` int(10) unsigned NOT NULL,
  `Unidad` varchar(20) DEFAULT NULL,
  `Cantidad` int(10) unsigned DEFAULT NULL,
  `Tipo` varchar(20) DEFAULT NULL,
  KEY `Detalle_Prestamo_FKIndex1` (`Nota_Prestamo_idNota_Prestamo`),
  KEY `Detalle_Prestamo_FKIndex2` (`Materiales_IdMaterial`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE IF NOT EXISTS `empleado` (
  `IdEmpleado` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Contratista_idContratista` int(10) unsigned NOT NULL,
  `Nombres` varchar(50) DEFAULT NULL,
  `Apellidos` varchar(50) DEFAULT NULL,
  `Telefono` int(10) unsigned DEFAULT NULL,
  `Carnet_de_Identidad` int(10) unsigned DEFAULT NULL,
  `Direccion` varchar(50) DEFAULT NULL,
  `cargo` varchar(35) DEFAULT NULL,
  PRIMARY KEY (`IdEmpleado`),
  KEY `Empleado_FKIndex2` (`Contratista_idContratista`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`IdEmpleado`, `Contratista_idContratista`, `Nombres`, `Apellidos`, `Telefono`, `Carnet_de_Identidad`, `Direccion`, `cargo`) VALUES
(1, 1, 'Gonzalo', 'Rojas Uriarte', 3454236, 25235623, 'Villa 1ero de Mayo', 'Encofrador'),
(2, 1, 'German', 'Mendoza Vaca', 78335345, 74645743, 'Villa Fatima', 'Ayudante'),
(3, 2, 'Estaban', 'Urquizo Becerra', 4526346, 5235236, 'Av las Palmas 3er Anillo', 'Ayudante'),
(4, 2, 'Florentino', 'Perez', 73453462, 3423425, 'B/ Castulo Chavez', 'Mecanico');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ficha_obra_materiales`
--

CREATE TABLE IF NOT EXISTS `ficha_obra_materiales` (
  `idFicha_Obra_Materiales` int(10) unsigned NOT NULL,
  `Obra_IdObra` int(10) unsigned NOT NULL,
  PRIMARY KEY (`idFicha_Obra_Materiales`),
  KEY `Ficha_Obra_Materiales_FKIndex1` (`Obra_IdObra`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `ficha_obra_materiales`
--

INSERT INTO `ficha_obra_materiales` (`idFicha_Obra_Materiales`, `Obra_IdObra`) VALUES
(1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `materiales`
--

CREATE TABLE IF NOT EXISTS `materiales` (
  `IdMaterial` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Descripcion` varchar(50) DEFAULT NULL,
  `Marca` varchar(40) DEFAULT NULL,
  `Categoria` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`IdMaterial`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Volcado de datos para la tabla `materiales`
--

INSERT INTO `materiales` (`IdMaterial`, `Descripcion`, `Marca`, `Categoria`) VALUES
(1, 'Cemento', 'Fancesa', 'A'),
(2, 'Estuco', 'Suticollo', 'A'),
(3, 'Martillo Electrico', 'Sthil', 'B'),
(4, 'Disco p/ Fierro', 'Ulistools', 'C'),
(5, 'Sierra Mecanica', 'Sthil', 'C'),
(6, 'Hormigonera tri fasica', 'Menegotti', 'B'),
(7, 'Escobillones de Pelo Largo', 'Escobas', 'C'),
(8, 'Escobas', 'Escobas', 'C'),
(9, 'Gomas', 'Gomas', 'C'),
(10, 'Trapos p/Trapear', 'Trapos de Tela', 'C');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `notadevolucion`
--

CREATE TABLE IF NOT EXISTS `notadevolucion` (
  `idNotaDevolucion` int(10) unsigned NOT NULL,
  `Empleado_IdEmpleado` int(10) unsigned NOT NULL,
  `Usuario_IdUsuario` int(10) unsigned NOT NULL,
  `fecha` varchar(10) NOT NULL,
  PRIMARY KEY (`idNotaDevolucion`),
  KEY `NotaDevolucion_FKIndex1` (`Usuario_IdUsuario`),
  KEY `NotaDevolucion_FKIndex2` (`Empleado_IdEmpleado`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `notapedido`
--

CREATE TABLE IF NOT EXISTS `notapedido` (
  `idNotaPedido` int(10) unsigned NOT NULL,
  `Obra_IdObra` int(10) unsigned NOT NULL,
  `Observacion` varchar(100) DEFAULT NULL,
  `Ingeniero_obra` varchar(50) DEFAULT NULL,
  `Fecha` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idNotaPedido`),
  KEY `NotaPedido_FKIndex1` (`Obra_IdObra`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `notarecepcion`
--

CREATE TABLE IF NOT EXISTS `notarecepcion` (
  `idNotaRecepcion` int(10) unsigned NOT NULL,
  `Obra_IdObra` int(10) unsigned NOT NULL,
  `Proveedor_idProveedor` int(10) unsigned NOT NULL,
  `Fecha` varchar(10) DEFAULT NULL,
  `Ingeniero_obra` varchar(70) DEFAULT NULL,
  `NotaRemision` int(10) unsigned DEFAULT NULL,
  `Transportista` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idNotaRecepcion`),
  KEY `NotaRecepcion_FKIndex1` (`Proveedor_idProveedor`),
  KEY `NotaRecepcion_FKIndex2` (`Obra_IdObra`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `nota_prestamo`
--

CREATE TABLE IF NOT EXISTS `nota_prestamo` (
  `idNota_Prestamo` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Empleado_IdEmpleado` int(10) unsigned NOT NULL,
  `Usuario_IdUsuario` int(10) unsigned NOT NULL,
  `Fecha` date DEFAULT NULL,
  `Motivo` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`idNota_Prestamo`),
  KEY `Nota_Prestamo_FKIndex1` (`Usuario_IdUsuario`),
  KEY `Nota_Prestamo_FKIndex2` (`Empleado_IdEmpleado`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `obra`
--

CREATE TABLE IF NOT EXISTS `obra` (
  `IdObra` int(10) unsigned NOT NULL,
  `Usuario_IdUsuario` int(10) unsigned NOT NULL,
  `Descripcion` varchar(50) DEFAULT NULL,
  `Direccion` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`IdObra`),
  KEY `Obra_FKIndex1` (`Usuario_IdUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `obra`
--

INSERT INTO `obra` (`IdObra`, `Usuario_IdUsuario`, `Descripcion`, `Direccion`) VALUES
(1, 1, 'Hot Burguer 4to anillo Radial 19', '4to Anillo Radial 19'),
(2, 3, 'Nibol - Tarija', 'Av. La glorieta'),
(3, 3, 'Hot Burguer', 'Av San Aurelio 3er Anillo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedor`
--

CREATE TABLE IF NOT EXISTS `proveedor` (
  `idProveedor` int(10) unsigned NOT NULL,
  `Nombres` varchar(70) DEFAULT NULL,
  `Apellidos` varchar(70) DEFAULT NULL,
  `Empresa` varchar(30) DEFAULT NULL,
  `Telefono` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`idProveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `proveedor`
--

INSERT INTO `proveedor` (`idProveedor`, `Nombres`, `Apellidos`, `Empresa`, `Telefono`) VALUES
(1, 'Daniel', 'Lopez', 'Ferreteria la Rioja', 78474342),
(2, 'Raul', 'Gonzales', 'Tecnopor', 734634634),
(3, 'Kevin', 'Roldan', 'Pre Forte', 3436423);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `salidamateriales`
--

CREATE TABLE IF NOT EXISTS `salidamateriales` (
  `idSalidaMateriales` int(10) unsigned NOT NULL,
  `Obra_IdObra` int(10) unsigned NOT NULL,
  `ObraDestino` varchar(100) NOT NULL,
  `Transportista` varchar(100) DEFAULT NULL,
  `Fecha` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`idSalidaMateriales`),
  KEY `SalidaMateriales_FKIndex1` (`Obra_IdObra`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `salidamateriales`
--

INSERT INTO `salidamateriales` (`idSalidaMateriales`, `Obra_IdObra`, `ObraDestino`, `Transportista`, `Fecha`) VALUES
(1, 2, 'Hot Burguer 4to anillo Radial 19', 'Miguel Mercado', '21/07/2016'),
(2, 1, 'Nibol - Tarija', '', '21/07/2016');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `stock`
--

CREATE TABLE IF NOT EXISTS `stock` (
  `Materiales_IdMaterial` int(10) unsigned NOT NULL,
  `Ficha_Obra_Materiales_idFicha_Obra_Materiales` int(10) unsigned NOT NULL,
  `Unidad` varchar(20) DEFAULT NULL,
  `Cantidad` int(10) unsigned DEFAULT NULL,
  KEY `Stock_FKIndex1` (`Ficha_Obra_Materiales_idFicha_Obra_Materiales`),
  KEY `Stock_FKIndex2` (`Materiales_IdMaterial`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `stock`
--

INSERT INTO `stock` (`Materiales_IdMaterial`, `Ficha_Obra_Materiales_idFicha_Obra_Materiales`, `Unidad`, `Cantidad`) VALUES
(1, 1, 'Bolsa', 120);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `IdUsuario` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Nombre_Completo` varchar(50) DEFAULT NULL,
  `Nick` varchar(20) DEFAULT NULL,
  `Contrasenha` varchar(20) DEFAULT NULL,
  `Carnet_de_Identidad` int(10) unsigned DEFAULT NULL,
  `Direccion` varchar(255) DEFAULT NULL,
  `Telefono` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`IdUsuario`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`IdUsuario`, `Nombre_Completo`, `Nick`, `Contrasenha`, `Carnet_de_Identidad`, `Direccion`, `Telefono`) VALUES
(1, 'Carlos Aguilera', 'carlos90', 'carlos2090', 7676659, 'B/ la Colorada', 78438086),
(2, 'Victor', 'vgutierrez', 'vgutierrez', 5634533, 'B/4 de Noviembre', 76345343),
(3, 'Fernando  Mora', 'fmora', 'fmora', 423241123, 'B/4 de noviembre', 75457453);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detallesalida`
--
ALTER TABLE `detallesalida`
  ADD CONSTRAINT `detallesalida_ibfk_1` FOREIGN KEY (`SalidaMateriales_idSalidaMateriales`) REFERENCES `salidamateriales` (`idSalidaMateriales`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `detallesalida_ibfk_2` FOREIGN KEY (`Materiales_IdMaterial`) REFERENCES `materiales` (`IdMaterial`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `detalle_prestamo`
--
ALTER TABLE `detalle_prestamo`
  ADD CONSTRAINT `detalle_prestamo_ibfk_1` FOREIGN KEY (`Nota_Prestamo_idNota_Prestamo`) REFERENCES `nota_prestamo` (`idNota_Prestamo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `detalle_prestamo_ibfk_2` FOREIGN KEY (`Materiales_IdMaterial`) REFERENCES `materiales` (`IdMaterial`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD CONSTRAINT `empleado_ibfk_1` FOREIGN KEY (`Contratista_idContratista`) REFERENCES `contratista` (`idContratista`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `ficha_obra_materiales`
--
ALTER TABLE `ficha_obra_materiales`
  ADD CONSTRAINT `ficha_obra_materiales_ibfk_1` FOREIGN KEY (`Obra_IdObra`) REFERENCES `obra` (`IdObra`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `nota_prestamo`
--
ALTER TABLE `nota_prestamo`
  ADD CONSTRAINT `nota_prestamo_ibfk_1` FOREIGN KEY (`Usuario_IdUsuario`) REFERENCES `usuario` (`IdUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `nota_prestamo_ibfk_2` FOREIGN KEY (`Empleado_IdEmpleado`) REFERENCES `empleado` (`IdEmpleado`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `obra`
--
ALTER TABLE `obra`
  ADD CONSTRAINT `obra_ibfk_1` FOREIGN KEY (`Usuario_IdUsuario`) REFERENCES `usuario` (`IdUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `salidamateriales`
--
ALTER TABLE `salidamateriales`
  ADD CONSTRAINT `salidamateriales_ibfk_1` FOREIGN KEY (`Obra_IdObra`) REFERENCES `obra` (`IdObra`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `stock`
--
ALTER TABLE `stock`
  ADD CONSTRAINT `stock_ibfk_1` FOREIGN KEY (`Ficha_Obra_Materiales_idFicha_Obra_Materiales`) REFERENCES `ficha_obra_materiales` (`idFicha_Obra_Materiales`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `stock_ibfk_2` FOREIGN KEY (`Materiales_IdMaterial`) REFERENCES `materiales` (`IdMaterial`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
