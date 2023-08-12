INSERT INTO `product` (`product_id`,  `name`, `price`, `sku`, `is_active`) VALUES
  (1,'LEGO Cup test',4.99,'1A2S3D4F',NULL),
  (2, 'Classic Key Ring',  4.99, 'Q1W2E3R4', NULL);


INSERT INTO `permission` VALUES
  (1,'ROLE_ORDER_CREATE'),
  (2,'ROLE_USER_CREATE'),
  (3,'ROLE_MANAGE_PRODUCT'),
  (4,'ROLE_ADD_CATEGORY'),
  (5,'ROLE_ADMINISTRATOR');

INSERT INTO `role` VALUES
    (1,'ADMIN'),
    (2,'CUSTOMER'),
    (3,'SELLER');

INSERT INTO `roles_permissions` VALUES (1,4),(1,2),(3,1),(2,1),(1,1),(1,3),(3,3),(1,5);

INSERT INTO `user` (`id`, `email`, `password`, `user_name`, `created_at`, `updated_at`) VALUES
  (1,'admin@test.com','$2a$10$oLEOhvAhzPWLd2uxBvjl7uTCDPJ9bZ2q6cMB9Mf5OBgoPPRz3fPEe','admin', now(), NULL ),
  (2,'customer@test.com','$2a$10$MT/ERiRU6C0xPbbsr1lvpeTeD0t0PtXA1YLRX2WMQ./Bfp9H9h7s2','customer', now(), NULL ),
  (3,'seller@test.com','$2a$10$2Wi4/wZg3SBpUMrhUu53sOEJiXyWpT746k8ARvzDWuQmZtSM9G39e','seller', now(), NULL );

INSERT INTO `users_roles` VALUES (1,1),(2,2),(3,3);

