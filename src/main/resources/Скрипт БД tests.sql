-- DROP TABLE test.tests;

CREATE TABLE test.tests (
	test_id bigserial NOT NULL,
	test_name varchar(50) NOT NULL,
	CONSTRAINT tests_pkey PRIMARY KEY (test_id)
);

-- DROP TABLE test.tests_questions;

CREATE TABLE test.tests_questions (
	test_question_id bigserial NOT NULL,
	test_id int8 NOT NULL,
	question_number int4 NOT NULL,
	question_text varchar NOT NULL,
	CONSTRAINT tests_questions_pkey PRIMARY KEY (test_question_id),
	CONSTRAINT tests_questions_test_id_fkey FOREIGN KEY (test_id) REFERENCES test.tests(test_id)
);

-- DROP TABLE test.tests_answers;

CREATE TABLE test.tests_answers (
	test_answer_id bigserial NOT NULL,
	test_question_id int8 NOT NULL,
	answer_number int4 NOT NULL,
	answer_text varchar NOT NULL,
	answer_correct bool NOT NULL DEFAULT false,
	CONSTRAINT tests_answers_pkey PRIMARY KEY (test_answer_id),
	CONSTRAINT tests_answers_test_question_id_fkey FOREIGN KEY (test_question_id) REFERENCES test.tests_questions(test_question_id)
);

-- =================================================

-- DROP TABLE test.students;

CREATE TABLE test.students (
	student_id bigserial NOT NULL,
	last_name varchar(50) NOT NULL,
	first_name varchar(50) NOT NULL,
	CONSTRAINT students_pkey PRIMARY KEY (student_id)
);

-- DROP TABLE test.students_tests;

CREATE TABLE test.students_tests (
	student_test_id bigserial NOT NULL,
	student_id int8 NOT NULL,
	test_id int8 NOT NULL,
	date_of_completion date NULL,
	CONSTRAINT students_tests_pkey PRIMARY KEY (student_test_id),
	CONSTRAINT students_tests_student_id_fkey FOREIGN KEY (student_id) REFERENCES test.students(student_id),
	CONSTRAINT students_tests_test_id_fkey FOREIGN KEY (test_id) REFERENCES test.tests(test_id)
);

-- DROP TABLE test.students_answers;

CREATE TABLE test.students_answers (
	student_answer_id bigserial NOT NULL,
	test_question_id int8 NOT NULL,
	test_answer_id int8 NOT NULL,
	student_test_id int8 NOT NULL,
	CONSTRAINT students_answers_pkey PRIMARY KEY (student_answer_id),
	CONSTRAINT students_answers_student_test_id_fkey FOREIGN KEY (student_test_id) REFERENCES test.students_tests(student_test_id),
	CONSTRAINT students_answers_test_answer_id_fkey FOREIGN KEY (test_answer_id) REFERENCES test.tests_answers(test_answer_id),
	CONSTRAINT students_answers_test_question_id_fkey FOREIGN KEY (test_question_id) REFERENCES test.tests_questions(test_question_id)
);

