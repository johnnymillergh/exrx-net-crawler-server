CREATE TABLE body_part (
    id   bigint UNSIGNED AUTO_INCREMENT COMMENT 'The ID of body part.'
        PRIMARY KEY,
    name varchar(20) NOT NULL COMMENT 'The name of body part.',
    CONSTRAINT body_part_name_uindex
        UNIQUE (name)
)
    COMMENT 'Human Body Part.';

CREATE TABLE equipment (
    id   bigint UNSIGNED AUTO_INCREMENT COMMENT 'The ID of exercise equipment.'
        PRIMARY KEY,
    name varchar(50) NOT NULL COMMENT 'The name of equipment.',
    CONSTRAINT equipment_name_uindex
        UNIQUE (name)
)
    COMMENT 'Exercise Equipment.';

CREATE TABLE exercise (
    id                bigint UNSIGNED AUTO_INCREMENT COMMENT 'The ID of exercise.'
        PRIMARY KEY,
    name              varchar(100) NOT NULL COMMENT 'The name of exercise.',
    preparation       varchar(800) NOT NULL COMMENT 'Exercise preparation description.',
    execution         varchar(800) NOT NULL COMMENT 'Exercise execution description.',
    exercise_gif_path varchar(100) NULL COMMENT 'Exercise GIF image path.',
    CONSTRAINT exercise_name_uindex
        UNIQUE (name)
)
    COMMENT 'Exercise.

https://exrx.net/Lists/Directory';

CREATE TABLE exercise_classification (
    id          bigint UNSIGNED AUTO_INCREMENT COMMENT 'The ID of exercise classification.'
        PRIMARY KEY,
    name        varchar(20)   NOT NULL COMMENT 'The name of exercise classification.',
    description varchar(1000) NOT NULL COMMENT 'The description of exercise classification.',
    CONSTRAINT exercise_classification_name_uindex
        UNIQUE (name)
)
    COMMENT 'Exercise Classification.

https://exrx.net/WeightTraining/Glossary';

CREATE TABLE exercise_comment (
    id          bigint UNSIGNED AUTO_INCREMENT COMMENT 'The ID of exercise comment.'
        PRIMARY KEY,
    exercise_id bigint UNSIGNED NOT NULL COMMENT 'The ID of exercise.',
    comment     varchar(2500)   NOT NULL COMMENT 'The comment.',
    CONSTRAINT exercise_comment_exercise_id_uindex
        UNIQUE (exercise_id)
)
    COMMENT 'Exercise Comment.

Relationship:
One exercise to one comment.

If the exercise doen''t have comment,
then this table will still store the comment record for it,
like { id: 1, exercise_id: 1, comment: ''NONE'' }.';

CREATE TABLE exercise_related_classification (
    id                          bigint UNSIGNED AUTO_INCREMENT COMMENT 'The ID of exercise related classification.'
        PRIMARY KEY,
    exercise_id                 bigint UNSIGNED NOT NULL COMMENT 'The ID of exercise.',
    exercise_classification_id  bigint UNSIGNED NOT NULL COMMENT 'The exercise classification ID.',
    related_classification_type tinyint         NOT NULL COMMENT '1 - Utility, 2 - Mechanics, 3 - Force'
)
    COMMENT 'Exercise Related Classification.

Relationship:
One exercise usually mapping to 3 types of exercise classification.
And one exercise can have more than one specific type of classification.

For example:
One exercise can have 2 records whose types are both Utility.';

CREATE TABLE exercise_related_muscle (
    id                  bigint UNSIGNED AUTO_INCREMENT COMMENT 'The ID of exercise related muscle.'
        PRIMARY KEY,
    exercise_id         bigint UNSIGNED NOT NULL COMMENT 'The ID of exercise.',
    muscle_id           bigint UNSIGNED NOT NULL COMMENT 'The ID of muscle.',
    related_muscle_type tinyint         NOT NULL COMMENT 'Related muscle type. Muscle movement classification.

1 - Agonist
2 - Antagonist
3 - Target
4 - Synergist
5 - Stabilizer
6 - Dynamic Stabilizer
7 - Antagonist Stabilizer

https://exrx.net/Kinesiology/Glossary#MuscleMovClass'
)
    COMMENT 'Exercise Related Muscle.

Relationship:
One exercise can have 3 (or more) different types of related muscle.
And one exercise can have more than one specific type of related muscles.';

CREATE TABLE kinesiology_glossary (
    id          bigint UNSIGNED AUTO_INCREMENT COMMENT 'The ID of kinesiology glossary.'
        PRIMARY KEY,
    name        varchar(30)     NOT NULL COMMENT 'The name kinesiology glossary.',
    description varchar(2000)   NULL COMMENT 'The description of kinesiology glossary.',
    parent_id   bigint UNSIGNED NULL COMMENT 'The parent ID of kinesiology glossary.',
    CONSTRAINT kinesiology_glossary_name_uindex
        UNIQUE (name)
)
    COMMENT 'Kinesiology Glossary.

https://exrx.net/Kinesiology/Glossary';

CREATE TABLE muscle (
    id           bigint UNSIGNED AUTO_INCREMENT COMMENT 'The ID of muscle.'
        PRIMARY KEY,
    name         varchar(50)     NOT NULL COMMENT 'The name of muscle.',
    other_names  varchar(200)    NULL COMMENT 'The muslce''s other names.',
    parent_id    bigint UNSIGNED NULL COMMENT 'The parent ID of muscle.',
    body_part_id bigint UNSIGNED NOT NULL COMMENT 'Related body part ID.',
    CONSTRAINT muscle_name_uindex
        UNIQUE (name)
)
    COMMENT 'Muscle.

https://exrx.net/Lists/Muscle';

CREATE TABLE muscle_image (
    id               bigint UNSIGNED AUTO_INCREMENT COMMENT 'The ID of muscle image.'
        PRIMARY KEY,
    muscle_id        bigint UNSIGNED NOT NULL COMMENT 'The ID of muslce.',
    image_path       varchar(100)    NOT NULL COMMENT 'The image path of muscle image.',
    alternative_text varchar(100)    NOT NULL COMMENT 'A textual description of the image.',
    CONSTRAINT muscle_image_image_path_uindex
        UNIQUE (image_path)
)
    COMMENT 'Muscle Image.

The relationship:
One muscle to one or more muscle image.';

CREATE TABLE related_muscle (
    id                bigint UNSIGNED AUTO_INCREMENT COMMENT 'The ID of related muscle.'
        PRIMARY KEY,
    muscle_id         bigint UNSIGNED NOT NULL COMMENT 'The ID of muscle.',
    related_muscle_id bigint UNSIGNED NOT NULL COMMENT 'Related muscle''s ID.'
)
    COMMENT 'Muscle''s related muscles.';

CREATE TABLE test_table (
    id             bigint UNSIGNED AUTO_INCREMENT
        PRIMARY KEY,
    string_value   varchar(10) NOT NULL,
    int_value      int         NULL,
    double_value   double      NULL,
    datetime_value datetime    NULL
)
    COMMENT 'Test Table for ORM library.';

