--1.
SELECT STUDENT_NAME AS "학생 이름",STUDENT_ADDRESS AS "주소지"
FROM TB_STUDENT
ORDER BY STUDENT_NAME;

--2.
SELECT STUDENT_NAME,STUDENT_SSN
FROM TB_STUDENT
WHERE ABSENCE_YN = 'Y'
ORDER BY TO_DATE(SUBSTR(STUDENT_SSN,1,6)) DESC;

--3.
SELECT STUDENT_NAME,STUDENT_NO,STUDENT_ADDRESS
FROM TB_STUDENT
WHERE STUDENT_ADDRESS LIKE '%강원도%' OR STUDENT_ADDRESS LIKE '%경기도%' 
    AND STUDENT_NO LIKE '9%'
ORDER BY STUDENT_NAME;

--4.
SELECT PROFESSOR_NAME,PROFESSOR_SSN
FROM TB_PROFESSOR
JOIN TB_DEPARTMENT USING(DEPARTMENT_NO)
WHERE DEPARTMENT_NAME='법학과'
ORDER BY SUBSTR(PROFESSOR_SSN,1,6) ;

--5.
SELECT STUDENT_NO,POINT
FROM TB_STUDENT
JOIN TB_GRADE USING(STUDENT_NO)
WHERE CLASS_NO='C3118100' AND TERM_NO='200402'
ORDER BY POINT DESC,STUDENT_NO;

--6.
SELECT STUDENT_NO,STUDENT_NAME,DEPARTMENT_NAME
FROM TB_STUDENT
JOIN TB_DEPARTMENT USING(DEPARTMENT_NO)
ORDER BY STUDENT_NAME;

--7.
SELECT CLASS_NAME,DEPARTMENT_NAME
FROM TB_CLASS
JOIN TB_DEPARTMENT USING(DEPARTMENT_NO);

--8.
SELECT CLASS_NAME,PROFESSOR_NAME
FROM TB_CLASS
JOIN TB_CLASS_PROFESSOR USING(CLASS_NO)
JOIN TB_PROFESSOR USING(PROFESSOR_NO);


--9.
SELECT CLASS_NAME,PROFESSOR_NAME
FROM(SELECT CLASS_NAME,PROFESSOR_NAME
        FROM TB_CLASS
        JOIN TB_CLASS_PROFESSOR USING(CLASS_NO)
        JOIN TB_PROFESSOR USING(PROFESSOR_NO))
JOIN TB_PROFESSOR USING(PROFESSOR_NAME)
JOIN TB_DEPARTMENT USING(DEPARTMENT_NO)
WHERE CATEGORY='인문사회';

--10. 다시 풀어보기
SELECT STUDENT_NO 학번,STUDENT_NAME 학생이름,ROUND(AVG(POINT),1) 전체평점
FROM TB_GRADE
JOIN TB_STUDENT USING(STUDENT_NO)
JOIN TB_DEPARTMENT USING(DEPARTMENT_NO)
WHERE DEPARTMENT_NAME='음악학과'
GROUP BY STUDENT_NO,STUDENT_NAME
ORDER BY STUDENT_NO;

--11.
       
SELECT DEPARTMENT_NAME 학과이름,STUDENT_NAME 학생이름,PROFESSOR_NAME AS "지도교수이름"
FROM TB_STUDENT
JOIN TB_DEPARTMENT USING (DEPARTMENT_NO)
JOIN TB_PROFESSOR ON (COACH_PROFESSOR_NO=PROFESSOR_NO)
WHERE STUDENT_NO='A313047';

--12.
SELECT STUDENT_NAME,TERM_NO AS "TERM_NAME" 
FROM TB_STUDENT
JOIN TB_GRADE USING(STUDENT_NO)
JOIN TB_CLASS USING(CLASS_NO)
WHERE TERM_NO LIKE '2007%' AND CLASS_NAME='인간관계론';

--13.
SELECT CLASS_NAME,DEPARTMENT_NAME
            FROM TB_CLASS
                 LEFT JOIN TB_CLASS_PROFESSOR USING(CLASS_NO)
                 LEFT JOIN TB_DEPARTMENT USING(DEPARTMENT_NO)
                 WHERE PROFESSOR_NO IS NULL AND CATEGORY='예체능';  
                 
--14.
SELECT STUDENT_NAME AS "학생이름",NVL(PROFESSOR_NAME,'지도교수 미지정' )"지도교수"
FROM TB_STUDENT
LEFT JOIN TB_DEPARTMENT USING(DEPARTMENT_NO)
LEFT JOIN TB_PROFESSOR ON (COACH_PROFESSOR_NO=PROFESSOR_NO)
WHERE DEPARTMENT_NAME = '서반아어학과';

--15.
SELECT STUDENT_NO AS "학번",STUDENT_NAME AS "이름",
        DEPARTMENT_NAME AS "학과 이름",AVG(POINT) AS "평점"
FROM TB_STUDENT
JOIN TB_DEPARTMENT USING(DEPARTMENT_NO)
JOIN TB_GRADE USING(STUDENT_NO)
GROUP BY STUDENT_NO
WHERE ABSENCE_YN= 'N' AND AVG(POINT)>= 4;

SELECT STUDENT_NO 학번,STUDENT_NAME 이름,DEPARTMENT_NAME,AVG(POINT) 평점
FROM TB_STUDENT
JOIN TB_DEPARTMENT USING(DEPARTMENT_NO)
JOIN TB_GRADE USING(STUDENT_NO)
WHERE ABSENCE_YN='N' AND AVG(POINT)>= 4
GROUP BY STUDENT_NO,STUDENT_NAME,DEPARTMENT_NAME;

--16.
SELECT CLASS_NO,CLASS_NAME,AVG(POINT)
FROM TB_CLASS
JOIN TB_DEPARTMENT USING(DEPARTMENT_NO)
JOIN TB_GRADE USING(CLASS_NO)
WHERE DEPARTMENT_NAME ='환경조경학과' AND CLASS_TYPE LIKE '%전공%'
GROUP BY CLASS_NO,CLASS_NAME
ORDER BY CLASS_NO;

--17.
SELECT STUDENT_NAME,STUDENT_ADDRESS
FROM TB_STUDENT
LEFT JOIN TB_DEPARTMENT USING(DEPARTMENT_NO) 
WHERE DEPARTMENT_NAME=(SELECT DEPARTMENT_NAME
                        FROM TB_STUDENT
                        LEFT JOIN TB_DEPARTMENT USING(DEPARTMENT_NO)
                        WHERE STUDENT_NAME='최경희');
                        
--18.
SELECT STUDENT_NO,STUDENT_NAME
FROM TB_STUDENT
WHERE MAX(AVG(POINT)) IN(SELECT STUDENT_NO,AVG(POINT)
                    FROM TB_STUDENT
                    JOIN TB_GRADE USING(STUDENT_NO)
                    JOIN TB_DEPARTMENT USING(DEPARTMENT_NO)
                    WHERE DEPARTMENT_NAME='국어국문학과'
                    GROUP BY STUDENT_NO
                    );


