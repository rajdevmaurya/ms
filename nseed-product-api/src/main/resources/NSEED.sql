INSERT INTO `category` (`id`, `name`, `description`, `created_at`, `updated_at` )VALUES
    (1,'other','Other', now(), NULL),
    (2,'clothing','Clothing', now(), NULL),
    (3,'sports','Sports', now(), NULL),
    (4,'Electronics','Electronics', now(), NULL);

INSERT INTO `product` (`product_id`, `description`, `name`, `price`, `sku`, `image_path`, `is_active`, `featured`, `category_id`, `available_quantities`, `created_at`, `updated_at` ) VALUES
  (1,'LEGO Cup test','Coffee Cup',4.99,'1A2S3D4F','lego-cup.jpg',NULL,NULL,1,5,now(),NULL),
  (2,'We are providing Mike Headphones. Our products are enormously well-liked by patrons owing to their top features.','Mike Headphone',24.99,'B07T1GVZ3J','earphone.jpg',NULL,NULL,4,10,now(),NULL),
  (3,'The ultimate hydration companion.','Water Bottle',9.99,'1Q2W3E4R5T','water-bottle.jpg',NULL,NULL,1,3,now(),NULL),
  (4,'Monitor Stand ','Monitor Stand',99.99,'A9B8C7D6','monitor-stand.jpg',NULL,NULL,1,4,now(),NULL),
  (5, 'this is cool hat', 'Hat', 19.99, 'A1B2C3D4E5', 'hat.jpg', NULL, NULL, 1, 9, now(), NULL),
  (6, 'Classic Key Ring', 'Bear Key Chain', 4.99, 'Q1W2E3R4', 'cute_ring.jpeg', NULL, NULL, 1, 8, now(), NULL);