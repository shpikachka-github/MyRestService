select st.full_name, sp.specialty_name
	from students as st, specialties as sp, students_specialties as ss
	where ss.student_id = st.id and ss.specialty_id = sp.id;
