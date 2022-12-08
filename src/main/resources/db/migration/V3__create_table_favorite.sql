CREATE TABLE favorite(
	uuid varchar(255) primary key,
    user_uuid varchar(255),
    FOREIGN KEY (user_uuid) REFERENCES user(uuid),
    book_uuid varchar(255),
    FOREIGN KEY (book_uuid) REFERENCES book(uuid)
);
