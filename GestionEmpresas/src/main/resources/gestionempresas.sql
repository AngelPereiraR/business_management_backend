-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 03-06-2023 a las 16:33:50
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `gestionempresas`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `category`
--

CREATE TABLE `category` (
  `id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `company_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `category`
--

INSERT INTO `category` (`id`, `description`, `name`, `company_id`) VALUES
(1, 'Tipos de comida', 'Comida', 1),
(2, 'Tipos de bebida', 'Bebida', 1),
(3, 'Tipos de bebida', 'Bebida', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `category_seq`
--

CREATE TABLE `category_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `category_seq`
--

INSERT INTO `category_seq` (`next_val`) VALUES
(101);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `company`
--

CREATE TABLE `company` (
  `id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `company`
--

INSERT INTO `company` (`id`, `description`, `name`, `user_id`) VALUES
(1, 'Venta de yogures', 'Danone', 5),
(2, 'Venta de productos Coca Cola', 'Coca Cola', 6),
(3, 'Venta de productos Nestlé', 'Nestlé', 7);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `company_seq`
--

CREATE TABLE `company_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `company_seq`
--

INSERT INTO `company_seq` (`next_val`) VALUES
(101);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `favorite`
--

CREATE TABLE `favorite` (
  `id` bigint(20) NOT NULL,
  `suggestion_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `favorite`
--

INSERT INTO `favorite` (`id`, `suggestion_id`) VALUES
(1, 2),
(2, 4),
(3, 3),
(5, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `favorite_seq`
--

CREATE TABLE `favorite_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `favorite_seq`
--

INSERT INTO `favorite_seq` (`next_val`) VALUES
(101);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `favorite_user_dislikes`
--

CREATE TABLE `favorite_user_dislikes` (
  `favorite_dislikes_id` bigint(20) NOT NULL,
  `user_dislikes_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `favorite_user_dislikes`
--

INSERT INTO `favorite_user_dislikes` (`favorite_dislikes_id`, `user_dislikes_id`) VALUES
(3, 3),
(5, 2),
(5, 3),
(1, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `favorite_user_likes`
--

CREATE TABLE `favorite_user_likes` (
  `favorite_likes_id` bigint(20) NOT NULL,
  `user_likes_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `favorite_user_likes`
--

INSERT INTO `favorite_user_likes` (`favorite_likes_id`, `user_likes_id`) VALUES
(1, 3),
(2, 3),
(2, 2),
(3, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `order_product`
--

CREATE TABLE `order_product` (
  `id` bigint(20) NOT NULL,
  `company_name` varchar(255) DEFAULT NULL,
  `final_price` double NOT NULL,
  `quantities` varbinary(255) DEFAULT NULL,
  `user_username` varchar(255) DEFAULT NULL,
  `company_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `order_product`
--

INSERT INTO `order_product` (`id`, `company_name`, `final_price`, `quantities`, `user_username`, `company_id`, `user_id`) VALUES
(206, 'Danone', 26.62, 0xaced0005737200136a6176612e7574696c2e41727261794c6973747881d21d99c7619d03000149000473697a65787000000002770400000002740001327400013478, 'Prueba01', 1, 2),
(207, 'Danone', 67.76, 0xaced0005737200136a6176612e7574696c2e41727261794c6973747881d21d99c7619d03000149000473697a657870000000047704000000047400013374000135740001327400013378, 'Prueba01', 1, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `order_product_seq`
--

CREATE TABLE `order_product_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `order_product_seq`
--

INSERT INTO `order_product_seq` (`next_val`) VALUES
(301);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `product`
--

CREATE TABLE `product` (
  `id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `category_id` bigint(20) DEFAULT NULL,
  `company_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `product`
--

INSERT INTO `product` (`id`, `description`, `name`, `price`, `category_id`, `company_id`) VALUES
(1, 'Yogur blanco', 'Yogur blanco', 3, 1, 1),
(2, 'Yogur sin azúcar', 'Yogur 0.0', 5, 1, 1),
(3, 'Yogur con menor cantidad de azúcar', 'Yogur light', 4, 1, 1),
(4, 'Yogur en botella pequeña', 'Yogur líquido', 2, 2, 1),
(5, 'Yogur en botella pequeña sin azúcar', 'Yogur líquido 0.0', 6, 2, 1),
(6, 'Coca Cola original', 'Coca Cola', 4, 3, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `product_orders`
--

CREATE TABLE `product_orders` (
  `products_id` bigint(20) NOT NULL,
  `orders_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `product_orders`
--

INSERT INTO `product_orders` (`products_id`, `orders_id`) VALUES
(1, 206),
(3, 206),
(1, 207),
(3, 207),
(5, 207),
(2, 207);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `product_seq`
--

CREATE TABLE `product_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `product_seq`
--

INSERT INTO `product_seq` (`next_val`) VALUES
(101);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `suggestion`
--

CREATE TABLE `suggestion` (
  `id` bigint(20) NOT NULL,
  `commentary` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `company_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `suggestion`
--

INSERT INTO `suggestion` (`id`, `commentary`, `state`, `username`, `company_id`, `user_id`) VALUES
(1, 'Añadir nuevos yogures', 'Pending', 'Admin', 1, 1),
(2, 'Añadir categoría para productos para personas intolerantes a la lactosa', 'Accepted', 'Admin', 1, 1),
(3, 'Separar categoría de Comida en los distintos tipos que se pueden encontrar', 'Pending', 'Admin', 1, 1),
(4, 'Eliminar categoría de Bebida y añadirla a Comida', 'Denegated', 'Admin', 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `suggestion_seq`
--

CREATE TABLE `suggestion_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `suggestion_seq`
--

INSERT INTO `suggestion_seq` (`next_val`) VALUES
(101);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) NOT NULL,
  `enabled` bit(1) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(255) DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL,
  `username` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `user`
--

INSERT INTO `user` (`id`, `email`, `enabled`, `password`, `role`, `token`, `username`) VALUES
(1, 'admin@admin.com', b'1', '$2a$10$rn9.tpAaviPinn7C2H8Dqehhdcq.M44Tue6lQfAxQ9aMivFg7SJwq', 'ROLE_ADMIN', NULL, 'Admin'),
(2, 'prueba01@gmail.com', b'1', '$2a$10$IjCCrpYzELWFr8ZdehCJ3ul60zyGPVhZ.IoZ4yYb/5Bjjc.9yzzyS', 'ROLE_USER', NULL, 'Prueba01'),
(3, 'prueba02@gmail.com', b'1', '$2a$10$V4iWudUR1F2FwKoDE7mzseTKB31QbpTkfl6B5YyPZTi2wvPaiMHiq', 'ROLE_USER', NULL, 'Prueba02'),
(4, 'prueba03@gmail.com', b'0', '$2a$10$RPW1Gkh6Ps3BxFL6XtrnG.kz4PhLYOevdO/jInOL9iNXi0Fnl/FR2', 'ROLE_USER', NULL, 'Prueba03'),
(5, 'danone@gmail.com', b'1', '$2a$10$UYl7dbcIy5htV2GLYw2kfuavvQ0cifr6T8ALPnx4RzHReyQI4E.im', 'ROLE_COMPANY', NULL, 'Danone'),
(6, 'cocacola@gmail.com', b'1', '$2a$10$E.WV3rZPEuLGg2eXKa9g7eevMdm3rgpYhbL69FImj2XTDgbVMBjNS', 'ROLE_COMPANY', NULL, 'Coca Cola'),
(7, 'nestle@gmail.com', b'1', '$2a$10$GUKJ23c.IEzqBNi2WfAh5OPwGZKgiuzBd.3N4XpHHO8T5uHjPEx0S', 'ROLE_COMPANY', NULL, 'Nestlé');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user_seq`
--

CREATE TABLE `user_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `user_seq`
--

INSERT INTO `user_seq` (`next_val`) VALUES
(101);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK2twm010w181ypxiegra4o0rgc` (`company_id`);

--
-- Indices de la tabla `company`
--
ALTER TABLE `company`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKdy4v2yb46hefqicjpyj7b7e4s` (`user_id`);

--
-- Indices de la tabla `favorite`
--
ALTER TABLE `favorite`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK3dcwkxk48fiw7ucs6tixaghdp` (`suggestion_id`);

--
-- Indices de la tabla `favorite_user_dislikes`
--
ALTER TABLE `favorite_user_dislikes`
  ADD KEY `FKbkfm2emc96758fga96qma5tt4` (`user_dislikes_id`),
  ADD KEY `FKkgekttsgtbby4i3i2ke5jvwir` (`favorite_dislikes_id`);

--
-- Indices de la tabla `favorite_user_likes`
--
ALTER TABLE `favorite_user_likes`
  ADD KEY `FK2lsiqvn1yg9swhrw6y5rx8ec8` (`user_likes_id`),
  ADD KEY `FKngmmbuk1j0lkfu1ktu92bsotx` (`favorite_likes_id`);

--
-- Indices de la tabla `order_product`
--
ALTER TABLE `order_product`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKlnovjtppodddc3v5ll913lmdf` (`company_id`),
  ADD KEY `FKo9xn5tfed9g2dqctro3cg0h0` (`user_id`);

--
-- Indices de la tabla `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK1mtsbur82frn64de7balymq9s` (`category_id`),
  ADD KEY `FKghawd5rtv8ok565nwpdyyuto9` (`company_id`);

--
-- Indices de la tabla `product_orders`
--
ALTER TABLE `product_orders`
  ADD KEY `FK3pim5d9qvehyn5o3fj4uovbb7` (`orders_id`),
  ADD KEY `FK72g78wdy9c99wx9jy1mlb4482` (`products_id`);

--
-- Indices de la tabla `suggestion`
--
ALTER TABLE `suggestion`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKgk9gc9n6r1co2n79g36o6fj14` (`company_id`),
  ADD KEY `FKnocwtfc34pk1e7upvi1plaedu` (`user_id`);

--
-- Indices de la tabla `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`) USING HASH,
  ADD UNIQUE KEY `UK_sb8bbouer5wak8vyiiy4pf2bx` (`username`) USING HASH;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
