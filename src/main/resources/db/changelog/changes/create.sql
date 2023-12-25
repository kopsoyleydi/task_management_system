CREATE TABLE users (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       name VARCHAR(255),
                       email VARCHAR(255),
                       password VARCHAR(255),
                       UNIQUE KEY (email)
);

CREATE TABLE permission (
                            id BIGINT AUTO_INCREMENT PRIMARY KEY,
                            role VARCHAR(255) NOT NULL
);


CREATE TABLE user_permissions (
                                  user_id BIGINT,
                                  permission_id BIGINT,
                                  PRIMARY KEY (user_id, permission_id),
                                  FOREIGN KEY (user_id) REFERENCES users(id),
                                  FOREIGN KEY (permission_id) REFERENCES permission(id)
);

CREATE TABLE tasks (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       title VARCHAR(255),
                       description VARCHAR(255),
                       status VARCHAR(50),
                       priority VARCHAR(50),
                       author_id BIGINT,
                       FOREIGN KEY (author_id) REFERENCES users(id)
);

CREATE TABLE task_performers (
                                 task_id BIGINT,
                                 user_id BIGINT,
                                 PRIMARY KEY (task_id, user_id),
                                 FOREIGN KEY (task_id) REFERENCES tasks(id),
                                 FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE comments (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          message VARCHAR(255),
                          task_id BIGINT NOT NULL,
                          user_id BIGINT NOT NULL,
                          created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                          FOREIGN KEY (task_id) REFERENCES tasks(id),
                          FOREIGN KEY (user_id) REFERENCES users(id)
);

