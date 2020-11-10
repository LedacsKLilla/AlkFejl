insert into user (username, password, enabled, role) values ('admin', '$2a$10$Xtv0umJn1DDZ3ds5FTWHUOHuwJnRQ0qrYpTA1ANaRl8vdiwo1R1iW', true, 'ROLE_ADMIN');
-- password: admin
insert into user (username, password, enabled, role) values ('user', '$2a$10$QUhsliTs8Ufe9nSQgIwzzeDktWOdDw8WY77lN.3AAXL5vVDI2EoVO', true, 'ROLE_USER');
-- password: user

insert into Recipe (title,  quantity, description) values ('Spagetti',10,'nincs');
insert into Recipe (title,  quantity, description) values ('Shuffle',10,'nincs');
insert into Ingredient (ingredient) values ('Apple');
insert into Ingredient (ingredient) values ('Pasta');

insert into recipe_ingredients(recipe_id, ingredients_id) values (1,1);
insert into recipe_ingredients(recipe_id, ingredients_id) values (1,2);
insert into recipe_ingredients(recipe_id, ingredients_id) values (2,1);
insert into recipe_ingredients(recipe_id, ingredients_id) values (2,2);

insert into User_History (day) values ('Monday');
insert into User_History (day) values ('Tuesday');
insert into User_History (day) values ('Wednesday');
insert into User_History (day) values ('Thursday');
insert into User_History (day) values ('Friday');
insert into User_History (day) values ('Saturday');
insert into User_History (day) values ('Sunday');



