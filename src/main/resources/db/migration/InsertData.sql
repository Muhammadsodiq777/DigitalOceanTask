INSERT INTO faculty (created_at, is_active, name, university_id, updated_at)
VALUES (CURRENT_TIMESTAMP, 1, 'John Doe', 1, CURRENT_TIMESTAMP);

INSERT INTO faculty (created_at, is_active, name, university_id, updated_at)
VALUES (CURRENT_TIMESTAMP, 1, 'Jane Smith', 2, CURRENT_TIMESTAMP);

INSERT INTO faculty (created_at, is_active, name, university_id, updated_at)
VALUES (CURRENT_TIMESTAMP, 1, 'Robert Johnson', 1, CURRENT_TIMESTAMP);

INSERT INTO faculty (created_at, is_active, name, university_id, updated_at)
VALUES (CURRENT_TIMESTAMP, 1, 'Emily Davis', 3, CURRENT_TIMESTAMP);

INSERT INTO faculty (created_at, is_active, name, university_id, updated_at)
VALUES (CURRENT_TIMESTAMP, 1, 'Michael Brown', 2, CURRENT_TIMESTAMP);

-------------------------------------------------------------------------------------------
INSERT INTO journal (created_at, group_id, is_active, name, updated_at)
VALUES (CURRENT_TIMESTAMP, 1, 1, 'Journal A', CURRENT_TIMESTAMP);

INSERT INTO journal (created_at, group_id, is_active, name, updated_at)
VALUES (CURRENT_TIMESTAMP, 2, 1, 'Journal B', CURRENT_TIMESTAMP);

INSERT INTO journal (created_at, group_id, is_active, name, updated_at)
VALUES (CURRENT_TIMESTAMP, 1, 1, 'Journal C', CURRENT_TIMESTAMP);

INSERT INTO journal (created_at, group_id, is_active, name, updated_at)
VALUES (CURRENT_TIMESTAMP, 3, 1, 'Journal D', CURRENT_TIMESTAMP);

INSERT INTO journal (created_at, group_id, is_active, name, updated_at)
VALUES (CURRENT_TIMESTAMP, 2, 1, 'Journal E', CURRENT_TIMESTAMP);

------------------------------------------------------------------------------------------

INSERT INTO journal_subjects (created_at, is_active, journal_id, subject_id, updated_at)
VALUES (CURRENT_TIMESTAMP, 1, 1, 1, CURRENT_TIMESTAMP);

INSERT INTO journal_subjects (created_at, is_active, journal_id, subject_id, updated_at)
VALUES (CURRENT_TIMESTAMP, 1, 1, 2, CURRENT_TIMESTAMP);

INSERT INTO journal_subjects (created_at, is_active, journal_id, subject_id, updated_at)
VALUES (CURRENT_TIMESTAMP, 1, 2, 3, CURRENT_TIMESTAMP);

INSERT INTO journal_subjects (created_at, is_active, journal_id, subject_id, updated_at)
VALUES (CURRENT_TIMESTAMP, 1, 3, 2, CURRENT_TIMESTAMP);

INSERT INTO journal_subjects (created_at, is_active, journal_id, subject_id, updated_at)
VALUES (CURRENT_TIMESTAMP, 1, 2, 1, CURRENT_TIMESTAMP);

-----------------------------------------------------------------------------------------------

INSERT INTO marks (created_at, is_active, name, updated_at)
VALUES (CURRENT_TIMESTAMP, 1, 'Math', CURRENT_TIMESTAMP);

INSERT INTO marks (created_at, is_active, name, updated_at)
VALUES (CURRENT_TIMESTAMP, 1, 'Science', CURRENT_TIMESTAMP);

INSERT INTO marks (created_at, is_active, name, updated_at)
VALUES (CURRENT_TIMESTAMP, 1, 'English', CURRENT_TIMESTAMP);

INSERT INTO marks (created_at, is_active, name, updated_at)
VALUES (CURRENT_TIMESTAMP, 1, 'History', CURRENT_TIMESTAMP);

INSERT INTO marks (created_at, is_active, name, updated_at)
VALUES (CURRENT_TIMESTAMP, 1, 'Geography', CURRENT_TIMESTAMP);

-----------------------------------------------------------------------------------------------------

INSERT INTO student (created_at, group_id, is_active, name, updated_at)
VALUES (CURRENT_TIMESTAMP, 1, 1, 'John Smith', CURRENT_TIMESTAMP);

INSERT INTO student (created_at, group_id, is_active, name, updated_at)
VALUES (CURRENT_TIMESTAMP, 2, 1, 'Emily Johnson', CURRENT_TIMESTAMP);

INSERT INTO student (created_at, group_id, is_active, name, updated_at)
VALUES (CURRENT_TIMESTAMP, 1, 1, 'Michael Davis', CURRENT_TIMESTAMP);

INSERT INTO student (created_at, group_id, is_active, name, updated_at)
VALUES (CURRENT_TIMESTAMP, 3, 1, 'Sophia Brown', CURRENT_TIMESTAMP);

INSERT INTO student (created_at, group_id, is_active, name, updated_at)
VALUES (CURRENT_TIMESTAMP, 2, 1, 'William Wilson', CURRENT_TIMESTAMP);

------------------------------------------------------------------------------------------------

INSERT INTO student_marks (created_at, is_active, marks_id, student_id, updated_at)
VALUES (CURRENT_TIMESTAMP, 1, 1, 1, CURRENT_TIMESTAMP);

INSERT INTO student_marks (created_at, is_active, marks_id, student_id, updated_at)
VALUES (CURRENT_TIMESTAMP, 1, 2, 1, CURRENT_TIMESTAMP);

INSERT INTO student_marks (created_at, is_active, marks_id, student_id, updated_at)
VALUES (CURRENT_TIMESTAMP, 1, 3, 2, CURRENT_TIMESTAMP);

INSERT INTO student_marks (created_at, is_active, marks_id, student_id, updated_at)
VALUES (CURRENT_TIMESTAMP, 1, 4, 3, CURRENT_TIMESTAMP);

INSERT INTO student_marks (created_at, is_active, marks_id, student_id, updated_at)
VALUES (CURRENT_TIMESTAMP, 1, 5, 2, CURRENT_TIMESTAMP);

-----------------------------------------------------------------------------------------------

INSERT INTO student_subjects (created_at, is_active, student_id, subject_id, updated_at)
VALUES (CURRENT_TIMESTAMP, 1, 1, 1, CURRENT_TIMESTAMP);

INSERT INTO student_subjects (created_at, is_active, student_id, subject_id, updated_at)
VALUES (CURRENT_TIMESTAMP, 1, 1, 2, CURRENT_TIMESTAMP);

INSERT INTO student_subjects (created_at, is_active, student_id, subject_id, updated_at)
VALUES (CURRENT_TIMESTAMP, 1, 2, 3, CURRENT_TIMESTAMP);

INSERT INTO student_subjects (created_at, is_active, student_id, subject_id, updated_at)
VALUES (CURRENT_TIMESTAMP, 1, 3, 2, CURRENT_TIMESTAMP);

INSERT INTO student_subjects (created_at, is_active, student_id, subject_id, updated_at)
VALUES (CURRENT_TIMESTAMP, 1, 2, 1, CURRENT_TIMESTAMP);

--------------------------------------------------------------------------------------------------

INSERT INTO subject (created_at, is_active, name, updated_at)
VALUES (CURRENT_TIMESTAMP, 1, 'Mathematics', CURRENT_TIMESTAMP);

INSERT INTO subject (created_at, is_active, name, updated_at)
VALUES (CURRENT_TIMESTAMP, 1, 'Physics', CURRENT_TIMESTAMP);

INSERT INTO subject (created_at, is_active, name, updated_at)
VALUES (CURRENT_TIMESTAMP, 1, 'Chemistry', CURRENT_TIMESTAMP);

INSERT INTO subject (created_at, is_active, name, updated_at)
VALUES (CURRENT_TIMESTAMP, 1, 'Biology', CURRENT_TIMESTAMP);

INSERT INTO subject (created_at, is_active, name, updated_at)
VALUES (CURRENT_TIMESTAMP, 1, 'English Literature', CURRENT_TIMESTAMP);

-----------------------------------------------------------------------------------------------------

INSERT INTO university (address, created_at, is_active, name, updated_at)
VALUES ('123 Main Street', CURRENT_TIMESTAMP, 1, 'University A', CURRENT_TIMESTAMP);

INSERT INTO university (address, created_at, is_active, name, updated_at)
VALUES ('456 Elm Street', CURRENT_TIMESTAMP, 1, 'University B', CURRENT_TIMESTAMP);

INSERT INTO university (address, created_at, is_active, name, updated_at)
VALUES ('789 Oak Street', CURRENT_TIMESTAMP, 1, 'University C', CURRENT_TIMESTAMP);

INSERT INTO university (address, created_at, is_active, name, updated_at)
VALUES ('321 Pine Street', CURRENT_TIMESTAMP, 1, 'University D', CURRENT_TIMESTAMP);

INSERT INTO university (address, created_at, is_active, name, updated_at)
VALUES ('654 Maple Street', CURRENT_TIMESTAMP, 1, 'University E', CURRENT_TIMESTAMP);

---------------------------------------------------------------------------------------------------

INSERT INTO unv_group (created_at, faculty_id, is_active, name, updated_at, gr_year)
VALUES (CURRENT_TIMESTAMP, 1, 1, 'Group A', CURRENT_TIMESTAMP, 2023);

INSERT INTO unv_group (created_at, faculty_id, is_active, name, updated_at, gr_year)
VALUES (CURRENT_TIMESTAMP, 2, 1, 'Group B', CURRENT_TIMESTAMP, 2023);

INSERT INTO unv_group (created_at, faculty_id, is_active, name, updated_at, gr_year)
VALUES (CURRENT_TIMESTAMP, 1, 1, 'Group C', CURRENT_TIMESTAMP, 2022);

INSERT INTO unv_group (created_at, faculty_id, is_active, name, updated_at, gr_year)
VALUES (CURRENT_TIMESTAMP, 3, 1, 'Group D', CURRENT_TIMESTAMP, 2022);

INSERT INTO unv_group (created_at, faculty_id, is_active, name, updated_at, gr_year)
VALUES (CURRENT_TIMESTAMP, 2, 1, 'Group E', CURRENT_TIMESTAMP, 2021);

------------------------------------------------------------------------------------------------------